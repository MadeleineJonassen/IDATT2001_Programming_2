package edu.ntnu.idatt2001;

import java.util.Scanner;

public class Main {

    private final Scanner in = new Scanner(System.in);
    private Player player = new Player("Arthur",10,0,0);

    public static void main(String[] args) throws IllegalAccessException {
        Main client = new Main();
        client.menu();
    }
    
    public void menu(){
        while (true){
            String returnNewNameStatus;
            System.out.println("");
            System.out.println("Hello, traveler! What is your name? ");
            String name = Confirm.stringConfirm("Your name: ", "\n ~ Sorry, I didn't quite catch that." );
            try {
                returnNewNameStatus = player.getName(name);
            } catch (Exception err) {
                err.printStackTrace();
                returnNewNameStatus = "Something happened to the application, please try again. ";
            }

            System.out.println("\nHello, " + player.getName(name));
            System.out.println(player.toString());
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("\t# Something happened! #\n");

            break;
        }
    }

}