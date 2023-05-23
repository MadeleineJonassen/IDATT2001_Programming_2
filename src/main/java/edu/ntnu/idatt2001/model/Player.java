package edu.ntnu.idatt2001.model;

import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Player.
 */
public class Player {
  private String name;
  private int health;
  private int score;
  private int gold;
  private List<String> inventory;
  private StringProperty nameProperty;
  
  /**
   * Instantiates a new Player.
   *
   * @param builder the builder
   */
  public Player(Builder builder) {
    this.name = builder.name;
    this.health = builder.health;
    this.score = builder.score;
    this.gold = builder.gold;
    this.inventory = builder.inventory;
  }
  
  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
  
  /**
   * Gets health.
   *
   * @return the health
   */
  public int getHealth() {
    return health;
  }
  
  /**
   * Add health.
   *
   * @param health the health
   */
  public void addHealth(int health){
    this.health += health;
  }
  
  /**
   * Gets score.
   *
   * @return the score
   */
  public int getScore() {
    return score;
  }
  
  /**
   * Add score.
   *
   * @param score the score
   */
  public void addScore(int score){
    this.score += score;
  }
  
  /**
   * Gets gold.
   *
   * @return the gold
   */
  public int getGold() {
    return gold;
  }
  
  /**
   * Add gold.
   *
   * @param gold the gold
   */
  public void addGold(int gold){
    this.gold += gold;
  }
  
  /**
   * Gets inventory.
   *
   * @return the inventory
   */
  public List<String> getInventory() {
    return inventory;
  }
  
  /**
   * Add to inventory.
   *
   * @param item the item
   */
  public void addToInventory(String item){
    inventory.add(item);
  }


  public String toString() {
    return "Name: " + this.name + " | " + this.health + " HP | " + this.score + " score | " + this.gold + " gold || Inventory: " + this.inventory;
  }
  
  /**
   * A builder class
   */
  public static class Builder {
    private final String name;
    private int health;
    private int score;
    private int gold;
    private List<String> inventory = new ArrayList<>();
    
    /**
     * Instantiates a new Builder.
     *
     * @param name      the name
     * @param health    the health
     * @param score     the score
     * @param gold      the gold
     * @param inventory the inventory
     */
    public Builder(String name, int health, int score, int gold, List<String> inventory){
      this.name = name;
      this.health = health;
      this.score = score;
      this.gold = gold;
      this.inventory = inventory;
    }
    
    /**
     * Instantiates a new Builder.
     *
     * @param name the name
     */
    public Builder(String name){
      this.name = name;
    }
    
    /**
     * Instantiates a new Builder.
     *
     * @param name   the name
     * @param health the health
     * @param gold   the gold
     */
    public Builder(String name, int health, int gold){
      this.name = name;
      this.health = health;
      this.gold = gold;
    }
    
    /**
     * Health builder.
     *
     * @param health the health
     * @return the builder
     */
    public Builder health (int health){
      this.health = health;
      return this;
    }
    
    /**
     * Score builder.
     *
     * @param score the score
     * @return the builder
     */
    public Builder score (int score){
      this.score = score;
      return this;
    }
    
    /**
     * Gold builder.
     *
     * @param gold the gold
     * @return the builder
     */
    public Builder gold (int gold){
      this.gold = gold;
      return this;
    }
    
    /**
     * Inventory builder.
     *
     * @param inventory the inventory
     * @return the builder
     */
    public Builder inventory (List <String> inventory){
      this.inventory = inventory;
      return this;
    }
    
    /**
     * Build player.
     *
     * @return the player
     */
    public Player build(){
      return new Player(this);
    }
  }
}

