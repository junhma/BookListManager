package ui;

import model.Book;
import model.BookList;
import model.Event;
import model.EventLog;
import model.exceptions.NegativeChapterException;
import model.persistence.JsonReader;
import model.persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the book list application.
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
    // EFFECTS: processes user input. when the input is q, close the program and print the event log to the console
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
                EventLog eventLog = EventLog.getInstance();
                for (Event event : eventLog) {
                    System.out.println(event);
                }
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye.");
        input.close();
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
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
    private void processCommand(String command) {
        switch (command) {
            case "a": addBooksHelper(bookList, input);
                break;
            case "r": removeBooksHelper(bookList, input);
                break;
            case "t": changeTitlesHelper(bookList, input);
                break;
            case "c": changeChaptersHelper(bookList, input);
                break;
            case "p": printBooks();
                break;
            case "s": saveBookList();
                break;
            case "l": loadBookList();
                break;
            default: System.out.println("\nSelection not valid.");
                break;
        }
    }

    // EFFECTS: prints all the books in the book list to the console
    private void printBooks() {
        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.print(i + " " + bookList.getBook(i).getTitle() + " ");
            System.out.println("Chapter " + bookList.getBook(i).getChapter());
        }
    }

    // EFFECTS: saves the book list to a file
    private void saveBookList() {
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
    private void loadBookList() {
        try {
            bookList = jsonReader.read();
            System.out.println("\nLoaded book list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("\nUnable to read from file: " + JSON_STORE);
        }
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: see and edit the number of chapters for a given book
    private void changeChaptersHelper(BookList bookList, Scanner input) {

        System.out.println("Choose a book to edit.");

        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.println(i + " " + bookList.getBook(i).getTitle());
        }

        try {
            int choice = Integer.parseInt(input.next());

            Book editedBook = bookList.getBook(choice);

            System.out.println("You are currently at chapter " + editedBook.getChapter());
            System.out.println("Enter the new number of chapters.");

            int numChapter = Integer.parseInt(input.next());
            editedBook.changeChapter(numChapter);
        } catch (NumberFormatException e) {
            System.out.println("Please input an integer.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please choose one of the above options.");
        } catch (NegativeChapterException e) {
            System.out.println("Please input a positive integer.");
        }
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: see and edit the title for a given book
    private void changeTitlesHelper(BookList bookList, Scanner input) {

        System.out.println("Choose a book to edit.");

        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.println(i + " " + bookList.getBook(i).getTitle());
        }

        try {
            int choice = Integer.parseInt(input.next());
            Book editedBook = bookList.getBook(choice);
            System.out.println("Enter the new title.");
            input.nextLine();
            String title = input.nextLine();
            editedBook.changeTitle(title);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please choose one of the above options.");
        }
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: add a book to the book list
    private void removeBooksHelper(BookList bookList, Scanner input) {
        System.out.println("Choose a book to remove.");
        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.println(i + " " + bookList.getBook(i).getTitle());
        }

        try {
            int choice = Integer.parseInt(input.next());
            Book removedBook = bookList.getBook(choice);
            bookList.removeBook(removedBook);

        } catch (NumberFormatException e) {
            System.out.println("Please input an integer.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please choose one of the above options.");
        }
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: add a book to the book list
    private void addBooksHelper(BookList bookList, Scanner input) {
        System.out.println("Enter the name of the book you want to add.");
        input.nextLine();
        String title = input.nextLine();
        System.out.println("Enter the current chapter of the book you want to add.");
        int chapter = Integer.parseInt(input.next());
        try {
            Book addedBook = new Book(title, chapter);
            bookList.addBook(addedBook);
        } catch (NegativeChapterException e) {
            System.out.println("Chapter number can't be negative.");
        }
    }
}