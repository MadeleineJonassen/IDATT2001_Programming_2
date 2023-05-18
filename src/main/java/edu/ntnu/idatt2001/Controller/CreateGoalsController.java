package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.*;
import edu.ntnu.idatt2001.Model.GameManager;

import java.util.Arrays;
import java.util.List;

public class CreateGoalsController {
  private GameManager gameManager;
  
  public CreateGoalsController(GameManager gameManager) {
    this.gameManager = gameManager;
  }
  
  public void addGoal(int goalTypeSelection, String value){
    //user selects goal type, 0=Gold, 1=Health, 2=Inventory, 3=Score
    
    
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
    
  }
  
  public void clearGoals(){
  
  }
}
