package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.GUI.MainMenu;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.View.MainMenuView;
import javafx.stage.Stage;

public class MainMenuController {

  //private GameManager gameManager;
  private MainMenuView view;
  private final Stage stage;

  public MainMenuController(Stage stage){
    this.stage = stage;
  }

  public void initialize() {
    MainMenuView view = new MainMenuView(stage, this);
    view.setup();
  }
/*
  public void createGame() {
    CreateGameController controller = new CreateGameController(stage, this);
    controller.initialize();
  }

  public void playGame() {
    PlayGameController controller = new PlayGameController(stage, this);
    controller.initialize();
  }

 */
}
