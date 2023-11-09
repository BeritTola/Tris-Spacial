package view.atoms.ui_components.widgets;

import javafx.scene.image.ImageView;

public class CompImageView extends ImageView {

  public CompImageView(String image) {super(image);}
  public CompImageView(String image, int sizeX, int sizeY) {
    super(image);
    setFitWidth(sizeX);
    setFitHeight(sizeY);
  }

  public CompImageView(String image, int sizeX, int sizeY, int posX, int posY) {
    super(image);
    setFitWidth(sizeX);
    setFitHeight(sizeY);
    setTranslateX(posX);
    setTranslateY(posY);
  }
}
