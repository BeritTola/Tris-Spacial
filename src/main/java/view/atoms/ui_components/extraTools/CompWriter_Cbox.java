package view.atoms.ui_components.extraTools;

import view.atoms.ui_components.widgets.BtnComboBox;
import view.atoms.ui_components.widgets.CompLabel;
import view.atoms.ui_components.widgets.CompTextField;
import view.atoms.utils.style_text.StyleTextBy;
import view.atoms.utils.style_text.StyleTextConfigurations;
import view.pages.sign_up.components.utils.Utils_SignUp;

public class CompWriter_Cbox {

  private BtnComboBox component;

  public CompWriter_Cbox(String[] roles, String title, int width, int height, int posX, int posY, String descriptionTool) {
    component = new BtnComboBox(roles, title, width, height, posX, posY);
    component.setTooltip(new TooltipComp(descriptionTool));
  }

  public BtnComboBox returnComp() {
    return component;
  }
}

