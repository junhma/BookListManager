package ui;

import model.Book;
import model.BookList;

import java.util.Scanner;

public class BookListHelper {

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: add a book to the book list
    protected static void addBooksHelper(BookList bookList, Scanner in) {
        String replyContinue;
        do {
            System.out.println("Enter the name of the book you want to add.");
            String title = in.nextLine();
            System.out.println("Enter the current chapter of the book you want to add.");
            int chapter = Integer.parseInt(in.nextLine());

            Book addedBook = new Book(title, chapter);
            bookList.addBook(addedBook);

            System.out.println("Continue? Yes/No");
            replyContinue = in.nextLine();
        } while (replyContinue.equals("Yes"));
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: add a book to the book list
    protected static void removeBooksHelper(BookList bookList, Scanner in) {
        String replyContinue;
        do {
            System.out.println("Choose a book to remove.");
            for (int i = 0; i < bookList.getBookListLength(); i++) {
                System.out.println(i + " " + bookList.getBookList().get(i).getTitle());
            }
            int choice = Integer.parseInt(in.nextLine());
            Book removedBook = bookList.getBookList().get(choice);
            bookList.removeBook(removedBook);

            System.out.println("Continue? Yes/No");
            replyContinue = in.nextLine();
        } while (replyContinue.equals("Yes"));
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: see and edit the number of chapters for a given book
    protected static void changeChaptersHelper(BookList bookList, Scanner in) {
        String replyContinue;
        do {
            System.out.println("Choose a book.");
            for (int i = 0; i < bookList.getBookListLength(); i++) {
                System.out.println(i + " " + bookList.getBookList().get(i).getTitle());
            }

            int choice = Integer.parseInt(in.nextLine());

            Book editedBook = bookList.getBookList().get(choice);
            System.out.println("You are currently at chapter " + editedBook.getChapter());

            System.out.println("Enter the new number of chapters.");
            int numChapter = Integer.parseInt(in.nextLine());
            editedBook.changeChapter(numChapter);

            System.out.println("Continue? Yes/No");
            replyContinue = in.nextLine();
        } while (replyContinue.equals("Yes"));
    }
}