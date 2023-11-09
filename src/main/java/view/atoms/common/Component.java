package view.atoms.common;

import javafx.scene.Node;

public interface Component {
  default Node build() {
    configureComponent();
    return getComponent();
  }

  void configureComponent();

  Node getComponent();
}
