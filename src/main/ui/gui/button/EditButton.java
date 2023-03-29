package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

public class EditButton extends Button {

    public EditButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Edit");
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createComponent(JComponent parent) {
        customizeButton();
        addToParent(parent);
    }
}