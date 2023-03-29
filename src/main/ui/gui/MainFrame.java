package ui.gui;

import model.BookList;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.gui.button.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    public static final String JSON_STORE = "./data/bookList.json";

    EditButton editButton;
    SaveButton saveButton;
    LoadButton loadButton;
    AddButton addButton;
    DeleteButton deleteButton;

    private BookList bookList;
    private BookTableModel bookTableModel;
    private JTable bookTable;

    private int selection;

    public MainFrame() {
        super("Book List");
        initializeFields();
        initializeGraphics();
    }

    private void initializeFields() {
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        bookList = new BookList();
        bookTableModel = new BookTableModel(bookList);
        bookTable = new JTable(bookTableModel);
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
        JPanel buttonPanel = new JPanel();
        this.add(buttonPanel, BorderLayout.EAST);

        editButton = new EditButton(this, buttonPanel);
        addButton = new AddButton(this, buttonPanel);
        deleteButton = new DeleteButton(this, buttonPanel);
        saveButton = new SaveButton(this, buttonPanel);
        loadButton = new LoadButton(this, buttonPanel);
        buttonPanel.setLayout(new GridLayout(0,1));

        editButton.addActionListener(this);
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
    }

    private void createTable() {
        JScrollPane tableContainer = new JScrollPane(bookTable);
        add(tableContainer, BorderLayout.CENTER);
        TableMouseListener ml = new TableMouseListener();
        bookTable.addMouseListener(ml);
    }

    private class TableMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            selection = bookTable.getSelectedRow();
            bookTable.clearSelection();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == editButton) {
            edit();
        } else if (source == addButton) {
            add();
        } else if (source == deleteButton) {
            delete();
        } else if (source == saveButton) {
            save();
        } else if (source == loadButton) {
            load();
        }
    }

    private void edit() {
        bookTableModel.setEditable(true);
        bookTableModel.fireTableDataChanged();
    }

    private void add() {
        bookTableModel.newRow();
        bookTableModel.fireTableDataChanged();
    }

    private void delete() {
        bookTableModel.removeBook(selection);
        bookTableModel.fireTableDataChanged();
        selection = 0;
    }

    private void save() {
        try {
            jsonWriter.open();
            jsonWriter.write(bookList);
            jsonWriter.close();
            infoBoxSuccess("Saved book list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            infoBox("Unable to write to the file at " + JSON_STORE);
        }
    }

    private void load() {
        try {
            bookList = jsonReader.read();
            infoBoxSuccess("Successfully loaded the book list from " + JSON_STORE);
        } catch (IOException e) {
            infoBox("Unable to read from the file at " + JSON_STORE);
        }
        bookTableModel = new BookTableModel(bookList);
        bookTable.setModel(bookTableModel);
    }

    public static void infoBoxSuccess(String infoMessage) {
        ImageIcon icon = new ImageIcon("./images/checkmark.png");
        JOptionPane.showMessageDialog(null, infoMessage, null, JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public static void infoBox(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage, null, JOptionPane.PLAIN_MESSAGE);
    }

    //https://static.vecteezy.com/system/resources/previews/000/572/885/original/check-mark-icon-vector.jpg
}