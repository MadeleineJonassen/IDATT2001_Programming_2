package edu.ntnu.idatt2001.controller;

import edu.ntnu.idatt2001.model.GameManager;
import edu.ntnu.idatt2001.model.Player;
import edu.ntnu.idatt2001.view.CreatePlayerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.stage.Stage;



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
  public CreatePlayerController(Stage stage, GameManager gameManager) {
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
  public ObservableList<String> getPlayerInfo() {
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
  public void submitPlayer(
          String name, String healthInput, String scoreInput,
          String goldInput, String inventoryInput) {
    if (name.isBlank()) {
      throw new IllegalArgumentException("Name must be filled out");
    }
    if (healthInput.isBlank()) {
      throw new IllegalArgumentException("Health must be filled out");
    }
    if (goldInput.isBlank()) {
      throw new IllegalArgumentException("Gold amount must be filled out");
    }
    int health = Integer.parseInt(healthInput);
    int gold = Integer.parseInt(goldInput);
    int score = 0;
    if (!scoreInput.isBlank()) {
      score = Integer.parseInt(scoreInput);
    }
    List<String> inventory = new ArrayList<>();
    if (!inventoryInput.isBlank()) {
      inventory = Arrays.stream(inventoryInput.split(", ")).toList();
    }
 
    Player player = new Player.Builder(name, health, gold)
            .score(score).inventory(inventory).build();
    gameManager.setPlayer(player);
    createGame();
  }
  
  
  
}
