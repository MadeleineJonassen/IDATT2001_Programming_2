package edu.ntnu.idatt2001.View;

import edu.ntnu.idatt2001.Controller.PlayGameController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayGameView {
  private final PlayGameController controller;
  private HBox layoutPlayGameMid;
  private ObservableList<String> linkTitles;
  private HBox userOptions = new HBox();

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
    
    /*
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
    layoutPlayGameMid.getChildren().addAll(layoutPlayGameMidLeft, rightInfoBox);*/
    updatePassageView();
    
    // Bottom play game layout
    /*HBox userOptions = populateLinks(controller.getLinkTitles());
    userOptions.setId("boxes");*/
    //TODO: make HBox create buttons based on number of links. Extract separate method?
    //Button testButton1 = new Button("Link 1");
    //Button testButton2 = new Button("Link 2");
    //userOptions.getChildren().addAll(testButton1,testButton2);
    userOptions.setId("boxes");
    linkTitles = controller.getLinkTitles();
    populateLinks();
    linkTitles.addListener(new ListChangeListener<String>() {
      @Override
      public void onChanged(Change<? extends String> change) {
        populateLinks();
      }
    });
    
    
    // * Overall Playing Game Layout *
    BorderPane layoutPlayGame = new BorderPane();
    layoutPlayGame.setTop(layoutPlayGameTop);
    layoutPlayGame.setCenter(layoutPlayGameMid);
    layoutPlayGame.setBottom(userOptions);
    layoutPlayGame.getStylesheets().add("StyleSheets/playGameStyle.css");
    Scene playGameScene = new Scene(layoutPlayGame, 1300, 700);
    
    return playGameScene;
  }
  
  private void populateLinks(){
    userOptions.getChildren().clear();
    for(String linkTitle : linkTitles){
      userOptions.getChildren().add(linkButton(linkTitle));
    }
    
    if(userOptions.getChildren().isEmpty()){
      userOptions.getChildren().add(endGameButton());
    }
  }
  
  private Button linkButton(String linkTitle){
    Button newButton = new Button(linkTitle);
    newButton.setId("boxes");
    newButton.setOnAction(e -> {
      try {
        controller.nextPassage(linkTitle);
      } catch (Exception ex){
        //set error message visible
        System.out.println("something wrong with link button");
        System.out.println(ex.getMessage());
      }
    });
    return newButton;
  }
  
  private void updatePassageView(){
    layoutPlayGameMid = new HBox();
    layoutPlayGameMid.setId("boxes");
    VBox layoutPlayGameMidLeft = new VBox();
    layoutPlayGameMidLeft.setId("big-boxes");
    ListView playerListView = new ListView<>();
    //playerListView.getItems().add(controller.getPlayerInfo());
    playerListView.setItems(controller.getCurrentPlayer());
    //TODO: set selected player;
    ListView storyListView = new ListView<>();
    storyListView.setId("big-list-view");
    storyListView.setItems(controller.getPassageText());
    //TODO: set selected story
    layoutPlayGameMidLeft.getChildren().addAll(playerListView, storyListView);
    VBox rightInfoBox = new VBox();
    rightInfoBox.setId("boxes");
    ComboBox setGoals = new ComboBox<>();
    setGoals.setPromptText("View Goals");
    //setGoals.getItems().addAll(controller.getNoncompletedGoals());
    setGoals.setItems(controller.getNoncompletedGoals());
    //TODO: add selected goals in box and add function "crossed out" when finished a goal
    Button options = new Button("options?");
    Button other = new Button("other?");
    rightInfoBox.getChildren().addAll(setGoals,options,other);
    layoutPlayGameMid.getChildren().addAll(layoutPlayGameMidLeft, rightInfoBox);
  }
  
  private Button endGameButton(){
    Button endButton = new Button("Finish game");
    endButton.setId("boxes");
    endButton.setOnAction(e -> {
      controller.endGame();
    });
    
    return endButton;
  }
}
