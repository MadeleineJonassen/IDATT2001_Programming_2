package edu.ntnu.idatt2001.GUI;

import edu.ntnu.idatt2001.GUI.HelpScenes.helpCreatePlayer;
import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.Players.PlayerData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;


public class MainMenu extends Application {
  Stage openWindow;
  Scene mainMenuScene, createGameScene, createStoryScene, createPlayerScene, createGoalScene, playGameScene;
  public static ListView <String> storyListView; //TODO: Change from string to story?
  public static ListView<String> playerListView = new ListView();



  //TODO:             *** Overall thoughts ***   P.S Look for "TODO:" within the application
  //TODO: add customized help-buttons to all scenes
  //TODO: add menubar? depending on what options we would like to have in the application
  //TODO: error handling!
  //TODO: transfer info from scene to scene
  //TODO: look closer at GUI later for better design; button size, layout, ect.



  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    openWindow = primaryStage;

    // **************************** MENU ****************************
    // Top menu layout
    VBox layoutMenuTitle = new VBox();
    layoutMenuTitle.setId("boxes");
    Label menuTitle = new Label("Paths");
      menuTitle.setId("title");
    Label underTitle = new Label("Welcome to a story based game engine!");
      underTitle.setId("underTitle");
    layoutMenuTitle.getChildren().addAll(menuTitle, underTitle);

    // Mid menu layout
    HBox layoutMenuOptions = new HBox();
      layoutMenuOptions.setId("boxes");
    Button createGameBtn = new Button("Create Game");
      createGameBtn.setId("finalButton");
      createGameBtn.setOnAction(e -> openWindow.setScene(createGameScene));
    Button excitingGameBtn = new Button("Play game");
      excitingGameBtn.setId("finalButton");
      excitingGameBtn.setOnAction(e -> openWindow.setScene(playGameScene));
    layoutMenuOptions.getChildren().addAll(createGameBtn, excitingGameBtn);

    // * Overall Main Menu Layout *
    BorderPane layoutMenu = new BorderPane();
      layoutMenu.setTop(layoutMenuTitle);
      layoutMenu.setCenter(layoutMenuOptions);
    mainMenuScene = new Scene(layoutMenu, 900, 700);
    mainMenuScene.getStylesheets().add("StyleSheets/menuStyle.css");



    // **************************** CREATE GAME LAYOUT ****************************
    // Top create game layout
    BorderPane layoutCreateGameTop = new BorderPane();
    layoutCreateGameTop.setId("boxes");
    Button goHomeMenu = new Button(" ");
      goHomeMenu.getStyleClass().add("homeButton");
      goHomeMenu.setOnAction(e -> openWindow.setScene(mainMenuScene));
    Label createGameTitle = new Label("Create game");
      createGameTitle.setId("title");
    layoutCreateGameTop.setLeft(goHomeMenu);
    layoutCreateGameTop.setCenter(createGameTitle);

    // Mid create game layout
    VBox createGameLayout = new VBox();
    createGameLayout.setId("boxes");
    HBox menuStoryLayout = new HBox();
    menuStoryLayout.setId("boxes");
      Button createStoryBtn = new Button("Story");
        createStoryBtn.setOnAction(e -> openWindow.setScene(createStoryScene));
      TextField storySelectedDisplay = new TextField();
        storySelectedDisplay.setPromptText("Story not selected yet...");
        //TODO: display selected story
    menuStoryLayout.getChildren().addAll(createStoryBtn, storySelectedDisplay);
    HBox menuPlayerLayout = new HBox();
    menuPlayerLayout.setId("boxes");
      Button createPlayerBtn = new Button("Player");
        createPlayerBtn.setOnAction(e -> openWindow.setScene(createPlayerScene));
      TextField playerSelectedDisplay = new TextField();
        playerSelectedDisplay.setPromptText("Player not selected yet");
    menuPlayerLayout.getChildren().addAll(createPlayerBtn,playerSelectedDisplay);
    HBox menuGoalsLayout = new HBox();
    menuGoalsLayout.setId("boxes");
      Button createGoalBtn = new Button("Goals");
        createGoalBtn.setOnAction(e -> openWindow.setScene(createGoalScene));
      ListView goalsSelectedDisplay = new ListView<>();
    menuGoalsLayout.getChildren().addAll(createGoalBtn, goalsSelectedDisplay);
    createGameLayout.getChildren().addAll(menuStoryLayout, menuPlayerLayout, menuGoalsLayout);


