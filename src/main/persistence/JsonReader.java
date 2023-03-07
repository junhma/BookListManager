package persistence;

import model.Book;
import model.BookList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Represents a reader that reads a book list from JSON data stored in a file
 * code based on <a href="https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo">...</a>
 */
public class JsonReader {
    private final String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads book list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public BookList read() throws IOException {
        String jsonData = readFile(source);
        JSONArray jsonArray = new JSONArray(jsonData);
        return parseBookList(jsonArray);
    }

    // EFFECTS: reads source file as string and returns it
    protected String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // MODIFIES: bookList
    // EFFECTS: parses books from JSON object and adds them to book list
    protected BookList parseBookList(JSONArray jsonArray) {
        BookList bookList = new BookList();
        for (Object json : jsonArray) {
            Book nextBook = parseBook((JSONObject) json);
            bookList.addBook(nextBook);
        }
        return bookList;
    }

    // EFFECTS: parses a book from a JSON object and returns it
    protected Book parseBook(JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        int chapter = jsonObject.getInt("chapter");
        return new Book(title, chapter);
    }

}