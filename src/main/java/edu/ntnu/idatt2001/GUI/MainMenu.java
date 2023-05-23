package edu.ntnu.idatt2001.GUI;

import edu.ntnu.idatt2001.Controller.CreatePlayerController;
import edu.ntnu.idatt2001.View.helpPlayGame;
import edu.ntnu.idatt2001.View.createGoals;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class MainMenu extends Application {
  public static Stage openWindow;
  Scene mainMenuScene, createGameScene, createStoryScene, createPlayerScene, createGoalScene, playGameScene;

  public static TextField displayStoryPath, displayBrokenLinks;
  public static ListView <String> storyListView; //TODO: Change from string to story?
  public static ListView<String> playerListView;
  public static TextField  playerName, playerHealth, playerGold, playerScore, playerInventory;
  public static Button submitPlayerBtn, playerErrorIcon;



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


    // **************************** CREATE GAME LAYOUT ****************************
    // Top create game layout
    BorderPane layoutCreateGameTop = new BorderPane();
    layoutCreateGameTop.setId("boxes");
    Button goHomeMenu = new Button(" ");
    goHomeMenu.getStyleClass().add("homeButton");
      //goHomeMenu.setOnAction(e -> controller.mainMenu());
    VBox createGameTopMid = new VBox();
    createGameTopMid.setId("boxes");
    Label createGameTitle = new Label("Create game");
    createGameTitle.setId("title");
    Label createGameUnderTitle = new Label("Create your own game!");
    createGameUnderTitle.setId("underTitle");
    createGameTopMid.getChildren().addAll(createGameTitle, createGameUnderTitle);
    layoutCreateGameTop.setLeft(goHomeMenu);
    layoutCreateGameTop.setCenter(createGameTopMid);

    // Mid create game layout
    VBox createGameLayout = new VBox();
    createGameLayout.setId("boxes");
    HBox menuStoryLayout = new HBox();
    menuStoryLayout.setId("boxes");
    Button createStoryBtn = new Button("Story");
      //createStoryBtn.setOnAction(e -> controller.createStory());
    TextField storySelectedDisplay = new TextField();
    storySelectedDisplay.setPromptText("Story not selected yet...");
    //TODO: display selected story
    menuStoryLayout.getChildren().addAll(createStoryBtn, storySelectedDisplay);
    HBox menuPlayerLayout = new HBox();
    menuPlayerLayout.setId("boxes");
    Button createPlayerBtn = new Button("Player");
      //createPlayerBtn.setOnAction(e -> controller.createPlayer());
    TextField playerSelectedDisplay = new TextField();
    playerSelectedDisplay.setPromptText("Player not selected yet");
    menuPlayerLayout.getChildren().addAll(createPlayerBtn,playerSelectedDisplay);
    HBox menuGoalsLayout = new HBox();
    menuGoalsLayout.setId("boxes");
    Button createGoalBtn = new Button("Goals");
      //createGoalBtn.setOnAction(e -> controller.createGoals());
    ListView goalsSelectedDisplay = new ListView<>();
    menuGoalsLayout.getChildren().addAll(createGoalBtn, goalsSelectedDisplay);
    createGameLayout.getChildren().addAll(menuStoryLayout, menuPlayerLayout, menuGoalsLayout);


    // Bottom create game layer
    BorderPane layoutBottom = new BorderPane();
    layoutBottom.setId("boxes");
    Button helpBtn = new Button(" ");
    helpBtn.getStyleClass().add("helpButton");
    helpBtn.setOnAction(e -> helpPlayGame.display());
    Button submitNewGame = new Button("Submit");
    submitNewGame.setId("finalButton");
    submitNewGame.setDisable(!storySelectedDisplay.hasProperties() && !playerSelectedDisplay.hasProperties() && !goalsSelectedDisplay.hasProperties());
    submitNewGame.setOnAction(e -> {
      //TODO: Save selected info and error handling
    //  stage.setScene(controller.playGame());
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
    //layoutCreateGame.getStylesheets().add("StyleSheets/createGameStyle.css");

    Scene scene = new Scene(layoutCreateGame, 1300, 700);
    scene.getStylesheets().add("StyleSheets/createGame  Style.css");
    //stage.setScene(scene);
    //stage.show();


    // -------------------- CREATE STORY SCENE --------------------
    // Top create story layout
    BorderPane createStoryTop = new BorderPane();
    createStoryTop.setId("boxes");
    Button goToCreateHomeStory = new Button(" ");
      goToCreateHomeStory.getStyleClass().add("backButton");
      goToCreateHomeStory.setOnAction(e -> openWindow.setScene(createGameScene));
    VBox creatStoryTopMid = new VBox();
    creatStoryTopMid.setId("boxes");
      Label createStoryTitle = new Label("Create Story");
      createStoryTitle.setId("createTitles");
      Label createStoryUnderTitle = new Label("Select, edit or add your story to the library");
      createStoryUnderTitle.setId("underTitle");
    creatStoryTopMid.getChildren().addAll(createStoryTitle, createStoryUnderTitle);
    createStoryTop.setLeft(goToCreateHomeStory);
    createStoryTop.setCenter(creatStoryTopMid);

    // Mid create story layout
    HBox createStoryMid = new HBox();
    createStoryMid.setId("boxes");
      VBox createStoryMidDisplay = new VBox();
      createStoryMidDisplay.setId("boxes");
        displayStoryPath = new TextField();
          displayStoryPath.setPromptText("Path for display");
        storyListView = new ListView<>();
          storyListView.setId("big-list-view");
        displayBrokenLinks = new TextField();
      createStoryMidDisplay.getChildren().addAll(displayStoryPath, storyListView, displayBrokenLinks);
      VBox createStoryMidBtn = new VBox();
      createStoryMidBtn.setId("boxes");
        Button selectStory = new Button("Select ");
          selectStory.setOnAction(actionEvent -> {
            //  CreateStoryController.chooseStory();
            //Story.getBrokenLinks();
            //TODO: fileDisplay-functionality; broken links, ect.
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
    createStoryScene = new Scene(createStoryLayout, 1300, 700);
    createStoryScene.getStylesheets().add("StyleSheets/createGameStyle.css");



    // -------------------- CREATE PLAYER SCENE --------------------
    // Top create player layout
    BorderPane createPlayerTop = new BorderPane();
    Button goToCreateHomePlayer = new Button(" ");
      goToCreateHomePlayer.getStyleClass().add("backButton");
      goToCreateHomePlayer.setOnAction(e -> openWindow.setScene(createGameScene));
    VBox creatPlayerTopMid = new VBox();
    creatPlayerTopMid.setId("boxes");
      Label createPlayerTitle = new Label("Create Player");
      createPlayerTitle.setId("createTitles");
     Label createPlayerUnderTitle = new Label("Create your own player");
      createPlayerUnderTitle.setId("underTitle");
    creatPlayerTopMid.getChildren().addAll(createPlayerTitle, createPlayerUnderTitle);
    createPlayerTop.setLeft(goToCreateHomePlayer);
    createPlayerTop.setCenter(creatPlayerTopMid);

    // Mid create player layout
    VBox createPlayerMid = new VBox();
    HBox playerNameLayout = new HBox();
    playerNameLayout.setId("boxes");
      playerName = new TextField();
        playerName.setPromptText("Enter Name * ");
        playerName.setId("#playerTextFields");
      Image nameIcon = new Image("photos/Icons/PlayerIcons/person-simple.png");
      ImageView nameIconView = new ImageView();
        nameIconView.setImage(nameIcon);
        nameIconView.setFitWidth(30);
        nameIconView.setFitHeight(30);
    playerNameLayout.getChildren().addAll(playerName,nameIconView);
    HBox playerHealthLayout = new HBox();
    playerHealthLayout.setId("boxes");
      playerHealth = new TextField();
        playerHealth.setPromptText("Enter Health *");
      Image healthIcon = new Image("photos/Icons/PlayerIcons/pharmacy (1).png");
      ImageView healthIconView = new ImageView();
      healthIconView.setImage(healthIcon);
      healthIconView.setFitWidth(30);
      healthIconView.setFitHeight(30);
    playerHealthLayout.getChildren().addAll(playerHealth, healthIconView);
    HBox playerGoldLayout = new HBox();
    playerGoldLayout.setId("boxes");
      playerGold = new TextField();
        playerGold.setPromptText("Enter Gold *");
      Image goldIcon = new Image("photos/Icons/PlayerIcons/treasure-chest.png");
      ImageView goldIconView = new ImageView();
      goldIconView.setImage(goldIcon);
      goldIconView.setFitWidth(30);
      goldIconView.setFitHeight(30);
      playerGoldLayout.getChildren().addAll(playerGold, goldIconView);
    HBox playerScoreLayout = new HBox();
    playerScoreLayout.setId("boxes");
      playerScore = new TextField();
        playerScore.setPromptText("Enter Score");
      Image scoreIcon = new Image("photos/Icons/PlayerIcons/star-sharp-half-stroke.png");
      ImageView scoreIconView = new ImageView();
        scoreIconView.setImage(scoreIcon);
        scoreIconView.setFitWidth(30);
        scoreIconView.setFitHeight(30);
    playerScoreLayout.getChildren().addAll(playerScore, scoreIconView);
    HBox playerInventoryLayout = new HBox();
    playerInventoryLayout.setId("boxes");
    playerInventory = new TextField();
        playerInventory.setPromptText("Enter Inventory ");
        playerInventory.setMinHeight(40);
      Image inventoryIcon = new Image("photos/Icons/PlayerIcons/apps.png");
      ImageView InventoryIconView = new ImageView();
        InventoryIconView.setImage(inventoryIcon);
        InventoryIconView.setFitWidth(30);
        InventoryIconView.setFitHeight(30);
    playerInventoryLayout.getChildren().addAll(playerInventory, InventoryIconView);
    createPlayerMid.getChildren().addAll(playerNameLayout, playerHealthLayout ,playerGoldLayout,playerScoreLayout,playerInventoryLayout);

    // Bottom create player layout
    VBox createPlayerBottom = new VBox();
      createPlayerBottom.setId("boxes");
    playerErrorIcon = new Button("");
      playerErrorIcon.getStyleClass().add("invincible");
    submitPlayerBtn = new Button("Submit player");
      submitPlayerBtn.setOnAction(e -> {
        CreatePlayerController.isString();
        CreatePlayerController.isInt();
      });
    //TODO: make submit work
    createPlayerBottom.getChildren().addAll( playerErrorIcon, submitPlayerBtn);

    // * Overall Create Player Layout *
    BorderPane createPlayerLayout = new BorderPane();
    createPlayerLayout.setId("boxes");
    createPlayerLayout.setTop(createPlayerTop);
    createPlayerLayout.setCenter(createPlayerMid);
    createPlayerLayout.setBottom(createPlayerBottom);
    createPlayerScene = new Scene(createPlayerLayout, 1300, 700);
    createPlayerScene.getStylesheets().add("StyleSheets/createGameStyle.css");



    // -------------------- CREATE GOALS SCENE --------------------
    // Top create goals layout
    BorderPane createGoalTop = new BorderPane();
    createGoalTop.setId("boxes");
    Button goToCreateHomeGoals = new Button(" ");
    goToCreateHomeGoals.getStyleClass().add("backButton");
    goToCreateHomeGoals.setOnAction(e -> openWindow.setScene(createGameScene));
    VBox creatGoalTopMid = new VBox();
    creatGoalTopMid.setId("boxes");
      Label createGoalTitle = new Label("Create Goal");
      createGoalTitle.setId("createTitles");
      Label createGoalUnderTitle = new Label("Select one or multiple goal for your character");
      createGoalUnderTitle.setId("underTitle");
    creatGoalTopMid.getChildren().addAll(createGoalTitle, createGoalUnderTitle);

    createGoalTop.setLeft(goToCreateHomeGoals);
    createGoalTop.setCenter(creatGoalTopMid);

    // Mid create goal layout
    HBox createGoalMid = new HBox();
    createGoalMid.setId("boxes");
      ListView selectedGoals = new ListView<>();
      selectedGoals.setId("big-list-view");
    VBox createGoalsBtn = new VBox();
      createGoalsBtn.setId("boxes");
      Button goalBox = new Button("Create Goal");
      goalBox.setOnAction(e -> createGoals.display());
      Button clearAllGoals = new Button("Clear All");
        //TODO: create a delete option for the listview
    createGoalsBtn.getChildren().addAll(goalBox, clearAllGoals);
    createGoalMid.getChildren().addAll(selectedGoals, createGoalsBtn);

    // Bottom create gal layout
    HBox createGoalsBottom = new HBox();
    Button submitGoalBtn = new Button("Submit goal(s)");
    createGoalsBottom.getChildren().addAll(submitGoalBtn);

    // * Overall Create Goal Layout *
    BorderPane createGoalLayout = new BorderPane();
    createGoalLayout.setTop(createGoalTop);
    createGoalLayout.setCenter(createGoalMid);
    createGoalLayout.setBottom(createGoalsBottom);
    createGoalScene = new Scene(createGoalLayout, 1300, 700);
    createGoalScene.getStylesheets().add("StyleSheets/createGameStyle.css");





    // **************************** PLAY GAME LAYOUT ****************************
    // Top play game layout
    HBox layoutPlayGameTop = new HBox();
      layoutPlayGameTop.setId("topBoxes");
    Button goHomePlayGame = new Button(" ");
      goHomePlayGame.getStyleClass().add("homeButton");
      goHomePlayGame.setOnAction(e -> openWindow.setScene(mainMenuScene));
    Label playGameTitle = new Label("Play game");
      playGameTitle.setId("title");
    layoutPlayGameTop.getChildren().addAll(goHomePlayGame,playGameTitle);

    // Mid play game layout
    HBox layoutPlayGameMid = new HBox();
      layoutPlayGameMid.setId("boxes");
    VBox layoutPlayGameMidLeft = new VBox();
    layoutPlayGameMidLeft.setId("big-boxes");
      playerListView = new ListView<>();
        playerListView.getItems().addAll("Player here");
        //TODO: set selected player;
      storyListView = new ListView<>();
        storyListView.setId("big-list-view");
        storyListView.getItems().addAll("Story here");
       //TODO: set selected story
    layoutPlayGameMidLeft.getChildren().addAll(playerListView, storyListView);
    VBox rightInfoBox = new VBox();
      rightInfoBox.setId("boxes");
      ComboBox setGoals = new ComboBox<>();
        setGoals.setPromptText("View Goals");
          //TODO: add selected goals in box and add function "crossed out" when finished a goal
      Button options = new Button("options?");
      Button other = new Button("other?");
    rightInfoBox.getChildren().addAll(setGoals,options,other);
    layoutPlayGameMid.getChildren().addAll(layoutPlayGameMidLeft, rightInfoBox);

    // Bottom play game layout
    HBox userOptions = new HBox();
    userOptions.setId("boxes");
      //TODO: make HBox create buttons based on number of passages
      Button testButton1 = new Button("test button 1");
      Button testButton2 = new Button("test button 2");
    userOptions.getChildren().addAll(testButton1,testButton2);

    // * Overall Playing Game Layout *
    BorderPane layoutPlayGame = new BorderPane();
    layoutPlayGame.setTop(layoutPlayGameTop);
    layoutPlayGame.setCenter(layoutPlayGameMid);
    layoutPlayGame.setBottom(userOptions);
    layoutPlayGame.getStylesheets().add("StyleSheets/playGameStyle.css");
    playGameScene = new Scene(layoutPlayGame, 1300, 700);




    // ***** END SCENE *****
      //TODO: create end scene



    // ~~~ Opening Window ~~~
    primaryStage.setResizable(false);
    primaryStage.setScene(mainMenuScene);
    primaryStage.show();
  }

}


