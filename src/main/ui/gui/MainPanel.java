package ui.gui;

import exceptions.NegativeChapterException;
import model.Book;
import model.BookList;
import ui.gui.BookTableModel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    //private static final String JSON_STORE = "./data/bookList.json";

    private final Font font = new Font("SansSerif", Font.PLAIN, 12);
    private BookList bookList;
    private BookTableModel model;
    private JTable jTable;

    public MainPanel() {
        super("Book List");
        initializeFields();
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS:  instantiates bookList
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

    // MODIFIES: this
    // EFFECTS:  draws the JFrame window where this DrawingEditor will operate, and populates the tools to be used
    //           to manipulate this drawing
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        addBookList();
        jTable.setFont(font);
    }

    // MODIFIES: this
    // EFFECTS:  declares and instantiates a Drawing (newDrawing), and adds it to drawings
    private void addBookList() {
        add(jTable, BorderLayout.CENTER);
        validate();
    }
}