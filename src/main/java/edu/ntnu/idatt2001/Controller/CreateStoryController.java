package edu.ntnu.idatt2001.Controller;

import edu.ntnu.idatt2001.GUI.MainMenu;
import edu.ntnu.idatt2001.Model.GameManager;
import edu.ntnu.idatt2001.ScanStory;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static edu.ntnu.idatt2001.GUI.MainMenu.displayStoryPath;
import static edu.ntnu.idatt2001.GUI.MainMenu.storyListView;

public class CreateStoryController {
  
  private GameManager gameManager;
  
  public CreateStoryController(GameManager gameManager) {
    this.gameManager = gameManager;
  }

  public static void chooseStory() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select a story");
    fileChooser.setInitialDirectory(new File("src/resources/Stories"));
    File selectedFile = fileChooser.showOpenDialog(MainMenu.openWindow);
    if (selectedFile != null) {
      try {
        Scanner fileScanner = new Scanner(selectedFile);
        while (fileScanner.hasNextLine()) {
          storyListView.getItems().add(fileScanner.nextLine() + "\n");
          displayStoryPath.setPromptText(selectedFile.getPath());
        }
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
    }
  }




  /** Lists all files in the resources' folder. Returns a set of strings
   *
   * @return files
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
  
}
