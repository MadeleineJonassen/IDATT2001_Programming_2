package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Goal.Goal;

import java.util.ArrayList;
import java.util.List;


public class Game {
  private final Player player;
  private final Story story;
  private List<Goal> goals = new ArrayList<>();
  
  
  public Game(Player player, Story story, List<Goal> goals) {
    this.player = player;
    this.story = story;
    this.goals = goals;
  }
  
  public Player getPlayer() {
    return player;
  }
  
  public Story getStory() {
    return story;
  }
  
  public List<Goal> getGoals(){
    return goals;
  }
  
  public Passage begin(){
    return story.getOpeningPassage();
  }
  
  public Passage go(Link link){
    return story.getPassage(link);
  }
}
