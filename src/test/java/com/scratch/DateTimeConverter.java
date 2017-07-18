package com.scratch;

/**
 * Created by roshane on 7/14/17.
 */
public class DateTimeConverter {

    public static void main(String[] args) {
        String time = "12:05:45PM";
        System.out.println(timeConversion(time));
        System.out.println("a "+(int)'a');
    }

    static boolean isPM(String s) {
        return s.equals("PM");
    }

    static boolean isAM(String s) {
        return s.equals("AM");
    }

    static int convertTo24Hours(int h) {
        int value = 12 + h;
        return (value == 24) ? 0 : value;
    }

    static String timeConversion(String s) {
        // Complete this function
        if (s.length() != 10) {
            return "";
        }

        String[] tokens = s.split(":");
        String ampm = tokens[2].substring(2, 4);
        String ss = tokens[2].substring(0, 2);
        tokens[2] = ss;

        if (isPM(ampm)) {
            int i = convertTo24Hours(Integer.parseInt(tokens[0]));
            String strValue = String.valueOf(i);
            if (strValue.length() < 2) {
                strValue = "0" + strValue;
            }
            tokens[0] = strValue;
        }
        String retValue = "";
        for (int i = 0; i < tokens.length; i++) {
            if (i != tokens.length - 1) {
                retValue += tokens[i] + ":";
            } else {
                retValue += tokens[i];
            }
        }
        return retValue;
    }
}
