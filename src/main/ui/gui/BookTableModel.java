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

    // REQUIRES: an integer for row, an integer for column
    // EFFECTS: return the editable state of the cell at the coordinates given
    @Override
    public boolean isCellEditable(int row, int column) {
        return editable;
    }

    // REQUIRES: a boolean
    // MODIFIES: this
    // EFFECTS: set the editable state of the cell to the given boolean
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    // EFFECTS: return the number of columns
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // EFFECTS: return the name of columns
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // EFFECTS: return the number of rows
    @Override
    public int getRowCount() {
        return bookList.getBookListLength();
    }

    // REQUIRES: an integer for row, an integer for column
    // EFFECTS: if the title column is indicated, return the title of the book at the given row; if the chapter column is indicated, return the chapter.
    @Override
    public Object getValueAt(int row, int column) {
        Book book = getBook(row);
        switch (column) {
            case 0: return book.getTitle();
            case 1: return book.getChapter();
            default: return null;
        }
    }

    // REQUIRES: an integer for row, an integer for column, a string or an integer
    // MODIFIES: this
    // EFFECTS: if the title column is indicated, change the title of the book at the given row to the given string; if the chapter column is indicated, change the chapter of the book to the given integer. Pop up an infobox when the wrong type is provided.
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

    // REQUIRES: an integer
    // EFFECTS: returns the book in the given row
    public Book getBook(int row) {
        return bookList.getBook(row);
    }

    // MODIFIES: this
    // EFFECTS: add a new row with empty title and 0 chapter
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

    // REQUIRES: an integer
    // MODIFIES: this
    // EFFECTS: remove the book on the indicated row from the book list
    public void removeBook(int row) {
        bookList.removeByIndex(row);
        fireTableRowsDeleted(row, row);
    }
}