package com.hyperskill.projects.medium.search;

import java.util.*;

public class SearchAll implements SearchImpl {
    @Override
    public ArrayList<Integer> searchPeople(String search, Map<String, List<Integer>> searchInd) {
        String[] arrSearch = search.toLowerCase().split(" ");
        Set<Integer> posPeople = new HashSet<>();
        for (String people : arrSearch) {
            if (searchInd.containsKey(people)) {
                if (posPeople.isEmpty()) {
                    posPeople.addAll(searchInd.get(people));
                } else {
                    posPeople.retainAll(searchInd.get(people));
                }
            }
        }
        return new ArrayList<>(posPeople);
    }
}
