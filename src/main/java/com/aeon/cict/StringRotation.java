package com.aeon.cict;

/**
 * Created by roshane on 7/16/17.
 */
public class StringRotation {

    public static void main(String[] args) {
        String a = "erbottlewat";
        String b = "waterbottle";
        System.out.printf("isRotation(%s, %s): %b\n",a,b,isRotation(a,b));
    }

    static boolean isRotation(String s1, String s2) {
        String s1s1 = s1 + s1;
        System.out.println(s1s1);
        return s1s1.contains(s2);
    }
}
