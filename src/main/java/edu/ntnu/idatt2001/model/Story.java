package edu.ntnu.idatt2001.model;

import java.util.*;

/**
 * The type Story.
 */
public class Story {
  private final String title;
  private Map<Link, Passage> passages = new HashMap<>();
  private final Passage openingPassage;
  
  
  /**
   * Instantiates a new Story object with title and opening passage.
   *
   * @param title          the title
   * @param openingPassage the opening passage
   */
  public Story(String title, Passage openingPassage) {
    if (title.isEmpty()) {
      throw new IllegalArgumentException("Title cannot be empty");
    }
    this.title = title;
    this.openingPassage = openingPassage;
    Link openingLink = new Link("Play story", openingPassage.getTitle());
    passages.put(openingLink, openingPassage);
  }
  
  /**
   * Gets title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * Gets opening passage.
   *
   * @return the opening passage
   */
  public Passage getOpeningPassage() {
    return openingPassage;
  }
  
  /**
   * Adds a new passage to the story-list.
   * Constructs a custom Link-object to use as key in hashMap
   *
   * @param passage the passage
   */
  public void addPassage(Passage passage) {
    if (passages.containsValue(passage)) {
      throw new IllegalArgumentException("This passage had already been added to the story");
    }
    
    String passageTitle = passage.getTitle();
    
    passages.put(new Link(passageTitle, passageTitle), passage);
  }
  
  /**
   * Returns a passage, specified by the Link-object parameter.
   *
   * @param link the link
   * @return the passage
   */
  public Passage getPassage(Link link) {
    if (!passages.containsKey(link)) {
      throw new IllegalArgumentException("No such link in the story.");
    }
    return passages.get(link);
  }
  
  /**
   * Returns a list of all the passages currently contained in the story.
   *
   * @return the passages
   */
  public Collection<Passage> getPassages() {
    HashSet<Passage> passageHashSet = new HashSet<>(passages.size());
    for (Link link : passages.keySet()) {
      passageHashSet.add(passages.get(link));
    }
    
    return passageHashSet;
  }
  
  /**
   * Get broken links list.
   *
   * @return the list
   */
  public List<Link> getBrokenLinks() {
    return passages.values().stream().map(Passage::getLinks)
            .flatMap(Collection::stream).filter(link -> !passages.containsKey(link)).toList();
  }
  
  /**
   * Delete broken links.
   */
  public void deleteBrokenLinks() {
    for (Link l : getBrokenLinks()) {
      for (Passage p : getPassages()) {
        if (p.getLinks().contains(l)) {
          p.removeLink(l);
        }
      }
    }
    
  }
  
  /**
   * Removes a passage from the story.
   *
   * @param link the link
   */
  public void removePassage(Link link) {
    if (!passages.containsKey(link)) {
      throw new IllegalArgumentException("No such link in the story.");
    }
    for (Passage p : passages.values()) {
      if (p.getLinks().contains(link)) {
        throw new IllegalArgumentException("Passage '" + p.getTitle()
                + "' contains a Link to this passage. This passage cannot be deleted.");
      }
    }
    passages.remove(link);
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    
    Story s = (Story) obj;
    return (s.getTitle().equals(this.title) && s.getPassages().equals(getPassages()));
  }
  
  
}
