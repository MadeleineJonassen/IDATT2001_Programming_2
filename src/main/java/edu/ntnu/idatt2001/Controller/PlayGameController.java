package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Model.Link;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Model.Passage;
import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.View.PlayGameView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PlayGameController {
  private GameManager gameManager;
  private final Stage stage;
  private PlayGameView view;
  private SceneController sceneController = new SceneController();
  private Passage currentPassage;
  private List<Link> currentLinks;
  
  //TODO: exception handling

  public PlayGameController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    currentPassage = gameManager.getOpeningPassage();
    updateCurrentLinks();
    this.stage = stage;
    view = new PlayGameView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  //if new passage has no links -> endGame button/method (return "endGame"-link??)
  //Sort links by title, to keep order consistent?
  
  public String getStoryName(){
    return gameManager.getStoryTitle();
  }
  
  public String getPlayerInfo(){
    //use getGame.getPlayer, or getPlayer?
    //return string list, to be formatted in view?
    //TODO: update playerInfo on changes
    Player player = gameManager.getPlayer();
    return player.toString();
  }
  
  public void updateCurrentLinks(){
    //TODO: sort links by title (to keep order consistent)
    currentLinks = currentPassage.getLinks();
  }
  
  public List<String> getCurrentPassage(){
    List<String> passageInformation = new ArrayList<>();
    passageInformation.add(currentPassage.getTitle());
    passageInformation.add(currentPassage.getContent());
    
    return passageInformation;
  }
  
  public List<String> getLinkTitles(){
    List<String> linkTitles = new ArrayList<>();
    
    for (Link l : currentLinks){
      linkTitles.add(l.getText());
    }
    
    return linkTitles;
  }
  
  public void nextPassage(String linkTitle){
    Link link = null;
    
    for (Link l : currentLinks){
      if(l.getText().equals(linkTitle)){
        link = l;
      }
    }
    
    if(link == null){
      throw new IllegalArgumentException("Cannot find the matching link");
    }
    
    currentPassage = gameManager.nextPassage(link);
    updateCurrentLinks();
  }
  
  public List<Goal> getNonCompletedGoals(){
    List<Goal> allGoals = gameManager.getGoals();
    return allGoals.stream().filter(g -> !g.isFulfilled(gameManager.getPlayer())).toList();
  }
  
  public List<Goal> getCompletedGoals(){
    List<Goal> allGoals = gameManager.getGoals();
    return allGoals.stream().filter(g -> g.isFulfilled(gameManager.getPlayer())).toList();
  }
  
  public void mainMenu() throws Exception {
    sceneController.switchScene(stage, 1, gameManager);
  }
  
  public void endGame() throws Exception {
    sceneController.switchScene(stage, 7, gameManager);
  }
}
