package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;

/**
 * An abstract class for buttons.
 */
public abstract class Button extends JButton {

    protected MainFrame frame;

    public Button(MainFrame frame, JComponent parent, String name) {
        super(name);
        this.frame = frame;
        createComponent(parent);
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS:  customizes the button
    protected void customizeButton() {
        this.setBorderPainted(true);
        this.setFocusPainted(true);
        this.setContentAreaFilled(true);
    }

    protected abstract void createComponent(JComponent parent);

    // REQUIRES: a parent component
    // MODIFIES: the parent component
    // EFFECTS: creates button
    public void addToParent(JComponent parent) {
        parent.add(this);
    }
}