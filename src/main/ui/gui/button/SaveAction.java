package ui.gui.button;

import model.BookList;
import ui.gui.MainFrame;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class SaveAction extends AbstractAction {

    public BookList bookList;
    private final JsonWriter jsonWriter;
    private static final String JSON_STORE = "./data/test_bookList.json";

    SaveAction(MainFrame panel) {
        super("Save");
        bookList = panel.bookList;
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            jsonWriter.open();
            jsonWriter.write(bookList);
            jsonWriter.close();
            System.out.println("\nSaved book list to " + JSON_STORE); //change
        } catch (FileNotFoundException e) {
            System.out.println("\nUnable to write to file: " + JSON_STORE);
        }
    }
}