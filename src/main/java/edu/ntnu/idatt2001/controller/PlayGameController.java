package edu.ntnu.idatt2001.controller;

import edu.ntnu.idatt2001.model.GameManager;
import edu.ntnu.idatt2001.model.Goal.Goal;
import edu.ntnu.idatt2001.model.PlayGameModel;
import edu.ntnu.idatt2001.view.PlayGameView;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 * The type Play game controller.
 */
public class PlayGameController {
  private final GameManager gameManager;
  private final PlayGameModel model;
  private final Stage stage;
  private final SceneController sceneController = new SceneController();
  
  /**
   * Instantiates a new Play game controller.
   *
   * @param stage       the stage
   * @param gameManager the game manager
   */
  public PlayGameController(Stage stage, GameManager gameManager) {
    this.gameManager = gameManager;
    this.stage = stage;
    PlayGameView view = new PlayGameView(this);
    model = new PlayGameModel(gameManager.getGame());
    stage.setScene(view.setup());
    stage.show();
  }
  
  /**
   * Get story name string.
   *
   * @return the string
   */
  public String getStoryName() {
    return model.getStoryTitle();
  }
  
  /**
   * Get current player observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getCurrentPlayer() {
    return model.getPlayerInfo();
  }
  
  /**
   * Get passage text observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getPassageText() {
    return model.getPassageText();
  }
  
  /**
   * Get link titles observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getLinkTitles() {
    return model.getLinksText();
  }
  
  /**
   * Next passage.
   *
   * @param linkTitle the link title
   */
  public void nextPassage(String linkTitle) {
    model.nextPassage(linkTitle);
  }
  
  /**
   * Get noncompleted goals observable list.
   *
   * @return the observable list
   */
  public ObservableList<Goal> getNoncompletedGoals() {
    return model.getNonCompletedGoals();
  }
  
  
  /**
   * Get completed goals observable list.
   *
   * @return the observable list
   */
  public ObservableList<Goal> getCompletedGoals() {
    return model.getCompletedGoals();
  }
  
  
  /**
   * Main menu.
   */
  public void mainMenu() {
    gameManager.setGameInProgress(model);
    sceneController.switchScene(stage, 1, gameManager);
  }
  
  /**
   * End game.
   */
  public void endGame() {
    sceneController.switchScene(stage, 7, gameManager);
  }
}
