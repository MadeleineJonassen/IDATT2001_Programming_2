package edu.ntnu.idatt2001;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Story {
  private final String title;
  private Map<Link, Passage> passages = new HashMap<>();
  private final Passage openingPassage;
  
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
    String passageTitle = passage.getTitle();
    
    for(Passage listedPassage : getPassages()){
      if(!listedPassage.hasLinks()){
        continue;
      }
      
      for(Link link : listedPassage.getLinks()){
        if(link.getReference().equals(passageTitle)){
          passages.put(link,passage);
        }
      }
    }
  }
  
  public Passage getPassage(Link link){
    return passages.get(link);
  }
  
  public Collection<Passage> getPassages() {
    HashSet<Passage> passageHashSet = new HashSet<>(passages.size());
    for(Link link : passages.keySet()){
      passageHashSet.add(passages.get(link));
    }
    return passageHashSet;
  }
}
