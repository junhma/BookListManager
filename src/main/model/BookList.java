package model;

import java.util.List;
import java.util.ArrayList;

public class BookList {

    private List<Book> bookList = new ArrayList<>();

    // EFFECTS: constructs a new book list
    public BookList() {
    }

    // EFFECTS: returns the book list
    public List<Book> getBookList() {
        return this.bookList;
    }

    // EFFECTS: returns the number of books in the book list
    public int getBookListLength() {
        return this.bookList.size();
    }

    // REQUIRES: chapters > 0
    // MODIFIES: this
    // EFFECTS: adds a new book to the list of books
    public void addBook(String bookName, int chapters) {
        Book newBook = new Book(bookName, chapters);
        bookList.add(newBook);
    }

    // REQUIRES: chapters > 0
    // MODIFIES: this
    // EFFECTS: remove a book from the list of books
    public void removeBook(String bookName, int chapters) {
        Book newBook = new Book(bookName, chapters);
        bookList.remove(newBook);
    }
}