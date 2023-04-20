package edu.ntnu.idatt2001.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class helpScene {

  public static void display() {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);  //makes the user take care of the window in front of them
    window.setMinWidth(250);

    VBox helpLayout = new VBox();
    helpLayout.setAlignment((Pos.CENTER));
    helpLayout.setSpacing(10);
      Label helpTitle = new Label("What to do in Paths");
      helpTitle.setFont(Font.font(30));
      Text helpText1 = new Text("Press the button and it will take you on the right path.");
      Text helpText2 = new Text("Yes, pun intended.");
      Button closeButton = new Button(("Okay"));
       closeButton.setOnAction(e -> window.close());
    helpLayout.getChildren().addAll(helpTitle, helpText1, helpText2, closeButton);

    Scene scene = new Scene(helpLayout, 300,300);
    window.setScene(scene);
    window.showAndWait();
  }
}
