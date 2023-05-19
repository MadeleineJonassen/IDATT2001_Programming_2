package edu.ntnu.idatt2001.View;

import edu.ntnu.idatt2001.Controller.CreateGameController;
import edu.ntnu.idatt2001.Controller.MainMenuController;
import edu.ntnu.idatt2001.GUI.HelpScenes.helpCreatePlayer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateGameView {
  private final Stage stage;
  private final CreateGameController controller;

  public CreateGameView(Stage stage, CreateGameController controller){
    this.stage = stage;
    this.controller = controller;
  }
  public void setup(){

  }

}
