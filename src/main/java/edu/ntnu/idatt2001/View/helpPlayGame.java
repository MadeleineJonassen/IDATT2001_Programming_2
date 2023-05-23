package edu.ntnu.idatt2001.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class helpPlayGame {

  public static void display() {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);  //makes the user take care of the window in front of them
    window.setMinWidth(250);

    VBox helpLayout = new VBox();
    helpLayout.setId("boxes");
      Label helpTitle = new Label("HELP");
      Text helpText1 = new Text("To the left, you can see your your player stats.");
        helpText1.setFont(Font.font("Constantia"));
      Text helpText2 = new Text("In the middle of the screen the story will be displayed");
        helpText2.setFont(Font.font("Constantia"));
      Text helpText3 = new Text("Underneath the story, you can select your path to the story.");
        helpText3.setFont(Font.font("Constantia"));
      Text helpText4 = new Text("To the right, you can see your goals. When finished a goal, they disappear.");
        helpText4.setFont(Font.font("Constantia"));
      Text helpText5 = new Text("When you finish your story or die, a button will pop up to end the game.");
        helpText5.setFont(Font.font("Constantia"));
    Button closeButton = new Button(("Okay"));
       closeButton.setOnAction(e -> window.close());
    helpLayout.getChildren().addAll(helpTitle, helpText1, helpText2,helpText3, helpText4, helpText5, closeButton);

    Scene scene = new Scene(helpLayout, 420,300);

    scene.getStylesheets().add("/StyleSheets/popUpWindows.css");

    window.setScene(scene);
    window.showAndWait();
  }
}
