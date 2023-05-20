package edu.ntnu.idatt2001.View;

import edu.ntnu.idatt2001.Controller.MainMenuController;
import edu.ntnu.idatt2001.Controller.PlayGameController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayGameView {
  private final PlayGameController controller;

  public PlayGameView(PlayGameController controller){
    this.controller = controller;
  }


  public Scene setup() {
    // **************************** PLAY GAME LAYOUT ****************************
    // Top play game layout
    HBox layoutPlayGameTop = new HBox();
    layoutPlayGameTop.setId("topBoxes");
    Button goHomePlayGame = new Button(" ");
    goHomePlayGame.getStyleClass().add("homeButton");
    goHomePlayGame.setOnAction(e -> {
      try {
        controller.mainMenu();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    Label playGameTitle = new Label("Play game");
    playGameTitle.setId("title");
    layoutPlayGameTop.getChildren().addAll(goHomePlayGame,playGameTitle);
    
    // Mid play game layout
    HBox layoutPlayGameMid = new HBox();
    layoutPlayGameMid.setId("boxes");
    VBox layoutPlayGameMidLeft = new VBox();
    layoutPlayGameMidLeft.setId("big-boxes");
    ListView playerListView = new ListView<>();
    playerListView.getItems().add(controller.getPlayerInfo());
    //TODO: set selected player;
    ListView storyListView = new ListView<>();
    storyListView.setId("big-list-view");
    storyListView.getItems().addAll(controller.getCurrentPassage());
    //TODO: set selected story
    layoutPlayGameMidLeft.getChildren().addAll(playerListView, storyListView);
    VBox rightInfoBox = new VBox();
    rightInfoBox.setId("boxes");
    ComboBox setGoals = new ComboBox<>();
    setGoals.setPromptText("View Goals");
    setGoals.getItems().addAll(controller.getNonCompletedGoals());
    //TODO: add selected goals in box and add function "crossed out" when finished a goal
    Button options = new Button("options?");
    Button other = new Button("other?");
    rightInfoBox.getChildren().addAll(setGoals,options,other);
    layoutPlayGameMid.getChildren().addAll(layoutPlayGameMidLeft, rightInfoBox);
    
    // Bottom play game layout
    HBox userOptions = new HBox();
    userOptions.setId("boxes");
    //TODO: make HBox create buttons based on number of links. Extract separate method?
    Button testButton1 = new Button("Link 1");
    Button testButton2 = new Button("Link 2");
    userOptions.getChildren().addAll(testButton1,testButton2);
    
    // * Overall Playing Game Layout *
    BorderPane layoutPlayGame = new BorderPane();
    layoutPlayGame.setTop(layoutPlayGameTop);
    layoutPlayGame.setCenter(layoutPlayGameMid);
    layoutPlayGame.setBottom(userOptions);
    layoutPlayGame.getStylesheets().add("StyleSheets/playGameStyle.css");
    Scene playGameScene = new Scene(layoutPlayGame, 1300, 700);
    
    
    return playGameScene;
  }
}
