package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

/**
 * Represents the "Delete" button.
 */
public class DeleteButton extends Button {

    public DeleteButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Delete");
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