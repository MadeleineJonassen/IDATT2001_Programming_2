package edu.ntnu.idatt2001.InputValidation;

public class IntInput {
  public static int result(String rawInput){
    try {
      String editedString = rawInput.replace(" ", "");
      int parsed = Integer.parseInt(rawInput);
      return parsed;
    } catch (NumberFormatException e){
      throw new IllegalArgumentException("The input must be a number");
    }
  }
}
