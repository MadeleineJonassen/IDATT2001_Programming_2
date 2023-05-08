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
  Scene mainMenuScene, createGameScene, playGameScene;

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    openWindow = primaryStage;

    // ***** Menu *****
    // Top menu layout
    VBox layoutMenuTitle = new VBox();
      layoutMenuTitle.setPadding(new Insets(20));
      layoutMenuTitle.setSpacing(5);
      layoutMenuTitle.setAlignment(Pos.CENTER);
    Label menuTitle = new Label("Paths");
      menuTitle.setId("title");
    Label underTitle = new Label("Welcome to a story based game engine!");
      underTitle.setId("underTitle");
    layoutMenuTitle.getChildren().addAll(menuTitle, underTitle);

    // Mid menu layout
    VBox layoutMenuOptions = new VBox();
      layoutMenuOptions.setPadding(new Insets(20));
      layoutMenuOptions.setSpacing(20);
      layoutMenuOptions.setAlignment(Pos.CENTER);
    Button createGameBtn = new Button("Create Game");
      createGameBtn.setOnAction(e -> openWindow.setScene(createGameScene));
    Button excitingGameBtn = new Button("Play game");
      excitingGameBtn.setOnAction(e -> openWindow.setScene(playGameScene));
    layoutMenuOptions.getChildren().addAll(createGameBtn, excitingGameBtn);

    // Bottom menu layer
    BorderPane layoutBottom = new BorderPane();
      layoutBottom.setPadding(new Insets(20));
    Button helpBtn = new Button(" ");
      helpBtn.getStyleClass().add("helpButton");
      helpBtn.setOnAction(e -> helpScene.display());
    layoutBottom.setLeft(helpBtn);

    // Whole menu layout
    BorderPane layoutMenu = new BorderPane();
      layoutMenu.setTop(layoutMenuTitle);
      layoutMenu.setCenter(layoutMenuOptions);
      layoutMenu.setBottom(layoutBottom);
    mainMenuScene = new Scene(layoutMenu, 900, 700);
    mainMenuScene.getStylesheets().add("menu.css");


    // ***** Create game stage *****
    // Top create game layout
    BorderPane layoutCreateGameTop = new BorderPane();
      layoutCreateGameTop.setPadding(new Insets(20));
    Button goHomeCreateHome = new Button(" ");
      goHomeCreateHome.getStyleClass().add("homeButton");
      goHomeCreateHome.setOnAction(e -> openWindow.setScene(mainMenuScene));
    Label createGameTitle = new Label("Create game!");
      createGameTitle.setId("title");
    layoutCreateGameTop.setLeft(goHomeCreateHome);
    layoutCreateGameTop.setCenter(createGameTitle);

    // Mid create game layout
    VBox layoutCreateGameMid = new VBox();
    ComboBox playerBox = new ComboBox<>();
    playerBox.getItems().addAll(
            "Swordsmen",
            "Witch",
            "Create new player"
    );
    playerBox.setPromptText("Select player");
    playerBox.setOnAction(e -> {
      System.out.println("User selected: " + playerBox.getValue() );
      if (playerBox.getValue() == "Create new player") {
        createPlayer.display();
      }
    } );
    layoutCreateGameMid.getChildren().addAll(playerBox);


    // Whole create game layout
    BorderPane layoutCreateGame = new BorderPane();
      layoutCreateGame.setTop(layoutCreateGameTop);
      layoutCreateGame.setCenter(layoutCreateGameMid);
      layoutCreateGame.getStylesheets().add("menu.css");
    createGameScene = new Scene(layoutCreateGame, 900,700);


    // ***** Play game layout *****
    // Top playing game layout
    BorderPane layoutPlayGameTop = new BorderPane();
    layoutPlayGameTop.setPadding(new Insets(20));
    Button goHomePlayGame = new Button(" ");
      goHomePlayGame.getStyleClass().add("homeButton");
      goHomePlayGame.setOnAction(e -> openWindow.setScene(mainMenuScene));
    Label playGameTitle = new Label("Play game");
    playGameTitle.setId("title");
    layoutPlayGameTop.setLeft(goHomePlayGame);
    layoutPlayGameTop.setCenter(playGameTitle);

    // Whole playing game layout
    BorderPane layoutPlayGame = new BorderPane();
    layoutPlayGame.setTop(layoutPlayGameTop);
    layoutPlayGame.getStylesheets().add("menu.css");
    playGameScene = new Scene(layoutPlayGame, 900,700);



    // ~~~ Opening window ~~~
    primaryStage.setResizable(false);
    primaryStage.setScene(mainMenuScene);
    primaryStage.show();
  }
}


