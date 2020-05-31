package com.hyperskill.projects.medium.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ReadFile {
    private final String pathToTheFile;
    ReadFile(String pathToTheFile) {
        this.pathToTheFile = pathToTheFile;
    }
    public Map<String,String> readFile() {
        Map<String,String> result = new TreeMap<>();
            try (final Scanner scan = new Scanner(new File(pathToTheFile))) {
                while (scan.hasNext()) {
                    String[] stringNameEmail = scan.nextLine().split(" ");
                    String name = stringNameEmail[0];
                    String surname = "";
                    String email = "";
                    if (stringNameEmail.length > 1) {
                        surname = stringNameEmail[1];
                    }
                    if (stringNameEmail.length > 2) {
                        email = stringNameEmail[2];
                    }
                    result.put(name + " " + surname, email);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File not found.");
            }
            return result;
    }
}
