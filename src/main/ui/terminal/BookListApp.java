package ui.terminal;

import model.BookList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static ui.terminal.BookListHelper.*;

/**
 * Represents the book list application.
 * code based on <a href="https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo">...</a>
 */
public class BookListApp {

    private static final String JSON_STORE = "./data/bookList.json";
    private Scanner input;
    private BookList bookList;
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;

    // EFFECTS: constructs book list and runs application
    public BookListApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        bookList = new BookList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runBookList();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    protected void runBookList() {
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
        System.out.println("\nGoodbye.");
        input.close();
    }

    // EFFECTS: displays menu of options to user
    protected void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add books");
        System.out.println("\tr -> remove books");
        System.out.println("\tt -> change book titles");
        System.out.println("\tc -> change book chapters");
        System.out.println("\tp -> print book list");
        System.out.println("\ts -> save book list to a file");
        System.out.println("\tl -> load book list from a file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    protected void processCommand(String command) {
        switch (command) {
            case "a":
                addBooksHelper(bookList, input);
                break;
            case "r":
                removeBooksHelper(bookList, input);
                break;
            case "t":
                changeTitlesHelper(bookList, input);
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
                System.out.println("\nSelection not valid.");
                break;
        }
    }

    // EFFECTS: prints all the books in the book list to the console
    protected void printBooks() {
        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.print(i + " " + bookList.getBook(i).getTitle() + " ");
            System.out.println("Chapter " + bookList.getBook(i).getChapter());
        }
    }

    // EFFECTS: saves the book list to a file
    protected void saveBookList() {
        try {
            jsonWriter.open();
            jsonWriter.write(bookList);
            jsonWriter.close();
            System.out.println("\nSaved book list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("\nUnable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads the book list from the file
    protected void loadBookList() {
        try {
            bookList = jsonReader.read();
            System.out.println("\nLoaded book list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("\nUnable to read from file: " + JSON_STORE);
        }
    }
}