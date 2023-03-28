package ui.gui;

import exceptions.NegativeChapterException;
import model.Book;
import model.BookList;

import javax.swing.*;

public class BookTable extends Component {

    protected JTable table;
    public MainFrame.Toggle editable;
    public BookList bookList;

    public BookTable(MainFrame panel, JComponent parent) {
        super(panel, parent);
    }

    // MODIFIES: this
    // EFFECTS:  customizes the table
    protected JTable customizeTable(JTable table) {
        return table;
    }

    @Override
    // EFFECTS: creates table
    protected void createComponent(JComponent parent) {
        BookTableModel model = new BookTableModel();
        addBooks(model);
        table = new JTable(model);
        table = customizeTable(table);
        addToParent(parent);
        editable = model.editable;
        bookList = model.bookList;
    }

    @Override
    // MODIFIES: parent
    // EFFECTS:  adds the given button to the parent component
    public void addToParent(JComponent parent) {
        JScrollPane tableContainer = new JScrollPane(table);
        parent.add(tableContainer);
    }

    private void addBooks(BookTableModel model) {
        try {
            Book testBook0 = new Book("Overlord", 10);
            Book testBook1 = new Book("The Beginning after the End", 102);
            Book testBook2 = new Book("So I'm a Spider, So What?", 432);

            model.addBook(testBook0);
            model.addBook(testBook1);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook0);
            model.addBook(testBook1);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook0);
            model.addBook(testBook1);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook0);
            model.addBook(testBook1);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
            model.addBook(testBook2);
        } catch (NegativeChapterException e) {
        }
    }
}