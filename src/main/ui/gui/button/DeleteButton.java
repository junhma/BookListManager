package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

public class DeleteButton extends Button {

    public DeleteButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Delete");
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createComponent(JComponent parent) {
        customizeButton();
        addToParent(parent);
    }
}