package com.scratch;

import java.util.Arrays;

/**
 * Created by roshane on 7/13/17.
 */
public class ScratchRunner {


    static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 9999999, 999999999, Integer.MAX_VALUE};

    public static void main(String[] args) {
        Arrays.asList(1, 12, 133, 23, 100, 23433)
                .forEach(i -> {
                    System.out.printf("getStringSize(%d): %d\n", i, getStringSize(i));
                });

    }

    static int getStringSize(int x) {
        for (int i = 0; ; i++) {
            if (sizeTable[i] >= x)
                return i + 1;
        }
    }
}
