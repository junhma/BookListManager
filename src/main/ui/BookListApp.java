package ui;

import model.BookList;
import persistence.JsonReader;
import persistence.JsonWriter;
import static ui.BookListHelper.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BookListApp {

    private static final String JSON_STORE = "./data/book-list.json";
    private Scanner input;
    private BookList bookList;
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;

    // EFFECTS: constructs workroom and runs application
    public BookListApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        bookList = new BookList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runBookList();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runBookList() {
        boolean keepGoing = true;
        String command;
        input = new Scanner(System.in);

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
        input.close();
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add books");
        System.out.println("\tr -> remove books");
        System.out.println("\tc -> change book chapters");
        System.out.println("\tp -> print book list");
        System.out.println("\ts -> save book list to a file");
        System.out.println("\tl -> load book list from a file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        switch (command) {
            case "a":
                addBooksHelper(bookList, input);
                break;
            case "r":
                removeBooksHelper(bookList, input);
                break;
            case "c":
                changeChaptersHelper(bookList, input);
                break;
            case "p":
                printBooks();
                break;
            case "s":
                saveBookList();
                break;
            case "l":
                loadBookList();
                break;
            default:
                System.out.println("Selection not valid...");
                break;
        }
    }

    // EFFECTS: prints all the thingies in workroom to the console
    private void printBooks() {
        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.print(i + " " + bookList.getBookList().get(i).getTitle() + " ");
            System.out.println("chapter " + bookList.getBookList().get(i).getChapter());
        }
    }

    // EFFECTS: saves the workroom to file
    private void saveBookList() {
        try {
            jsonWriter.open();
            jsonWriter.write(bookList);
            jsonWriter.close();
            System.out.println("Saved book list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadBookList() {
        try {
            bookList = jsonReader.read();
            System.out.println("Loaded book list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}