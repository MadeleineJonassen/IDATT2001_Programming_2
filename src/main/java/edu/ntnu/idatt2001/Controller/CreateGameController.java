package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.View.CreateGameView;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class CreateGameController {
  private final Stage stage;
  private CreateGameView view;
  private GameManager gameManager;
  SceneController sceneController = new SceneController();
  private boolean gameIsConstructed;

  public CreateGameController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    constructGame();
    gameIsConstructed = !(gameManager.getGame() == null);
    this.stage = stage;
    view = new CreateGameView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  public String getStoryName(){
    try {
      return gameManager.getStoryTitle();
    } catch (Exception e){
      System.out.println(e.getMessage());
      return "The story has not been added";
    }
  }
  
  public String getPlayerName(){
    try {
      return gameManager.getPlayerName();
    } catch (Exception e){
      System.out.println(e.getMessage());
      return "The player has not been added";
    }
  }
  
  public ObservableList<Goal> getGoalsList(){
    return gameManager.getGoals();
  }
  
  public void mainMenu() {
    sceneController.switchScene(stage, 1, gameManager);
  }
  
  public void createStory() {
    sceneController.switchScene(stage, 3, gameManager);
  }
  
  public void createPlayer() {
    sceneController.switchScene(stage, 4, gameManager);
  }
  
  public void createGoals() {
    sceneController.switchScene(stage, 5, gameManager);
  }
  
  public void playGame() {
    sceneController.switchScene(stage, 6, gameManager);
  }
  
  private void constructGame(){
    try {
      boolean player = gameManager.playerHasBeenAdded();
      boolean story = gameManager.storyHasBeenAdded();
      boolean goals = !gameManager.getGoals().isEmpty();
      
      if(!gameIsConstructed && player && story && goals){
        gameManager.createGame();
      }
    }catch (Exception ex){
      System.out.println(ex.getMessage());
    }
    
  }
  
  public boolean isGameConstructed(){
    return gameIsConstructed;
  }

}
