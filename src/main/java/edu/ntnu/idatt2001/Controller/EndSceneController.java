package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.View.EndView;
import edu.ntnu.idatt2001.View.MainMenuView;
import javafx.stage.Stage;

import java.util.List;

/**
 * The type End scene controller.
 */
public class EndSceneController {
  private final GameManager gameManager;
  private final Stage stage;
  
  
  /**
   * Instantiates a new End scene controller.
   *
   * @param stage       the stage
   * @param gameManager the game manager
   */
  public EndSceneController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    this.stage = stage;
    EndView view = new EndView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  /**
   * Get completed goals list.
   *
   * @return the list
   */
  public List<Goal> getCompletedGoals(){
    return gameManager.getGoals().stream().filter(g -> g.isFulfilled(gameManager.getPlayer())).toList();
  }
  
  /**
   * Get non completed goals list.
   *
   * @return the list
   */
  public List<Goal> getNonCompletedGoals(){
    return gameManager.getGoals().stream().filter(g -> !g.isFulfilled(gameManager.getPlayer())).toList();
  }
  
  /**
   * Main menu.
   */
  public void mainMenu() {
    SceneController sceneController = new SceneController();
    sceneController.switchScene(stage, 1, gameManager);
  }
  
}
