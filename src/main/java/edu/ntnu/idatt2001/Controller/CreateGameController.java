package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.*;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Passage;
import edu.ntnu.idatt2001.ScanStory;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateGameController {
  private GameManager gameManager = new GameManager();
  private final SceneController sceneController = new SceneController();
  
  public CreateGameController(GameManager gameManager){
    this.gameManager = gameManager;
  }
  
  public void createStoryScene(Stage stage){
    sceneController.switchScene(stage, 3, gameManager);
  }
  
  public void createPlayerScene(Stage stage){
    sceneController.switchScene(stage, 4, gameManager);
  }
  
  public void createGoalsScene(Stage stage){
    sceneController.switchScene(stage, 5, gameManager);
  }
  
}
