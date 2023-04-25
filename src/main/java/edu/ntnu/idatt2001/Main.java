package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Players.Player;

import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        Main client = new Main();
        client.menu();
    }

    public void menu() {
      Player player1 = new Player.Builder("Maddy",250,0,100).inventory(Collections.singletonList("Sword")).build();
      System.out.println(player1);
    }
}
