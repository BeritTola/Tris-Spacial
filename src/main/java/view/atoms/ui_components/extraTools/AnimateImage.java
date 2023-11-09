package view.atoms.ui_components.extraTools;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimateImage {
  public AnimateImage(String mode, ImageView img, int from, int to, int ms) {
    TranslateTransition animateMenu = new TranslateTransition();
    animateMenu.setDuration(Duration.millis(ms));
    animateMenu.setNode(img);
    if (mode.equals("V")) {
      animateMenu.setFromY(from);
      animateMenu.setToY(to);
    } else {
      animateMenu.setFromX(from);
      animateMenu.setToX(to);
    }
    animateMenu.setAutoReverse(true);
    animateMenu.setCycleCount(TranslateTransition.INDEFINITE);
    animateMenu.play();

  }
}
