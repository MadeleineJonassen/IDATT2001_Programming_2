package edu.ntnu.idatt2001;

import edu.ntnu.idatt2001.Players.Player;
import edu.ntnu.idatt2001.Players.PlayerData;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main client = new Main();
        client.menu();
    }

    public void menu() {
      Player player1 = new Player.Builder("Maddy",250,0,100).inventory(Collections.singletonList("Sword")).build();
      System.out.println(player1);
      System.out.println(PlayerData.playerData());
    }
}
