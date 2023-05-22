package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Controller.SceneController;
import edu.ntnu.idatt2001.Model.GameManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Window;

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
