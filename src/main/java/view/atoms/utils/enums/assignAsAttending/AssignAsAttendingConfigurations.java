package view.atoms.utils.enums.assignAsAttending;

public class AssignAsAttendingConfigurations {
  private static final String ON = "plugins/assignAsAttendingBlue-Library.png";
  private static final String OFF = "plugins/assignAsAttending-Library.png";
  private String chosenOption;

  public AssignAsAttendingConfigurations(AssignAsAttendingBy option) {
    this.chosenOption = getOptionStyle(String.valueOf(option));
  }

  public String getChosenOption() {
    return chosenOption;
  }

  public String getOptionStyle(String option) {
    switch (option) {
      case "ON":
        return ON;
      case "OFF":
        return OFF;
      default:
        return null;
    }
  }
}
