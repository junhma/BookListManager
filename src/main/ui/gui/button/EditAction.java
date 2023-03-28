package ui.gui.button;

import ui.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditAction extends AbstractAction {

    public MainFrame.Toggle editable;

    EditAction(MainFrame panel) {
        super("Edit");
        editable = panel.editable;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        editable.toggle();
    }
}