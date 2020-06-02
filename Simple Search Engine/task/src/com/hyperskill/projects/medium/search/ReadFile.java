package com.hyperskill.projects.medium.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private final String pathToTheFile;

    ReadFile(String pathToTheFile) {
        this.pathToTheFile = pathToTheFile;
    }

    public List<String> readFile() {
        List<String> result = new ArrayList<>();
        try (final Scanner scan = new Scanner(new File(pathToTheFile))) {
            while (scan.hasNext()) {
                String stringNameEmail = scan.nextLine();
                result.add(stringNameEmail);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        return result;
    }
}
