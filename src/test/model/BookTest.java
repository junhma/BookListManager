package model;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BookTest {

    Book testBook = new Book("Overlord", 10);

    @Test
    void testConstructor() {
        assertEquals("Overlord", testBook.getTitle());
        assertEquals(10, testBook.getChapter());
    }

    @Test
    void testChangeChapterLower() {
        testBook.changeChapter(5);
        assertEquals(10, testBook.getChapter());
    }

    @Test
    void testChangeChapter() {
        testBook.changeChapter(15);
        assertEquals(15, testBook.getChapter());
    }

    @Test
    void testBookToJson() {
        JSONObject testJsonObject = testBook.bookToJson();
        String title = testBook.getTitle();
        int chapter = testBook.getChapter();
        String jsonTitle = testJsonObject.getString("title");
        int jsonChapter = testJsonObject.getInt("chapter");
        assertEquals(title, jsonTitle);
        assertEquals(chapter, jsonChapter);
    }

}