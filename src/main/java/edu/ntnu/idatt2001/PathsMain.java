package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.controller.SceneController;
import edu.ntnu.idatt2001.model.GameManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The type Paths main.
 */
public class PathsMain extends Application {
  
  private Stage primaryStage;
  private GameManager gameManager;
  
  
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    gameManager = new GameManager();
    SceneController sceneController = new SceneController();
    sceneController.switchScene(primaryStage, 1, gameManager);
  }
}
