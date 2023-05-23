package edu.ntnu.idatt2001.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Passage.
 */
public class Passage {
  private final String title;
  private final String content;
  private List<Link> links = new ArrayList<>();
  
  /**
   * Instantiates a new Passage.
   *
   * @param title   the title
   * @param content the content
   */
  public Passage(String title, String content) {
    if (title.isEmpty()) {
      throw new IllegalArgumentException("Title cannot be empty");
    }
    if (content.isEmpty()) {
      throw new IllegalArgumentException("Content cannot be empty");
    }
    this.title = title;
    this.content = content;
  }
  
  /**
   * Instantiates a new Passage.
   *
   * @param title   the title
   * @param content the content
   * @param links   the links
   */
  public Passage(String title, String content, Link ... links) {
    this.title = title;
    this.content = content;
    for (Link l : links) {
      if (!this.links.contains(l)) {
        this.links.add(l);
      }
    }
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
   * Gets content.
   *
   * @return the content
   */
  public String getContent() {
    return content;
  }
  
  /**
   * Add link.
   *
   * @param link the link
   */
  public void addLink(Link link) {
    if (links.contains(link)) {
      throw new IllegalArgumentException("Link has already been added to the passage");
    }
    links.add(link);
  }
  
  /**
   * Remove link.
   *
   * @param link the link
   */
  public void removeLink(Link link) {
    if (!links.contains(link)) {
      throw new IllegalArgumentException("This link does not exist in this passage");
    }
    
    links.remove(link);
  }
  
  /**
   * Gets links.
   *
   * @return the links
   */
  public List<Link> getLinks() {
    return links;
  }
  
  /**
   * Has links boolean.
   *
   * @return the boolean
   */
  public boolean hasLinks() {
    return !links.isEmpty();
  }
  
  @Override
  public String toString() {
    return "Passage: " + title + ", content: " + content + ".";
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
  
    return this.title.equals(((Passage) o).getTitle());
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(title, content, links);
  }
}
