package edu.ntnu.idatt2001.fileHandler;

import edu.ntnu.idatt2001.model.Action.Action;
import edu.ntnu.idatt2001.model.Link;
import edu.ntnu.idatt2001.model.Passage;
import edu.ntnu.idatt2001.model.Story;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * Writes a story.
 */
public class WriteStory {
  /**
   * Writes a story.
   *
   * @param story the story
   * @param file  txt file
   */
  public void write(Story story, File file) {
    try (FileWriter fileWriter = new FileWriter(file)) {
      
      fileWriter.write(story.getTitle() + "\n");
      
      Passage openingPassage = story.getOpeningPassage();
      
      fileWriter.write(writePassage(openingPassage));
      
      Collection<Passage> passages = story.getPassages();
      
      for (Passage passage : passages) {
        if (passage != openingPassage) {
          fileWriter.write(writePassage(passage));
        }
      }
      
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot write to this file");
    }
  }

  /**
   * Writes a story.
   *
   * @param story A story
   */
  public void write(Story story) {
    String dir = "src/main/resources/Stories/" + story.getTitle().replace(" ", "") + ".paths";
    File file = new File(dir);
    try (FileWriter fileWriter = new FileWriter(file)) {
      
      fileWriter.write(story.getTitle() + "\n");
      
      Passage openingPassage = story.getOpeningPassage();
      
      fileWriter.write(writePassage(openingPassage));
      
      Collection<Passage> passages = story.getPassages();
      
      for (Passage passage : passages) {
        if (passage != openingPassage) {
          fileWriter.write(writePassage(passage));
        }
      }
      
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot write the file");
    }
  }
  
  private String writePassage(Passage passage) {
    StringBuilder passageString = new StringBuilder("\n::");
    
    passageString.append(passage.getTitle()).append("\n");
    passageString.append(passage.getContent()).append("\n");
    
    for (Link link : passage.getLinks()) {
      passageString.append(writeLink(link));
    }
    
    return passageString.toString();
  }
  
  private String writeLink(Link link) {
    StringBuilder linkString = new StringBuilder("[");
    linkString.append(link.getText()).append("]");
    linkString.append("(").append(link.getReference()).append(")");
    for (Action a : link.getActions()) {
      linkString.append(writeAction(a));
    }
    linkString.append("\n");
    return linkString.toString();
  }
  
  private String writeAction(Action action) {
    return "{" + action.toString() + "}";
  }
}
