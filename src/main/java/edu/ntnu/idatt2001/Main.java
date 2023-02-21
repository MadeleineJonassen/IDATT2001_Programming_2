package edu.ntnu.idatt2001;

import java.util.Scanner;

public class Main {

    private final Scanner in = new Scanner(System.in);
    private static final Player info = new Player();

    public static void main(String[] args) throws IllegalAccessException {
        Main client = new Main();
        client.playerData();
        client.menu();
    }

    public void playerData() throws IllegalAccessException {
        info.newPlayer("Emil super rumpe",100,100, 100, null);
    }

    public void menu(){
        while (true){
            String returnNewNameStatus;
            System.out.println("Hello, Traveler! What is your name? ");
            String name = Confirm.stringConfirm("Your name: ", "\n ~ Sorry, I didn't quite catch that." );
            try {
                returnNewNameStatus = info.getName(name);
            } catch (Exception err) {
                err.printStackTrace();
                returnNewNameStatus = "Something happened to the application, please try again. ";
            }

            System.out.println("");
            System.out.println("Hello, " + Player.getName(name));
            System.out.println("Your health is " + Player.getHealth() + "hp");
            System.out.println("You have " + Player.getGold() + " gold");

            System.out.println(Player.toString());

            break;
        }
    }

}