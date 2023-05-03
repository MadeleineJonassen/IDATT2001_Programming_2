package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Game;
import edu.ntnu.idatt2001.Model.GameManager;
import javafx.stage.Stage;

public class SceneController {
  
  
  public void switchScene(Stage stage, int sceneChoice, GameManager gameManager){
    //set gameManager for each controller/scene
    switch (sceneChoice){
      case 1:
        //switch to scene 1, main menu?
        
        break;
      case 2:
        //edit game
        //EditSceneController controller;
        //controller.setGameManager(gameManager);
        break;
      case 3:
        //play game
        //GameSceneController controller;
        ////controller.setGameManager(gameManager);
        //stage.setScene(gameScene.getScene);
        //GameSceneController set controller???
        break;
      case 4:
        //end scene
        break;
    }
    
  }
}
