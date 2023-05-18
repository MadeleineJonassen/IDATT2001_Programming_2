package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class CreatePlayerController {
  private GameManager gameManager;
  
  private Player player;
  private List<String> inventory = new ArrayList<>();
  
  public CreatePlayerController(GameManager gameManager) {
    this.gameManager = gameManager;
    //this.player = new Player.Builder();
    //player.inventory(inventory);
    //if (gameManager.getPlayer.getInventory != null) {this.inventory = gameManager.getPlayer.getInventory}
    //^^ to sync inventory items for builder
  }
  /*
  
  //attach listeners in view?
  
  public void setName(int name){
    player.name(name);
  }
  
  public void setHealth(int health){
    player.health(health);
  }
  
  public void setScore(int score){
    player.score(score);
  }
  
  public void setGold(int gold){
    player.gold(gold);
  }
  
  public void setInventory(String inventoryItem){
    this.inventory.add(inventoryItem);
  }
  
  public void build(){
    //build player, send to model. Use method in view, when user presses button
    //error handling here!!

    gameManager.setPlayer(player.build);
  }
  
  */
  
}
