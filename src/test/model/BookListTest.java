package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class BookListTest {

    Book testBook1 = new Book("Overlord", 10);
    Book testBook2 = new Book("The Beginning after the End", 102);
    Book testBook3 = new Book("So I'm a Spider, So What?", 432);
    BookList testBookList = new BookList();

    @BeforeEach
    void runBefore() {
        testBookList.addBook(testBook1);
        testBookList.addBook(testBook2);
    }

    @Test
    void testConstructor() {
        assertEquals(Arrays.asList(testBook1, testBook2),testBookList.getBookList());
    }

    @Test
    void testAddBook() {
        testBookList.addBook(testBook3);
        assertEquals(Arrays.asList(testBook1, testBook2, testBook3),testBookList.getBookList());
    }

    @Test
    void testGetBookListLength() {
        assertEquals(2, testBookList.getBookListLength());
    }

    @Test
    void testRemoveBook() {
        testBookList.removeBook(testBook2);
        assertEquals(Collections.singletonList(testBook1), testBookList.getBookList());
    }

    // test removeBook() when the input book is not in the book list
    @Test
    void testRemoveBookNotPresent() {
        testBookList.removeBook(testBook3);
        assertEquals(Arrays.asList(testBook1, testBook2), testBookList.getBookList());
    }

}