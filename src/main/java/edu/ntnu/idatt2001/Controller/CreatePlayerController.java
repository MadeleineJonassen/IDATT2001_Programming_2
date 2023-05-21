package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.GUI.MainMenu;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.View.CreateGameView;
import edu.ntnu.idatt2001.View.CreatePlayerView;
import edu.ntnu.idatt2001.View.CreateStoryView;
import edu.ntnu.idatt2001.View.MainMenuView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.ntnu.idatt2001.GUI.MainMenu.playerErrorIcon;

public class CreatePlayerController {
  private GameManager gameManager;
  private final Stage stage;
  private CreatePlayerView view;
  private SceneController sceneController = new SceneController();
  private boolean playerExists;
  //TODO: getPlayer functionality


  public CreatePlayerController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    
    this.stage = stage;
    view = new CreatePlayerView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  public void createGame() throws Exception {
    sceneController.switchScene(stage, 2, gameManager);
  }
  
  
  public void submitPlayer(String name, String healthInput, String scoreInput, String goldInput, String ... inventoryItems) throws Exception {
    //TODO: error handling, taking no input as 0
    int health = Integer.parseInt(healthInput);
    int score = Integer.parseInt(scoreInput);
    int gold = Integer.parseInt(goldInput);
    List<String> inventory = List.of(inventoryItems);
    /*Player.Builder playerBuilder = new Player.Builder(name, health, score, gold, inventory);
    Player player = playerBuilder.build();*/
    
    Player player = new Player.Builder(name).health(health).score(score).gold(gold).inventory(inventory).build();
    
    
    gameManager.setPlayer(player);
    createGame();
  }
  
/*
  public void createGame() {
    CreateGameController controller = new CreateGameController(stage, this);
    controller.initialize();
  }



  /*
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
  public static boolean isString(){
    try{
     /* .\\d+. */
      //TODO: check to see if input is an integer
      return true;
    } catch(Exception e) {
      MainMenu.playerName.setPromptText("Please input a valid name");
      MainMenu.playerInventory.setPromptText("Please input a valid item");
      return false;
    }
  }

  public static boolean isInt() {
    try{
      int health = Integer.parseInt(MainMenu.playerHealth.getText());
      int gold = Integer.parseInt(MainMenu.playerGold.getText());
      int score = Integer.parseInt(MainMenu.playerScore.getText());
      return true;
    } catch(NumberFormatException e) {
      MainMenu.playerHealth.setPromptText("Please input a valid number");
      MainMenu.playerHealth.getStyleClass().add("errorText");
      MainMenu.playerGold.setPromptText("Please input a valid number");
      MainMenu.playerGold.getStyleClass().add("errorText");
      MainMenu.playerScore.setPromptText("Please input a valid number");
      MainMenu.playerScore.getStyleClass().add("errorText");
      MainMenu.playerErrorIcon.getStyleClass().add("errorImage");

      return false;
    }
  }
  
}
