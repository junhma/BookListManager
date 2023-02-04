package ui;

import model.BookList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BookList bookList = new BookList();
        EditBookList editBookList = new EditBookList();

        // creates an object of Scanner
        Scanner in = new Scanner(System.in);

        // add a book
        editBookList.addBooksUI(bookList, in);


        // remove a book
        editBookList.removeBooksUI(bookList, in);


        // change chapter of a book
        editBookList.changeChaptersUI(bookList, in);

        //  show list of books
        for (int i = 0; i < bookList.getBookListLength(); i++) {
            System.out.print(i + " " + bookList.getBookList().get(i).getTitle() + " ");
            System.out.println("chapter " + bookList.getBookList().get(i).getChapter());
        }

        // show number of books
        System.out.println("There are " + bookList.getBookListLength() + " book(s) in the list.");

        // closes the scanner
        in.close();
    }
}