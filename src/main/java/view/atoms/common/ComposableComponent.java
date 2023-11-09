package view.atoms.common;

import javafx.scene.Node;

public interface ComposableComponent extends Component{
  @Override
  default Node build() {
    compose();
    return Component.super.build();
  }

  void compose();
}
