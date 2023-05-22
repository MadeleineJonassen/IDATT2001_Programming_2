package edu.ntnu.idatt2001.GUI;

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

/**
 * The type Create goals.
 */
public class createGoals {
  /**
   * The constant helpLayout.
   */
  public static VBox helpLayout;
  /**
   * The constant inputValueGoal.
   */
  public static TextField inputValueGoal;
  
  /**
   * Display.
   */
  public static void display() {
    Stage window = new Stage();

    helpLayout = new VBox();
    helpLayout.setAlignment((Pos.CENTER));
    helpLayout.setSpacing(10);
    Label createGoalTitle = new Label("Create Goal");
    HBox optionsGoal = new HBox();
      optionsGoal.setAlignment(Pos.CENTER);
      optionsGoal.setSpacing(10);
      ComboBox selectGoal = new ComboBox<>();
        selectGoal.getItems().addAll(
                "Health",
                "Score",
                "Gold",
                "Inventory"
        );
        selectGoal.setPromptText("Select goal");
        inputValueGoal = new TextField();
        inputValueGoal.setPromptText("Amount");
    optionsGoal.getChildren().addAll(selectGoal, inputValueGoal);

    Button closeButton = new Button(("Submit"));
      closeButton.setOnAction(e -> {
        validateInput();
        if(validateInput() == true){
          window.close();
        } else {
          inputValueGoal.setPromptText("Please input a valid number");
          inputValueGoal.getStyleClass().add("errorTextFields");
        }
      });
    helpLayout.getChildren().addAll(createGoalTitle, optionsGoal, closeButton);

    Scene scene = new Scene(helpLayout,300,100);
    scene.getStylesheets().add("/StyleSheets/popUpWindows.css");
    window.initModality(Modality.APPLICATION_MODAL);
    window.setResizable(false);
    window.setScene(scene);
    window.showAndWait();
  }
  
  /**
   * Validate input boolean.
   *
   * @return the boolean
   */
  public static boolean validateInput() {
        if (Integer.parseInt(inputValueGoal.getText()) == 0){
          inputValueGoal.clear();
          inputValueGoal.setPromptText("Please input a number");
          inputValueGoal.getStyleClass().add("errorTextFields");
          return true;
        } else {
          inputValueGoal.setPromptText("Please input a valid number");
          inputValueGoal.getStyleClass().add("errorTextFields");
          return false;
        }
  }

}
