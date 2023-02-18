package edu.ntnu.idatt2001;

import java.util.List;

public class Game {
  private Player player;
  private Story story;
  //private List<Goal> goals;
  
  
  public Game(Player player, Story story) {
    this.player = player;
    this.story = story;
  }
  
  public Player getPlayer() {
    return player;
  }
  
  public Story getStory() {
    return story;
  }
  
  //getGoals
  
  public Passage begin(){
    return story.getOpeningPassage();
  }
  
  public Passage go(Link link){
    return story.getPassage(link);
  }
}
