package edu.ntnu.idatt2001.controller;

import edu.ntnu.idatt2001.model.GameManager;
import javafx.stage.Stage;

/**
 * The type Scene controller.
 */
public class SceneController {
  
  
  /**
   * Switch scene.
   *
   * @param stage       the stage
   * @param sceneChoice the scene choice
   * @param gameManager the game manager
   */
  public void switchScene(Stage stage, int sceneChoice, GameManager gameManager) {
    //set gameManager for each controller/scene
    switch (sceneChoice) {
      case 1:
        //main menu
        MainMenuController mainMenuController = new MainMenuController(stage, gameManager);
        break;
      case 2:
        //edit game
        CreateGameController createGameController = new CreateGameController(stage, gameManager);
        break;
      case 3:
        //create story
        CreateStoryController createStoryController = new CreateStoryController(stage, gameManager);
        break;
      case 4:
        //create player
        CreatePlayerController createPlayerController = new CreatePlayerController(stage, gameManager);
        break;
      case 5:
        //create goals
        CreateGoalsController createGoalsController = new CreateGoalsController(stage, gameManager);
        break;
      case 6:
        //play game
        PlayGameController playGameController = new PlayGameController(stage, gameManager);
        break;
      case 7:
        //end scene
        EndSceneController endSceneController = new EndSceneController(stage, gameManager);
        break;
      default:
        throw new IllegalArgumentException("The number must be between 1 and 7");
    }
    
  }

  
}
