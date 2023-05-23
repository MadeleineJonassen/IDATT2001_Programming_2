package edu.ntnu.idatt2001.view.HelpScenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * View for create game.
 */
public class HelpCreatePlayer {

  /**
   * Display for help in create game view.
   */
  public static void display() {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setMinWidth(250);

    VBox helpLayout = new VBox();
    helpLayout.setAlignment((Pos.CENTER));
    helpLayout.setSpacing(10);
    Label helpTitle = new Label("HELP");
    helpTitle.setFont(Font.font(30));
    Text helpText1 = new Text("By clicking 'Select Player', you will be able create your own!");
    Text helpText2 = new Text("By clicking 'Create Goal',"
            + " a window should pop up. Here you can create your own goals within the game");
    Button closeButton = new Button(("Okay"));
    closeButton.setOnAction(e -> window.close());
    helpLayout.getChildren().addAll(helpTitle, helpText1, helpText2, closeButton);
    helpLayout.getChildren().addAll(helpTitle, helpText1, helpText2, closeButton);


    Scene scene = new Scene(helpLayout, 300, 300);

    window.setScene(scene);
    window.showAndWait();
  }
}
