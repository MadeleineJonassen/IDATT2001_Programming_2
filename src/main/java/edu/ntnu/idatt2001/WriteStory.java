package edu.ntnu.idatt2001;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class WriteStory {
  public void write(Story story, File file){
    try (FileWriter fileWriter = new FileWriter(file)) {
      //fileWriter.write("Hello world!");
  
      fileWriter.write(story.getTitle() + "\n");
      
      Passage openingPassage = story.getOpeningPassage();
      
      fileWriter.write(writePassage(openingPassage));
      
      //need to start with opening passage, OR skip opening passage below
      //alternatively, modify getPassages to make sure opening passage is first?
      
      Collection<Passage> passages = story.getPassages();
      
      for(Passage passage : passages){
        if (passage != openingPassage){
          fileWriter.write(writePassage(passage));
        }
      }
      
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  
    
    //write opening passage and link
    //write remaining passages
    
  }
  
  private String writePassage(Passage passage){
    StringBuilder passageString = new StringBuilder("\n::");
    
    passageString.append(passage.getTitle()).append("\n");
    passageString.append(passage.getContent()).append("\n");
    
    //check if links is empty
    for(Link link : passage.getLinks()){
      passageString.append("[").append(link.getText()).append("]");
      passageString.append("(").append(link.getReference()).append(")\n");
    }
    
    return passageString.toString();
  }
}
