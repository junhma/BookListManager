package ui;

import model.Book;
import model.BookList;

import java.util.Scanner;

public class EditBookList {

    // REQUIRES: a book list
    // MODIFIES: this
    // EFFECTS: add a book to the book list
    public BookList addBooksUI(BookList bookList, Scanner in) {

        System.out.println("Enter the name of the book you want to add.");
        String title = in.nextLine();
        System.out.println("Enter the current chapter of the book you want to add (whole number only).");

        int chapters = 0;
        if (in.hasNextInt()) {
            chapters = in.nextInt();
        } else {
            System.out.println("Please type a whole number.");
        }

        Book newBook = new Book(title, chapters);
        bookList.addBook(newBook);

        return bookList;
    }
}