package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


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

}