package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.*;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.Model.Link;
import edu.ntnu.idatt2001.View.EndView;
import edu.ntnu.idatt2001.View.MainMenuView;
import edu.ntnu.idatt2001.View.PlayGameView;
import javafx.stage.Stage;

import java.util.List;

public class EndSceneController {
  private GameManager gameManager;
  private final Stage stage;
  private EndView view;

  public EndSceneController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    this.stage = stage;
    view = new EndView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  public List<Goal> getCompletedGoals(){
    return gameManager.getGoals().stream().filter(g -> g.isFulfilled(gameManager.getPlayer())).toList();
  }
  
  public List<Goal> getNonCompletedGoals(){
    return gameManager.getGoals().stream().filter(g -> !g.isFulfilled(gameManager.getPlayer())).toList();
  }
}