    // Bottom create game layer
    BorderPane layoutBottom = new BorderPane();
      layoutBottom.setId("boxes");
    Button helpBtn = new Button(" ");
      helpBtn.getStyleClass().add("helpButton");
      helpBtn.setOnAction(e -> helpCreatePlayer.display());
    Button submitNewGame = new Button("Submit");
    submitNewGame.setId("finalButton");
    submitNewGame.setOnAction(e -> {
      //TODO: Save selected info and error handling
      openWindow.setScene(playGameScene);
    });
    Region space = new Region();
    layoutBottom.setLeft(helpBtn);
    layoutBottom.setCenter(submitNewGame);
    layoutBottom.setRight(space);

    // * Overall Create Game Layout *
    BorderPane layoutCreateGame = new BorderPane();
      layoutCreateGame.setTop(layoutCreateGameTop);
      layoutCreateGame.setCenter(createGameLayout);
      layoutCreateGame.setBottom(layoutBottom);
      layoutCreateGame.getStylesheets().add("StyleSheets/createGameStyle.css");
    createGameScene = new Scene(layoutCreateGame, 900,700);



    // -------------------- CREATE STORY SCENE --------------------
    // Top create story layout
    BorderPane createStoryTop = new BorderPane();
      createStoryTop.setId("boxes");
    Button goToCreateHomeStory = new Button(" ");
      goToCreateHomeStory.getStyleClass().add("backButton");
      goToCreateHomeStory.setOnAction(e -> openWindow.setScene(createGameScene));
    Label createStoryTitle = new Label("Create Story");
      createStoryTitle.setId("title");
    Label createStoryUnderTitle = new Label("Select, edit or add your story to the library");
      createStoryUnderTitle.setId("underTitle");
    createStoryTop.setLeft(goToCreateHomeStory);
    createStoryTop.setCenter(createStoryTitle);
    createStoryTop.setBottom(createStoryUnderTitle);

