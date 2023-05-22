package edu.ntnu.idatt2001.Model;

import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Goal.InventoryGoal;
import edu.ntnu.idatt2001.Players.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;
import java.util.stream.Collectors;

public class GameManager {
  private Game game;
  private PlayGameModel startedGame;
  private Story story;
  private Player player;
  private ObservableList<Goal> goalsList = FXCollections.observableList(new ArrayList<>());
  private ObservableList<Goal> completedGoalsList = FXCollections.observableList(new ArrayList<>());
  private ObservableList<Goal> nonCompletedGoalsList = FXCollections.observableList(new ArrayList<>());
  private ObservableList<String> playerList = FXCollections.observableList(new ArrayList<>());
  
  public void setStory(Story story){
    //TODO: check for broken links
    this.story = story;
  }
  
  public void setPlayer(Player player){
    this.player = player;
    playerList.clear();
    playerList.addAll(player.getName(),
            Integer.toString(player.getHealth()),
            Integer.toString(player.getGold()),
            Integer.toString(player.getScore()),
            player.getInventory().toString().replace("[", "").replace("]", ""));
  }
  
  public void addGoal(Goal goal){
    if(goalsList.contains(goal)){
      throw new IllegalArgumentException("Goal has already been added.");
    }
    goalsList.add(goal);
  }
  
  public ObservableList<Goal> getGoals(){
    return goalsList;
  }
  
  public ObservableList<Goal> getNonCompletedGoals(){
    return nonCompletedGoalsList;
  }
  
  public ObservableList<Goal> getCompletedGoals(){
    return completedGoalsList;
  }
  
  public ObservableList<String> getPlayerInfo(){
    return playerList;
  }
  
  public void clearGoals(){
    goalsList.clear();
  }
  
  public boolean storyHasBeenAdded(){
    return !(story == null);
  }
  
  public boolean playerHasBeenAdded(){
    return !(player == null);
  }
  
  public void createGame(){
    //This method is run when user clicks "run game"-button
    if(this.story == null){
      throw new NullPointerException("Story has not been added");
    }
    if(this.player == null){
      throw new NullPointerException("Player has not been added");
    }
    if(this.goalsList.isEmpty()){
      throw new NullPointerException("Goals have not been added");
    }
    this.game = new Game(this.player, this.story, this.goalsList.stream().toList());
  }
  
  public Game getGame(){
    //TODO: return deep copy????
    //method might not be needed, as the class provides relevant getters and
    //Game is only created when story, player etc is finished, so method might be nice for playGame-scene?
    if (this.game == null){
      return null;
    }
    
    return new Game(game);
  }
  
  public void setGameInProgress(PlayGameModel gameInProgress){
    this.startedGame = gameInProgress;
  }
  
  public PlayGameModel getGameInProgress(){
    return startedGame;
  }
  
  public String getPlayerName(){
    if(this.player == null){
      throw new IllegalArgumentException("The player is not defined");
    }
    return player.getName();
  }
  
  public Player getPlayer(){
    if(player == null){
      throw new IllegalArgumentException("Player has not been added.");
    }
    return player;
  }
  
  public List<String> getBrokenLinks(){
    if(this.story == null){
      throw new IllegalArgumentException("The story is not defined");
    }
    
    List<Link> links = this.story.getBrokenLinks();
    
    List<String> linkNames = new ArrayList<>();
    for(Link l : links){
      linkNames.add(l.getText());
    }
    return linkNames;
  }
  
  public void deleteBrokenLinks(){
    story.deleteBrokenLinks();
  }
  
  public String getStoryTitle(){
    if (this.story == null){
      throw new NullPointerException("Story must be added first");
    }
    return story.getTitle();
  }
  
  private Collection<Passage> getStoryPassages(){
    if (this.story == null){
      throw new NullPointerException("Story must be added first");
    }
    
    Collection<Passage> passages = this.story.getPassages();
    
    return passages;
  }
  
  public Set<String> getStoryPassageNames(){
    return getStoryPassages().stream().map(Passage::getTitle).collect(Collectors.toSet());
  }
  
  public Passage getOpeningPassage(){
    if (this.game == null){
      throw new NullPointerException("The game has not been created");
    }
    return this.game.getStory().getOpeningPassage();
  }
  
  public Passage nextPassage(Link link){
    if (this.game == null){
      throw new NullPointerException("The game has not been created");
    }
    Passage newPassage = this.game.go(link);
    //checkGoalCompletion();
    return newPassage;
  }
  
  private void checkGoalCompletion(){
    for(Goal g : nonCompletedGoalsList){
      if(g.isFulfilled(this.game.getPlayer())){
        if(nonCompletedGoalsList.size()>1){
          nonCompletedGoalsList.remove(g);
        } else if(nonCompletedGoalsList.size() == 1) {
          System.out.println(nonCompletedGoalsList);
          nonCompletedGoalsList.clear();
          System.out.println(nonCompletedGoalsList);
        }
        
        //List<String> placeHolder = new ArrayList<>();
        //placeHolder.add("Placeholder");
        //nonCompletedGoalsList.add(new InventoryGoal(placeHolder));
        //completedGoalsList.add(g);
      }
    }
  }
  
}
