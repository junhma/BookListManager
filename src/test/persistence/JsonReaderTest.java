package persistence;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonReaderTest {
    String TEST_JSON_STORE = "./data/testBookList.json";
    JsonReader jsonReader = new JsonReader(TEST_JSON_STORE);

    @Test
    void read() throws IOException {
        jsonReader.read();
    }

    @Test
    void readFile() {
    }

    @Test
    void parseBookList() {
    }

    @Test
    void parseBook() {
    }
}