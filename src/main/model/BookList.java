package model;

import java.util.List;
import java.util.ArrayList;

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
    public boolean removeBook(Book oldBook) {
        return this.bookList.remove(oldBook);
    }
}