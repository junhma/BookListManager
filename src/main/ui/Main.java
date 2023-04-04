package ui;

import ui.gui.MainFrame;

import java.io.FileNotFoundException;

/**
 * Represent the main program to be run
 * code based on <a href="https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo">...</a>
 */
public class Main {
    public static void main(String[] args) {
        new MainFrame();
        try {
            new BookListApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}