package com.hyperskill.projects.medium.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    Map<String, List<Integer>> invertedIndex;

    SearchEngine(List<String> listOfPeople) {
        this.invertedIndex = invertedIndex(listOfPeople);
    }

    public Map<String, List<Integer>> invertedIndex(List<String> listOfPeople) {
        Map<String, List<Integer>> invertedMap = new HashMap<>();
        int strNumber = 0;
        for (String str : listOfPeople) {
            String[] wordsInLine = str.toLowerCase().split(" ");
            for (String word : wordsInLine) {
                if (!invertedMap.containsKey(word)) {
                    invertedMap.put(word, new ArrayList<>());
                }
                invertedMap.get(word).add(strNumber);
            }
            strNumber++;
        }
        return invertedMap;
    }
}
