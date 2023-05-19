package edu.ntnu.idatt2001.GUI;

import edu.ntnu.idatt2001.Goal.GoldGoal;
import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.Players.PlayerData;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class createGoals {
  public static VBox helpLayout;
  public static TextField inputValueGoal;
  public static Button iconView;

  public static void display() {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);  //makes the user take care of the window in front of them
    window.setMinWidth(350);
    window.setMinHeight(50);

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
        inputValueGoal.setPromptText("Amount/Item");
      iconView = new Button();
        iconView.getStyleClass().add("invinsable");
    optionsGoal.getChildren().addAll(selectGoal,inputValueGoal, iconView);
    Button closeButton = new Button(("Submit"));
      //TODO: save input
      closeButton.setOnAction(e -> {
        validateInput();
        if(validateInput() == true){
          window.close();
        }else{
         validateInput();
        }
      });
    helpLayout.getChildren().addAll(createGoalTitle, optionsGoal, closeButton);

    Scene scene = new Scene(helpLayout, 300, 300);
    scene.getStylesheets().add("/StyleSheets/popUpWindows.css");
    window.setScene(scene);
    window.showAndWait();
  }

  public static boolean validateInput() {
      try{
        int gold = Integer.parseInt(inputValueGoal.getText());
        return true;
      } catch(NumberFormatException e) {
        inputValueGoal.setPromptText("Please input a valid number");
        inputValueGoal.getStyleClass().add("errorText");
        iconView.getStyleClass().add("errorImage");
        return false;
      }
  }

}
