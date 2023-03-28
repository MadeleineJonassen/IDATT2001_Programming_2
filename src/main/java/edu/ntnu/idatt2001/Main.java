package edu.ntnu.idatt2001;

import java.io.*;
import java.util.Scanner;

public class Main {

    private final Scanner in = new Scanner(System.in);
    private Player player = new Player("Arthur", 10, 0, 0);

    public static void main(String[] args) throws FileNotFoundException {
        Main client = new Main();
        client.menu();
    }

    public void menu() throws FileNotFoundException {

            File stories = new File("C:\\NTNU\\Programmering 2\\paths\\src\\main\\resources\\Stories.txt");
            Scanner scan = new Scanner(stories);

            //Prints only the first line in the text file
            System.out.println(scan.nextLine());

            //Reads the whole file
            while (scan.hasNextLine()){
              System.out.println(scan.nextLine());
            }

            //Gets the files location and checks to see if the file is a valid .txt file or not
            if (stories.exists()) {
              System.out.println("The story exist");
              System.out.println(stories.getPath());
              System.out.println(stories.getAbsolutePath());
              System.out.println(stories.isFile());
            } else {
              System.out.println("File not found");
            }
    }
}