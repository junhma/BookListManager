package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

public class EditButton extends Button {

    public EditButton(MainFrame panel, JComponent parent) {
        super(panel, parent);
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createComponent(JComponent parent) {
        button = new JButton(new EditAction(panel));
        button = customizeButton((JButton) button);
        addToParent(parent);
    }
}