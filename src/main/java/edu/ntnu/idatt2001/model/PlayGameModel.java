package edu.ntnu.idatt2001.model;

import edu.ntnu.idatt2001.goal.Goal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Play game model.
 */
public class PlayGameModel {
  private Game game;
  private ObservableList<String> currentPassageText = FXCollections.observableArrayList();
  private ObservableList<String> currentLinkTitles = FXCollections.observableArrayList();
  private ObservableList<String> currentPlayerInfo = FXCollections.observableArrayList();
  private ObservableList<Goal> completedGoalsList = FXCollections.observableList(new ArrayList<>());
  private ObservableList<Goal> nonCompletedGoalsList = FXCollections.observableList(new ArrayList<>());
  private Passage currentPassage;
  private List<Link> currentLinks;
  
  /**
   * Instantiates a new Play game model.
   *
   * @param game the game
   */
  public PlayGameModel(Game game) {
    this.game = game;
    currentPassage = game.begin();
    updateCurrentLinks();
    updatePassageInfo();
    updatePlayerInfo();
    nonCompletedGoalsList.addAll(game.getGoals());
  }
  
  /**
   * Get story title string.
   *
   * @return the string
   */
  public String getStoryTitle(){
    return this.game.getStory().getTitle();
  }
  
  /**
   * Get passage text observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getPassageText(){
    return this.currentPassageText;
  }
  
  /**
   * Get links text observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getLinksText(){
    return this.currentLinkTitles;
  }
  
  /**
   * Get player info observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getPlayerInfo(){
    return this.currentPlayerInfo;
  }
  
  /**
   * Get non completed goals observable list.
   *
   * @return the observable list
   */
  public ObservableList<Goal> getNonCompletedGoals(){
    return nonCompletedGoalsList;
  }
  
  /**
   * Get completed goals observable list.
   *
   * @return the observable list
   */
  public ObservableList<Goal> getCompletedGoals(){
    return completedGoalsList;
  }
  
  /**
   * Next passage.
   *
   * @param linkText the link text
   */
  public void nextPassage(String linkText){
    Link link = null;
    
    for (Link l : currentLinks){
      if(l.getText().equals(linkText)){
        link = l;
      }
    }
    
    if(link == null){
      throw new IllegalArgumentException("Cannot find the matching link");
    }
    
    try{
      currentPassage = game.go(link);
    } catch (Exception ex){
      throw new IllegalArgumentException("Cannot find passage");
    }
    
    updateCurrentLinks();
    updatePassageInfo();
    checkGoalCompletion();
    updatePlayerInfo();
    
    //updateObservableLists();
    //Passage newPassage = this.game.go(link);
    //checkGoalCompletion();
    //return newPassage;
  }
  
  private void updateCurrentLinks(){
    currentLinks = currentPassage.getLinks();
    currentLinkTitles.clear();
    for (Link l : currentLinks){
      currentLinkTitles.add(l.getText());
    }
  }
  
  private void updatePassageInfo(){
    currentPassageText.clear();
    currentPassageText.addAll(currentPassage.getTitle(), currentPassage.getContent());
  }
  
  private void updatePlayerInfo(){
    currentPlayerInfo.clear();
    currentPlayerInfo.addAll(
            this.game.getPlayer().getName(),
            Integer.toString(this.game.getPlayer().getGold()),
            Integer.toString(this.game.getPlayer().getHealth()),
            Integer.toString(this.game.getPlayer().getScore()),
            this.game.getPlayer().getInventory().toString()
    );
  }
  
  private void checkGoalCompletion(){
    for(Goal g : nonCompletedGoalsList){
      if(g.isFulfilled(this.game.getPlayer())){
        if(nonCompletedGoalsList.size()>1){
          nonCompletedGoalsList.remove(g);
        } else if(nonCompletedGoalsList.size() == 1) {
          nonCompletedGoalsList.clear();
        }
        
        //List<String> placeHolder = new ArrayList<>();
        //placeHolder.add("Placeholder");
        //nonCompletedGoalsList.add(new InventoryGoal(placeHolder));
        completedGoalsList.add(g);
      }
    }
  }
}
