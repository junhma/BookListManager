package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

/**
 * Represents the "Save" button.
 */
public class SaveButton extends Button {

    public SaveButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Save");
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