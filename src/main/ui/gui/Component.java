package ui.gui;

import javax.swing.*;

public abstract class Component {

    protected MainFrame panel;
    protected boolean active;
    protected JComponent component;

    public Component(MainFrame panel, JComponent parent) {
        this.panel = panel;
        active = false;
        createComponent(parent);
        addToParent(parent);
    }

    // getters
    public boolean isActive() {
        return active;
    }

    // EFFECTS: sets this button's active field to true
    public void activate() {
        active = true;
    }

    // EFFECTS: sets this button's active field to false
    public void deactivate() {
        active = false;
    }

    // EFFECTS: creates button
    protected abstract void createComponent(JComponent parent);

    // MODIFIES: parent
    // EFFECTS:  adds the given button to the parent component
    public abstract void addToParent(JComponent parent);
}