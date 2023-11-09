package BackEnd.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
  public static boolean validNameRegister(String name){
    //Validation User
    return false;
  }

  public static boolean validCIRegister(int num){
    //Valid CI Register
    return false;
  }

  public static boolean isInt(String texto) {
    try {
      Integer.parseInt(texto);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static boolean hasMoreThanSixNumbers(String texto, String name) {
    int contadorNumeros = 0;

    for (int i = 0; i < texto.length(); i++) {
      char caracter = texto.charAt(i);
      if (Character.isDigit(caracter)) {
        contadorNumeros++;
      }
    }
    return contadorNumeros > 6;
  }

  public static boolean validatePassword(String password) {
    int specialCharCount = countSpecialCharacters(password);
    if (specialCharCount < 2) {
      return false;
    }

    if (!containsUpperCaseLetter(password)) {
      return false;
    }

    if (!containsNumber(password)) {
      return false;
    }
    return true;
  }

  private static int countSpecialCharacters(String str) {
    Pattern pattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]");
    Matcher matcher = pattern.matcher(str);
    int count = 0;
    while (matcher.find()) {
      count++;
    }
    return count;
  }

  private static boolean containsUpperCaseLetter(String str) {
    for (char c : str.toCharArray()) {
      if (Character.isUpperCase(c)) {
        return true;
      }
    }
    return false;
  }

  private static boolean containsNumber(String str) {
    for (char c : str.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }

  public static boolean isValidEmailFormat(String email) {
    String regex = "^[a-zA-Z]{5,}@gmail\\.com$";
    return email.matches(regex);
  }

  public static boolean validateNameSize(String password) {
    return password.length() > 5;
  }
}
