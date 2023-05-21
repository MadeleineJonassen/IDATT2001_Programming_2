package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Model.Link;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Model.Passage;
import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.View.PlayGameView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

public class PlayGameController {
  private GameManager gameManager;
  private final Stage stage;
  private PlayGameView view;
  private SceneController sceneController = new SceneController();
  private Passage currentPassage; //observable???
  private ObservableList<String> currentPassageText = FXCollections.observableArrayList();
  private ObservableList<String> currentLinkTitles = FXCollections.observableArrayList();
  private ObservableList<String> currentPlayerInfo = FXCollections.observableArrayList();
  private ObservableList<Goal> noncompletedGoals = FXCollections.observableArrayList();
  private ObservableList<Goal> completedGoals = FXCollections.observableArrayList();
  private List<Link> currentLinks;
  
  //TODO: exception handling

  public PlayGameController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    currentPassage = gameManager.getOpeningPassage();
    updateObservableLists();
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
  
  public ObservableList<String> getCurrentPlayer(){
    return currentPlayerInfo;
  }
  
  private void updateCurrentLinks(){
    currentLinks = currentPassage.getLinks();
  }
  
  /*public List<String> getCurrentPassage(){
    List<String> passageInformation = new ArrayList<>();
    passageInformation.add(currentPassage.getTitle());
    passageInformation.add(currentPassage.getContent());
    
    return passageInformation;
  }*/
  
  public ObservableList<String> getPassageText(){
    return currentPassageText;
  }
  
  public ObservableList<String> getLinkTitles(){
    return currentLinkTitles;
  }
  
  /*public List<String> getLinkTitles(){
    List<String> linkTitles = new ArrayList<>();
    
    for (Link l : currentLinks){
      linkTitles.add(l.getText());
    }
    
    return linkTitles;
  }*/
  
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
    
    try{
      currentPassage = gameManager.nextPassage(link);
    } catch (Exception ex){
      System.out.println("Something wrong with nextPassage in GameManager");
      System.out.println(link.getText() + " | " + link.getReference());
      System.out.println(link.getActions().toString());
    }
    
    updateObservableLists();
  }
  
  private void updateObservableLists(){
    currentPassageText.clear();
    currentPassageText.addAll(currentPassage.getTitle(), currentPassage.getContent());
    
    updateCurrentLinks();
    currentLinkTitles.clear();
    for(Link l : currentLinks){
      currentLinkTitles.add(l.getText());
    }
    
    //TODO: update player more cleanly
    currentPlayerInfo.clear();
    currentPlayerInfo.addAll(
    gameManager.getGame().getPlayer().getName(),
    Integer.toString(gameManager.getGame().getPlayer().getGold()),
    Integer.toString(gameManager.getGame().getPlayer().getHealth()),
    Integer.toString(gameManager.getGame().getPlayer().getScore()),
    gameManager.getGame().getPlayer().getInventory().toString()
    );
    
    //goals
    noncompletedGoals.clear();
    noncompletedGoals = gameManager.getGoals().stream().filter(g -> !g.isFulfilled(gameManager.getPlayer())).collect(Collectors.toCollection(FXCollections::observableArrayList));
    
    completedGoals.clear();
    completedGoals = gameManager.getGoals().stream().filter(g -> g.isFulfilled(gameManager.getPlayer())).collect(Collectors.toCollection(FXCollections::observableArrayList));
  }
  
  public ObservableList<Goal> getNoncompletedGoals(){
    return noncompletedGoals;
  }
  
  public ObservableList<Goal> getCompletedGoals(){
    return completedGoals;
  }
  
  public void mainMenu() {
    sceneController.switchScene(stage, 1, gameManager);
  }
  
  public void endGame() {
    sceneController.switchScene(stage, 7, gameManager);
  }
}
