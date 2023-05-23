package edu.ntnu.idatt2001.view;


import edu.ntnu.idatt2001.controller.CreatePlayerController;
import javafx.collections.ObservableList;
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
  
  private TextField playerName = new TextField();
  private TextField playerHealth = new TextField();
  private TextField playerGold = new TextField();
  private TextField playerScore = new TextField();
  private TextField playerInventory = new TextField();
  public Button errorIcon;
  public Label errorText;

  public CreatePlayerView(CreatePlayerController controller){
    this.controller = controller;
  }
  public Scene setup(){
    // -------------------- CREATE PLAYER SCENE --------------------
    
    ObservableList<String> playerInfo = controller.getPlayerInfo();
    // Top create player layout
    BorderPane createPlayerTop = new BorderPane();
    Button goToCreateHomePlayer = new Button(" ");
      goToCreateHomePlayer.getStyleClass().add("backButton");
      goToCreateHomePlayer.setOnAction(e -> {
        try {
          controller.createGame();
        } catch (Exception ex) {
          errorIcon.getStyleClass().add("errorImage");
          ;
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
    
    playerName.setPromptText("Enter Name * ");
    if(!playerInfo.isEmpty()){
      playerName.setText(playerInfo.get(0));
    }
    playerName.setId("#playerTextFields");
    Image nameIcon = new Image("photos/Icons/PlayerIcons/person-simple.png");
    ImageView nameIconView = new ImageView();
    nameIconView.setImage(nameIcon);
    nameIconView.setFitWidth(30);
    nameIconView.setFitHeight(30);
    playerNameLayout.getChildren().addAll(playerName,nameIconView);
    HBox playerHealthLayout = new HBox();
    playerHealthLayout.setId("boxes");
    
    playerHealth.setPromptText("Enter Health *");
    if(!playerInfo.isEmpty()){
      playerHealth.setText(playerInfo.get(1));
    }
    Image healthIcon = new Image("photos/Icons/PlayerIcons/pharmacy (1).png");
    ImageView healthIconView = new ImageView();
    healthIconView.setImage(healthIcon);
    healthIconView.setFitWidth(30);
    healthIconView.setFitHeight(30);
    playerHealthLayout.getChildren().addAll(playerHealth, healthIconView);
    HBox playerGoldLayout = new HBox();
    playerGoldLayout.setId("boxes");
    
    playerGold.setPromptText("Enter Gold *");
    if(!playerInfo.isEmpty()){
      playerGold.setText(playerInfo.get(2));
    }
    Image goldIcon = new Image("photos/Icons/PlayerIcons/treasure-chest.png");
    ImageView goldIconView = new ImageView();
    goldIconView.setImage(goldIcon);
    goldIconView.setFitWidth(30);
    goldIconView.setFitHeight(30);
    playerGoldLayout.getChildren().addAll(playerGold, goldIconView);
    HBox playerScoreLayout = new HBox();
    playerScoreLayout.setId("boxes");
    
    playerScore.setPromptText("Enter Score");
    if(playerInfo.size() > 3){
      playerScore.setText(playerInfo.get(3));
    }
    Image scoreIcon = new Image("photos/Icons/PlayerIcons/star-sharp-half-stroke.png");
    ImageView scoreIconView = new ImageView();
    scoreIconView.setImage(scoreIcon);
    scoreIconView.setFitWidth(30);
    scoreIconView.setFitHeight(30);
    playerScoreLayout.getChildren().addAll(playerScore, scoreIconView);
    HBox playerInventoryLayout = new HBox();
    playerInventoryLayout.setId("boxes");
    
    playerInventory.setPromptText("Enter Inventory ");
    if(playerInfo.size() > 4){
      playerInventory.setText(playerInfo.get(4));
    }
    playerInventory.setMinHeight(40);
    Image inventoryIcon = new Image("photos/Icons/PlayerIcons/apps.png");
    ImageView InventoryIconView = new ImageView();
    InventoryIconView.setImage(inventoryIcon);
    InventoryIconView.setFitWidth(30);
    InventoryIconView.setFitHeight(30);
    playerInventoryLayout.getChildren().addAll(playerInventory, InventoryIconView);
    createPlayerMid.getChildren().addAll(playerNameLayout, playerHealthLayout, playerGoldLayout, playerScoreLayout, playerInventoryLayout);
    
    // Bottom create player layout
    VBox createPlayerBottom = new VBox();
    createPlayerBottom.setId("boxes");
    errorIcon = new Button("");
      errorIcon.getStyleClass().add("invincible");
    errorText = new Label();
      errorText.getStyleClass().addAll("invincible");
    Button submitPlayerBtn = new Button("Submit player");
    submitPlayerBtn.setOnAction(e -> {
      submit();
    });
    
    createPlayerBottom.getChildren().addAll( errorIcon, errorText, submitPlayerBtn);
    
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
  
  private void submit(){
    try {
      controller.submitPlayer(playerName.getText(), playerHealth.getText(), playerScore.getText(), playerGold.getText(), playerInventory.getText());
    } catch (Exception ex) {
      errorIcon.getStyleClass().add("errorImage");
      errorText.getStyleClass().add("errorText");
      errorText.setText("Please enter a value in the missing text-fields");
      if (playerName.getText() != null) {
        playerName.setId("errorPlayerTextFields");
        playerName.setPromptText("Please enter a name");
      }
      if (playerHealth.getText() != null) {
        playerHealth.setId("errorPlayerTextFields");
        playerHealth.setPromptText("Please enter your health");
      }
      if (playerGold.getText() != null) {
        playerGold.setId("errorPlayerTextFields");
        playerGold.setPromptText("Please enter your gold");
      }
    }
  }
}

