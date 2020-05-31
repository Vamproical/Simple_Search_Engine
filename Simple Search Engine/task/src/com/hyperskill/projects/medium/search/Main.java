package com.hyperskill.projects.medium.search;

public class Main {
    public static void main(String[] args) {
        String path = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--data")) {
                path = args[i + 1];
            }
        }
        SearchMachine searchMachine = new SearchMachine();
        searchMachine.chooseAction(path);
    }
}
