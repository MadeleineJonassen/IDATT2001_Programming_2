package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.controller.SceneController;
import edu.ntnu.idatt2001.model.GameManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Set up of the application.
 */
public class PathsMain extends Application {
  
  private Stage primaryStage;
  private GameManager gameManager;
  
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    gameManager = new GameManager();
    SceneController sceneController = new SceneController();
    sceneController.switchScene(primaryStage, 1, gameManager);
  }
  
  @Override
  public void stop() {
    System.exit(0);
  }
}
