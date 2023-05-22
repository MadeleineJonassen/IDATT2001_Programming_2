package edu.ntnu.idatt2001.inputValidation;

/**
 * The type Int input.
 */
public class IntInput {
  /**
   * Result int.
   *
   * @param rawInput the raw input
   * @return the int
   */
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
