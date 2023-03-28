package ui.gui;

import exceptions.NegativeChapterException;
import model.Book;
import model.BookList;

import javax.swing.table.AbstractTableModel;

import static java.lang.Boolean.FALSE;

/**
 * Represents the model for Book Table
 */
public class BookTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Name", "Chapter"};
    public BookList bookList;
    public MainFrame.Toggle editable;

    public BookTableModel() {
        bookList = new BookList();
        editable = new MainFrame.Toggle(FALSE);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return bookList.getBookListLength();
    }

    //    @Override
//    public String getColumnName(int column)
//    {
//        return columnNames[column];
//    }

//    @Override
//    public Class getColumnClass(int column)
//    {
//        switch (column)
//        {
//            case 2: return Date.class;
//            default: return String.class;
//        }
//    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return editable.getVal(); //request current value
    }

    @Override
    public Object getValueAt(int row, int column) {
        Book book = getBook(row);

        switch (column) {
            case 0: return book.getTitle();
            case 1: return book.getChapter();
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        Book book = getBook(row);

        switch (column) {
            case 0: book.changeTitle((String)value); break;
            case 1:
                try {
                    book.changeChapter((int) value);
                } catch (NegativeChapterException e) {
                    // nothing
                }
                break;
        }

        fireTableCellUpdated(row, column);
    }

    public Book getBook(int row) {
        return bookList.getBook(row);
    }

    public void addBook(Book book) {
        insertBook(getRowCount(), book);
    }

    public void insertBook(int row, Book book) {
        bookList.addByIndex(row, book);
        fireTableRowsInserted(row, row);
    }

    public void removeBook(int row) {
        bookList.removeByIndex(row);
        fireTableRowsDeleted(row, row);
    }
}