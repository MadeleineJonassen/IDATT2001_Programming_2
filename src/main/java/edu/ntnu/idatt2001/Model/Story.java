package edu.ntnu.idatt2001.Model;
import java.util.*;

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
  
  public List<Link> getBrokenLinks(){
    /*
    List<Link> brokenLinks = new ArrayList<>();
    //use streams
    for(Passage listedPassage : getPassages()){
      for(Link link : listedPassage.getLinks()){
        if (passages.containsKey(link)){
          brokenLinks.add(link);
        }
      }
    }*/
    
    List<Link> brokenLinks = passages.values().stream().map(Passage::getLinks).flatMap(Collection::stream).filter(link -> !passages.containsKey(link)).toList();
    
    
    return brokenLinks;
  }
  
  public void deleteBrokenLinks(){
    for(Link l : getBrokenLinks()){
      for (Passage p : getPassages()){
        if(p.getLinks().contains(l)){
          p.removeLink(l);
        }
      }
    }
    
  }
  
  //removes a passage from the story
  public void removePassage(Link link){
    if(!passages.containsKey(link)){
      throw new IllegalArgumentException("No such link in the story.");
    }
    //TODO: restrict, passages cannot be removed if linked to (creating broken links)
    //not supposed to be able to remove passage if other passages contain a link leading to the passage.
    //Should it instead be the other way around? If a passage links to other passages it would create
    //passages that cannot be accessed
    //if not: need a way to replace passage or remove links!
    passages.remove(link);
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if(obj == null || getClass() != obj.getClass()) return false;
    
    Story s = (Story) obj;
    return (s.getTitle().equals(this.title) && s.getPassages().equals(getPassages()));
  }
  
  
}
