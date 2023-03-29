package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

public class LoadButton extends Button {

    public LoadButton(MainFrame frame, JComponent parent) {
        super(frame, parent, "Load");
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createComponent(JComponent parent) {
        customizeButton();
        addToParent(parent);
    }
}