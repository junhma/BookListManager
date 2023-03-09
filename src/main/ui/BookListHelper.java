package ui;

import exceptions.NegativeChapterException;
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
        try {
            Book addedBook = new Book(title, chapter);
            bookList.addBook(addedBook);
        } catch (NegativeChapterException e) {
            System.out.println("Chapter number can't be negative.");
        }
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: add a book to the book list
    protected static void removeBooksHelper(BookList bookList, Scanner input) {
        System.out.println("Choose a book to remove.");
        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.println(i + " " + bookList.getBookList().get(i).getTitle());
        }

        try {
            int choice = Integer.parseInt(input.next());
            Book removedBook = bookList.getBookList().get(choice);
            bookList.removeBook(removedBook);

        } catch (NumberFormatException e) {
            System.out.println("Please input an integer.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please choose one of the above options.");
        }
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: see and edit the number of chapters for a given book
    protected static void changeChaptersHelper(BookList bookList, Scanner input) {

        System.out.println("\nChoose a book.");

        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.println(i + " " + bookList.getBookList().get(i).getTitle());
        }

        try {
            int choice = Integer.parseInt(input.next());

            Book editedBook = bookList.getBookList().get(choice);

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
}