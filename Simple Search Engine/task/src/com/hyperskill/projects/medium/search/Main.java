package com.hyperskill.projects.medium.search;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "";
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("--data")) {
                    path = args[i + 1];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ReadFile readFile = new ReadFile(path);
        List<String> listOfPeople = readFile.readFile();
        SearchEngine searchEngine = new SearchEngine(listOfPeople);
        InteractiveMenu interactiveMenu = new InteractiveMenu(searchEngine, listOfPeople);
        interactiveMenu.chooseAction();
    }
}
