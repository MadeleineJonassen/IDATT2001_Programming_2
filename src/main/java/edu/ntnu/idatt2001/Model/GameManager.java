package edu.ntnu.idatt2001.Model;

import edu.ntnu.idatt2001.*;
import edu.ntnu.idatt2001.Goal.Goal;
import edu.ntnu.idatt2001.Players.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
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
    return Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
            .filter(file -> !file.isDirectory())
            .map(File::getName)
            .collect(Collectors.toSet());
  }
  
  public void scanStory(File file) throws FileNotFoundException {
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
  
  public void createGame(){
    //TODO: throw exceptions if story, player and goals are not filled out. Alt, take these as params
    this.game = new Game(this.player, this.story, this.goals);
  }
  
  public Game getGame(){
    //TODO: return deep copy????
    //method might not be needed, as the class provides relevant get-methods
    return game;
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
  
  public String getStoryTitle(){
    if (this.story == null){
      throw new NullPointerException("Story must be added first");
    }
    return story.getTitle();
  }
  
  public Collection<Passage> getStoryPassages(){
    if (this.story == null){
      throw new NullPointerException("Story must be added first");
    }
    
    Collection<Passage> passages = this.story.getPassages();
    
    //TODO: deep copies???
    
    return passages;
  }
  
  public Set<String> getStoryPassageNames(){
    return getStoryPassages().stream().map(Passage::getTitle).collect(Collectors.toSet());
  }
  
  //Methods to modify story etc? Or do this directly in controller?
  
}
