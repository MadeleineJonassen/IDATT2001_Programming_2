package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Controller.MainMenuController;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApp extends Application {


  @Override
  public void start(Stage stage) throws Exception {

    MainMenuController controller = new MainMenuController(stage);
    controller.initialize();
  }
}
