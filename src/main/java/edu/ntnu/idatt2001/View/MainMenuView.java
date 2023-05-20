package edu.ntnu.idatt2001.View;

import edu.ntnu.idatt2001.Controller.MainMenuController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class MainMenuView  {

  //private final Stage stage;
  private final MainMenuController controller;

  /*public MainMenuView(Stage stage, MainMenuController controller){
    this.stage = stage;
    this.controller = controller;
  }*/
  
  public MainMenuView(MainMenuController controller){
    this.controller = controller;
  }
  
  public Scene setup(){

    // **************************** MENU ****************************
    // Top menu layout
    VBox layoutMenuTitle = new VBox();
    layoutMenuTitle.setId("titleBox");
    Label menuTitle = new Label("PATHS");
    menuTitle.setId("title");
    Label menuUnderTitle = new Label("A story based game engine");
    menuUnderTitle.setId("underTitle");
    layoutMenuTitle.getChildren().addAll(menuTitle, menuUnderTitle);

    // Mid menu layout
    VBox layoutMenuOptions = new VBox();
    layoutMenuOptions.setId("boxes");
      Button errorButtonIcon = new Button("");
        errorButtonIcon.getStyleClass().add("invincible");;
      Label errorLabel = new Label("");
        errorLabel.setId("invincible");
    Button createGameBtn = new Button("Create Game");
    createGameBtn.setId("menuButton");
     createGameBtn.setOnAction(e -> {
       try {
         controller.createGame();
         System.out.println("success");
       } catch (Exception ex) {
         //throw new RuntimeException(ex);
         errorLabel.getStyleClass().add("errorText");;
         errorLabel.setText("Something went wrong, try again later");
         errorButtonIcon.getStyleClass().add("errorImage");
       }
     });
    Button playGameBtn = new Button("Play game");
    playGameBtn.setId("menuButton");
     playGameBtn.setOnAction(e -> {
       try {
         controller.playGame();
       } catch (Exception ex) {
         errorLabel.getStyleClass().add("errorText");;
         errorLabel.setText("Something went wrong, try again later");
         errorButtonIcon.getStyleClass().add("errorImage");

         //throw new RuntimeException(ex);
       }
     });
    layoutMenuOptions.getChildren().addAll(createGameBtn, playGameBtn, errorButtonIcon, errorLabel);

    // * Overall Main Menu Layout *
    BorderPane layoutMenu = new BorderPane();
    layoutMenu.setCenter(layoutMenuTitle);
    layoutMenu.setLeft(layoutMenuOptions);

    Scene scene = new Scene(layoutMenu, 1300, 700);
    scene.getStylesheets().add("StyleSheets/menuStyle.css");
    return scene;
    
  }


  //TODO: make getters here, as well as private variables above
}