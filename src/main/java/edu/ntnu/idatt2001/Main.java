package edu.ntnu.idatt2001;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private final Scanner in = new Scanner(System.in);
    private Player player = new Player("Arthur", 10, 0, 0);

    public static void main(String[] args) throws IllegalAccessException {
        Main client = new Main();
        client.menu();
    }

    public void menu() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\NTNU\\Programmering 2\\paths\\src\\main\\resources\\Stories.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}