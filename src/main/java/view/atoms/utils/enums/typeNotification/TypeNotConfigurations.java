package view.atoms.utils.enums.typeNotification;

public class TypeNotConfigurations {
  private static final String SUCCESS = "plugins/success-Library.png";
  private static final String FAILURE = "plugins/failure-Library.png";
  private String chosenOption;

  public TypeNotConfigurations(TypeNotBy option) {
    this.chosenOption = getOptionStyle(String.valueOf(option));
  }

  public String getChosenOption() {
    return chosenOption;
  }

  public String getOptionStyle(String option) {
    switch (option) {
      case "SUCCESS":
        return SUCCESS;
      case "FAILURE":
        return FAILURE;
      default:
        return null;
    }
  }
}
