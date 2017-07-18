package com.aeon.hrank;

/**
 * Created by roshane on 7/15/17.
 */
public class MinClosestSquareNeeded {

    public static void main(String[] args) {
        int result = findMinPerfSquareNeeded(7);
        System.out.println("result: " + result);
    }

    static int findClosestPerfectSquare(int n) {
        int i = 1;
        while (i * i <= n) {
            i++;
        }
        if (i == 1) {
            return 1;
        }
        return (i - 1) * (i - 1);
    }

    static int findMinPerfSquareNeeded(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            System.out.printf("%d -> %d\n", n, 1);
            return 1;
        }
        int closestPerfSquare = findClosestPerfectSquare(n);
        int perfSquarecountNeeded = (n / closestPerfSquare);
        int remainder = (n - (closestPerfSquare * perfSquarecountNeeded));
        System.out.printf("%d -> %d\n", n, closestPerfSquare);
        return (n / closestPerfSquare) + findMinPerfSquareNeeded(remainder);
    }
}
