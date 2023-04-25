package edu.ntnu.idatt2001.Players;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private final String name;
  private int health;
  private int score;
  private int gold;
  private List<String> inventory = new ArrayList<>();

  public Player(Builder builder) {
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


  public String toString() {
    return "Name: " + this.name + " | " + this.health + " HP | " + this.score + " score | " + this.gold + " Gold || Inventory: " + this.inventory;
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

    public Builder(String name, int health, int score, int gold){
      this.name = name;
      this.health = health;
      this.score = score;
      this.gold = gold;
    }

    public Builder inventory (List <String> inventory){
      this.inventory = inventory;
      return this;
    }
    public Player build(){
      return new Player(this);
    }

  }

}

