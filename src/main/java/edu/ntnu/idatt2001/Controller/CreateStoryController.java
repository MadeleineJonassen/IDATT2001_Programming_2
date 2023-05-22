package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.FileHandler.ScanStory;
import edu.ntnu.idatt2001.PathsLauncher;
import edu.ntnu.idatt2001.View.CreateStoryView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static edu.ntnu.idatt2001.GUI.MainMenu.displayStoryPath;
//import static edu.ntnu.idatt2001.GUI.MainMenu.storyListView;

/**
 * The type Create story controller.
 */
public class CreateStoryController {
  
  private GameManager gameManager;
  private final Stage stage;
  private SceneController sceneController = new SceneController();
  /**
   * The Selected file.
   */
  public File selectedFile;
  
  /**
   * Instantiates a new Create story controller.
   *
   * @param stage       the stage
   * @param gameManager the game manager
   */
  public CreateStoryController(Stage stage, GameManager gameManager) {
    this.gameManager = gameManager;
    this.stage = stage;
    CreateStoryView view = new CreateStoryView(this);
    stage.setScene(view.setup());
    stage.show();
  }
  
  /**
   * Create game.
   *
   */
  public void createGame() {
    sceneController.switchScene(stage, 2, gameManager);
  }
  
  /**
   * Choose story.
   */
  public void chooseStory() throws FileNotFoundException{
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select a story");
    fileChooser.setInitialDirectory(new File("src/main/resources/Stories"));
    selectedFile = fileChooser.showOpenDialog(PathsLauncher.openWindow);
    if (selectedFile != null) {
      ScanStory scan = new ScanStory();
      gameManager.setStory(scan.scanStory(selectedFile));
    }
  }
  
  /**
   * Gets directory.
   *
   * @return the directory
   */
  public String getDirectory() {
    return selectedFile.getPath();
  }
  
  
  /**
   * Get story passage names collection.
   *
   * @return the collection
   */
  public Collection<String> getStoryPassageNames(){
    return gameManager.getStoryPassageNames();
  }
  
  /**
   * Lists all files in the resources' folder. Returns a set of strings
   *
   * @return files set
   */
  public Set<String> listFiles() {
    //TODO: add exceptions if path is invalid, or empty
    //TODO: filter or sort by file type (se filechooser)
    //possibly not within the scope of this class
    String dir = "src/main/resources";
    return Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
            .filter(file -> !file.isDirectory())
            .map(File::getName)
            .collect(Collectors.toSet());
  }
  
  /**
   * Gets broken links.
   *
   * @return the broken links
   */
  public String getBrokenLinks() {
    return gameManager.getBrokenLinks().toString();
  }
  
  /**
   * Delete broken links.
   */
  public void deleteBrokenLinks(){
    gameManager.deleteBrokenLinks();
  }
  
}
