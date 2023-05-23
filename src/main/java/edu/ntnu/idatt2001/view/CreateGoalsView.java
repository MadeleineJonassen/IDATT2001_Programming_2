package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.CreateGoalsController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateGoalsView {
  private final CreateGoalsController controller;

  public CreateGoalsView(CreateGoalsController controller){
    this.controller = controller;
  }
  public Scene setup(){
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
    //TODO: attach listener to observableList, update on changes
    Button clearAllGoals = new Button("Clear All");
    clearAllGoals.setOnAction(e -> controller.clearGoals());
    createGoalsBtn.getChildren().addAll(goalBox, clearAllGoals);
    createGoalMid.getChildren().addAll(selectedGoals, createGoalsBtn);
    
    // Bottom create goal layout
    HBox createGoalsBottom = new HBox();
    createGoalsBottom.setId("boxes");
    Button submitGoalBtn = new Button("Submit goal(s)");
    submitGoalBtn.setOnAction(e -> {
      try {
        controller.createGame();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    createGoalsBottom.getChildren().addAll(submitGoalBtn);
    
    // * Overall Create Goal Layout *
    BorderPane createGoalLayout = new BorderPane();
    createGoalLayout.setTop(createGoalTop);
    createGoalLayout.setCenter(createGoalMid);
    createGoalLayout.setBottom(createGoalsBottom);
    Scene createGoalScene = new Scene(createGoalLayout, 1300, 700);
    createGoalScene.getStylesheets().add("StyleSheets/createGameStyle.css");
    
    return createGoalScene;
  }
}
