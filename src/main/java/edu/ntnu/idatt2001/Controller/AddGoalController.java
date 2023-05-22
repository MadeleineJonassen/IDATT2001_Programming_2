package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.*;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.View.AddGoalView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AddGoalController {
  private GameManager gameManager;
  private final Stage stage;
  private AddGoalView view;
  private Goal goal;
  
  public AddGoalController(GameManager gameManager, Stage stage) {
    this.gameManager = gameManager;
    this.stage = stage;
    stage.initModality(Modality.APPLICATION_MODAL);  //makes the user take care of the window in front of them
    view = new AddGoalView(this);
    stage.setScene(view.setup());
    stage.showAndWait();
  }
  
  public void closeWindow(){
    stage.close();
  }
  
  public void addGoldGoal(int amount){
    Goal goldGoal = new GoldGoal(amount);
    gameManager.addGoal(goldGoal);
  }
  
  public void addScoreGoal(int amount){
    Goal scoreGoal = new ScoreGoal(amount);
    gameManager.addGoal(scoreGoal);
  }
  
  public void addHealthGoal(int amount){
    Goal healthGoal = new HealthGoal(amount);
    gameManager.addGoal(healthGoal);
  }
  
  public void addInventoryGoal(String item){
    List<String> items = new ArrayList<>();
    items.add(item);
    Goal inventoryGoal = new InventoryGoal(items);
    gameManager.addGoal(inventoryGoal);
  }

}
