package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Book;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


class BookTest {

    @BeforeEach
    void runBefore() {
        //stub
    }

    Book testBook = new Book("Harry Potter 1", 10);
    @Test
    void testConstructor() {
        assertEquals("Harry Potter 1", testBook.getBookName());
        assertEquals(10, testBook.getChapters());
    }

}