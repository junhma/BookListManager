package ui;

import model.BookList;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BookList bookList = new BookList();
        EditBookList editBookList = new EditBookList();

        // creates an object of Scanner
        Scanner in = new Scanner(System.in);

        System.out.println("Do you want to add books? Yes/No");
        String replyAdd = in.nextLine();
        if (!replyAdd.equals("Yes") && !replyAdd.equals("No")) {
            System.out.println("Sorry, I can't understand you. The two options are \"Yes\" and \"No\".");
        } else if (replyAdd.equals("Yes")) {
            bookList = editBookList.addBooksUI(bookList, in);
        }

        if (bookList.getBookListLength() != 0) {
            System.out.println(bookList.getBookList().get(0).getTitle());
        }

        // closes the scanner
        in.close();
    }
}