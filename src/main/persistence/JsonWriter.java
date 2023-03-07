package persistence;

import model.BookList;

import org.json.JSONArray;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Represents a writer that writes JSON representation of a book list to a file.
 */
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private final String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(destination);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of book list to file
    public void write(BookList bookList) {
        JSONArray json = bookList.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    protected void saveToFile(String json) {
        writer.print(json);
    }
}