package edu.ntnu.idatt2001.GUI;

import edu.ntnu.idatt2001.Players.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class createPlayer extends Dialog<Player> {

  private Player player;

  private TextField playerName;
  private TextField playerHealth;
  private TextField playerGold;
  private TextField playerScore;
  private TextField playerInventory;

  public createPlayer(Player player) {
    super();
    this.setTitle("Add Player");
    this.player = player;
    buildUI();
    setPropertyBindings();
    setResultConverter();
  }

  private void buildUI() {
    Pane createPlayer = createPlayerPane();
    getDialogPane().setContent(createPlayer);
    getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    Button button = (Button) getDialogPane().lookupButton(ButtonType.OK);
    button.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        if (! validateDialog()){
          actionEvent.consume();
        }
      }
      private boolean validateDialog() {
        if ((playerName.getText().isEmpty() || playerHealth.getText().isEmpty() || playerGold.getText().isEmpty() ||playerScore.getText().isEmpty() || playerInventory.getText().isEmpty())) {
          return false;
        }
        return true;
      }
    });
  }

  private void setPropertyBindings() {
    playerName.textProperty().bindBidirectional(player.getName());
  }

  private void setResultConverter() {
  }


  public Pane createPlayerPane() {

    VBox createPlayerLayout = new VBox(10);

    Label createPlayerTitle = new Label("Create Player");
    this.playerName = new TextField();
    playerName.setPromptText("Player name");
    this.playerHealth = new TextField();
    playerHealth.setPromptText("Player health");
    this.playerGold = new TextField();
    playerGold.setPromptText("Player gold");
    this.playerScore = new TextField();
    playerScore.setPromptText("Player score");
    this.playerInventory = new TextField(); //May change later based on the ability to add/ edit inventory
    playerInventory.setPromptText("Player Inventory");

    createPlayerLayout.getChildren().addAll(createPlayerTitle, playerName, playerHealth, playerGold, playerScore, playerInventory);

    return createPlayerLayout;
  }
}