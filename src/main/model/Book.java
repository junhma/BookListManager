package model;

import org.json.JSONObject;

/**
 * Represents a book. A book is composed of a title and a chapter number.
 */
public class Book {
    private final String title;
    private int chapter;

    // REQUIRES: int >= 0
    // EFFECTS: constructs a new book
    public Book(String title, int chapter) {
        this.title = title;
        this.chapter = chapter;
    }

    // EFFECTS: returns book name
    public String getTitle() {
        return this.title;
    }

    // EFFECTS: returns book chapter
    public int getChapter() {
        return this.chapter;
    }

    // REQUIRES: int >= 0
    // MODIFIES: this
    // EFFECTS: change book chapter if new chapter is larger
    public void changeChapter(int numChapter) {
        if (this.chapter < numChapter) {
            this.chapter = numChapter;
        }
    }

    // EFFECTS: returns the book as a JSON object
    protected JSONObject bookToJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("chapter", this.chapter);
        return json;
    }
}