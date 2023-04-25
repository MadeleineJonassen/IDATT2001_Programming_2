package edu.ntnu.idatt2001;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private final String name;
  private int health;
  private int score;
  private int gold;
  private List<String> inventory = new ArrayList<>();

  private Player(Builder builder) {
    this.name = builder.name;
    this.health = builder.health;
    this.score = builder.score;
    this.gold = builder.gold;
    this.inventory = builder.inventory;
  }

  public String getName(String name) {
    return name;
  }

  public int getHealth() {
    return health;
  }
  public void addHealth(int health){
    this.health += health;
  }

  public int getScore() {
    return score;
  }
  public void addScore(int score){
    this.score += score;
  }

  public int getGold() {
    return gold;
  }
  public void addGold(int gold){
    this.gold += gold;
  }

  public List<String> getInventory() {
    return inventory;
  }
  public void addToInventory(String item){
    inventory.add(item);
  }



  /**
   * A builder class
   */
  public static class Builder {
    private String name;
    private int health;
    private int score;
    private int gold;
    private List<String> inventory = new ArrayList<>();

    public Builder(String name, int health, int score, int gold, List<String> inventory){
      this.name = name;
      this.health = health;
      this.score = score;
      this.gold = gold;
      this.inventory = inventory;
    }

  }

}

