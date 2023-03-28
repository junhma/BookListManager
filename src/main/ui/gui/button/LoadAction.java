package ui.gui.button;

import model.BookList;
import persistence.JsonReader;
import ui.gui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoadAction extends AbstractAction {

    public BookList bookList;
    private final JsonReader jsonReader;
    private static final String JSON_STORE = "./data/testBookListReader.json";

    LoadAction(MainFrame panel) {
        super("Load");
        bookList = panel.bookList;
        jsonReader = new JsonReader(JSON_STORE);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            bookList = jsonReader.read();
            System.out.println("\nLoaded book list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("\nUnable to read from file: " + JSON_STORE);
        }
    }
}