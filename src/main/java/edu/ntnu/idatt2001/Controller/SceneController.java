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
        //stage.setScene(mainMenu.getScene);
        break;
      case 2:
        //edit game
        CreateGameController createGameController = new CreateGameController(gameManager);
        //CreateGame createGame = new CreateGame(createGameController, gameManager);
        //stage.setScene(createGame.getScene);
        break;
      case 3:
        //create player
        CreatePlayerController createPlayerController = new CreatePlayerController();
        //CreatePlayer createPlayer = new CreatePlayer(createPlayerController, gameManager);
        //stage.setScene(createPlayer.getScene);
        break;
      case 4:
        //create goals
        CreateGoalsController createGoalsController = new CreateGoalsController();
        //CreateGoals createGoals = new CreateGoals(createGoalsController, gameManager);
        //stage.setScene(createGoals.getScene);
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
