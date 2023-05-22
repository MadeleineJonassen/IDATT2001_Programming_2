package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.GUI.MainMenu;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.View.CreateGameView;
import edu.ntnu.idatt2001.View.CreatePlayerView;
import edu.ntnu.idatt2001.View.CreateStoryView;
import edu.ntnu.idatt2001.View.MainMenuView;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.ntnu.idatt2001.GUI.MainMenu.playerErrorIcon;

/**
 * The type Create player controller.
 */
public class CreatePlayerController {
  private final GameManager gameManager;
  private final Stage stage;
  private final SceneController sceneController = new SceneController();
  
  /**
   * Instantiates a new Create player controller.
   *
   * @param stage       the stage
   * @param gameManager the game manager
   */
  public CreatePlayerController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    this.stage = stage;
    CreatePlayerView view = new CreatePlayerView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  /**
   * Get player info observable list.
   *
   * @return the observable list
   */
  public ObservableList<String> getPlayerInfo(){
    return gameManager.getPlayerInfo();
  }
  
  /**
   * Create game.
   *
   */
  public void createGame() {
    sceneController.switchScene(stage, 2, gameManager);
  }
  
  
  /**
   * Submit player.
   *
   * @param name           the name
   * @param healthInput    the health input
   * @param scoreInput     the score input
   * @param goldInput      the gold input
   * @param inventoryInput the inventory input
   */
  public void submitPlayer(String name, String healthInput, String scoreInput, String goldInput, String inventoryInput) {
    if(name.isBlank()){
      throw new IllegalArgumentException("Name must be filled out");
    }
    if(healthInput.isBlank()){
      throw new IllegalArgumentException("Health must be filled out");
    }
    if(goldInput.isBlank()){
      throw new IllegalArgumentException("Gold amount must be filled out");
    }
    int health = Integer.parseInt(healthInput);
    int gold = Integer.parseInt(goldInput);
    int score = 0;
    if(!scoreInput.isBlank()){
      score = Integer.parseInt(scoreInput);
    }
    List<String> inventory = new ArrayList<>();
    if(!inventoryInput.isBlank()){
      inventory = Arrays.stream(inventoryInput.split(", ")).toList();
    }
 
    Player player = new Player.Builder(name, health, gold).score(score).inventory(inventory).build();
    gameManager.setPlayer(player);
    createGame();
  }
  
  /**
   * Sets string.
   *
   * @return the string
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
  
  /**
   * Is int boolean.
   *
   * @return the boolean
   */
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
