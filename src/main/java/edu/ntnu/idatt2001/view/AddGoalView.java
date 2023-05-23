package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.AddGoalController;
import edu.ntnu.idatt2001.inputValidation.IntInput;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class AddGoalView {
  private final AddGoalController controller;
  public Button errorIcon;
  public Label errorText;
  public TextField inputValueGoal;



  public AddGoalView(AddGoalController controller) {
    this.controller = controller;
  }
  
  public Scene setup(){
    VBox helpLayout;
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
    optionsGoal.getChildren().addAll(selectGoal,inputValueGoal);

    HBox errorBox = new HBox();
      errorIcon = new Button();
        errorIcon.getStyleClass().add("invincible");
      errorText = new Label();
        errorText.getStyleClass().add("invincible");
    errorBox.getChildren().addAll(errorIcon,errorText);

    Button closeButton = new Button(("Submit"));
    closeButton.setOnAction(e -> {
      try{
        errorInvisible();
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
      }catch(Exception ignored){
        errorVisible("Select a category and amount");
      }

    });
    helpLayout.getChildren().addAll(createGoalTitle, optionsGoal,errorBox, closeButton);

    Scene scene = new Scene(helpLayout, 300, 300);
    scene.getStylesheets().add("/StyleSheets/popUpWindows.css");
    
    return scene;
  }
  public void errorInvisible(){
    errorText.setText("");
    errorIcon.setBackground(Background.EMPTY);
  }
  public void errorVisible(String message){
    errorText.getStyleClass().add("errorText");
    errorText.setText(message);
    errorIcon.getStyleClass().add("errorImage");
    inputValueGoal.getStylesheets().add("errorTextFields");
  }
}
