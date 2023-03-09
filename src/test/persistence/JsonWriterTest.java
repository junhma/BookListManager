package persistence;

import exceptions.NegativeChapterException;
import model.Book;
import model.BookList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest {
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
        testBookList.addBook(testBook2);
    }

    @Test
    void testOpenEmpty() {
        JsonWriter testJsonWriterEmpty = new JsonWriter("");
        try {
            testJsonWriterEmpty.open();
            testJsonWriterEmpty.close();
            fail("FileNotFoundException was not thrown.");
        } catch (FileNotFoundException e) {
            // successful
        }

    }

    @Test
    void test() {
        String TEST_JSON_STORE = "./data/testBookListWriter.json";
        BookList testReadBookList = new BookList();
        try {
            JsonWriter testJsonWriter = new JsonWriter(TEST_JSON_STORE);
            testJsonWriter.open();
            testJsonWriter.write(testBookList);
            testJsonWriter.close();

            JsonReader testJsonReader = new JsonReader(TEST_JSON_STORE);
            List<Book> tmpBookList = testJsonReader.read().getBookList();
            for (Book book : tmpBookList) {
                testReadBookList.addBook(book);
            }
        } catch (FileNotFoundException e) {
            fail("Unexpected FileNotFoundException.");
        } catch (IOException e) {
            fail("Unexpected IOException.");
        }
        assertEquals(testBookList.getBookList(),testReadBookList.getBookList());
    }

}