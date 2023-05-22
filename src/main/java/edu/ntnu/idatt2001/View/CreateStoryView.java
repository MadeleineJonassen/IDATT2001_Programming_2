package edu.ntnu.idatt2001.View;

import edu.ntnu.idatt2001.Controller.CreateStoryController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CreateStoryView {
  //private final Stage stage;
  private final CreateStoryController controller;

  /*public CreateStoryView(Stage stage, CreateStoryController controller){
    this.stage = stage;
    this.controller = controller;
  }*/
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
    //goToCreateHomeStory.setOnAction(e -> openWindow.setScene(createGameScene));
    goToCreateHomeStory.setOnAction(e -> {
      try {
        controller.createGame();
      } catch (Exception ex) {
        System.out.println("error");
      }
    });
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
      Button selectStory = new Button("Select Story");
      selectStory.setOnAction(actionEvent -> {
        try {
          //errorInvisible();       Doesn't work
          controller.chooseStory();
          observableList.addAll(controller.getStoryPassageNames());
          displayStoryPath.setText(controller.getDirectory());
          displayBrokenLinks.setText(controller.getBrokenLinks());
        } catch (Exception e) {
          errorVisable();
        }
      });
    createStoryMidBtn.getChildren().addAll(selectStory, errorBox);
    createStoryMid.getChildren().addAll(createStoryMidDisplay, createStoryMidBtn);

    // Bottom create story layout
    HBox createStoryBottom = new HBox();
    createStoryBottom.setId("boxes");
      Button submit = new Button("Submit");
      submit.setOnAction(e -> {
          try {
            //TODO: save input
            controller.createGame();
          } catch (Exception ex) {
            errorVisable();
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
    errorText.getStyleClass().add("invincible");
    errorIcon.getStyleClass().add("invincible");
  }

  public void errorVisable(){
    errorText.getStyleClass().add("errorText");
    errorText.setText("Could not resolve file, try again...");
    //TODO: print error message to user
    errorIcon.getStyleClass().add("errorImage");
  }
}
