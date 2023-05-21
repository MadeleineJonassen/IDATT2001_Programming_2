package edu.ntnu.idatt2001.View;

import edu.ntnu.idatt2001.Controller.CreateGameController;
import edu.ntnu.idatt2001.Controller.EndSceneController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EndView {
  private final EndSceneController controller;

  public EndView(EndSceneController controller){
    this.controller = controller;
  }
  public Scene setup(){
    HBox mainLayout = new HBox(new Label("End scene!"), new Label("completed: " + controller.getCompletedGoals().toString()), new Label(controller.getNonCompletedGoals().toString()));
    return new Scene(mainLayout);
  }
}
