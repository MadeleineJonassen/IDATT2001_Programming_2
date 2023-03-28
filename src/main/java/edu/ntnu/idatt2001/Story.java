package edu.ntnu.idatt2001;
import java.util.*;

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
  
  public List<Link> getBrokenLinks(){
    List<Link> brokenLinks = new ArrayList<>();
    //use streams
    for(Passage listedPassage : getPassages()){
      for(Link link : listedPassage.getLinks()){
        if (passages.containsKey(link)){
          brokenLinks.add(link);
        }
      }
    }
    
    return brokenLinks;
  }
  
  public void removePassage(Link link){
    if(!passages.containsKey(link)){
      throw new IllegalArgumentException("No such link in the story.");
    }
    //not supposed to be able to remove passage if other passages contain a link leading to the passage.
    //Should it instead be the other way around? If a passage links to other passages it would create
    //passages that cannot be accessed
    passages.remove(link);
  }
}
