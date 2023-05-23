package edu.ntnu.idatt2001.View;

import edu.ntnu.idatt2001.Controller.CreateGameController;
import edu.ntnu.idatt2001.Controller.EndSceneController;
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

    Label endTitle = new Label("THE END");

    VBox endGoals = new VBox();
      Label completedGoals = new Label("Completed: " + controller.getCompletedGoals().toString());
      Label unacomplisedGoals = new Label("Unacomplised Goals: " + controller.getNonCompletedGoals().toString());
    Button returnButton = new Button("Back to main menu");
      returnButton.setOnAction(e -> {
        try {
          controller.mainMenu();
        } catch (Exception ex) {
          throw new RuntimeException(ex);
        }
      });
    endGoals.getChildren().addAll(completedGoals, unacomplisedGoals, returnButton);
    //HBox mainLayout = new HBox(new Label("completed: " + controller.getCompletedGoals().toString()), new Label(controller.getNonCompletedGoals().toString()));

    //* Whole layout
    endSceneLayout.setTop(endTitle);
    endSceneLayout.setCenter(endGoals);

    Scene scene = new Scene(endSceneLayout, 1300, 700);
    scene.getStylesheets().add("StyleSheets/endGameStyle.css");
    return scene;
    //return new Scene(mainLayout);
  }
  
}
