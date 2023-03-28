package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

public class LoadButton extends Button {

    public LoadButton(MainFrame panel, JComponent parent) {
        super(panel, parent);
    }

    // MODIFIES: this
    // EFFECTS:  creates new button and adds to parent
    @Override
    protected void createComponent(JComponent parent) {
        button = new JButton(new LoadAction(panel));
        button = customizeButton(button);
        addToParent(parent);
    }
}