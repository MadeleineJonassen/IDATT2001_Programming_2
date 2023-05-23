package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.PlayGameController;
import edu.ntnu.idatt2001.model.Goal.Goal;
import edu.ntnu.idatt2001.view.HelpScenes.helpPlayGame;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class PlayGameView {
  private final PlayGameController controller;
  private HBox layoutPlayGameMid;
  private ObservableList<String> linkTitles;
  private HBox userOptions = new HBox();
  public Button errorIcon;
  public Label errorText;
  
  
  public PlayGameView(PlayGameController controller){
    this.controller = controller;
  }


  public Scene setup() {
    // **************************** PLAY GAME LAYOUT ****************************
    // Top play game layout
    BorderPane playGameTopLayout = new BorderPane();
      HBox playGameLayoutTopLeft = new HBox();
      playGameLayoutTopLeft.setId("topBoxes");
      Button goHomePlayGame = new Button("Restart");
      //goHomePlayGame.getStyleClass().add("homeButton");
      goHomePlayGame.setOnAction(e -> {
        try {
          controller.mainMenu();
        } catch (Exception ex) {
          throw new RuntimeException(ex);
        }
      });
      Label playGameTitle = new Label("Play Game");
      playGameTitle.setId("title");
      Button helpBtn = new Button(" ");
        helpBtn.getStyleClass().add("helpButton");
        helpBtn.setOnAction(e -> helpPlayGame.display());
      playGameLayoutTopLeft.getChildren().addAll(goHomePlayGame, playGameTitle, helpBtn);
    playGameTopLayout.setLeft(playGameLayoutTopLeft);

    // Mid Play Game layout
    updatePassageView();

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
    layoutPlayGame.setTop(playGameLayoutTopLeft);
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
        errorVisible(ex.getMessage());
      }
    });
    return newButton;
  }
  
  private void updatePassageView(){
    layoutPlayGameMid = new HBox();
    layoutPlayGameMid.setId("boxes");

    VBox layoutPlayGameMidLeft = new VBox();
      layoutPlayGameMidLeft.setId("boxes");
      Label playerTitle = new Label("Player");
      playerTitle.setId("underTitle");
      ListView playerListView = new ListView<>();
      //playerListView.getItems().add(controller.getPlayerInfo());
      playerListView.setItems(controller.getCurrentPlayer());
    layoutPlayGameMidLeft.getChildren().addAll(playerTitle, playerListView);

    VBox layoutMid = new VBox();
    layoutMid.setId("big-boxes");
    Label storyTitle = new Label("Story");
    storyTitle.setId("underTitle");
    storyTitle.setFont(Font.font(30));
      ListView storyListView = new ListView<>();
      storyListView.setId("storyListView");
      storyListView.setItems(controller.getPassageText());
    layoutMid.getChildren().addAll(storyTitle, storyListView);
    
    HBox errorBox = new HBox();
    errorBox.setId("boxes");
    errorIcon = new Button();
    errorIcon.getStyleClass().add("invincible");
    errorText = new Label("");
    errorText.getStyleClass().add("invincible");
    errorInvisible();
    errorBox.getChildren().addAll(errorIcon, errorText);
    
    VBox rightInfoBox = new VBox();
    rightInfoBox.setId("rightBox");
    Label goalsTitle = new Label("Goals");
    goalsTitle.setId("underTitle");
      ListView<Goal> setGoals = new ListView<>();
      //setGoals.getItems().addAll(controller.getNoncompletedGoals());
      setGoals.setItems(controller.getNoncompletedGoals());
    rightInfoBox.getChildren().addAll(goalsTitle, setGoals);
    layoutPlayGameMid.getChildren().addAll(layoutPlayGameMidLeft, layoutMid, errorBox, rightInfoBox);
  }
  
  private Button endGameButton(){
    Button endButton = new Button("End Game");
    endButton.setId("boxes");
    endButton.setOnAction(e -> {
      controller.endGame();
    });
    
    return endButton;
  }
  
  public void errorInvisible(){
    errorText.setText("");
    errorIcon.setBackground(Background.EMPTY);
  }
  public void errorVisible(String message){
    errorText.getStyleClass().add("errorText");
    errorText.setText(message);
    errorIcon.getStyleClass().add("errorImage");
  }
  
}
