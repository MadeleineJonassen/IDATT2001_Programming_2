package edu.ntnu.idatt2001.GUI;

import edu.ntnu.idatt2001.GUI.HelpScenes.helpCreatePlayer;
import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.Players.PlayerData;
import edu.ntnu.idatt2001.Story;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.Collections;
import java.util.Optional;


public class MainMenu extends Application {
  Stage openWindow;
  Scene mainMenuScene, createGameScene, playGameScene;
  TableView <Story> storyBox;
  public static ComboBox playerBox;
  public static ListView<String> listView = new ListView<>();

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    openWindow = primaryStage;

    // ***** MENU *****
    // Top menu layout
    VBox layoutMenuTitle = new VBox();
    layoutMenuTitle.setId("boxes");
    Label menuTitle = new Label("Paths");
      menuTitle.setId("title");
    Label underTitle = new Label("Welcome to a story based game engine!");
      underTitle.setId("underTitle");
    layoutMenuTitle.getChildren().addAll(menuTitle, underTitle);

    // Mid menu layout
    VBox layoutMenuOptions = new VBox();
      layoutMenuOptions.setId("boxes");
    Button createGameBtn = new Button("Create Game");
      createGameBtn.setId("finalButton");
      createGameBtn.setOnAction(e -> openWindow.setScene(createGameScene));
    Button excitingGameBtn = new Button("Play game");
      excitingGameBtn.setId("finalButton");
      excitingGameBtn.setOnAction(e -> openWindow.setScene(playGameScene));
    layoutMenuOptions.getChildren().addAll(createGameBtn, excitingGameBtn);

    // Whole menu layout
    BorderPane layoutMenu = new BorderPane();
      layoutMenu.setTop(layoutMenuTitle);
      layoutMenu.setCenter(layoutMenuOptions);
    mainMenuScene = new Scene(layoutMenu, 900, 700);
    mainMenuScene.getStylesheets().add("StyleSheets/menu.css");



    // ***** CREATE GAME LAYOUT *****
    // Top create game layout
    BorderPane layoutCreateGameTop = new BorderPane();
    layoutCreateGameTop.setId("boxes");
    Button goHomeCreateHome = new Button(" ");
      goHomeCreateHome.getStyleClass().add("homeButton");
      goHomeCreateHome.setOnAction(e -> openWindow.setScene(mainMenuScene));
    Label createGameTitle = new Label("Create a game");
      createGameTitle.setId("title");
    layoutCreateGameTop.setLeft(goHomeCreateHome);
    layoutCreateGameTop.setCenter(createGameTitle);

    // Mid create game layout
    HBox layoutCreateGameMid = new HBox();
    layoutCreateGameMid.setId("boxes");

    VBox storyTableLayout = new VBox();
    storyTableLayout.setId("boxes");

    VBox tableButton = new VBox();
    tableButton.setId("boxes");
      Button openFile = new Button("Select Story");
      openFile.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
          FileChooser fileChooser = new FileChooser();
          fileChooser.setTitle("Select a story");
          fileChooser.setInitialDirectory(new File("src/resources/Stories"));
          File selectedFile = fileChooser.showOpenDialog(openWindow);
          if (selectedFile != null) {
            System.out.println("Open File");
            System.out.println(selectedFile.getPath());
          }
        }
      });
      Button addStory = new Button("Add Story");
    tableButton.getChildren().addAll(openFile, addStory);
    storyTableLayout.getChildren().addAll(storyBox, tableButton);

    layoutCreateGameMid.getChildren().addAll(storyTableLayout);



    VBox playerLayout = new VBox();
    playerLayout.setId("boxes");
      listView.getItems().addAll(PlayerData.getPlayers());
      Button addPlayer = new Button("Add Player");
        addPlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
              Dialog<Player> createPlayer = new createPlayer(new Player.Builder(null,0,0,0,null).build());
              Optional<Player> result = createPlayer.showAndWait();

              if (result.isPresent()) {
                Player player = result.get();
                listView.getItems().addAll(player.toString());
              }
            }
        });
      /*playerBox = new ComboBox<>();
      playerBox.setPromptText("Select player");
      ObservableList<Player> players = playerBox.getItems();
      players.add(new Player.Builder("Swordsman", 250, 10, 100).inventory(Collections.singletonList("Sword")).build());
      players.add(new Player.Builder("Witch", 200, 35, 150).inventory(Collections.singletonList("Book of Spells")).build());
      playerBox.getItems().add("Create new player");
      playerBox.setOnAction(e -> {
        if (playerBox.getValue() == "Create new player") {
          createPlayer.display();
        }
      } );
       */
    Button goalBox = new Button("Create Goal");
      goalBox.setOnAction(e -> createGoals.display());

    playerLayout.getChildren().addAll(addPlayer, listView, goalBox);


    // Bottom menu layer
    BorderPane layoutBottom = new BorderPane();
      layoutBottom.setId("boxes");
    Button helpBtn = new Button(" ");
      helpBtn.getStyleClass().add("helpButton");
      helpBtn.setOnAction(e -> helpCreatePlayer.display());
    Button submitNewGame = new Button("Submit");
    submitNewGame.setId("finalButton");
    submitNewGame.setOnAction(e -> {
      //Save info
      //TO DO: error handling
      openWindow.setScene(playGameScene);
    });
    Region space = new Region();
    layoutBottom.setLeft(helpBtn);
    layoutBottom.setCenter(submitNewGame);
    layoutBottom.setRight(space);

    // Whole create game layout
    BorderPane layoutCreateGame = new BorderPane();
      layoutCreateGame.setTop(layoutCreateGameTop);
      layoutCreateGame.setCenter(layoutCreateGameMid);
      layoutCreateGame.setRight(playerLayout);
      layoutCreateGame.setBottom(layoutBottom);
      layoutCreateGame.getStylesheets().add("StyleSheets/menu.css");
    createGameScene = new Scene(layoutCreateGame, 900,700);



    // ***** PLAY GAME LAYOUT *****
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
    layoutPlayGame.getStylesheets().add("StyleSheets/playGameStyle.css");
    playGameScene = new Scene(layoutPlayGame, 900,700);



    // ***** END SCENE *****



    // ~~~ Opening window ~~~
    primaryStage.setResizable(false);
    primaryStage.setScene(mainMenuScene);
    primaryStage.show();
  }

}


