package edu.ntnu.idatt2001.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainMenu extends Application {
  Stage window;
  BorderPane layout;

  public static void main (String[] args) {
    launch();
  }

  @Override
  public void start (Stage menuStage) throws Exception {

    window = menuStage;
    window.setTitle("Menu for Paths");

    //File menu
    Menu fileMenu = new Menu("File");

    //Menu items
    fileMenu.getItems();

    layout = new BorderPane();
    Scene scene = new Scene(layout, 400, 300);
    window.setScene(scene);
    window.show();

  }
}
