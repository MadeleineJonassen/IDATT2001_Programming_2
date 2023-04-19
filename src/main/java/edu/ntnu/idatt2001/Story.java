package edu.ntnu.idatt2001;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Story {
  private final String title;
  private Map<Link, Passage> passages = new HashMap<>();
  private final Passage openingPassage;
  
  
  //constructor, initializes a story object with title and opening passage
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
    //return deep copy?
    return openingPassage;
  }
  
  //Adds a new passage to the story-list
  //Constructs a custom Link-object to use as key in hashMap
  public void addPassage(Passage passage){
    //if passage is not linked to? 'Unreachable' passages.
    //get broken links, see link references, or create link, use .equals-method
    
    if(passages.containsValue(passage)){
      throw new IllegalArgumentException("This passage had already been added to the story");
    }
    
    
    String passageTitle = passage.getTitle();
    
    passages.put(new Link(passageTitle, passageTitle), passage);
    
    /*
    for(Passage listedPassage : getPassages()){
      for(Link link : listedPassage.getLinks()){
        if(link.getReference().equals(passageTitle)){
          passages.put(link,passage);
        }
      }
    }*/
  }
  
  //Returns a passage, specified by the Link-object parameter
  public Passage getPassage(Link link){
    if(!passages.containsKey(link)){
      throw new IllegalArgumentException("No such link in the story.");
    }
    //return deep copy?
    
    return passages.get(link);
  }
  
  //Returns a list of all the passages currently contained in the story
  public Collection<Passage> getPassages() {
    HashSet<Passage> passageHashSet = new HashSet<>(passages.size());
    for(Link link : passages.keySet()){
      passageHashSet.add(passages.get(link));
    }
    //return deep copied list?
    
    return passageHashSet;
  }
}
