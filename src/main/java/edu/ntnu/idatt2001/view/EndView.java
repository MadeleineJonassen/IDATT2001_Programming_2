package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.EndSceneController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EndView {
  private final EndSceneController controller;
  
  public EndView(EndSceneController controller){
    this.controller = controller;
  }
  
  public Scene setup(){

    BorderPane endSceneLayout = new BorderPane();

    HBox titleBox = new HBox();
    titleBox.setId("boxes");
      Label endTitle = new Label("THE END");
        endTitle.setId("title");
    titleBox.getChildren().add(endTitle);

    VBox endGoals = new VBox();
    endGoals.setId("boxes");
      Label completedGoals = new Label("Completed: " + controller.getCompletedGoals().toString());
      Label unacomplisedGoals = new Label("Unacomplised Goals: " + controller.getNonCompletedGoals().toString());
    endGoals.getChildren().addAll(completedGoals, unacomplisedGoals);

    HBox bottomBox = new HBox();
    bottomBox.setId("boxes");
    Button returnButton = new Button("Back to main menu");
    returnButton.setOnAction(e -> {
      try {
        controller.mainMenu();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    bottomBox.getChildren().add(returnButton);

    //* Whole layout
    endSceneLayout.setTop(titleBox);
    endSceneLayout.setCenter(endGoals);
    endSceneLayout.setBottom(bottomBox);

    Scene scene = new Scene(endSceneLayout, 1300, 700);
    scene.getStylesheets().add("StyleSheets/endGameStyle.css");
    return scene;
    //return new Scene(mainLayout);
  }
  
}
