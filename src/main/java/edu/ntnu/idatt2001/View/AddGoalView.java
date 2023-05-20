package edu.ntnu.idatt2001.View;

import edu.ntnu.idatt2001.Controller.AddGoalController;
import edu.ntnu.idatt2001.InputValidation.IntInput;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AddGoalView {
  private final AddGoalController controller;
  
  public AddGoalView(AddGoalController controller) {
    this.controller = controller;
  }
  
  public Scene setup(){
    VBox helpLayout;
    TextField inputValueGoal;
    Button iconView;
    String[] goalChoices = {"Health", "Score", "Gold", "Inventory"};
    List<String> goalTypes = new ArrayList<>();
    goalTypes.add("Health");
    goalTypes.add("Score");
    goalTypes.add("Gold");
    goalTypes.add("Inventory");
    
    
    
    
    helpLayout = new VBox();
    helpLayout.setAlignment((Pos.CENTER));
    helpLayout.setSpacing(10);
    Label createGoalTitle = new Label("Create Goal");
    HBox optionsGoal = new HBox();
    optionsGoal.setAlignment(Pos.CENTER);
    optionsGoal.setSpacing(10);
    ComboBox selectGoal = new ComboBox<>(FXCollections.observableArrayList(goalTypes));
    selectGoal.setPromptText("Select goal");
    inputValueGoal = new TextField();
    inputValueGoal.setPromptText("Amount/Item");
    iconView = new Button();
    iconView.getStyleClass().add("invincible");
    optionsGoal.getChildren().addAll(selectGoal,inputValueGoal, iconView);
    Button closeButton = new Button(("Submit"));
    //TODO: error handling (empty input, wrong input (handle exception))
    closeButton.setOnAction(e -> {
      
      String input = inputValueGoal.getText();
      
      int goalSelection = selectGoal.getSelectionModel().getSelectedIndex();
      
      switch (goalSelection) {
        case 0 -> controller.addHealthGoal(Integer.parseInt(input));
        case 1 -> controller.addScoreGoal(IntInput.result(input));
        case 2 -> controller.addGoldGoal(IntInput.result(input));
        case 3 -> controller.addInventoryGoal(input);
        default -> throw new IllegalArgumentException("Choice out of bounds");
      }
      
      controller.closeWindow();
    });
    helpLayout.getChildren().addAll(createGoalTitle, optionsGoal, closeButton);
    
    Scene scene = new Scene(helpLayout, 300, 300);
    scene.getStylesheets().add("/StyleSheets/popUpWindows.css");
    
    return scene;
  }
}
