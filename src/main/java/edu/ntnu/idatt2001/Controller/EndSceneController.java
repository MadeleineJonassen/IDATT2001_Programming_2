package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.View.EndView;
import edu.ntnu.idatt2001.View.MainMenuView;
import javafx.stage.Stage;

public class EndSceneController {
  //private GameManager gameManager;
  private MainMenuView view;
  private final Stage stage;

  public EndSceneController(Stage stage){
    this.stage = stage;
  }

  public void initialize() {
    EndView view = new EndView(stage, this);
    view.setup();
  }
}
