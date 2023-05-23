package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.CreateGameController;
import edu.ntnu.idatt2001.view.HelpScenes.HelpCreatePlayer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;


/**
 * View for Create Game.
 */
public class CreateGameView {
  private final CreateGameController controller;

  public CreateGameView(CreateGameController controller) {
    this.controller = controller;
  }

  /**
   * Set up the scene for Create Game.
   *
   * @return the view
   */
  public Scene setup() {
    // **************************** CREATE GAME LAYOUT ****************************
    // Top create game layout
    BorderPane layoutCreateGameTop = new BorderPane();
    layoutCreateGameTop.setId("boxes");
    Button goHomeMenu = new Button(" ");
    goHomeMenu.getStyleClass().add("homeButton");
    goHomeMenu.setOnAction(e -> {
      try {
        controller.mainMenu();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
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
    createGameLayout.setPrefWidth(1000);
    HBox menuStoryLayout = new HBox();
    menuStoryLayout.setId("boxes");
    Button createStoryBtn = new Button("Story");
    createStoryBtn.setOnAction(e -> {
      try {
        controller.createStory();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    TextField storySelectedDisplay = new TextField();
    storySelectedDisplay.setText(controller.getStoryName());
    storySelectedDisplay.setEditable(false);
    storySelectedDisplay.setMinWidth(300);
    menuStoryLayout.getChildren().addAll(createStoryBtn, storySelectedDisplay);
    HBox menuPlayerLayout = new HBox();
    menuPlayerLayout.setId("boxes");
    menuPlayerLayout.setPrefWidth(700);

    Button createPlayerBtn = new Button("Player");
    createPlayerBtn.setOnAction(e -> {
      try {
        controller.createPlayer();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    TextField playerSelectedDisplay = new TextField();
    playerSelectedDisplay.setText(controller.getPlayerName());
    playerSelectedDisplay.setEditable(false);
    playerSelectedDisplay.setMinWidth(300);
    menuPlayerLayout.getChildren().addAll(createPlayerBtn, playerSelectedDisplay);
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
    goalsSelectedDisplay.setEditable(false);
    goalsSelectedDisplay.setMinWidth(300);
    goalsSelectedDisplay.setMinHeight(100);
    goalsSelectedDisplay.setItems(controller.getGoalsList());
    menuGoalsLayout.getChildren().addAll(createGoalBtn, goalsSelectedDisplay);
    createGameLayout.getChildren().addAll(menuStoryLayout, menuPlayerLayout, menuGoalsLayout);

    // Bottom create game layer
    BorderPane layoutBottom = new BorderPane();
    layoutBottom.setId("boxes");
    Button helpBtn = new Button(" ");
    helpBtn.getStyleClass().add("helpButton");
    helpBtn.setOnAction(e -> HelpCreatePlayer.display());
    Button submitNewGame = new Button("Submit");
    submitNewGame.setId("finalButton");
    submitNewGame.setDisable(!controller.isGameConstructed());
    submitNewGame.setOnAction(e -> {
      try {
        controller.playGame();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    layoutBottom.setCenter(submitNewGame);


    // * Overall Create Game Layout *
    BorderPane layoutCreateGame = new BorderPane();
    layoutCreateGame.setTop(layoutCreateGameTop);
    layoutCreateGame.setCenter(createGameLayout);
    layoutCreateGame.setBottom(layoutBottom);

    Scene scene = new Scene(layoutCreateGame, 1300, 700);
    scene.getStylesheets().add("StyleSheets/createGameStyle.css");
    return scene;
  }

}