    // Mid create story layout
    HBox createStoryMid = new HBox();
    createStoryMid.setId("boxes");
      VBox createStoryMidDisplay = new VBox();
      createStoryMidDisplay.setId("boxes");
        storyListView = new ListView<>();
        storyListView.setId("big-list-view");
      createStoryMidDisplay.getChildren().addAll(storyListView);
      VBox createStoryMidBtn = new VBox();
      createStoryMidBtn.setId("boxes");
        Button selectStory = new Button("Select ");
          selectStory.setOnAction(actionEvent -> {
            //TODO: make own method for fileChooser and fileDisplay-functionality
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select a story");
            fileChooser.setInitialDirectory(new File("src/resources/Stories"));
            File selectedFile = fileChooser.showOpenDialog(openWindow);
            if (selectedFile != null) {
              try {
                Scanner fileScanner = new Scanner(selectedFile);
                while (fileScanner.hasNextLine()) {
                  storyListView.getItems().add(fileScanner.nextLine() + "\n");
                }
              } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
              }
            }
          });
        Button addStory = new Button("Add");
          //TODO: add functionality
        Button editStory = new Button("Edit");
          //TODO: add functionality
    createStoryMidBtn.getChildren().addAll(selectStory,addStory,editStory);
    createStoryMid.getChildren().addAll(createStoryMidDisplay, createStoryMidBtn);


    // * Overall Create Story layout *
    BorderPane createStoryLayout = new BorderPane();
    createStoryLayout.setTop(createStoryTop);
    createStoryLayout.setCenter(createStoryMid);
    createStoryScene = new Scene(createStoryLayout, 900, 700);
    createStoryScene.getStylesheets().add("StyleSheets/createGameStyle.css");



    // -------------------- CREATE PLAYER SCENE --------------------
    // Top create player layout
    BorderPane createPlayerTop = new BorderPane();
    createPlayerTop.setId("boxes");
    Button goToCreateHomePlayer = new Button(" ");
    goToCreateHomePlayer.getStyleClass().add("backButton");
    goToCreateHomePlayer.setOnAction(e -> openWindow.setScene(createGameScene));
    Label createPlayerTitle = new Label("Create Player");
    createPlayerTop.setId("title");
    Label createPlayerUnderTitle = new Label("Select, delete or add your player to the library");
    createPlayerUnderTitle.setId("underTitle");
    createPlayerTop.setLeft(goToCreateHomePlayer);
    createPlayerTop.setCenter(createPlayerTitle);
    createPlayerTop.setBottom(createPlayerUnderTitle);

    // Mid create player layout
    HBox createPlayerMid = new HBox();
      VBox createPlayer = new VBox();
      createPlayer.setId("boxes");
      playerListView.getItems().addAll(PlayerData.getPlayers());
      Button addPlayer = new Button("Add Player");
      addPlayer.setOnAction(actionEvent -> {
        //TODO: make listview display into own method + next TODO
        Dialog<Player> createPlayer1 = new createPlayer(new Player.Builder(null,0,0,0,null).build());
        Optional<Player> result = createPlayer1.showAndWait();
        if (result.isPresent()) {
          Player player = result.get();
          playerListView.getItems().addAll(player.toString());
          //TODO: be able to create a player (issue is using a builder pattern design)
        }
      });
        //TODO: Bug fix with listview; last line prints out all info in the playerData() in one line
      createPlayer.getChildren().addAll(addPlayer);
    createPlayerMid.getChildren().addAll(playerListView, createPlayer);


    // * Overall Create Player Layout *
    BorderPane createPlayerLayout = new BorderPane();
    createPlayerLayout.setTop(createPlayerTop);
    createPlayerLayout.setCenter(createPlayerMid);
    createPlayerScene = new Scene(createPlayerLayout, 900, 700);
    createPlayerScene.getStylesheets().add("StyleSheets/createGameStyle.css");



    // -------------------- CREATE GOALS SCENE --------------------
    // Top create goals layout
    BorderPane createGoalTop = new BorderPane();
    createGoalTop.setId("boxes");
    Button goToCreateHomeGoals = new Button(" ");
    goToCreateHomeGoals.getStyleClass().add("backButton");
    goToCreateHomeGoals.setOnAction(e -> openWindow.setScene(createGameScene));
    Label createGoalTitle = new Label("Create Goal");
      createGoalTitle.setId("title");
    Label createGoalUnderTitle = new Label("Select multiple or one goal for your character");
    createGoalUnderTitle.setId("underTitle");
    createGoalTop.setLeft(goToCreateHomeGoals);
    createGoalTop.setCenter(createGoalTitle);
    createGoalTop.setBottom(createPlayerUnderTitle);

    // Mid create goal layout
    VBox createGoalMid = new VBox();
    createGoalMid.setId("boxes");
      Button goalBox = new Button("Create Goal");
      goalBox.setOnAction(e -> createGoals.display());
        //TODO: add ability to create goals based on "category" -> gold, health, inventory or score.
    createGoalMid.getChildren().addAll(goalBox);


    // * Overall Create Goal Layout *
    BorderPane createGoalLayout = new BorderPane();
    createGoalLayout.setTop(createGoalTop);
    createGoalLayout.setCenter(createGoalMid);
    createGoalScene = new Scene(createGoalLayout, 900, 700);
    createGoalScene.getStylesheets().add("StyleSheets/createGameStyle.css");





    // **************************** PLAY GAME LAYOUT ****************************
    // Top play game layout
    BorderPane layoutPlayGameTop = new BorderPane();
    layoutPlayGameTop.setPadding(new Insets(20));
    Button goHomePlayGame = new Button(" ");
      goHomePlayGame.getStyleClass().add("homeButton");
      goHomePlayGame.setOnAction(e -> openWindow.setScene(mainMenuScene));
    Label playGameTitle = new Label("Play game");
    playGameTitle.setId("title");
    layoutPlayGameTop.setLeft(goHomePlayGame);
    layoutPlayGameTop.setCenter(playGameTitle);

    // Mid play game layout
    BorderPane layoutPlayGameMid = new BorderPane();
      layoutPlayGameMid.setId("boxes");
    playerListView = new ListView<>();
      //TODO: set selected player; currently displaying the testDataPlayers
      playerListView.getItems().addAll(PlayerData.getPlayers());
    //storyListView = new ListView<>();
      //storyListView.getItems().addAll();
      //TODO: set selected story
    HBox userOptions = new HBox();
      userOptions.setId("boxes");
      //TODO: make HBox create buttons based on number of passages
      Button testButton1 = new Button("test button 1");
      Button testButton2 = new Button("test button 2");
    userOptions.getChildren().addAll(testButton1,testButton2);
    VBox rightInfoBox = new VBox();
      rightInfoBox.setId("boxes");
      ComboBox setGoals = new ComboBox<>();
        setGoals.setPromptText("Goals/Achievements");
          //TODO: add selected goals in box and add function "crossed out" when finished a goal
      Button options = new Button("options?");
      Button other = new Button("other?");
    rightInfoBox.getChildren().addAll(setGoals,options,other);
    layoutPlayGameMid.setTop(playerListView);
    //layoutPlayGameMid.setCenter(storyListView);
    layoutPlayGameMid.setRight(rightInfoBox);
    layoutPlayGameMid.setBottom(userOptions);


    // * Overall Playing Game Layout *
    BorderPane layoutPlayGame = new BorderPane();
    layoutPlayGame.setTop(layoutPlayGameTop);
    layoutPlayGame.setCenter(layoutPlayGameMid);
    layoutPlayGame.getStylesheets().add("StyleSheets/playGameStyle.css");
    playGameScene = new Scene(layoutPlayGame, 900,700);




    // ***** END SCENE *****
      //TODO: create end scene



    // ~~~ Opening Window ~~~
    primaryStage.setResizable(false);
    primaryStage.setScene(mainMenuScene);
    primaryStage.show();
  }

}


