package com.hyperskill.projects.medium.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

interface SearchImpl {
    ArrayList<Integer> searchPeople(String search, Map<String, List<Integer>> searchInd);
}
