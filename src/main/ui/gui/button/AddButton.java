package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

public class AddButton extends Button {

    public AddButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Add");
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createComponent(JComponent parent) {
        customizeButton();
        addToParent(parent);
    }
}