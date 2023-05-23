package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.CreateStoryController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreateStoryView {
  private final CreateStoryController controller;

  public Button errorIcon;
  public Label errorText;
  
  public CreateStoryView(CreateStoryController controller) {
    this.controller = controller;
  }
  
  public Scene setup(){
    
    // -------------------- CREATE STORY SCENE --------------------
    // Top create story layout
    BorderPane createStoryTop = new BorderPane();
    createStoryTop.setId("boxes");
    Button goToCreateHomeStory = new Button(" ");
    goToCreateHomeStory.getStyleClass().add("backButton");
    goToCreateHomeStory.setOnAction(e -> {
      try {
        controller.createGame();
      } catch (Exception ex) {
        errorVisible(ex.getMessage());
      }
    });
    VBox creatStoryTopMid = new VBox();
    creatStoryTopMid.setId("boxes");
      Label createStoryTitle = new Label("Select Story");
      createStoryTitle.setId("createTitles");
      Label createStoryUnderTitle = new Label("Select your story");
      createStoryUnderTitle.setId("underTitle");
    creatStoryTopMid.getChildren().addAll(createStoryTitle, createStoryUnderTitle);
    createStoryTop.setLeft(goToCreateHomeStory);
    createStoryTop.setCenter(creatStoryTopMid);
    
    // Mid create story layout
    HBox createStoryMid = new HBox();
    createStoryMid.setId("boxes");
    VBox createStoryMidDisplay = new VBox();
      createStoryMidDisplay.setId("boxes");
      TextField displayStoryPath = new TextField();
      displayStoryPath.setPromptText("Directory for story");
      displayStoryPath.setMinHeight(20);
      displayStoryPath.setEditable(false);
      TextField displayBrokenLinks = new TextField();
        displayBrokenLinks.setPromptText("Broken links");
        displayBrokenLinks.setEditable(false);
      ListView storyListView = new ListView<>();
        ObservableList<String> observableList = FXCollections.observableList(new ArrayList<String>());
        storyListView.setItems(observableList);
        storyListView.setId("big-list-view");
    createStoryMidDisplay.getChildren().addAll(displayStoryPath, displayBrokenLinks, storyListView);

    VBox createStoryMidBtn = new VBox();
    createStoryMidBtn.setId("boxes");
      HBox errorBox = new HBox();
      errorBox.setId("boxes");
         errorIcon = new Button();
          errorIcon.getStyleClass().add("invincible");
         errorText = new Label("");
          errorText.getStyleClass().add("invincible");
    errorBox.getChildren().addAll(errorIcon, errorText);
    Button deleteBrokenLinks = new Button("Delete broken links");
    deleteBrokenLinks.setDisable(true);
    deleteBrokenLinks.setOnAction(e -> {
      try{
        controller.deleteBrokenLinks();
        displayBrokenLinks.clear();
      } catch (Exception exception) {
        errorVisible(exception.getMessage());}});
    Button selectStory = new Button("Select Story");
      selectStory.setOnAction(actionEvent -> {
        try {
          controller.chooseStory();
          errorInvisible();
          observableList.addAll(controller.getStoryPassageNames());
          displayStoryPath.setText(controller.getDirectory());
          displayBrokenLinks.setText(controller.getBrokenLinks());
          deleteBrokenLinks.setDisable(false);
        } catch (Exception e) {
          errorVisible(e.getMessage());
        }
      });


    createStoryMidBtn.getChildren().addAll(selectStory,deleteBrokenLinks, errorBox);
    createStoryMid.getChildren().addAll(createStoryMidDisplay, createStoryMidBtn);

    // Bottom create story layout
    HBox createStoryBottom = new HBox();
    createStoryBottom.setId("boxes");
      Button submit = new Button("Submit");
      submit.setOnAction(e -> {
        if (controller.storyIsAdded()){
          controller.createGame();
        } else {
          errorVisible("The story has not been chosen");
        }
      });
    createStoryBottom.getChildren().addAll(submit);

    
    // * Overall Create Story layout *
    BorderPane createStoryLayout = new BorderPane();
    createStoryLayout.setTop(createStoryTop);
    createStoryLayout.setCenter(createStoryMid);
    createStoryLayout.setBottom(createStoryBottom);
    Scene createStoryScene = new Scene(createStoryLayout, 1300, 700);
    createStoryScene.getStylesheets().add("StyleSheets/createGameStyle.css");
    return createStoryScene;
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
