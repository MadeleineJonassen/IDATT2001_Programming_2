package edu.ntnu.idatt2001;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Passage {
  private final String title;
  private final String content;
  private List<Link> links = new ArrayList<>();
  
  //Class constructor, parameters title and content
  public Passage(String title, String content) {
    if(title.isEmpty()){
      throw new IllegalArgumentException("Title cannot be empty");
    }
    if(content.isEmpty()){
      throw new IllegalArgumentException("Content cannot be empty");
    }
    this.title = title;
    this.content = content;
  }
  
  //Class constructor, parameters title, content and one or more Link-objects
  public Passage(String title, String content, Link ... links) {
    this.title = title;
    this.content = content;
    for(Link l : links){
      if(!this.links.contains(l)){
        this.links.add(l);
      }
    }
  }
  
  //
  public String getTitle() {
    return title;
  }
  
  public String getContent() {
    return content;
  }
  
  public void addLink(Link link){
    //diversion from task specification: return void
    if(links.contains(link)){
      throw new IllegalArgumentException("Link has already been added to the passage");
    }
    links.add(link);
  }
  
  public void removeLink(Link link){
    if (!links.contains(link)){
      throw new IllegalArgumentException("This link does not exist in this passage");
    }
    
    links.remove(link);
  }
  
  public List<Link> getLinks() {
    //Return deep copied list?
    return links;
  }
  
  public boolean hasLinks(){
    return !links.isEmpty();
  }
  @Override
  public String toString() {
    return "Passage: " + title + ", content: " + content + ".";
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
  
    return this.title.equals(((Passage) o).getTitle());
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(title, content, links);
  }
}
