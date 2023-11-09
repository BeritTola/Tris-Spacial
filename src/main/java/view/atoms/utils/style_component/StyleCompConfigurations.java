package view.atoms.utils.style_component;

public class StyleCompConfigurations {
  private static final String OPTION_1 = "-fx-font-family: 'Poppins'; -fx-font-size: 30px; -fx-background-color: #E9F4F6; -fx-border-color: #30BFCD; -fx-border-width: 3px; -fx-background-radius: 10em; -fx-border-radius: 10em;";
  private static final String OPTION_2 = "-fx-font-family: 'Poppins'; -fx-font-size: 30px; -fx-background-color: #30BFCD; -fx-text-fill: #FFFFFF; -fx-background-radius: 10em; -fx-border-radius: 10em;";
  private String chosenOption;

  public StyleCompConfigurations(StyleCompBy option) {
    this.chosenOption = getOptionStyle(String.valueOf(option));
  }

  public String getChosenOption() {
    return chosenOption;
  }

  public String getOptionStyle(String option) {
    switch (option) {
      case "OPTION_1":
        return OPTION_1;
      case "OPTION_2":
        return OPTION_2;
      default:
        return null;
    }
  }
}
