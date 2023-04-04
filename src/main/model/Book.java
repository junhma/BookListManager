package model;

import model.exceptions.NegativeChapterException;
import org.json.JSONObject;

/**
 * Represents a book. A book is composed of a title and a chapter number.
 */
public class Book {
    private String title;
    private int chapter;

    // REQUIRES: title is not null, chapter >= 0
    // EFFECTS: constructs a new book
    public Book(String title, int chapter) throws NegativeChapterException {
        if (chapter < 0) {
            throw new NegativeChapterException();
        }
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

    // MODIFIES: this
    // EFFECTS: change book title
    public void changeTitle(String title) {
        this.title = title;
        EventLog.getInstance().logEvent(new Event("A book title is changed."));
    }

    // REQUIRES: int >= 0
    // MODIFIES: this
    // EFFECTS: change book chapter
    public void changeChapter(int chapter) throws NegativeChapterException {
        if (chapter < 0) {
            throw new NegativeChapterException();
        }
        this.chapter = chapter;
        EventLog.getInstance().logEvent(new Event("A book chapter is changed."));
    }

    // EFFECTS: make 2 books as equal if they have the same titles and chapters
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Book other = (Book) obj;
        if (!this.title.equals(other.title)) {
            return false;
        }

        return this.chapter == other.chapter;
    }

    // EFFECTS: returns the book as a JSON object
    public JSONObject bookToJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("chapter", this.chapter);
        return json;
    }
}