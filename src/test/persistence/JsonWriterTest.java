package persistence;

import model.Book;
import model.BookList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonWriterTest {
    Book testBook1 = new Book("Overlord", 10);
    Book testBook2 = new Book("The Beginning after the End", 102);
    Book testBook3 = new Book("So I'm a Spider, So What?", 432);
    BookList testBookList = new BookList();

    String TEST_JSON_STORE = "./data/testBookList.json";
    JsonWriter jsonWriter = new JsonWriter(TEST_JSON_STORE);

    @BeforeEach
    void runBefore() {
        testBookList.addBook(testBook1);
        testBookList.addBook(testBook2);
        testBookList.addBook(testBook3);
    }

    @Test
    void open() {
        try {
            jsonWriter.open();
        } catch (FileNotFoundException e) {
            // stub
        }
    }

    @Test
    void write() {
    }

    @Test
    void close() {
    }

    @Test
    void saveToFile() {
    }
}