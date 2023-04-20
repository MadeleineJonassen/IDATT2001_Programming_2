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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class MainMenu extends Application {
  Stage window;
  Scene menuScene, gameScene, end;

  public static void main (String[] args) {
    launch();
  }

  @Override
  public void start (Stage menuStage) throws Exception {


    //Title Menu
    VBox layoutMenuTitle = new VBox();
      layoutMenuTitle.setPadding(new Insets(20));
      layoutMenuTitle.setSpacing(10);
      layoutMenuTitle.setAlignment(Pos.CENTER);
    Label menuTitle = new Label("Paths");
      menuTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
    Label underTitle = new Label("Welcome to a storyDisplay based game");
    layoutMenuTitle.getChildren().addAll(menuTitle, underTitle);
    
    //Info and photo layoutMenu
    HBox layoutMenuOptions = new HBox();
      layoutMenuOptions.setAlignment(Pos.CENTER);
      layoutMenuOptions.setSpacing(20);
    Image menuImage = new Image(new FileInputStream("src\\main\\resources\\photos\\pathsMenu.jpg"));
    ImageView viewMenuImage = new ImageView(menuImage);
      viewMenuImage.setFitWidth(300);
      viewMenuImage.setFitHeight(300);
    VBox playerInfo = new VBox();
      Label playerNameTitle = new Label("Player Name:");
      TextField playerNameInput = new TextField();
        playerNameInput.setPromptText("Enter your name");
        playerNameInput.setStyle("-fx-background-color: FAEBD7;");
        playerNameInput.setOnAction(e -> System.out.println("Your name is " + playerNameInput.getText()));
      Label playerHealthTitle = new Label("Health:");
      TextField playerHealthInput = new TextField();
        playerHealthInput.setPromptText("Enter your health");
        playerHealthInput.setStyle("-fx-background-color: FAEBD7;");
        playerHealthInput.setOnAction(e -> System.out.println("Your health is " + playerHealthInput.getText()));
      Label playerGoldTitle = new Label("Gold supply:");
      TextField playerGoldInput = new TextField();
        playerGoldInput.setPromptText("Enter your gold supply");
        playerGoldInput.setStyle("-fx-background-color: FAEBD7;");
        playerGoldInput.setOnAction(e -> System.out.println("Your gold is " + playerGoldInput.getText()));
    playerInfo.setAlignment(Pos.CENTER);
    playerInfo.setSpacing(10);
    playerInfo.getChildren().addAll(playerNameTitle, playerNameInput, playerHealthTitle, playerHealthInput, playerGoldTitle, playerGoldInput);
    layoutMenuOptions.getChildren().addAll(viewMenuImage, playerInfo);

    //Start Button
    HBox layoutMenuStartButton = new HBox();
      layoutMenuStartButton.setAlignment(Pos.CENTER);
      layoutMenuStartButton.setPadding(new Insets(20));
      Button startBtn = new Button("Start Game");
        startBtn.setOnAction(e -> window.setScene(gameScene));
    layoutMenuStartButton.getChildren().addAll(startBtn);

    //Whole layoutMenu layout
    BorderPane layoutMenu = new BorderPane();
      layoutMenu.setTop(layoutMenuTitle);
      layoutMenu.setCenter(layoutMenuOptions);
      layoutMenu.setBottom(layoutMenuStartButton);

    window = menuStage;
    window.setTitle("Menu for Paths");
    window.setResizable(false);
    menuScene = new Scene(layoutMenu, 600, 600);
    window.setScene(menuScene);
    window.show();

    
    //The game layout
    //Top layout 
    VBox layoutGameTop = new VBox();
      HBox layoutGamePlayerInfo = new HBox();
        layoutGamePlayerInfo.setAlignment(Pos.CENTER_LEFT);
        layoutGamePlayerInfo.setSpacing(10);
        layoutGamePlayerInfo.setPadding(new Insets(20));
        Label playerName = new Label("Name: " + playerNameInput.getText());
        Label playerHealth = new Label("Health: " + playerHealthInput.getText());
        Label playerGold = new Label("Gold: " + playerGoldInput.getText());
      layoutGamePlayerInfo.getChildren().addAll(playerName,playerHealth,playerGold);  
      Region gameTopSpacing = new Region();
      HBox layoutGameTopButtons = new HBox();
        Button backToMenu = new Button("Return to Menu");
          backToMenu.setOnAction(e -> window.setScene(menuScene));
        Button helpButton = new Button("Help");
          helpButton.setOnAction(e -> helpScene.display());
        layoutGameTopButtons.getChildren().addAll(backToMenu, helpButton);
    layoutGameTop.getChildren().addAll(layoutGamePlayerInfo, gameTopSpacing, layoutGameTopButtons);

    //Center visuals/layout
    VBox layoutGameVisuals = new VBox();
    layoutGameVisuals.setAlignment(Pos.CENTER);
    layoutGameVisuals.setPadding(new Insets(20));
      Image pathImage = new Image(new FileInputStream("src\\main\\resources\\photos\\pathsMenu.jpg"));
      ImageView viewPathImage = new ImageView(pathImage);
        viewPathImage.setFitWidth(300);
        viewPathImage.setFitHeight(300);
    layoutGameVisuals.getChildren().addAll(viewPathImage);

    //Bottom layout
    VBox layoutGameStoryMenu = new VBox();
      layoutGameStoryMenu.setPadding(new Insets(10));
      ScrollPane storyDisplay = new ScrollPane();
        storyDisplay.setStyle("-fx-background-color: FAEBD7;");
      TableView<Object> storyOptions = new TableView<>();
        storyOptions.setStyle("-fx-background-color: FAEBD7;");
        storyOptions.setItems(getLink());
    layoutGameStoryMenu.getChildren().addAll(storyDisplay, storyOptions);

    //Whole gameLayout layout
    BorderPane gameLayout = new BorderPane();
    gameLayout.setTop(layoutGamePlayerInfo);
    gameLayout.setCenter(layoutGameVisuals);
    gameLayout.setBottom(layoutGameStoryMenu);
    gameScene = new Scene(gameLayout, 600, 600);


    }
    public ObservableList<Object> getLink() {
    ObservableList<Link> links = FXCollections.observableArrayList();
    links.add(new Link("Something","Dunno"));
      return null;
    }

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
