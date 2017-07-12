package com.aeon;

/**
 * Created by roshane on 7/10/2017.
 */
public class StringRotation {

    public static void main(String[] args) {

        String str = "erbottlewat";
        String rot = "waterbottle";
//        (erbottlewaterbottlewat,waterbottle)
        System.out.printf("isRotation(%s,%s): %b\n", str, rot, isRotation(str, rot));
    }

    static boolean isRotation(String str, String rot) {
        return isSubString(str + str, rot);
    }

    static boolean isSubString(String str, String sub) {
        System.out.printf("isSubstring(%s,%s)\n", str, sub);
        return str.contains(sub);
    }
}
