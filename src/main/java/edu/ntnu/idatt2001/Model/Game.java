package edu.ntnu.idatt2001.Model;

import edu.ntnu.idatt2001.Action.*;
import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Players.Player;

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
  
  public Game(Game game){
    this.player = game.getPlayer();
    this.story = game.getStory();
    this.goals = game.getGoals();
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
    //TODO: excecute actions in link, does not currently work
    List<Action> linkActions = link.getActions();
    if(linkActions.size() > 0){
      for(int i = 0; i < linkActions.size(); i++){
        Action action = linkActions.get(i);
        action.execute(player);
      }
    }
    
    return story.getPassage(link);
  }
}
