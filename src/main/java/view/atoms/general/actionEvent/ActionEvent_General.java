package view.atoms.general.actionEvent;

import javafx.event.ActionEvent;
import view.Main;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionEvent_General {
  public static void closeMainMenu(ActionEvent event) {
    Main.libraryStage.close();
  }

  public static String getCurrentDate() {
    Date currentDate = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return format.format(currentDate);
  }
}
