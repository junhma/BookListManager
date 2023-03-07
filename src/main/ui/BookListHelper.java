package ui;

import model.Book;
import model.BookList;

import java.util.Scanner;

/**
 * Helpers for book list application.
 */
public class BookListHelper {

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: add a book to the book list
    protected static void addBooksHelper(BookList bookList, Scanner input) {
        System.out.println("Enter the name of the book you want to add.");
        input.nextLine();
        String title = input.nextLine();
        System.out.println("Enter the current chapter of the book you want to add.");
        int chapter = Integer.parseInt(input.next());
        Book addedBook = new Book(title, chapter);
        bookList.addBook(addedBook);
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: add a book to the book list
    protected static void removeBooksHelper(BookList bookList, Scanner input) {
        System.out.println("Choose a book to remove.");
        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.println(i + " " + bookList.getBookList().get(i).getTitle());
        }
        int choice = Integer.parseInt(input.next());
        Book removedBook = bookList.getBookList().get(choice);
        bookList.removeBook(removedBook);
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: see and edit the number of chapters for a given book
    protected static void changeChaptersHelper(BookList bookList, Scanner input) {
        System.out.println("\nChoose a book.");
        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.println(i + " " + bookList.getBookList().get(i).getTitle());
        }
        int choice = Integer.parseInt(input.next());
        Book editedBook = bookList.getBookList().get(choice);
        System.out.println("You are currently at chapter " + editedBook.getChapter());
        System.out.println("Enter the new number of chapters.");
        int numChapter = Integer.parseInt(input.next());
        editedBook.changeChapter(numChapter);
    }
}