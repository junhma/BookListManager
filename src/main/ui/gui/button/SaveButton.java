package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

public class SaveButton extends Button {

    public SaveButton(MainFrame panel, JComponent parent) {
        super(panel, parent);
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createComponent(JComponent parent) {
        button = new JButton(new SaveAction(panel));
        button = customizeButton(button);
        addToParent(parent);
    }
}