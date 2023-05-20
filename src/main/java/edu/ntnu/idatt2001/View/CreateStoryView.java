package edu.ntnu.idatt2001.View;

import edu.ntnu.idatt2001.Controller.CreateGameController;
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
import javafx.stage.Stage;

import java.util.ArrayList;

public class CreateStoryView {
  //private final Stage stage;
  private final CreateStoryController controller;

  /*public CreateStoryView(Stage stage, CreateStoryController controller){
    this.stage = stage;
    this.controller = controller;
  }*/
  
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
    TextField displayBrokenLinks = new TextField();
      displayBrokenLinks.setPromptText("Broken links");
    ListView storyListView = new ListView<>();
      ObservableList<String> observableList = FXCollections.observableList(new ArrayList<String>());
      storyListView.setItems(observableList);
      storyListView.setId("big-list-view");
    createStoryMidDisplay.getChildren().addAll(displayStoryPath, storyListView, displayBrokenLinks);
    VBox createStoryMidBtn = new VBox();
    createStoryMidBtn.setId("boxes");
      Button selectStory = new Button("Select Story");
      selectStory.setOnAction(actionEvent -> {
        controller.chooseStory();
        observableList.addAll(controller.getStoryPassageNames());
      });
    createStoryMidBtn.getChildren().addAll(selectStory);
    createStoryMid.getChildren().addAll(createStoryMidDisplay, createStoryMidBtn);
    
    
    // * Overall Create Story layout *
    BorderPane createStoryLayout = new BorderPane();
    createStoryLayout.setTop(createStoryTop);
    createStoryLayout.setCenter(createStoryMid);
    Scene createStoryScene = new Scene(createStoryLayout, 1300, 700);
    createStoryScene.getStylesheets().add("StyleSheets/createGameStyle.css");
    return createStoryScene;
  }
}
