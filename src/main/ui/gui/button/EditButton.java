package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

/**
 * Represents the "Edit" button.
 */
public class EditButton extends Button {

    public EditButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Edit");
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