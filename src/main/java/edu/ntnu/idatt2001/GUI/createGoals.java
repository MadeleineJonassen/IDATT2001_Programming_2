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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class createGoals {

  public static void display() {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);  //makes the user take care of the window in front of them
    window.setMinWidth(300);

    VBox helpLayout = new VBox();
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
      TextField inputValueGoal = new TextField();
        inputValueGoal.setPromptText("Amount/Item");
    optionsGoal.getChildren().addAll(selectGoal,inputValueGoal);
    Button closeButton = new Button(("Submit"));
      closeButton.setOnAction(e -> window.close());
    helpLayout.getChildren().addAll(createGoalTitle, optionsGoal, closeButton);

    Scene scene = new Scene(helpLayout, 300, 300);
    window.setScene(scene);
    window.showAndWait();
  }
}
