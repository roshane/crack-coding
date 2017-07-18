package com.aeon.prob;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roshane on 7/11/2017.
 */
public class SumList {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(9);
        a.add(9);
        a.add(9);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(0);
        b.add(1);

        System.out.println(sumList(a, b));
    }

    private static List<Integer> sumList(List<Integer> a, List<Integer> b) {
        int remainder = 0;
        int sum;

        List<Integer> lList;
        List<Integer> sList;
        if (a.size() > b.size()) {
            sList = b;
            lList = a;
        } else {
            sList = a;
            lList = b;
        }
        List<Integer> rList = new ArrayList<>();

        for (int i = 0; i < lList.size(); i++) {
            if (sList.size() > i) {
                sum = sList.get(i) + lList.get(i) + remainder;
                rList.add(sum % 10);
                remainder = (sum / 10);
            } else {
                sum = remainder + lList.get(i);
                rList.add(sum % 10);
                remainder = (sum / 10);
            }
        }
        if (remainder > 0) {
            rList.add(remainder);
        }
        return rList;
    }
}
