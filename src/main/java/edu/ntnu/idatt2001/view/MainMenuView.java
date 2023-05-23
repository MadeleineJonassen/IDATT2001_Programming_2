package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.MainMenuController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * View for Main Menu..
 */
public class MainMenuView  {
  private final MainMenuController controller;

  public Button errorIcon;
  public Label errorText;
  
  public MainMenuView(MainMenuController controller) {
    this.controller = controller;
  }

  /**
   * Setup for the main menu view.
   *
   * @return the view
   */
  public Scene setup() {

    // **************************** MENU ****************************
    // Top menu layout
    VBox layoutMenuTitle = new VBox();
    layoutMenuTitle.setId("titleBox");
    Label menuTitle = new Label("PATHS");
    menuTitle.setId("title");
    Label menuUnderTitle = new Label("A story based game engine");
    menuUnderTitle.setId("underTitle");
    layoutMenuTitle.getChildren().addAll(menuTitle, menuUnderTitle);

    // Mid menu layout
    VBox layoutMenuOptions = new VBox();
    layoutMenuOptions.setId("boxes");
    errorIcon = new Button("");
    errorText = new Label("");
    errorInvisible();
    Button createGameBtn = new Button("Create Game");
    createGameBtn.setId("menuButton");
    createGameBtn.setOnAction(e -> {
      try {
        controller.createGame();
      } catch (Exception ex) {
        errorVisible(ex.getMessage());
      }
    });
    Button playGameBtn = new Button("Play game");
    playGameBtn.setId("menuButton");
    playGameBtn.setOnAction(e -> {
      try {
        controller.playGame();
      } catch (Exception ex) {
        errorVisible(ex.getMessage());
      }
    });
    layoutMenuOptions.getChildren().addAll(createGameBtn, playGameBtn, errorIcon, errorText);

    // * Overall Main Menu Layout *
    BorderPane layoutMenu = new BorderPane();
    layoutMenu.setCenter(layoutMenuTitle);
    layoutMenu.setLeft(layoutMenuOptions);

    Scene scene = new Scene(layoutMenu, 1300, 700);
    scene.getStylesheets().add("StyleSheets/menuStyle.css");
    return scene;
    
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