package com.hyperskill.projects.medium.search;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        final int numberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter all people:");
        Map<String,String> people = new LinkedHashMap<>();
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
        System.out.println("Enter the number of search queries:");
        int numberOfPeopleForSearch = Integer.parseInt(scanner.nextLine());
        while (numberOfPeopleForSearch != 0) {
            System.out.println("Enter data to search people:");
            String search = scanner.nextLine();
            Pattern pattern = Pattern.compile(search, Pattern.CASE_INSENSITIVE);
            Matcher matcher;
            boolean isNotEmail = false;
            for (String str: people.keySet()) {
                boolean isOutput = false;
                String surname = people.get(str);
                matcher = pattern.matcher(str);
                if (matcher.find()) {
                    System.out.println(str + " " + people.get(str));
                    isNotEmail = true;
                    isOutput = true;
                }
                matcher = pattern.matcher(surname);
                if (!isOutput && matcher.find()) {
                    System.out.println(str + " " + people.get(str));
                    isNotEmail = true;
                }
            }
            if (!isNotEmail) {
                System.out.println("No matching people found.");
            }
            --numberOfPeopleForSearch;
        }

    }
}
