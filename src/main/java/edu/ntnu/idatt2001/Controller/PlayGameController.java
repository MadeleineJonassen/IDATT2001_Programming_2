package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Model.Link;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Model.Passage;
import edu.ntnu.idatt2001.Model.PlayGameModel;
import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.View.PlayGameView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayGameController {
  private GameManager gameManager;
  private PlayGameModel model;
  private final Stage stage;
  private PlayGameView view;
  private SceneController sceneController = new SceneController();
  private Passage currentPassage;
  private List<Link> currentLinks;
  private ObservableList<String> currentPassageText = FXCollections.observableArrayList();
  private ObservableList<String> currentLinkTitles = FXCollections.observableArrayList();
  private ObservableList<String> currentPlayerInfo = FXCollections.observableArrayList();
  
  //TODO: exception handling

  public PlayGameController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    this.stage = stage;
    view = new PlayGameView(this);
    model = new PlayGameModel(gameManager.getGame());
    stage.setScene(view.setup());
    stage.show();
  }
  
  public String getStoryName(){
    return model.getStoryTitle();
  }
  
  public ObservableList<String> getCurrentPlayer(){
    return model.getPlayerInfo();
  }
  
  public ObservableList<String> getPassageText(){
    return model.getPassageText();
  }
  
  public ObservableList<String> getLinkTitles(){
    return model.getLinksText();
  }
  
  public void nextPassage(String linkTitle){
    model.nextPassage(linkTitle);
  }
  
  public ObservableList<Goal> getNoncompletedGoals(){
    return model.getNonCompletedGoals();
  }
  
  
  public ObservableList<Goal> getCompletedGoals(){
    return model.getCompletedGoals();
  }
  
  
  public void mainMenu() {
    //TODO: save game progress
    gameManager.setGameInProgress(model);
    sceneController.switchScene(stage, 1, gameManager);
  }
  
  public void endGame() {
    sceneController.switchScene(stage, 7, gameManager);
  }
}
