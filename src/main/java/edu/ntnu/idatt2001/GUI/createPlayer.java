package edu.ntnu.idatt2001.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class createPlayer {

  public static void display() {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);  //makes the user take care of the window in front of them
    window.setMinWidth(300);

    VBox helpLayout = new VBox();
    helpLayout.setAlignment((Pos.CENTER));
    helpLayout.setSpacing(10);
    Label createPlayerTitle = new Label("Create Player");
    TextField playerName = new TextField();
      playerName.setPromptText("Player name");
    TextField playerHealth = new TextField();
      playerHealth.setPromptText("Player health");
    TextField playerGold = new TextField();
      playerGold.setPromptText("Player gold");
    TextField playerScore = new TextField();
      playerScore.setPromptText("Player score");
    TextField playerInventory = new TextField(); //May change later based on the ability to add/ edit inventory
      playerInventory.setPromptText("Player Inventory");
    Button closeButton = new Button(("Submit"));
      closeButton.setOnAction(e -> window.close());
    helpLayout.getChildren().addAll(createPlayerTitle,playerName,playerHealth,playerGold,playerScore,playerInventory, closeButton);

    Scene scene = new Scene(helpLayout, 300,300);
    window.setScene(scene);
    window.showAndWait();
  }
}
