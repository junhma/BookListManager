package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

public class SaveButton extends Button {

    public SaveButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Save");
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createComponent(JComponent parent) {
        customizeButton();
        addToParent(parent);
    }
}