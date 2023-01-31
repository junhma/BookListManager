package model;

public class Book {
    private String bookName;
    private int chapters;

    // EFFECTS: constructs a new book
    public Book(String bookName, int chapters) {
        this.bookName = bookName;
        this.chapters = chapters;
    }

    // EFFECTS: returns book name
    public String getBookName() {
        return bookName;
    }

    // EFFECTS: returns book chapter
    public int getChapters() {
        return chapters;
    }

    // MODIFIES: this
    // EFFECTS: change book chapter
    public void changeChapters(int numChapters) {
        this.chapters = numChapters;
    }
}