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

/**
 * The type Create story view.
 */
public class CreateStoryView {
  //private final Stage stage;
  private final CreateStoryController controller;
  
  /**
   * The Error icon.
   */
/*public CreateStoryView(Stage stage, CreateStoryController controller){
    this.stage = stage;
    this.controller = controller;
  }*/
  public Button errorIcon;
  /**
   * The Error text.
   */
  public Label errorText;
  
  /**
   * Instantiates a new Create story view.
   *
   * @param controller the controller
   */
  public CreateStoryView(CreateStoryController controller) {
    this.controller = controller;
  }
  
  /**
   * Setup scene.
   *
   * @return the scene
   */
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
        throw new RuntimeException(ex);
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
          controller.chooseStory();
          errorInvisible();
          observableList.addAll(controller.getStoryPassageNames());
          displayStoryPath.setText(controller.getDirectory());
          displayBrokenLinks.setText(controller.getBrokenLinks());
        } catch (Exception e) {
          errorVisable(e.getMessage());
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
            controller.createGame();
          } catch (Exception ex) {
            errorVisable(ex.getMessage());
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
  
  /**
   * Error invisible.
   */
  public void errorInvisible(){
    errorText.setText("");
    errorIcon.setBackground(Background.EMPTY);
  }
  
  /**
   * Error visable.
   */
  public void errorVisable(String message){
    errorText.getStyleClass().add("errorText");
    //errorText.setText("Could not resolve file, try again...");
    errorText.setText(message);
    errorIcon.getStyleClass().add("errorImage");
  }
}
