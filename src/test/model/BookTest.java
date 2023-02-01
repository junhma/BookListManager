package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BookTest {

    Book testBook = new Book("Overlord", 10);

    @BeforeEach
    void runBefore() {
        //stub
    }

    @Test
    void testConstructor() {
        assertEquals("Overlord", testBook.getTitle());
        assertEquals(10, testBook.getChapters());
    }

    @Test
    void testChangeChapters() {
        testBook.changeChapters(5);
        assertEquals(5, testBook.getChapters());
    }

}