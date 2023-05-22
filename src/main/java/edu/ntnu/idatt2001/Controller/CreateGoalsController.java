package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Goal.*;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.View.AddGoalView;
import edu.ntnu.idatt2001.View.CreateGameView;
import edu.ntnu.idatt2001.View.CreateGoalsView;
import edu.ntnu.idatt2001.View.MainMenuView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class CreateGoalsController {
  private GameManager gameManager;
  private final Stage stage;
  private CreateGoalsView view;
  private SceneController sceneController = new SceneController();


  public CreateGoalsController(Stage stage, GameManager gameManager){
    this.gameManager = gameManager;
    this.stage = stage;
    view = new CreateGoalsView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  public void createGame() throws Exception {
    sceneController.switchScene(stage, 2, gameManager);
  }
  
  public ObservableList<Goal> getGoalsList(){
    return gameManager.getGoals();
  }
  
  public void addSingleGoal(){
    Stage addGoalWindow = new Stage();
    //addGoalWindow.initModality(Modality.APPLICATION_MODAL);  //makes the user take care of the window in front of them
    AddGoalController addGoalController = new AddGoalController(gameManager, addGoalWindow);
  }
  
  public void clearGoals(){
    gameManager.clearGoals();
  }
}
