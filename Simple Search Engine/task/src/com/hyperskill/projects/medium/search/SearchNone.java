package com.hyperskill.projects.medium.search;

import java.util.*;

public class SearchNone implements SearchImpl {
    @Override
    public ArrayList<Integer> searchPeople(String search, Map<String, List<Integer>> searchInd) {
        Set<Integer> posPeople = new HashSet<>();
        for (String entry : searchInd.keySet()) {
            posPeople.addAll(searchInd.get(entry));
        }
        String[] arrSearch = search.toLowerCase().split(" ");
        for (String people : arrSearch) {
            posPeople.removeAll(searchInd.get(people));
        }
        return new ArrayList<>(posPeople);
    }
}
