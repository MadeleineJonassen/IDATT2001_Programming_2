package edu.ntnu.idatt2001;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private final Scanner in = new Scanner(System.in);
    private Player player = new Player("Arthur", 10, 0, 0);

    public static void main(String[] args) throws FileNotFoundException {
      Main client = new Main();
      client.menu();
    }

    public void menu() throws FileNotFoundException {
      //System.out.println("test print");
      File stories = new File("src/main/resources/Stories.txt");
      
      ScanStory scanning = new ScanStory();
      
      Story story = scanning.scanStory(stories);
  
      System.out.println(story.getPassages());
  
      //Gets the files location and checks to see if the file is a valid .txt file or not
      if (stories.exists()) {
        System.out.println("\n\nThe story exist. Path: " + stories.getPath() + " || Absolute path: " + stories.getAbsolutePath() + " || Is a file: " + stories.isFile());
      } else {
        System.out.println("File not found");
      }
    }
    
    
}