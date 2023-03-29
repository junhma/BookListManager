package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

/**
 * Represents the "Load" button.
 */
public class LoadButton extends Button {

    public LoadButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Load");
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