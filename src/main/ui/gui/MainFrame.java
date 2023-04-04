package ui.gui;

import model.BookList;
import model.Event;
import model.EventLog;
import model.persistence.JsonReader;
import model.persistence.JsonWriter;
import ui.gui.button.*;
import ui.gui.button.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Represents the main window of the application
 */
public class MainFrame extends JFrame implements ActionListener, WindowListener {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/bookList.json";

    private Button editButton;
    private Button saveButton;
    private Button loadButton;
    private Button addButton;
    private Button deleteButton;

    private BookList bookList;
    private BookTableModel bookTableModel;
    private JTable bookTable;

    public MainFrame() {
        super("Book List");
        initializeFields();
        initializeGraphics();
    }

    // MODIFIES: this
    // EFFECTS:  initializes a jsonReader, a jsonWriter, a bookList, a bookTableModel, and a bookTable
    private void initializeFields() {
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        bookList = new BookList();
        bookTableModel = new BookTableModel(bookList);
        bookTable = new JTable(bookTableModel);
    }

    // MODIFIES: this
    // EFFECTS: draw the JFrame window, and create the table and the buttons
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        createTable();
        createButtons();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS:  Instantiate all the buttons, then add them to the button panel
    private void createButtons() {
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.EAST);

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

    // MODIFIES: this
    // EFFECTS:  instantiates the table then add it to the table panel
    private void createTable() {
        JScrollPane tableContainer = new JScrollPane(bookTable);
        add(tableContainer, BorderLayout.CENTER);
    }

    // REQUIRES: an action event
    // MODIFIES: this
    // EFFECTS: perform the corresponding action when a button is pressed
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

    // MODIFIES: this
    // EFFECTS: make book table model editable, refresh the model
    private void edit() {
        bookTableModel.setEditable(true);
        bookTableModel.fireTableDataChanged();
    }

    // MODIFIES: this
    // EFFECTS: add a new empty row to the book table model, refresh the model
    private void add() {
        bookTableModel.newRow();
        bookTableModel.fireTableDataChanged();
    }

    // MODIFIES: this
    // EFFECTS: remove the selected row from the book table model, refresh the model
    private void delete() {
        int[] selectedRows = bookTable.getSelectedRows();
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            bookTableModel.removeBook(selectedRows[i]);
        }
        bookTableModel.fireTableDataChanged();
    }

    // MODIFIES: this
    // EFFECTS: save the book list in the book table model to a file
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

    // MODIFIES: this
    // EFFECTS: load the book list to the book table model from a file
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

    // EFFECTS: info box for successful operations
    // image from <a href="https://static.vecteezy.com/system/resources/previews/000/572/885/original/check-mark-icon-vector.jpg">...</a>
    public static void infoBoxSuccess(String infoMessage) {
        ImageIcon icon = new ImageIcon("./images/checkmark.png");
        JOptionPane.showMessageDialog(null, infoMessage, null, JOptionPane.INFORMATION_MESSAGE, icon);
    }

    // EFFECTS: generic info box
    public static void infoBox(String infoMessage) {
        JOptionPane.showMessageDialog(null, infoMessage, null, JOptionPane.PLAIN_MESSAGE);
    }

    // REQUIRES: a window event
    @Override
    public void windowOpened(WindowEvent e) {
    }

    // REQUIRES: a window event
    // EFFECTS: close the window, print the event log to the console
    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
        EventLog eventLog = EventLog.getInstance();
        for (Event event : eventLog) {
            System.out.println(event);
        }
    }

    // REQUIRES: a window event
    @Override
    public void windowClosed(WindowEvent e) {
    }

    // REQUIRES: a window event
    @Override
    public void windowIconified(WindowEvent e) {
    }

    // REQUIRES: a window event
    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    // REQUIRES: a window event
    @Override
    public void windowActivated(WindowEvent e) {
    }

    // REQUIRES: a window event
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}