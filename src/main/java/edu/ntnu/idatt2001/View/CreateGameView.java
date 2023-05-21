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
  //private final Stage stage;
  private final CreateGameController controller;

  /*public CreateGameView(Stage stage, CreateGameController controller){
    this.stage = stage;
    this.controller = controller;
  }*/
  
  public CreateGameView(CreateGameController controller){
    this.controller = controller;
  }
  public Scene setup(){
    // **************************** CREATE GAME LAYOUT ****************************
    // Top create game layout
    //TODO: exception handling
    BorderPane layoutCreateGameTop = new BorderPane();
    layoutCreateGameTop.setId("boxes");
    Button goHomeMenu = new Button(" ");
    goHomeMenu.getStyleClass().add("homeButton");
    goHomeMenu.setOnAction(e -> {
      try {
        controller.mainMenu();
      } catch (Exception ex) {
        System.out.println("error");
      }
    });
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
    createStoryBtn.setOnAction(e -> {
      try {
        controller.createStory();
        System.out.println("Story");
      } catch (Exception ex) {
        System.out.println("error");
      }
    });
    TextField storySelectedDisplay = new TextField();
    storySelectedDisplay.setPromptText(controller.getStoryName());
    //TODO: display selected story
    menuStoryLayout.getChildren().addAll(createStoryBtn, storySelectedDisplay);
    HBox menuPlayerLayout = new HBox();
    menuPlayerLayout.setId("boxes");
    Button createPlayerBtn = new Button("Player");
    createPlayerBtn.setOnAction(e -> {
      try {
        controller.createPlayer();
      } catch (Exception ex) {
        System.out.println("error");
      }
    });
    TextField playerSelectedDisplay = new TextField();
    playerSelectedDisplay.setPromptText(controller.getPlayerName());
    menuPlayerLayout.getChildren().addAll(createPlayerBtn,playerSelectedDisplay);
    HBox menuGoalsLayout = new HBox();
    menuGoalsLayout.setId("boxes");
    Button createGoalBtn = new Button("Goals");
    createGoalBtn.setOnAction(e -> {
      try {
        controller.createGoals();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
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
    submitNewGame.setDisable(!controller.isGameConstructed());
    submitNewGame.setOnAction(e -> {
      try {
        controller.playGame();
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
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
    scene.getStylesheets().add("StyleSheets/createGameStyle.css");
    return scene;
    //stage.setScene(scene);
    //stage.show();
  }
  
  

}
