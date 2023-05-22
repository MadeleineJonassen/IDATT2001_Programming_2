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
  
  /*public List<String> getLinkTitles(){
    List<String> linkTitles = new ArrayList<>();
    
    for (Link l : currentLinks){
      linkTitles.add(l.getText());
    }
    
    return linkTitles;
  }*/
  
  public void nextPassage(String linkTitle){
    model.nextPassage(linkTitle);
    /*Link link = null;
    
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
    
    updateObservableLists();*/
    
    //updateCurrentLinks();
  }
  private void updateObservableLists(){
    currentPassageText.clear();
    currentPassageText.addAll(currentPassage.getTitle(), currentPassage.getContent());
    
    //updateCurrentLinks();
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
