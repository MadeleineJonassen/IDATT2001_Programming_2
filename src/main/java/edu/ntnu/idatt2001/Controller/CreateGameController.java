package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.*;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Passage;
import edu.ntnu.idatt2001.ScanStory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateGameController {
  private GameManager gameManager = new GameManager();
  
  public CreateGameController(GameManager gameManager){
    this.gameManager = gameManager;
  }
  
  /** Lists all files in the resources folder. Returns a set of strings
   *
   * @return files
   */
  public Set<String> listFiles() {
    //TODO: add exceptions if path is invalid, or empty
    //TODO: filter or sort by file type (se filechooser)
    //possibly not within the scope of this class
    String dir = "src/main/resources";
    return Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
            .filter(file -> !file.isDirectory())
            .map(File::getName)
            .collect(Collectors.toSet());
  }
  
  public void scanStory(String fileName) throws FileNotFoundException {
    //TODO: exception handling
    File file = new File("src/main/resources" + fileName);
    scanStory(file);
  }
  
  //Used if user is presented with the files
  public void scanStory(File file) throws FileNotFoundException {
    //TODO: handle FileNotFoundException
    try{
      ScanStory scan = new ScanStory();
      gameManager.setStory(scan.scanStory(file));
    }catch (FileNotFoundException e){
      throw new FileNotFoundException("Finner ikke den angitte filen ");
    }
    
  }
  
  public void deletePassage(String passageName){
    //remove passage from story
    //return passages that link to this passage, so that user may delete these?
    //Alternatively, add possibility to edit passages (separate window)
  }
  
  
  
  public void editPassage(String passageName){
    //Open popup window
  }
  
  
  public void addPlayer(String name, int health, int score, int gold, List<String> inventory){
    //TODO: use builder-constructor
    //use the non-empty input-fields to build player object
    
    
  }
  
  public String addGoal(int goalTypeSelection, String value){
    //user selects goal type, 0=Gold, 1=Health, 2=Inventory, 3=Score
    
    try {
      if(value.isEmpty()){
        throw new IllegalArgumentException("You need to specify yhe amount/item");
      }
      Goal goal;
      switch (goalTypeSelection) {
        case 0 -> goal = new GoldGoal(Integer.parseInt(value));
        case 1 -> goal = new HealthGoal(Integer.parseInt(value));
        case 2 -> {
          List<String> inventoryGoal = Arrays.asList(value.split("[,?.@]"));
          goal = new InventoryGoal(inventoryGoal);
        }
        case 3 -> goal = new ScoreGoal(Integer.parseInt(value));
        default -> throw new IllegalArgumentException("Goal selection must be from 0-3");
      }
      
      gameManager.addGoal(goal);
      return "Goal was added";
    }catch (NumberFormatException e){
      return "The amount cannot be text or signs, only numbers";
    }catch (IllegalArgumentException e){
      return e.getMessage();
    }
  }
  
  
  
  
  
  
  
  
  
  
  
  

}
