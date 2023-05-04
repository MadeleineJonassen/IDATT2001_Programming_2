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
      layoutMenuTitle.setSpacing(10);
      layoutMenuTitle.setAlignment(Pos.CENTER);
    Label menuTitle = new Label("Paths");
    Text underTitle = new Text("Welcome to a storyDisplay based game engine");
    Button startBtn = new Button("Create Game");
    layoutMenuTitle.getChildren().addAll(menuTitle, underTitle, startBtn);

    //Whole layoutMenu layout
    BorderPane layoutMenu = new BorderPane();
    layoutMenu.setTop(layoutMenuTitle);

    Scene scene = new Scene(layoutMenu, 800, 800);
    scene.getStylesheets().add("menu.css");
    menuStage.setResizable(false);
    menuStage.setScene(scene);
    menuStage.show();
  }
}
