package model;

import exceptions.NegativeChapterException;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class BookListTest {
    Book testBook0;
    Book testBook1;
    Book testBook2;
    BookList testBookList = new BookList();

    @BeforeEach
    void runBefore() {
        try {
            testBook0 = new Book("Overlord", 10);
            testBook1 = new Book("The Beginning after the End", 102);
            testBook2 = new Book("So I'm a Spider, So What?", 432);
        } catch (NegativeChapterException e) {
            fail("Unexpected NegativeChapterException");
        }

        testBookList.addBook(testBook0);
        testBookList.addBook(testBook1);
    }

    @Test
    void testConstructor() {
        assertEquals(Arrays.asList(testBook0, testBook1),testBookList.getBookList());
    }

    @Test
    void testAddBook() {
        testBookList.addBook(testBook2);
        assertEquals(Arrays.asList(testBook0, testBook1, testBook2),testBookList.getBookList());
    }

    @Test
    void testGetBookListLength() {
        assertEquals(2, testBookList.getBookListLength());
    }

    @Test
    void testRemoveBook() {
        testBookList.removeBook(testBook1);
        assertEquals(Collections.singletonList(testBook0), testBookList.getBookList());
    }

    // test removeBook() when the input book is not in the book list
    @Test
    void testRemoveBookNotPresent() {
        testBookList.removeBook(testBook2);
        assertEquals(Arrays.asList(testBook0, testBook1), testBookList.getBookList());
    }

    @Test
    void testGetBook() {
        assertEquals(testBook0, testBookList.getBook(0));
        assertEquals(testBook1, testBookList.getBook(1));
    }

    @Test
    void testAddByIndex() {
        testBookList.addByIndex(0,testBook2);
        assertEquals(testBook2, testBookList.getBook(0));
    }

    @Test
    void testRemoveByIndex() {
        testBookList.removeByIndex(0);
        assertEquals(testBook1, testBookList.getBook(0));
    }


    @Test
    void testToJson() {
        JSONArray testJsonArray = testBookList.toJson();

        assertEquals(2,testJsonArray.length());

        String testJsonBookTitle0 = testJsonArray.optJSONObject(0).getString("title");
        String testJsonBookTitle1 = testJsonArray.optJSONObject(1).getString("title");

        assertEquals(testBook0.getTitle(),testJsonBookTitle0);
        assertEquals(testBook1.getTitle(),testJsonBookTitle1);

        int testJsonBookChapter0 = testJsonArray.optJSONObject(0).getInt("chapter");
        int testJsonBookChapter1 = testJsonArray.optJSONObject(1).getInt("chapter");
        assertEquals(testBook0.getChapter(),testJsonBookChapter0);
        assertEquals(testBook1.getChapter(),testJsonBookChapter1);
    }

}