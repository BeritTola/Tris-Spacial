package view.atoms.utils.style_text;

public class StyleTextConfigurations {
  private static final String BLACK = "#2F2E41";
  private static final String SKY_BLUE = "#30BFCD";
  private String chosenOption;

  public StyleTextConfigurations(StyleTextBy option) {
    this.chosenOption = getOptionStyle(String.valueOf(option));
  }

  public String getChosenOption() {
    return chosenOption;
  }

  public String getOptionStyle(String option) {
    switch (option) {
      case "BLACK":
        return BLACK;
      case "SKY_BLUE":
        return SKY_BLUE;
      default:
        return null;
    }
  }
}
