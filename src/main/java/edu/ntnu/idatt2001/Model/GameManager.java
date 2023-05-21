package edu.ntnu.idatt2001.Model;

import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Players.Player;

import java.util.*;
import java.util.stream.Collectors;

public class GameManager {
  private Game game; //Assumes user will only edit/run 1 game at a time. Final?
  private Story story; //current story. Is stored in game-object, superfluous to store here?
  private Player player;
  private List<Goal> goals = new ArrayList<>();
  
  public void setStory(Story story){
    //TODO: check for broken links
    this.story = story;
  }
  
  public void setPlayer(Player player){
    this.player = player;
  }
  
  public void addGoal(Goal goal){
    if(goals.contains(goal)){
      throw new IllegalArgumentException("Goal has already been added.");
    }
    goals.add(goal);
  }
  
  public List<Goal> getGoals(){
    return goals;
  }
  
  public void clearGoals(){
    goals.clear();
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
      throw new NullPointerException("Spillet har ingen story, dette må legges til før du oppretter et spill.");
    }
    if(this.player == null){
      throw new NullPointerException("Spillet har ingen player, dette må legges til før du oppretter et spill.");
    }
    if(this.goals.isEmpty()){
      throw new NullPointerException("Spillet har ingen goals, dette må legges til før du oppretter et spill.");
    }
    this.game = new Game(this.player, this.story, this.goals);
  }
  
  public Game getGame(){
    //TODO: return deep copy????
    //method might not be needed, as the class provides relevant getters and
    //Game is only created when story, player etc is finished, so method might be nice for playGame-scene?
    return new Game(game);
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
    return this.game.go(link);
  }
  
}
