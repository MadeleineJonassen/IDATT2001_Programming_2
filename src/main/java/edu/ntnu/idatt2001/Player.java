package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private final String name;
  private int health;
  private int score;
  private int gold;
  private List<String> inventory = new ArrayList<String>();
  private static List<Player> Player = new ArrayList<>();
  public PlayerData() {
    Player = new ArrayList<Player>();
  }
  
  public Player(String name, int health, int score, int gold, List<String> inventory) {
    this.name = name;
    this.health = health;
    this.score = score;
    this.gold = gold;
    this.inventory = inventory;
  }


  public String newPlayer(String name, int health, int score, int gold, List<String> inventory) throws IllegalAccessException {
    Player playerData = new Player(name, health, score, gold, inventory);
    return playerData.toString();
  }
  
  public String getName(String name) {
    return name;
  }
  
  public void addHealth(int health){
    this.health += health;
  }
  
  public int getHealth() {
    return health;
  }
  
  public void addScore(int score){
    this.score += score;
  }
  
  public int getScore() {
    return score;
  }
  
  public void addGold(int gold){
    this.gold += gold;
  }
  
  public int getGold() {
    return gold;
  }
  
  public void addToInventory(String item){
    inventory.add(item);
  }
  
  public List<String> getInventory() {
    return inventory;
  }

  public String toString() {
    return "Name: " + name + " | " + health + " health | " + score + " score | " + gold + "gold || " + inventory;
  }
}

