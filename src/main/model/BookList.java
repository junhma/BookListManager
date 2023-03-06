package model;

import org.json.JSONArray;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a book list (a list of books).
 */
public class BookList {

    private final List<Book> bookList;

    // EFFECTS: constructs a new book list
    public BookList() {
        bookList = new ArrayList<>();
    }

    // EFFECTS: returns the book list
    public List<Book> getBookList() {
        return this.bookList;
    }

    // EFFECTS: returns the number of books in the book list
    public int getBookListLength() {
        return this.bookList.size();
    }

    // MODIFIES: this
    // EFFECTS: adds a new book to the list of books
    public void addBook(Book newBook) {
        this.bookList.add(newBook);
    }

    // REQUIRES: a book in the book list
    // MODIFIES: this
    // EFFECTS: remove a book from the book list
    public void removeBook(Book oldBook) {
        this.bookList.remove(oldBook);
    }

    // EFFECTS: returns the book list as a JSON array
    public JSONArray toJson() {
        JSONArray jsonArray = new JSONArray();
        for (Book book : bookList) {
            jsonArray.put(book.bookToJson());
        }
        return jsonArray;
    }
}