package model;

import org.json.JSONArray;
import java.util.ArrayList;

/**
 * Represents a book list (a list of books).
 */
public class BookList {

    private final ArrayList<Book> bookList;

    // EFFECTS: constructs a new book list
    public BookList() {
        bookList = new ArrayList<>();
    }

    // EFFECTS: returns the book list
    public ArrayList<Book> getBookList() {
        return this.bookList;
    }

    // EFFECTS: returns the number of books in the book list
    public int getBookListLength() {
        return this.bookList.size();
    }

    // REQUIRES: a book
    // MODIFIES: this
    // EFFECTS: adds a new book to the list of books, log the event
    public void addBook(Book book) {
        this.bookList.add(book);
        EventLog.getInstance().logEvent(new Event("A book is added."));
    }

    // REQUIRES: a book in the book list
    // MODIFIES: this
    // EFFECTS: remove a book from the book list, log the event
    public void removeBook(Book book) {
        this.bookList.remove(book);
        EventLog.getInstance().logEvent(new Event("A book is removed."));
    }

    // REQUIRES: a integer, index <= the length of book list
    // MODIFIES: this
    // EFFECTS: get a book from the book list
    public Book getBook(int index) {
        return this.bookList.get(index);
    }

    // REQUIRES: an integer index, index <= the length of book list, a book
    // MODIFIES: this
    // EFFECTS: adds a new book to the list of books at the index, log the event
    public void addByIndex(int index, Book book) {
        this.bookList.add(index, book);
        EventLog.getInstance().logEvent(new Event("A book is added."));
    }

    // REQUIRES: an integer index, index <= the length of book list
    // MODIFIES: this
    // EFFECTS: remove the book at the index from the book list, log the event
    public void removeByIndex(int index) {
        this.bookList.remove(index);
        EventLog.getInstance().logEvent(new Event("A book is removed."));
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