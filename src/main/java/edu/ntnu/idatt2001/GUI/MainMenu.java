package edu.ntnu.idatt2001.GUI;

import edu.ntnu.idatt2001.Link;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class MainMenu extends Application {
  Stage window;
  Scene menuScene, gameScene, end;

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage menuStage) throws Exception {


    //Title Menu
    VBox layoutMenuTitle = new VBox();
    layoutMenuTitle.setPadding(new Insets(20));
    layoutMenuTitle.setSpacing(10);
    layoutMenuTitle.setAlignment(Pos.CENTER);
    Label menuTitle = new Label("Paths");
    menuTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
    Label underTitle = new Label("Welcome to a storyDisplay based game engine");
    layoutMenuTitle.getChildren().addAll(menuTitle, underTitle);

    //Info and photo layoutMenu
    HBox layoutMenuPhoto = new HBox();
    layoutMenuPhoto.setAlignment(Pos.CENTER);
    layoutMenuPhoto.setSpacing(20);
    layoutMenuPhoto.setPadding(new Insets(20));
    Image menuImage = new Image(new FileInputStream("src\\resources\\photos\\pathsMenu.jpg"));
    ImageView viewMenuImage = new ImageView(menuImage);
      viewMenuImage.setFitWidth(300);
      viewMenuImage.setFitHeight(300);
    layoutMenuPhoto.getChildren().addAll(viewMenuImage);

    VBox playerInfo = new VBox();
    playerInfo.setAlignment(Pos.CENTER);
    playerInfo.setSpacing(10);
    playerInfo.setPadding(new Insets(20));
    Button startBtn = new Button("Create Game");
      startBtn.setFont(Font.font("Verdana", 30));
      startBtn.setStyle("-fx-background-color: #BFC8AD");
      startBtn.setOnAction(e -> window.setScene(gameScene));
    playerInfo.getChildren().addAll(startBtn);

    //Whole layoutMenu layout
    BorderPane layoutMenu = new BorderPane();
    layoutMenu.setTop(layoutMenuTitle);
    layoutMenu.setLeft(layoutMenuPhoto);
    layoutMenu.setRight(playerInfo);

    window = menuStage;
    window.setTitle("Menu for Paths");
    window.setResizable(false);
    menuScene = new Scene(layoutMenu, 600, 600);
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
            System.out.println("Changing to Gold digger as goal");
          } else {
            System.out.println("Gold digger not selected");
          }
        });
      CheckMenuItem itemGoal = new CheckMenuItem("Item Acquired");
        itemGoal.setOnAction(e -> {
          if (itemGoal.isSelected()) {
            System.out.println("Changing to Gold digger as goal");
          } else {
            System.out.println("Gold digger not selected");
          }
        });
      CheckMenuItem autoSave = new CheckMenuItem("Enable auto save");
      autoSave.setSelected(true);
      goals.getItems().addAll(goldDiggerGoal, healGoal, itemGoal, autoSave);
  //May change to RadioMenu, so the user only can select one item...?


    //Main menu bar
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu, newGoal, goals);
    */

  }
}
