package ui.gui.button;

import ui.gui.Component;
import ui.gui.MainFrame;

import javax.swing.*;

public abstract class Button extends Component {

    protected JButton button;

    public Button(MainFrame panel, JComponent parent) {
        super(panel, parent);
    }

    // MODIFIES: this
    // EFFECTS:  customizes the button
    protected JButton customizeButton(JButton button) {
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        return button;
    }

    @Override
    public void addToParent(JComponent parent) {
        parent.add(button);
    }
}