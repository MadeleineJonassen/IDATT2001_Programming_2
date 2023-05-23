package edu.ntnu.idatt2001.controller;

import edu.ntnu.idatt2001.Goal.*;
import edu.ntnu.idatt2001.model.GameManager;
import edu.ntnu.idatt2001.model.Goal.*;
import edu.ntnu.idatt2001.view.AddGoalView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Add goal controller.
 */
public class AddGoalController {
  private final GameManager gameManager;
  private final Stage stage;
  
  /**
   * Instantiates a new Add goal controller.
   *
   * @param gameManager the game manager
   * @param stage       the stage
   */
  public AddGoalController(GameManager gameManager, Stage stage) {
    this.gameManager = gameManager;
    this.stage = stage;
    stage.initModality(Modality.APPLICATION_MODAL);  //makes the user take care of the window in front of them
    AddGoalView view = new AddGoalView(this);
    stage.setScene(view.setup());
    stage.showAndWait();
  }
  
  /**
   * Close window.
   */
  public void closeWindow(){
    stage.close();
  }
  
  /**
   * Add gold goal.
   *
   * @param amount the amount
   */
  public void addGoldGoal(int amount){
    Goal goldGoal = new GoldGoal(amount);
    gameManager.addGoal(goldGoal);
  }
  
  /**
   * Add score goal.
   *
   * @param amount the amount
   */
  public void addScoreGoal(int amount){
    Goal scoreGoal = new ScoreGoal(amount);
    gameManager.addGoal(scoreGoal);
  }
  
  /**
   * Add health goal.
   *
   * @param amount the amount
   */
  public void addHealthGoal(int amount){
    Goal healthGoal = new HealthGoal(amount);
    gameManager.addGoal(healthGoal);
  }
  
  /**
   * Add inventory goal.
   *
   * @param item the item
   */
  public void addInventoryGoal(String item){
    List<String> items = new ArrayList<>();
    items.add(item);
    Goal inventoryGoal = new InventoryGoal(items);
    gameManager.addGoal(inventoryGoal);
  }

}
