package edu.ntnu.idatt2001.controller;


import edu.ntnu.idatt2001.model.GameManager;
import edu.ntnu.idatt2001.model.Goal.Goal;
import edu.ntnu.idatt2001.view.CreateGoalsView;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

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
  public CreateGoalsController(Stage stage, GameManager gameManager) {
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
  
  public boolean goalsHaveBeenAdded() {
    return !gameManager.getGoals().isEmpty();
  }
  
  /**
   * Get goals list observable list.
   *
   * @return the observable list
   */
  public ObservableList<Goal> getGoalsList() {
    return gameManager.getGoals();
  }
  
  /**
   * Add single goal.
   */
  public void addSingleGoal() {
    Stage addGoalWindow = new Stage();
    AddGoalController addGoalController = new AddGoalController(gameManager, addGoalWindow);
  }
  
  /**
   * Clear goals.
   */
  public void clearGoals() {
    gameManager.clearGoals();
  }
}
