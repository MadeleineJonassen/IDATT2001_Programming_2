package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.GUI.MainMenu;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.View.MainMenuView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {

  private GameManager gameManager;
  private MainMenuView view;
  private final Stage stage;
  private SceneController sceneController = new SceneController();

  public MainMenuController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    this.stage = stage;
    view = new MainMenuView(this);
    stage.setScene(view.setup());
    stage.show();
    
  }

  public void createGame() throws Exception {
    sceneController.switchScene(stage, 2, gameManager);
  }

  public void playGame() throws Exception {
    sceneController.switchScene(stage, 6, gameManager);
  }
  
}
