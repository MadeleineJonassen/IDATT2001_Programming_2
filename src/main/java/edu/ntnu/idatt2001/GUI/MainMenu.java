package edu.ntnu.idatt2001.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class MainMenu extends Application {
  Stage openWindow;
  Scene mainMenuScene, createGameScene;

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    openWindow = primaryStage;
    //Menu
    VBox layoutMenuTitle = new VBox();
      layoutMenuTitle.setPadding(new Insets(20));
      layoutMenuTitle.setSpacing(5);
      layoutMenuTitle.setAlignment(Pos.CENTER);
    Label menuTitle = new Label("Paths");
      menuTitle.setId("menuTitle");
    Label underTitle = new Label("Welcome to a story based game engine!");
      underTitle.setId("underTitle");
    layoutMenuTitle.getChildren().addAll(menuTitle, underTitle);

    //Mid menu options
    VBox layoutMenuOptions = new VBox();
      layoutMenuOptions.setPadding(new Insets(20));
      layoutMenuOptions.setSpacing(10);
      layoutMenuOptions.setAlignment(Pos.CENTER);
    Button createGameBtn = new Button("Create Game");
      createGameBtn.setOnAction(e -> openWindow.setScene(createGameScene));
    Button excitingGameBtn = new Button("Play game");
    layoutMenuOptions.getChildren().addAll(createGameBtn, excitingGameBtn);

    // Bottom layer
    HBox layoutMenuBottom = new HBox();
      layoutMenuBottom.setPadding(new Insets(20));
      layoutMenuBottom.setAlignment(Pos.CENTER_RIGHT);
    Button helpBtn = new Button(" ");
      helpBtn.getStyleClass().add("helpButton");
      helpBtn.setOnAction(e -> helpScene.display());
    layoutMenuBottom.getChildren().addAll(helpBtn);

    //Whole layoutMenu layout
    BorderPane layoutMenu = new BorderPane();
      layoutMenu.setTop(layoutMenuTitle);
      layoutMenu.setCenter(layoutMenuOptions);
      layoutMenu.setBottom(layoutMenuBottom);
    mainMenuScene = new Scene(layoutMenu, 900, 700);
    mainMenuScene.getStylesheets().add("menu.css");


    //Create game stage
    VBox createGameLayout = new VBox();
    Label createGameTitle = new Label("Create game!");
    Button backToMenuBtn = new Button("Back to Homepage");
      backToMenuBtn.setOnAction(e -> openWindow.setScene(mainMenuScene));
    createGameLayout.getChildren().addAll(createGameTitle, backToMenuBtn);


    BorderPane layoutCreateGame = new BorderPane();
      layoutCreateGame.setCenter(createGameLayout);
    layoutCreateGame.getStylesheets().add("menu.css");
    createGameScene = new Scene(layoutCreateGame, 900,700);


    //Opening window

    primaryStage.setResizable(false);
    primaryStage.setScene(mainMenuScene);
    primaryStage.show();
  }
}


