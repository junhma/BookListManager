package ui;

import model.Book;
import model.BookList;

import java.util.Scanner;

public class EditBookList {

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: add a book to the book list
    public void addBooksUI(BookList bookList, Scanner in) {
        System.out.println("Do you want to add books? Yes/No");
        String replyAdd = in.nextLine();

        if (replyAdd.equals("Yes")) {
            System.out.println("Enter the name of the book you want to add.");
            String title = in.nextLine();
            System.out.println("Enter the current chapter of the book you want to add.");
            int chapter = Integer.parseInt(in.nextLine());

            Book addedBook = new Book(title, chapter);
            bookList.addBook(addedBook);
        }
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: add a book to the book list
    public void removeBooksUI(BookList bookList, Scanner in) {
        System.out.println("Do you want to remove books? Yes/No");
        String replyRemove = in.nextLine();

        if (replyRemove.equals("Yes")) {
            System.out.println("Choose a book to remove.");
            for (int i = 0; i < bookList.getBookListLength(); i++) {
                System.out.println(i + "" + bookList.getBookList().get(i).getTitle());
            }

            int choice = Integer.parseInt(in.nextLine());

            Book removedBook = bookList.getBookList().get(choice);
            bookList.removeBook(removedBook);
        }
    }

    // REQUIRES: a book list
    // MODIFIES: the book list
    // EFFECTS: see and edit the number of chapters for a given book
    public void changeChaptersUI(BookList bookList, Scanner in) {
        System.out.println("Do you want to change current chapter of a book? Yes/No");
        String replyChangeChapters = in.nextLine();

        if (replyChangeChapters.equals("Yes")) {
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
        }
    }
}