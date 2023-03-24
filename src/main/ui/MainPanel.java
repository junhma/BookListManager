package ui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private BookTable bookTable;

    private static final String JSON_STORE = "./data/bookList.json";

    public MainPanel() {
        super("Book List");
        bookTable = new BookTable();
        initializeGraphics();
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
        addBookTable();
    }

    // MODIFIES: this
    // EFFECTS:  declares and instantiates a Drawing (newDrawing), and adds it to drawings
    private void addBookTable() {
        add(bookTable, BorderLayout.CENTER);
        validate();
    }
}