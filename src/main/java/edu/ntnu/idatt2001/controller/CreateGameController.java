package edu.ntnu.idatt2001.controller;

import edu.ntnu.idatt2001.goal.Goal;
import edu.ntnu.idatt2001.model.GameManager;
import edu.ntnu.idatt2001.view.CreateGameView;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 * The type Create game controller.
 */
public class CreateGameController {
  private final Stage stage;
  private final GameManager gameManager;
  /**
   * The Scene controller.
   */
  SceneController sceneController = new SceneController();
  private final boolean gameIsConstructed;
  
  /**
   * Instantiates a new Create game controller.
   *
   * @param stage       the stage
   * @param gameManager the game manager
   */
  public CreateGameController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    constructGame();
    gameIsConstructed = (gameManager.getGame() != null);
    this.stage = stage;
    CreateGameView view = new CreateGameView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  /**
   * Get story name string.
   *
   * @return the string
   */
  public String getStoryName(){
    
    try {
      return gameManager.getStoryTitle();
    } catch (Exception e){
      return "The story has not been added";
    }
  }
  
  /**
   * Get player name string.
   *
   * @return the string
   */
  public String getPlayerName(){
    try {
      return gameManager.getPlayerName();
    } catch (Exception e){
      return "The player has not been added";
    }
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
   * Main menu.
   */
  public void mainMenu() {
    sceneController.switchScene(stage, 1, gameManager);
  }
  
  /**
   * Create story.
   */
  public void createStory() {
    sceneController.switchScene(stage, 3, gameManager);
  }
  
  /**
   * Create player.
   */
  public void createPlayer() {
    sceneController.switchScene(stage, 4, gameManager);
  }
  
  /**
   * Create goals.
   */
  public void createGoals() {
    sceneController.switchScene(stage, 5, gameManager);
  }
  
  /**
   * Play game.
   */
  public void playGame() {
    sceneController.switchScene(stage, 6, gameManager);
  }
  
  private void constructGame(){
    
    boolean player = gameManager.playerHasBeenAdded();
    boolean story = gameManager.storyHasBeenAdded();
    boolean goals = !gameManager.getGoals().isEmpty();
    
    if(!gameIsConstructed && player && story && goals){
      gameManager.createGame();
    }
  }
  
  /**
   * Is game constructed boolean.
   *
   * @return the boolean
   */
  public boolean isGameConstructed(){
    return gameIsConstructed;
  }

}
