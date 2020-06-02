package com.hyperskill.projects.medium.search;

import java.util.List;
import java.util.Scanner;

public class InteractiveMenu {
    private final List<String> listOfPeople;
    private final SearchEngine invertedInd;

    InteractiveMenu(SearchEngine invertedInd, List<String> listOfPeople) {
        this.invertedInd = invertedInd;
        this.listOfPeople = listOfPeople;
    }

    final Scanner scanner = new Scanner(System.in);

    private void printAll() {
        System.out.println("=== List of people ===");
        for (String str : listOfPeople) {
            System.out.println(str);
        }
    }

    public void chooseAction() {
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
                    System.out.println("Enter a name or email to search all suitable people.");
                    String name = scanner.nextLine().toLowerCase().trim();
                    List<Integer> people = invertedInd.searchPeople(name);
                    if (!people.isEmpty()) {
                        System.out.println(people.size() + "persons found:");
                        for (Integer person : people) {
                            System.out.println(listOfPeople.get(person));
                        }
                    } else {
                        System.out.println("No matching people found.");
                    }
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
