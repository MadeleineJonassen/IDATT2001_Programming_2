package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Game;
import edu.ntnu.idatt2001.Model.GameManager;
import javafx.stage.Stage;

public class SceneController {
  
  
  public void switchScene(Stage stage, int sceneChoice, GameManager gameManager){
    //set gameManager for each controller/scene
    switch (sceneChoice){
      case 1:
        //main menu?
        MainMenuController mainMenuController = new MainMenuController();
        //MainMenu mainMenu = new MainMenu(mainMenuController, gameManager);
        
        break;
      case 2:
        //edit game
        CreateGameController createGameController = new CreateGameController();
        //CreateGame createGame = CreateGame(createGameController, gameManager);
        
        break;
      case 3:
        //create player
        //GameSceneController controller;
        ////controller.setGameManager(gameManager);
        //stage.setScene(gameScene.getScene);
        //GameSceneController set controller???
        break;
      case 4:
        //create goals
        break;
      case 5:
        //play game
        break;
      case 6:
        //end scene
        break;
    }
    
  }
}
