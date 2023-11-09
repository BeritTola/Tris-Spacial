package view.atoms.ui_components.extraTools;

import view.atoms.ui_components.widgets.CompTextField;

public class CompWriter_Tf {

  private CompTextField component;

  public CompWriter_Tf(String title, int width, int height, int posX, int posY, String design, String descriptionTool) {
    component = new CompTextField(title, width, height, posX, posY, design);
    CompTextField.clearOnFirstClick(component);
    component.setTooltip(new TooltipComp(descriptionTool));
  }

  public CompTextField returnComp() {
    return component;
  }
}
