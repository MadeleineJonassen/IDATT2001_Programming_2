package edu.ntnu.idatt2001.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainMenu extends Application {
  Stage window;
  Scene menuScene, game, end;

  public static void main (String[] args) {
    launch();
  }

  @Override
  public void start (Stage menuStage) throws Exception {

    //Start Button
    HBox startButtonLayout = new HBox();
      startButtonLayout.setAlignment(Pos.CENTER);
      startButtonLayout.setPadding(new Insets(20));
    Button startBtn = new Button("Start Game");
      startBtn.setOnAction( e -> System.out.println("Start button pressed"));
    startButtonLayout.getChildren().addAll(startBtn);

    //Title Menu
    VBox titleLayout = new VBox();
      titleLayout.setPadding(new Insets(20));
      titleLayout.setSpacing(10);
      titleLayout.setAlignment(Pos.CENTER);
    Label menuTitle = new Label("Paths");
      menuTitle.setFont(Font.font(40));
    Label underTitle = new Label("Welcome to a story based game");
    titleLayout.getChildren().addAll(menuTitle,underTitle);

    //Whole menu layout
    BorderPane menu = new BorderPane();
      menu.setTop(titleLayout);
      menu.setBottom(startButtonLayout);

    window = menuStage;
    window.setTitle("Menu for Paths");
    window.setResizable(false);
    menuScene = new Scene(menu, 600, 600);
    window.setScene(menuScene);
    window.show();


    /* Put above
    //Settings Menu
    Menu fileMenu = new Menu("Settings");
      //Setting items
      MenuItem saveOption = new MenuItem("Save...");                     // This item
      saveOption.setOnAction(e -> System.out.println("Saving game..."));   // Does this thing
      fileMenu.getItems().add(saveOption);                                 // Execute action
      fileMenu.getItems().add(new SeparatorMenuItem());
      fileMenu.getItems().add(new MenuItem("Restart"));
      fileMenu.getItems().add(new MenuItem("Exit"));

    //Help menu
    Menu newGoal = new Menu("Help");
      //Help items
      newGoal.getItems().add(new MenuItem("What am i doing?"));
      newGoal.getItems().add(new MenuItem("Que?"));
      MenuItem gold = new MenuItem("Unlock me later");
      gold.setOnAction(e -> System.out.println("Unlock happened"));
      gold.setDisable(true);
      newGoal.getItems().add(gold);

    //Goal Menu
    Menu goals = new Menu("Goals");
      //Goal items
      CheckMenuItem goldDiggerGoal = new CheckMenuItem("Gold Digger.");
        goldDiggerGoal.setOnAction(e -> {
          if (goldDiggerGoal.isSelected()) {
            System.out.println("Changing to Gold digger as goal");
          } else {
            System.out.println("Gold digger not selected");
          }
        });
      CheckMenuItem healGoal = new CheckMenuItem("Heal up!");
        healGoal.setOnAction(e -> {
          if (healGoal.isSelected()) {
            System.out.println("Chaing to Gold digger as goal");
          } else {
            System.out.println("Gold digger not selected");
          }
        });
      CheckMenuItem itemGoal = new CheckMenuItem("Item Acquired");
        itemGoal.setOnAction(e -> {
          if (itemGoal.isSelected()) {
            System.out.println("Chaing to Gold digger as goal");
          } else {
            System.out.println("Gold digger not selected");
          }
        });
      CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
      autoSave.setSelected(true);
      goals.getItems().addAll(goldDiggerGoal, healGoal, itemGoal, autoSave);
  //May change to RadioMenu, so the user only can select one item...?


    //Main menu bar
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu, newGoal, goals);
    */

  }
}
