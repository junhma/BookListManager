package ui.gui;

import exceptions.NegativeChapterException;
import model.Book;
import model.BookList;
import static ui.gui.MainFrame.infoBox;

import javax.swing.table.AbstractTableModel;

/**
 * Represents the model for Book Table
 */
public class BookTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Name", "Chapter"};
    private final BookList bookList;
    private Boolean editable;

    public BookTableModel(BookList bookList) {
        this.bookList = bookList;
        editable = false;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return bookList.getBookListLength();
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
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Book book = bookList.getBook(rowIndex);
        if (0 == columnIndex) {
            book.changeTitle((String) value);
        } else if (1 == columnIndex) {
            try {
                int chapter = Integer.parseInt((String) value);
                book.changeChapter(chapter);
            } catch (Exception e) {
                infoBox("Invalid input. Chapter numbers must be a positive integer.");
            }
        }
    }

    public Book getBook(int row) {
        return bookList.getBook(row);
    }

    public void newRow() {
        Book book = null;
        try {
            book = new Book("", 0);
        } catch (NegativeChapterException e) {
            infoBox("Invalid input. Chapter numbers must be a positive integer.");
        }
        bookList.addByIndex(getRowCount(), book);
        fireTableRowsInserted(getRowCount(), getRowCount());
    }

    public void removeBook(int row) {
        bookList.removeByIndex(row);
        fireTableRowsDeleted(row, row);
    }
}