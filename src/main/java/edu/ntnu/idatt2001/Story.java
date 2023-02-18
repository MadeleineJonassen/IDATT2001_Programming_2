package edu.ntnu.idatt2001;
import java.util.HashMap;
import java.util.Map;

public class Story {
  private String title;
  private Map<Link, Passage> passages = new HashMap<Link,Passage>();
  private Passage openingPassage;
  
  public Story(String title, Passage openingPassage) {
    this.title = title;
    this.openingPassage = openingPassage;
    Link openingLink = new Link(openingPassage.getTitle(), openingPassage.getTitle());
    passages.put(openingLink, openingPassage);
  }
  
  public String getTitle() {
    return title;
  }
  
  public Passage getOpeningPassage() {
    return openingPassage;
  }
  
  public void addPassage(Passage passage){
    Link link = new Link(passage.getTitle(), passage.getTitle());
    passages.put(link,passage);
  }
  
  public Passage getPassage(Link link){
    return passages.get(link);
  }
  
  public Map<Link, Passage> getPassages() {
    return passages;
  }
}
