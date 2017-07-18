package com.aeon.hrank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by roshane on 7/15/17.
 */
public class HotelsVisited {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 4};
        int[] b = {2, 5, 4, 4, 3};
        int[] c = {7, 3, 1, 5, 4};

        List<Integer> count = commonIDs(new int[][]{a, b, c});
        System.out.println(count);
    }

    /*
    * Time complexity O(nm) => {n:number of users, m: number of hotels }
    * */
    static List<Integer> commonIDs(int[][] hotels) {

        int noOfUsers = hotels.length;

        Map<Integer, Integer> hotelVisit = new HashMap<>();
        List<Set<Integer>> uniqueHotelVisits = new ArrayList<>();

        for (int i = 0; i < noOfUsers; i++) { // n
            Set<Integer> visits = new HashSet<>();
            for (int j = 0; j < hotels[i].length; j++) { // m
                visits.add(hotels[i][j]);
            }
            uniqueHotelVisits.add(visits);
        }

        for (Set<Integer> visit : uniqueHotelVisits) {
            for (int id : visit) {
                hotelVisit.compute(id, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        return hotelVisit.entrySet()
                .stream()
                .filter(e -> e.getValue() == hotels.length)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }
}
