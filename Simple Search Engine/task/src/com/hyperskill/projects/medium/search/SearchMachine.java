package com.hyperskill.projects.medium.search;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchMachine {
    Map<String, String> people = new LinkedHashMap<>();
    final Scanner scanner = new Scanner(System.in);
    private void enterData() {
        System.out.println("Enter the number of people:");
        final int numberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter all people:");
        for (int i = 0; i < numberOfPeople; i++) {
            String[] stringNameEmail = scanner.nextLine().split(" ");
            String name = stringNameEmail[0];
            String surname = "";
            String email = "";
            if (stringNameEmail.length > 1) {
                surname = stringNameEmail[1];
            }
            if (stringNameEmail.length > 2) {
                email = stringNameEmail[2];
            }
            people.put(name + " " + surname, email);
        }
    }
    private void searchPeople() {
        System.out.println("Enter a name or email to search all suitable people.");
        String search = scanner.nextLine();
        Pattern pattern = Pattern.compile(search, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        boolean isNotEmail = false;
        for (String str : people.keySet()) {
            boolean isOutput = false;
            String surname = people.get(str);
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                System.out.println((str + " " + people.get(str)).trim());
                isNotEmail = true;
                isOutput = true;
            }
            matcher = pattern.matcher(surname);
            if (!isOutput && matcher.find()) {
                System.out.println((str + " " + people.get(str)).trim());
                isNotEmail = true;
            }
        }
        if (!isNotEmail) {
            System.out.println("No matching people found.");
        }
    }
    private void printAll() {
        System.out.println("=== List of people ===");
        for (var str: people.keySet()) {
            System.out.println((str + " " + people.get(str)).trim());
        }
    }
    public void chooseAction() {
        enterData();
        boolean isNotWorking = true;
        while (isNotWorking) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            String choose = scanner.nextLine();
            switch (choose) {
                case "0":
                    System.out.println("Bye!");
                    isNotWorking = false;
                    break;
                case "1":
                    searchPeople();
                    break;
                case "2":
                    printAll();
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }
    }
}
