package ui;

import java.io.FileNotFoundException;

/**
 * code based on <a href="https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo">...</a>
 */
public class Main {
    public static void main(String[] args) {
        try {
            new BookListApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}