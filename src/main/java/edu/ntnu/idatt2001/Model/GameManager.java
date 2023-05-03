package edu.ntnu.idatt2001.Model;

import edu.ntnu.idatt2001.Game;
import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Link;
import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.ScanStory;
import edu.ntnu.idatt2001.Story;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameManager {
  private Game game; //Assumes user will only edit/run 1 game at a time. Final?
  private Story story; //current story
  private Player player;
  private List<Goal> goals = new ArrayList<>();
  
  //returns a list of all files in the resources folder
  public Set<String> listFiles() {
    //TODO: add exceptions if path is invalid, or empty
    //TODO: filter or sort by file type (se filechooser)
    String dir = "src/main/resources";
    return Stream.of(new File(dir).listFiles())
            .filter(file -> !file.isDirectory())
            .map(File::getName)
            .collect(Collectors.toSet());
  }
  
  private void scanStory(File file) throws FileNotFoundException {
    //TODO: handle FineNotFoundException? Or handle somewhere else?
    ScanStory scan = new ScanStory();
    this.story = scan.scanStory(file);
  }
  
  //methods to init player. Modify to comply with builder:
  //TODO: refactor setPlayer method
  public void setPlayer(Player player){
    this.player = player;
  }
  
  public void setGoals(List<Goal> goals){
    this.goals = goals;
  }
  
  public void addGoal(Goal goal){
    game.getGoals().add(goal);
  }
  
  public void newGame(){
    //TODO: throw exceptions if story, player and goals are not filled out. Alt, take these as params
    this.game = new Game(this.player, this.story, this.goals);
  }
  
  public List<String> getBrokenLinks(){
    if(this.story == null){
      throw new IllegalArgumentException("The story is not defined");
    }
    List<Link> links = this.game.getStory().getBrokenLinks();
    if(links.isEmpty()){
      //throw exception? Or let this be handled later?
    }
    
    List<String> linkNames = new ArrayList<>();
    for(Link l : links){
      linkNames.add(l.getText());
    }
    return linkNames;
  }
  
  
  public Game getGame(){
    //return deep copy????
    return game;
  }
  
  //Are the methods below superfluous? Should the
  //class instead return the story object (or rather, a copy)
  //and controllers can use get-methods on these?
  public String getStoryTitle(){
    //handle exception, if story == null
    return story.getTitle();
  }
  
}
