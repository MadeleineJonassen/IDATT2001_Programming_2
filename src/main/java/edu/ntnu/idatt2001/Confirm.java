package edu.ntnu.idatt2001;

import java.util.Scanner;

/**
 * A class that verifies the input from the user
 * and runs the method again if the user has made an error.
 */
public class Confirm {

  private static boolean Testing = true;

  private static final Scanner in = new Scanner(System.in);

  /**
   * A method of which verifies the input from the user, with limitations.
   *
   * @param prompt The input
   * @param exc The output if the input is invalid
   * @param lower A limiter,the lowest allowed value
   * @param higher A limiter,the highest allowed value
   * @return The input from the user
   */
  public static int choiceConfirm(String prompt, String exc, int lower, int higher) {
    Testing = true;
    int choice = 0;
    while (Testing)  {
      try {
        System.out.print("\n" + prompt);
        choice = Integer.parseInt(in.nextLine());
        if (lower <= choice && higher >= choice) {
          Testing = false;
        } else {
          System.out.println(exc);
        }
      } catch (NumberFormatException e) {
        System.out.println("\n ~ Could not understand your input. Try again...");
      }
    }
    return choice;
  }

  /**
   * A method of which verifies the integer-input from the user.
   *
   * @param prompt The input
   * @param exc The output if the input is invalid
   * @return The input from the user
   */
  public static int intConfirm(String prompt, String exc) {
    Testing = true;
    int testingInt = 0;
    while (Testing) {
      try {
        System.out.print(prompt);
        testingInt = Integer.parseInt(in.nextLine());
        Testing = false;
      } catch (NumberFormatException e) {
        System.out.print(exc);
      }
    }
    return testingInt;
  }

  /**
   * A method of which verifies the String-input from the user.
   *
   * @param prompt The input
   * @param exc The output if the input is invalid
   * @return The input from the user
   */
  public static String stringConfirm(String prompt, String exc) {
    Testing = true;
    String testingString = "";
    while (Testing) {
      try {
        System.out.print(prompt);
        testingString = in.nextLine();
        Testing = false;
      } catch (NumberFormatException e) {
        System.out.print(exc);
      }
    }
    return testingString;
  }

}

