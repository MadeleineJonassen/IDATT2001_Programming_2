package edu.ntnu.idatt2001.View;


import edu.ntnu.idatt2001.Controller.CreatePlayerController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreatePlayerView {

  private final CreatePlayerController controller;

  public CreatePlayerView(CreatePlayerController controller){
    this.controller = controller;
  }
  public Scene setup(){
    // -------------------- CREATE PLAYER SCENE --------------------
    // Top create player layout
    BorderPane createPlayerTop = new BorderPane();
    Button goToCreateHomePlayer = new Button(" ");
    goToCreateHomePlayer.getStyleClass().add("backButton");
    //goToCreateHomePlayer.setOnAction(e -> openWindow.setScene(createGameScene));
    goToCreateHomePlayer.setOnAction(e -> {
      try {
        controller.createGame();
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    VBox creatPlayerTopMid = new VBox();
    creatPlayerTopMid.setId("boxes");
    Label createPlayerTitle = new Label("Create Player");
    createPlayerTitle.setId("createTitles");
    Label createPlayerUnderTitle = new Label("Create your own player");
    createPlayerUnderTitle.setId("underTitle");
    creatPlayerTopMid.getChildren().addAll(createPlayerTitle, createPlayerUnderTitle);
    createPlayerTop.setLeft(goToCreateHomePlayer);
    createPlayerTop.setCenter(creatPlayerTopMid);
    
    // Mid create player layout
    VBox createPlayerMid = new VBox();
    HBox playerNameLayout = new HBox();
    playerNameLayout.setId("boxes");
    TextField playerName = new TextField();
    playerName.setPromptText("Enter Name * ");
    playerName.setId("#playerTextFields");
    Image nameIcon = new Image("photos/Icons/PlayerIcons/person-simple.png");
    ImageView nameIconView = new ImageView();
    nameIconView.setImage(nameIcon);
    nameIconView.setFitWidth(30);
    nameIconView.setFitHeight(30);
    playerNameLayout.getChildren().addAll(playerName,nameIconView);
    HBox playerHealthLayout = new HBox();
    playerHealthLayout.setId("boxes");
    TextField playerHealth = new TextField();
    playerHealth.setPromptText("Enter Health *");
    Image healthIcon = new Image("photos/Icons/PlayerIcons/pharmacy (1).png");
    ImageView healthIconView = new ImageView();
    healthIconView.setImage(healthIcon);
    healthIconView.setFitWidth(30);
    healthIconView.setFitHeight(30);
    playerHealthLayout.getChildren().addAll(playerHealth, healthIconView);
    HBox playerGoldLayout = new HBox();
    playerGoldLayout.setId("boxes");
    TextField playerGold = new TextField();
    playerGold.setPromptText("Enter Gold *");
    Image goldIcon = new Image("photos/Icons/PlayerIcons/treasure-chest.png");
    ImageView goldIconView = new ImageView();
    goldIconView.setImage(goldIcon);
    goldIconView.setFitWidth(30);
    goldIconView.setFitHeight(30);
    playerGoldLayout.getChildren().addAll(playerGold, goldIconView);
    HBox playerScoreLayout = new HBox();
    playerScoreLayout.setId("boxes");
    TextField playerScore = new TextField();
    playerScore.setPromptText("Enter Score");
    Image scoreIcon = new Image("photos/Icons/PlayerIcons/star-sharp-half-stroke.png");
    ImageView scoreIconView = new ImageView();
    scoreIconView.setImage(scoreIcon);
    scoreIconView.setFitWidth(30);
    scoreIconView.setFitHeight(30);
    playerScoreLayout.getChildren().addAll(playerScore, scoreIconView);
    HBox playerInventoryLayout = new HBox();
    playerInventoryLayout.setId("boxes");
    TextField playerInventory = new TextField();
    playerInventory.setPromptText("Enter Inventory ");
    playerInventory.setMinHeight(40);
    Image inventoryIcon = new Image("photos/Icons/PlayerIcons/apps.png");
    ImageView InventoryIconView = new ImageView();
    InventoryIconView.setImage(inventoryIcon);
    InventoryIconView.setFitWidth(30);
    InventoryIconView.setFitHeight(30);
    playerInventoryLayout.getChildren().addAll(playerInventory, InventoryIconView);
    createPlayerMid.getChildren().addAll(playerNameLayout, playerHealthLayout ,playerGoldLayout,playerScoreLayout,playerInventoryLayout);
    
    // Bottom create player layout
    VBox createPlayerBottom = new VBox();
    createPlayerBottom.setId("boxes");
    Button playerErrorIcon = new Button("");
    playerErrorIcon.getStyleClass().add("invincible");
    Button submitPlayerBtn = new Button("Submit player");
    submitPlayerBtn.setOnAction(e -> {
      //CreatePlayerController.isString();
      //CreatePlayerController.isInt();
      
      try {
        controller.submitPlayer(playerName.getText(), playerHealth.getText(), playerScore.getText(), playerGold.getText(), playerInventory.getText());
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    });
    //TODO: make submit work
    createPlayerBottom.getChildren().addAll( playerErrorIcon, submitPlayerBtn);
    
    // * Overall Create Player Layout *
    BorderPane createPlayerLayout = new BorderPane();
    createPlayerLayout.setId("boxes");
    createPlayerLayout.setTop(createPlayerTop);
    createPlayerLayout.setCenter(createPlayerMid);
    createPlayerLayout.setBottom(createPlayerBottom);
    Scene createPlayerScene = new Scene(createPlayerLayout, 1300, 700);
    createPlayerScene.getStylesheets().add("StyleSheets/createGameStyle.css");
    return createPlayerScene;
  }
}

