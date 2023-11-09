package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.atoms.general.Utils.Utils_General;
import view.pages.main_menu_example.MainMenuPage;


public class Main extends Application {
  public static Stage libraryStage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage mainMenu) throws Exception {
    libraryStage = mainMenu;

    MainMenuPage menuLayout = new MainMenuPage();
    menuLayout.build();

    Scene primaryScene = new Scene((Pane) menuLayout.getComponent(), Utils_General.width, Utils_General.height);

    libraryStage.setTitle("Library");
    libraryStage.setScene(primaryScene);
    libraryStage.setResizable(false);
    libraryStage.show();
  }
}
