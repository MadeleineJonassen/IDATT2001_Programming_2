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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.Objects;


public class MainMenu extends Application {

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage menuStage) throws Exception {

    //Title Menu
    VBox layoutMenuTitle = new VBox();
      layoutMenuTitle.setPadding(new Insets(20));
      layoutMenuTitle.setSpacing(5);
      layoutMenuTitle.setAlignment(Pos.CENTER);
    Label menuTitle = new Label("Paths");
      menuTitle.setId("menuTitle");
    Label underTitle = new Label("Welcome to a story based game engine!");
      underTitle.setId("underTitle");
    layoutMenuTitle.getChildren().addAll(menuTitle, underTitle);

    //Mid menu options
    VBox layoutMenuOptions = new VBox();
      layoutMenuOptions.setPadding(new Insets(20));
      layoutMenuOptions.setSpacing(10);
      layoutMenuOptions.setAlignment(Pos.CENTER);
    Button createGameBtn = new Button("Create Game");
    Button excitingGameBtn = new Button("Play game");
    layoutMenuOptions.getChildren().addAll(createGameBtn, excitingGameBtn);

    // Bottom layer
    HBox layoutMenuBottom = new HBox();
      layoutMenuBottom.setPadding(new Insets(20));
      layoutMenuBottom.setAlignment(Pos.CENTER_RIGHT);
    Button helpBtn = new Button(" ");
      helpBtn.getStyleClass().add("helpButton");
      helpBtn.setOnAction(e -> helpScene.display());
    layoutMenuBottom.getChildren().addAll(helpBtn);

    //Whole layoutMenu layout
    BorderPane layoutMenu = new BorderPane();
    layoutMenu.setTop(layoutMenuTitle);
    layoutMenu.setCenter(layoutMenuOptions);
    layoutMenu.setBottom(layoutMenuBottom);

    Scene scene = new Scene(layoutMenu, 900, 700);
    scene.getStylesheets().add("menu.css");
    menuStage.setResizable(false);
    menuStage.setScene(scene);
    menuStage.show();
  }
}
