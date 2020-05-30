package com.hyperskill.projects.medium.search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        String[] storeInformation = temp.split(" ");
        String searchInformation = scanner.nextLine();
        boolean isFound = false;
        for (int i = 0; i < storeInformation.length; i++) {
            if (searchInformation.equals(storeInformation[i])) {
                System.out.println(++i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Not found.");
        }
    }
}
