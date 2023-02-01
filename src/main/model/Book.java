package model;

public class Book {
    private final String title;
    private int chapters;

    // EFFECTS: constructs a new book
    public Book(String title, int chapters) {
        this.title = title;
        this.chapters = chapters;
    }

    // EFFECTS: returns book name
    public String getTitle() {
        return this.title;
    }

    // EFFECTS: returns book chapter
    public int getChapters() {
        return this.chapters;
    }

    // MODIFIES: this
    // EFFECTS: change book chapter
    public void changeChapters(int numChapters) {
        this.chapters = numChapters;
    }
}