package view.pages.main_menu_example.components.action_event;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import view.Main;
import view.atoms.general.Utils.Utils_General;
import view.pages.main_menu_example.MainMenuPage;
import view.pages.sign_up.SignUp;

public class ActionEvent_MainMenu {
  public static void redirectToMessage(ActionEvent event) {
    Main.libraryStage.setScene(new Scene((Pane) new SignUp().build(), Utils_General.width, Utils_General.height));
  }

  public static void updatePage(ActionEvent event) {
    Main.libraryStage.setScene(new Scene((Pane) new MainMenuPage().build(), Utils_General.width, Utils_General.height));
  }
//Have a good day
}


