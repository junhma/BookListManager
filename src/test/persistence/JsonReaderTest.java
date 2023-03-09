package persistence;

import exceptions.NegativeChapterException;
import model.Book;
import model.BookList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {
    String TEST_JSON_STORE = "./data/testBookListReader.json";
    JsonReader testJsonReader = new JsonReader(TEST_JSON_STORE);
    JsonReader testJsonReaderEmpty = new JsonReader("");
    JSONArray testJsonArray;

    String STRING = "[    {        \"chapter\": 10,        \"title\": \"Overlord\"    },    {        \"chapter\": 102,        \"title\": \"The Beginning after the End\"    },    {        \"chapter\": 432,        \"title\": \"So I'm a Spider, So What?\"    }]";

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

        String testJsonData = null;
        try {
            testJsonData = testJsonReader.readFile(TEST_JSON_STORE);
        } catch (IOException e) {
            fail("Unexpected IOException.");
        }
        testJsonArray = new JSONArray(testJsonData);
    }

    @Test
    void testReadEmpty() {
        try {
            testJsonReaderEmpty.read();
            fail("IOException was not thrown.");
        } catch (IOException e) {
            // successful
        }
    }

    @Test
    void testRead() {
        BookList testReadBookList = new BookList();
        try {
            List<Book> tmpBookList = testJsonReader.read().getBookList();
            for (Book book : tmpBookList) {
                testReadBookList.addBook(book);
            }
        } catch (IOException e) {
            fail("Unexpected IOException.");
        }
        assertEquals(testBookList.getBookList(),testReadBookList.getBookList());
    }

    @Test
    void testReadFileEmpty() {
        try {
            testJsonReader.readFile("");
            fail("IOException was not thrown.");
        } catch (IOException e) {
            // successful
        }
    }

    @Test
    void testReadFile() {
        try {
            assertEquals(STRING, testJsonReader.readFile(TEST_JSON_STORE));
        } catch (IOException e) {
            fail("Unexpected IOException.");
        }

    }

    @Test
    void testParseBookList() {
        BookList testParseBookList = new BookList();
        List<Book> tmpBookList = testJsonReader.parseBookList(testJsonArray).getBookList();
        for (Book book : tmpBookList) {
            testParseBookList.addBook(book);
        }
        assertEquals(testBookList.getBookList(),testParseBookList.getBookList());
    }

    @Test
    void testParseBook() {
        assertEquals(testBook0, testJsonReader.parseBook(testBook0.bookToJson()));
    }

    @Test
    void testParseBookNegativeChapter() {
        String str = "{\"chapter\": -10,\"title\":\"Overlord\"}";
        JSONObject testJsonObject = new JSONObject(str);
        assertNull(testJsonReader.parseBook(testJsonObject));
    }
}