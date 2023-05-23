package edu.ntnu.idatt2001.inputValidation;

/**
 * Validation of integer.
 */
public class IntInput {

  /**
   * Checks the input from the user.
   *
   * @param rawInput the raw input from the user
   * @return the edited input
   */
  public static int result(String rawInput) {
    try {
      String editedString = rawInput.replace(" ", "");
      return Integer.parseInt(editedString);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("The input must be a number");
    }
  }
}
