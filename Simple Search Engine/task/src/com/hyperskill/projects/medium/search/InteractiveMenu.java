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

    private void printSearch(List<Integer> print) {
        if (!print.isEmpty()) {
            System.out.println(print.size() + "persons found:");
            for (Integer person : print) {
                System.out.println(listOfPeople.get(person));
            }
        } else {
            System.out.println("No matching people found.");
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
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String select = scanner.nextLine().toLowerCase();
                    ContextSearch contextSearch = new ContextSearch();
                    switch (select) {
                        case "all":
                            contextSearch.setSearch(new SearchAll());
                            System.out.println("Enter a name or email to search all suitable people.");
                            String name = scanner.nextLine();
                            List<Integer> people = contextSearch.searchPeople(name, invertedInd.invertedIndex);
                            printSearch(people);
                            break;
                        case "any":
                            contextSearch.setSearch(new SearchAny());
                            System.out.println("Enter a name or email to search all suitable people.");
                            name = scanner.nextLine();
                            people = contextSearch.searchPeople(name, invertedInd.invertedIndex);
                            printSearch(people);
                            break;
                        case "none":
                            contextSearch.setSearch(new SearchNone());
                            System.out.println("Enter a name or email to search all suitable people.");
                            name = scanner.nextLine();
                            people = contextSearch.searchPeople(name, invertedInd.invertedIndex);
                            printSearch(people);
                            break;
                        default:
                            System.out.println("Wrong strategy!");
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
