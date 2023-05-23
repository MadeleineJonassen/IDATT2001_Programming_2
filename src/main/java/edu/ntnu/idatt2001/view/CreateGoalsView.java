package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.CreateGoalsController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * View for Create Goals.
 */
public class CreateGoalsView {
  private final CreateGoalsController controller;
  public Button errorIcon;
  public Label errorText;

  public CreateGoalsView(CreateGoalsController controller) {
    this.controller = controller;
  }

  /**
   * Setup for the create goal view.
   *
   * @return the view
   */
  public Scene setup() {
    // -------------------- CREATE GOALS SCENE --------------------
    // Top create goals layout
    
    BorderPane createGoalTop = new BorderPane();
    createGoalTop.setId("boxes");
    Button goToCreateHomeGoals = new Button(" ");
    goToCreateHomeGoals.getStyleClass().add("backButton");
    goToCreateHomeGoals.setOnAction(e -> {
      try {
        controller.createGame();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    VBox creatGoalTopMid = new VBox();
    creatGoalTopMid.setId("boxes");
    Label createGoalTitle = new Label("Create Goal");
    createGoalTitle.setId("createTitles");
    Label createGoalUnderTitle = new Label("Select one or multiple goal(s) for your character");
    createGoalUnderTitle.setId("underTitle");
    creatGoalTopMid.getChildren().addAll(createGoalTitle, createGoalUnderTitle);
    
    createGoalTop.setLeft(goToCreateHomeGoals);
    createGoalTop.setCenter(creatGoalTopMid);
    
    // Mid create goal layout
    HBox createGoalMid = new HBox();
    createGoalMid.setId("boxes");
    ListView selectedGoals = new ListView<>();
    selectedGoals.setId("big-list-view");
    selectedGoals.setItems(controller.getGoalsList());
    VBox createGoalsBtn = new VBox();
    createGoalsBtn.setId("boxes");
    Button goalBox = new Button("Create Goal");
    goalBox.setOnAction(e -> {
      try {
        controller.addSingleGoal();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    Button clearAllGoals = new Button("Clear All");
    clearAllGoals.setOnAction(e -> controller.clearGoals());
    createGoalsBtn.getChildren().addAll(goalBox, clearAllGoals);
    createGoalMid.getChildren().addAll(selectedGoals, createGoalsBtn);
    
    // Bottom create goal layout
    HBox errorBox = new HBox();
    errorBox.setId("boxes");
    errorIcon = new Button();
    errorIcon.getStyleClass().add("invincible");
    errorText = new Label("");
    errorText.getStyleClass().add("invincible");
    errorBox.getChildren().addAll(errorIcon, errorText);
    errorInvisible();
    HBox createGoalsBottom = new HBox();
    createGoalsBottom.setId("boxes");
    Button submitGoalBtn = new Button("Submit goal(s)");
    submitGoalBtn.setOnAction(e -> {
      if (controller.goalsHaveBeenAdded()) {
        controller.createGame();
      } else {
        errorVisible("Goals have not been added");
      }
    });
    createGoalsBottom.getChildren().addAll(submitGoalBtn, errorBox);
    
    // * Overall Create Goal Layout *
    BorderPane createGoalLayout = new BorderPane();
    createGoalLayout.setTop(createGoalTop);
    createGoalLayout.setCenter(createGoalMid);
    createGoalLayout.setBottom(createGoalsBottom);
    Scene createGoalScene = new Scene(createGoalLayout, 1300, 700);
    createGoalScene.getStylesheets().add("StyleSheets/createGameStyle.css");
    
    return createGoalScene;
  }

  /**
   * Makes the error invisible for the user.
   */
  public void errorInvisible() {
    errorText.setText("");
    errorIcon.setBackground(Background.EMPTY);
  }

  /**
   * Makes the error visible for the user.
   *
   * @param message the error message
   */
  public void errorVisible(String message) {
    errorText.getStyleClass().add("errorText");
    errorText.setText(message);
    errorIcon.getStyleClass().add("errorImage");
  }
}
