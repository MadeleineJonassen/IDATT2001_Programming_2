package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.EndSceneController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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