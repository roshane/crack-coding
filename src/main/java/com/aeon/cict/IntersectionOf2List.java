package com.aeon.cict;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by roshane on 7/16/17.
 */
public class IntersectionOf2List {

    public static void main(String[] args) {
        Integer[] listA = {1, 2, 3, 4, 8, 9, 10};
        Integer[] listB = {5, 6, 7, 8, 9, 10};

        int i=findIntersection(Arrays.asList(listA),Arrays.asList(listB));
        System.out.println("Intersection: "+i);
    }

    static int findIntersection(List<Integer> a, List<Integer> b) {
        List<Integer> longerList, shorterList;

        if (a.size() > b.size()) {
            longerList = a;
            shorterList = b;
        } else {
            longerList = b;
            shorterList = a;
        }

        for (int i = 0; i < longerList.size(); i++) {
            for (int j = 0; j < shorterList.size(); j++) {
                if (Objects.equals(longerList.get(i), shorterList.get(j))) {
                    return longerList.get(i);
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
