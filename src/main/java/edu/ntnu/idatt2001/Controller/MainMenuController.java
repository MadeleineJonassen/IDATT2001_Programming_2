package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.GUI.MainMenu;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.View.MainMenuView;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The type Main menu controller.
 */
public class MainMenuController {

  private final GameManager gameManager;
  private final Stage stage;
  private final SceneController sceneController = new SceneController();
  private final boolean gameExists;
  
  /**
   * Instantiates a new Main menu controller.
   *
   * @param stage       the stage
   * @param gameManager the game manager
   */
  public MainMenuController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    gameExists = (gameManager.getGame() != null);
    this.stage = stage;
    MainMenuView view = new MainMenuView(this);
    stage.setScene(view.setup());
    stage.show();
    
  }
  
  /**
   * Does game exist boolean.
   *
   * @return the boolean
   */
  public boolean doesGameExist(){
    return gameExists;
  }
  
  /**
   * Create game.
   */
  public void createGame() {
    sceneController.switchScene(stage, 2, gameManager);
  }
  
  /**
   * Play game.
   */
  public void playGame() {
    if (!gameExists) {
      throw new IllegalArgumentException("The game has not been constructed");
    }
    sceneController.switchScene(stage, 6, gameManager);
  }
  
}
