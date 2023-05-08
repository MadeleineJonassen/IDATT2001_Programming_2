package edu.ntnu.idatt2001.Players;

import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private String name;
  private int health;
  private int score;
  private int gold;
  private List<String> inventory = new ArrayList<>();
  private StringProperty nameProperty;

  public Player(Builder builder) {
    this.name = builder.name;
    this.health = builder.health;
    this.score = builder.score;
    this.gold = builder.gold;
    this.inventory = builder.inventory;
  }
  public String getName() {
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

    public Builder(String name, int health, int score, int gold, List<String> inventory){
      this.name = name;
      this.health = health;
      this.score = score;
      this.gold = gold;
      this.inventory = inventory;
    }

    public Builder name (String name){
      this.name = name;
      return this;
    }
    public Builder health (int health){
      this.health = health;
      return this;
    }
    public Builder score (int score){
      this.score = score;
      return this;
    }
    public Builder gold (int gold){
      this.gold = gold;
      return this;
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

