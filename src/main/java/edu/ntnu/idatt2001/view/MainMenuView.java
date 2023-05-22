package edu.ntnu.idatt2001.view;

import edu.ntnu.idatt2001.controller.MainMenuController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * The type Main menu view.
 */
public class MainMenuView  {

  //private final Stage stage;
  private final MainMenuController controller;
  
  /**
   * The Error icon.
   */
/*public MainMenuView(Stage stage, MainMenuController controller){
    this.stage = stage;
    this.controller = controller;
  }*/
  public Button errorIcon;
  /**
   * The Error text.
   */
  public Label errorText;
  
  /**
   * Instantiates a new Main menu view.
   *
   * @param controller the controller
   */
  public MainMenuView(MainMenuController controller){
    this.controller = controller;
  }
  
  /**
   * Setup scene.
   *
   * @return the scene
   */
  public Scene setup(){

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
    //TODO: grey out button when game is not added
    playGameBtn.setOnAction(e -> {
      try {
        controller.playGame();
      } catch (Exception ex) {
        errorVisible(ex.getMessage());
      }
    });
    layoutMenuOptions.getChildren().addAll(createGameBtn, playGameBtn, errorIcon, errorText);
    //TODO: add "try a sample game"-button

    // * Overall Main Menu Layout *
    BorderPane layoutMenu = new BorderPane();
    layoutMenu.setCenter(layoutMenuTitle);
    layoutMenu.setLeft(layoutMenuOptions);

    Scene scene = new Scene(layoutMenu, 1300, 700);
    scene.getStylesheets().add("StyleSheets/menuStyle.css");
    return scene;
    
  }
  
  /**
   * Error invisible.
   */
  public void errorInvisible(){
    errorText.getStyleClass().add("invincible");
    errorIcon.getStyleClass().add("invincible");
  }
  
  /**
   * Error visible.
   *
   * @param message the message
   */
  public void errorVisible(String message){
    errorText.getStyleClass().add("errorText");
    errorText.setText(message);
    errorIcon.getStyleClass().add("errorImage");
  }


  //TODO: make getters here, as well as private variables above
}