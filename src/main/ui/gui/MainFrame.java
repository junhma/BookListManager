package ui.gui;

import model.BookList;
import ui.gui.button.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    public Toggle editable;
    public BookList bookList;

    public MainFrame() {
        super("Book List");
        initializeGraphics();
    }

    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        createTable();
        createButtons();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createButtons() {
        JPanel buttonArea = new JPanel();
        buttonArea.setLayout(new GridLayout(0,1));
        add(buttonArea, BorderLayout.EAST);

        new EditButton(this, buttonArea);
        new SaveButton(this, buttonArea);
        new LoadButton(this, buttonArea);
    }

    private void createTable() {
        JPanel tableArea = new JPanel();
        add(tableArea, BorderLayout.CENTER);
        BookTable bookTable = new BookTable(this, tableArea);
        editable = bookTable.editable;
        bookList = bookTable.bookList;
    }

    public static class Toggle {
        Boolean val;

        public Toggle(Boolean val) {
            this.val = val;
        }

        public void setVal(Boolean val) {
            this.val = val;
        }

        public Boolean getVal() {
            return val;
        }

        public void toggle() {
            setVal(!getVal());
        }
    }
}