package edu.ntnu.idatt2001;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Passage {
  private final String title;
  private final String content;
  private List<Link> links = new ArrayList<>();
  
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
  
  public String getTitle() {
    return title;
  }
  
  public String getContent() {
    return content;
  }
  
  public boolean addLink(Link link){
    if(links.contains(link)){
      return false;
    }
    links.add(link);
    return true;
  }
  
  public List<Link> getLinks() {
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
    
    Passage passage = (Passage) o;
    if (this.title.equals(((Passage) o).getTitle())) return true;
    return false;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(title, content, links);
  }
}
