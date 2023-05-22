package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.*;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.View.AddGoalView;
import edu.ntnu.idatt2001.View.CreateGameView;
import edu.ntnu.idatt2001.View.CreateGoalsView;
import edu.ntnu.idatt2001.View.MainMenuView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

/**
 * The type Create goals controller.
 */
public class CreateGoalsController {
  private final GameManager gameManager;
  private final Stage stage;
  private final SceneController sceneController = new SceneController();
  
  
  /**
   * Instantiates a new Create goals controller.
   *
   * @param stage       the stage
   * @param gameManager the game manager
   */
  public CreateGoalsController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    this.stage = stage;
    CreateGoalsView view = new CreateGoalsView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  /**
   * Create game.
   *
   */
  public void createGame() {
    sceneController.switchScene(stage, 2, gameManager);
  }
  
  /**
   * Get goals list observable list.
   *
   * @return the observable list
   */
  public ObservableList<Goal> getGoalsList(){
    return gameManager.getGoals();
  }
  
  /**
   * Add single goal.
   */
  public void addSingleGoal(){
    Stage addGoalWindow = new Stage();
    //addGoalWindow.initModality(Modality.APPLICATION_MODAL);  //makes the user take care of the window in front of them
    AddGoalController addGoalController = new AddGoalController(gameManager, addGoalWindow);
  }
  
  /**
   * Clear goals.
   */
  public void clearGoals(){
    gameManager.clearGoals();
  }
}
