package model;

import org.json.JSONArray;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a book list (a list of books).
 */
public class BookList{

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

    // REQUIRES: a book
    // MODIFIES: this
    // EFFECTS: adds a new book to the list of books
    public void addBook(Book book) {
        this.bookList.add(book);
    }

    // REQUIRES: a book in the book list
    // MODIFIES: this
    // EFFECTS: remove a book from the book list
    public void removeBook(Book book) {
        this.bookList.remove(book);
    }

    // REQUIRES: a integer, index <= the length of book list
    // MODIFIES: this
    // EFFECTS: get a book from the book list
    public Book getBook(int index) {
        return this.bookList.get(index);
    }

    // REQUIRES: an integer index, index <= the length of book list, a book
    // MODIFIES: this
    // EFFECTS: adds a new book to the list of books at the index
    public void addByIndex(int index, Book book) {
        this.bookList.add(index, book);
    }

    // REQUIRES: an integer index, index <= the length of book list
    // MODIFIES: this
    // EFFECTS: remove the book at the index from the book list
    public void removeByIndex(int index) {
        this.bookList.remove(index);
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