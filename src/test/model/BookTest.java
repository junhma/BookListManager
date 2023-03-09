package model;

import exceptions.NegativeChapterException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BookTest {

    Book testBook;

    @BeforeEach
    void runBefore() {
        try {
            testBook = new Book("Overlord", 10);
        } catch (NegativeChapterException e) {
            fail("Unexpected NegativeChapterException");
        }
    }

    @Test
    void testConstructor() {
        assertEquals("Overlord", testBook.getTitle());
        assertEquals(10, testBook.getChapter());
    }

    @Test
    void testConstructorNegative() {
        try {
            testBook = new Book("Overlord", -10);
            fail("Expect NegativeChapterException");
        } catch (NegativeChapterException e) {
            // success
        }
    }

    @Test
    void testChangeChapter() {
        try {
            testBook.changeChapter(15);
        } catch (NegativeChapterException e) {
            fail("Unexpected NegativeChapterException");
        }
        assertEquals(15, testBook.getChapter());
    }

    @Test
    void testChangeChapterNegative() {
        try {
            testBook.changeChapter(-15);
            fail("Expect NegativeChapterException");
        } catch (NegativeChapterException e) {
            // success
        }
    }

    @Test
    void testBookToJson() {
        JSONObject testToJson = testBook.bookToJson();
        String title = testBook.getTitle();
        int chapter = testBook.getChapter();
        String jsonTitle = testToJson.getString("title");
        int jsonChapter = testToJson.getInt("chapter");
        assertEquals(title, jsonTitle);
        assertEquals(chapter, jsonChapter);
    }
    
    @Test
    void testEquals(){
        Book testBook2 = null;
        try {
            testBook2 = new Book("Overlord", 10);
        } catch (NegativeChapterException e) {
            fail("Unexpected NegativeChapterException");
        }
        assertEquals(testBook, testBook2);
    }

    @Test
    void testNotEqualNull(){
        assertNotEquals(testBook, null);
    }

    @Test
    void testNotEqualTitle(){
        Book testBook2 = null;
        try {
            testBook2 = new Book("Over", 10);
        } catch (NegativeChapterException e) {
            fail("Unexpected NegativeChapterException");
        }
        assertNotEquals(testBook, testBook2);
    }

    @Test
    void testNotEqualChapter(){
        Book testBook2 = null;
        try {
            testBook2 = new Book("Overlord", 11);
        } catch (NegativeChapterException e) {
            fail("Unexpected NegativeChapterException");
        }
        assertNotEquals(testBook, testBook2);
    }

    @Test
    void testNotEqualClass(){
        String testBook2 = "Overlord";
        assertNotEquals(testBook, testBook2);
    }

}