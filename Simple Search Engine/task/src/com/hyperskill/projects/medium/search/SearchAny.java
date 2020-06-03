package com.hyperskill.projects.medium.search;

import java.util.*;

public class SearchAny implements SearchImpl {
    @Override
    public ArrayList<Integer> searchPeople(String search, Map<String, List<Integer>> searchInd) {
        String[] arrSearch = search.toLowerCase().split(" ");
        Set<Integer> posPeople = new HashSet<>();
        for (String people : arrSearch) {
            if (searchInd.containsKey(people)) {
                posPeople.addAll(searchInd.get(people));
            }
        }
        return new ArrayList<>(posPeople);
    }
}
