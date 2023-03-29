package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

/**
 * Represents the "Add" button.
 */
public class AddButton extends Button {

    public AddButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Add");
    }

    // REQUIRES: a parent component
    // MODIFIES: the parent component
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createComponent(JComponent parent) {
        customizeButton();
        addToParent(parent);
    }
}