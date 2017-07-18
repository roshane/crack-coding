package com.aeon.cict;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by roshane on 7/16/17.
 */
public class AddNumberList {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(6);
        a.add(1);
        a.add(7);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(9);
        b.add(5);
        System.out.printf("add(%s, %s): %s",
                a.toString(),b.toString(),add(a,b));
    }

    static List<Integer> add(List<Integer> a, List<Integer> b) {

        if (a.size() == 0 && b.size() == 0) {
            return Collections.emptyList();
        } else if (a.size() == 0) {
            return b;
        } else if (b.size() == 0) {
            return a;
        }

        Stack<Integer> result = new Stack<>();
        int carry = 0;
        int total = 0;
        int upperBound = Math.max(a.size(), b.size());

        for (int i = upperBound-1; i>=0; i--) {
            if (i < a.size() && i < b.size()) {
                total = carry + a.get(i) + b.get(i);
                carry = total / 10;
                result.push(total % 10);
            } else if (i < a.size() && i >= b.size()) {
                total = carry + a.get(i);
                carry = total / 10;
                result.push(total % 10);
            } else if (i >= a.size() && i < b.size()) {
                total = carry + b.get(i);
                carry = total / 10;
                result.push(total % 10);
            }
        }
        if(carry>0){
            result.add(carry);
        }
        List<Integer> inOrderList=new ArrayList<>();
        while (!result.isEmpty()){
            inOrderList.add(result.pop());
        }
        return inOrderList;
    }

//    static List<Integer> add(List<Integer> a, List<Integer> b) {
//
//        if (a.size() == 0 && b.size() == 0) {
//            return Collections.emptyList();
//        } else if (a.size() == 0) {
//            return b;
//        } else if (b.size() == 0) {
//            return a;
//        }
//
//        List<Integer> result = new ArrayList<>();
//        int carry = 0;
//        int total = 0;
//        int upperBound = Math.max(a.size(), b.size());
//
//        for (int i = 0; i < upperBound; i++) {
//            if (i < a.size() && i < b.size()) {
//                total = carry + a.get(i) + b.get(i);
//                carry = total / 10;
//                result.add(total % 10);
//            } else if (i < a.size() && i >= b.size()) {
//                total = carry + a.get(i);
//                carry = total / 10;
//                result.add(total % 10);
//            } else if (i >= a.size() && i < b.size()) {
//                total = carry + b.get(i);
//                carry = total / 10;
//                result.add(total % 10);
//            }
//        }
//        if(carry>0){
//            result.add(carry);
//        }
//        return result;
//    }
}
