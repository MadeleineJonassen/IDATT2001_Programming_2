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

public class CreateStoryController {
  
  private GameManager gameManager;
  private final Stage stage;
  private SceneController sceneController = new SceneController();
  public File selectedFile;
  
  public CreateStoryController(Stage stage, GameManager gameManager) {
    this.gameManager = gameManager;
    this.stage = stage;
    CreateStoryView view = new CreateStoryView(this);
    stage.setScene(view.setup());
    stage.show();
  }



  public void createGame() throws Exception {
    System.out.println("goToCreateGame");
    sceneController.switchScene(stage, 2, gameManager);
  }
  
  public void chooseStory(){
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select a story");
    fileChooser.setInitialDirectory(new File("src/resources/Stories"));
    selectedFile = fileChooser.showOpenDialog(PathsLauncher.openWindow);
    if (selectedFile != null) {
      try {
        ScanStory scan = new ScanStory();
        //storyListView.getItems().add(scan.nextLine() + "\n");
        //displayStoryPath.setPromptText(selectedFile.getPath());
        gameManager.setStory(scan.scanStory(selectedFile));
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public String getDirectory() {
     String directory = selectedFile.getPath();
     return directory;
  }

  
  public Collection<String> getStoryPassageNames(){
    return gameManager.getStoryPassageNames();
  }
  
  /** Lists all files in the resources' folder. Returns a set of strings
   *
   * @return files
   **/
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

  public String getBrokenLinks() {
    String brokenLinks = gameManager.getBrokenLinks().toString();
    return brokenLinks;
  }
  
  /*
  public void scanStory(String fileName) throws FileNotFoundException {
    //TODO: exception handling
    File file = new File("src/main/resources" + fileName);
    scanStory(file);
  }
  
  //Used if user is presented with the files
  public void scanStory(File file) throws FileNotFoundException {
    //TODO: handle FileNotFoundException
    try{
      ScanStory scan = new ScanStory();
      gameManager.setStory(scan.scanStory(file));
    }catch (FileNotFoundException e){
      throw new FileNotFoundException("Finner ikke den angitte filen ");
    }
  }
  
  public void deleteBrokenLinks(){
    gameManager.deleteBrokenLinks();
  }
  
  public void deletePassage(String passageName){
    //remove passage from story
    //return passages that link to this passage, so that user may delete these?
    //Alternatively, add possibility to edit passages (separate window)
  }
  
  public void editPassage(String passageName){
    //Open popup window
  }


   */
}
