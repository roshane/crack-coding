package com.aeon.prob;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

/**
 * Created by roshane on 7/8/17.
 */
public class LonelyInteger {

    public static void main(String[] args) {
        int[] input = {1, 2, 1, 2, 3, 4, 4, 5, 5, 6, 6, 6};

        System.out.println("lonelyInt: " + lonelyIntXOR(input));
        System.out.println("lonelyInt: " + lonelyIntMap(input));
    }

    static int lonelyIntXOR(int[] input) {

        int lonelyInt = 0;
        for (int i : input) {
            lonelyInt ^= i;
        }
        return lonelyInt;
    }

    static int lonelyIntMap(int[] input) {

        List<Integer> intStream = Arrays.stream(input).boxed().collect(Collectors.toList());
        int lonelyInt;
        Map<Integer, Integer> numberCount = intStream
                .stream()
                .collect(Collectors.toMap(Function.identity(), v -> 0, (v1, v2) -> v2, LinkedHashMap::new));
        intStream.forEach(i -> {
            numberCount.compute(i, (k, v) -> v += 1);
        });

        lonelyInt = numberCount.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .get();

        return lonelyInt;
    }
}
