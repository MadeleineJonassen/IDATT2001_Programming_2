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
    if(title.isEmpty()){
      throw new IllegalArgumentException("Title cannot be empty");
    }
    this.title = title;
    this.openingPassage = openingPassage;
    Link openingLink = new Link("Play story", openingPassage.getTitle());
    passages.put(openingLink, openingPassage);
  }
  
  public String getTitle() {
    return title;
  }
  
  public Passage getOpeningPassage() {
    return openingPassage;
  }
  
  public void addPassage(Passage passage){
    if(passages.containsValue(passage)){
      throw new IllegalArgumentException("This passage had already been added to the story");
    }
    
    String passageTitle = passage.getTitle();
    
    for(Passage listedPassage : getPassages()){
      for(Link link : listedPassage.getLinks()){
        if(link.getReference().equals(passageTitle)){
          passages.put(link,passage);
        }
      }
    }
  }
  
  public Passage getPassage(Link link){
    if(!passages.containsKey(link)){
      throw new IllegalArgumentException("No such link in the story.");
    }
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
