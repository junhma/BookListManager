package ui;

import exceptions.NegativeChapterException;
import model.Book;
import model.BookList;

import javax.swing.*;
import java.awt.*;

public class BookTable extends JPanel {

    private final Font font = new Font("SansSerif", Font.PLAIN, 12);
    private BookList bookList;
    private BookTableModel model;
    private JTable jTable;

    public BookTable() {
        initializeFields();
        jTable.setFont(font);
    }

    private void initializeFields() {
        bookList = new BookList();
        model = new BookTableModel();
        jTable = new JTable(model);

        //// test
        try {
            Book testBook0 = new Book("Overlord", 10);
            Book testBook1 = new Book("The Beginning after the End", 102);
            Book testBook2 = new Book("So I'm a Spider, So What?", 432);

            model.addBook(testBook0);
            model.addBook(testBook1);
            model.addBook(testBook2);
        } catch (NegativeChapterException e) {
        }
    }
}