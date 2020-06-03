package com.hyperskill.projects.medium.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContextSearch {
    private SearchImpl search;

    public void setSearch(SearchImpl search) {
        this.search = search;
    }

    public ArrayList<Integer> searchPeople(String search, Map<String, List<Integer>> searchInd) {
        return this.search.searchPeople(search, searchInd);
    }
}
