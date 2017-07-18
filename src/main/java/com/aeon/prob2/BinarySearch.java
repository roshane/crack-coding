package com.aeon.prob2;

import java.util.*;

/**
 * Created by roshane on 7/17/17.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 3, 5, 6, 7, 8, 9};
        System.out.printf("findMagicNumber(%s): %d\n", arrayToString(numbers), findMagicNumber(numbers));
        int k = 20;
        System.out.printf("binarySearch(%s, %d): %d", arrayToString(numbers), k, binarySearch(numbers, k));
//        System.out.println();
//
//        System.out.printf("findTwoSum(%s, %d): %s", arrayToString(numbers),
//                k,
//                arrayToString(findTwoSum(numbers, k)));
        System.out.println();
        System.out.printf("fibonacci(%d): %d", k, fibonacci(k));
        System.out.println();
        System.out.printf("fibonacciLoop(%d): %d", k, fibonacciLoop(k));
//        System.out.println();
//        System.out.printf("fibonacciBoottomUp(%d): %d", k, fibonacciBoottomUp(k));
//        System.out.println();
//        System.out.printf("%d!: %d", k, p(k));
//        System.out.println();
//        int n = 30;
//        System.out.printf("countWays(%d): %d", n, countWays(n));
//        System.out.println();
//        System.out.printf("countWaysMemoized(%d): %d", n, cwM(n));
//        System.out.println();
//        System.out.println("multiply: " + multiply(12, 5));
        System.out.println("\n");
//        String s = "abcd";
//        List<String> perms = permutations(s);
//        System.out.printf("permutations(%s): %s [len= %d ]", s, perms, perms.size());
//        Arrays.asList("()",
//                "",
//                "[][{()}]",
//                "}[",
//                "()[00]{abc}()",
//                "[[{}")
//                .forEach(s -> {
//                    System.out.printf("isBanalceParan %s: %b\n", s, isBalancedParan(s));
//                });
//        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
//        System.out.println(arrayToString(arr));
//        System.out.println("max of naive: " + maxSumOf(arr, 4));
//        System.out.println("max of sliding : " + maxSumOfSW(arr, 4));

    }

    static boolean isBalancedParan(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpenParan(c)) {
                stack.push(c);
            } else if (isCloseParan(c) && !stack.isEmpty()) {
                if (!isProperPair(stack.pop() + "" + c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static int maxSumOf(int[] numbers, int k) {
        if (k > numbers.length) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length - k + 1; i++) {
            int currentMax = 0;
            for (int j = i; j < k + i; j++) {
                currentMax += numbers[j];
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }

    static int maxSumOfSW(int[] arr, int k) {
        if (k > arr.length) throw new RuntimeException("invalid argument");
        int windowSum = 0;
        int maxSum;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }

    static boolean isOpenParan(char c) {
        for (char p : openParans) {
            if (p == c)
                return true;
        }
        return false;
    }

    static boolean isCloseParan(char c) {
        for (char p : closeParans) {
            if (p == c) {
                return true;
            }
        }
        return false;
    }

    static boolean isProperPair(String s) {
        for (String p : paranPairs) {
            if (s.equals(p)) {
                return true;
            }
        }
        return false;
    }

    static char[] openParans = {'(', '[', '{'};
    static char[] closeParans = {')', ']', '}'};
    static String[] paranPairs = {"()", "[]", "{}"};

    static List<String> permutations(String s) {
        if (s == null) return null;

        List<String> perms = new ArrayList<>();

        if (s.length() == 0) {
            perms.add("");
            return perms;
        }

        char c = s.charAt(0);
        String remain = s.substring(1);
        List<String> words = permutations(remain);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                perms.add(insertCharAt(word, i, c));
            }
        }

        return perms;
    }

    static String insertCharAt(String s, int i, char c) {
        String start = s.substring(0, i);
        String end = s.substring(i);
        return start + c + end;
    }

    static int findMagicNumber(int[] array) {
        if (array.length == 0) return -1;
        return findMagicNumber(array, 0, array.length);
    }

    static int findMagicNumber(int[] arr, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;

        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            return findMagicNumber(arr, low, mid - 1);
        } else {
            return findMagicNumber(arr, mid + 1, high);
        }
    }

    static int multiply(int a, int b) {
        return mu(a, b, 0);
    }

    static int mu(int a, int b, int sum) {
        System.out.printf("a: %d, b: %d, sum: %d\n", a, b, sum);
        if (b == 0) {
            return sum;
        }
        return mu(a, b - 1, a + sum);
    }

    static long cwM(int n) {
        long[] memo = new long[n + 1];
        arrayFill(memo);
        memo[0] = 1;
        return countWaysMemoized(n, memo);
    }

    static void arrayFill(long[] n) {
        for (int i = 0; i < n.length; i++) {
            n[i] = -1;
        }
    }

    static long countWaysMemoized(int n, long[] memo) {
        if (n < 0) return 0;
        if (memo[n] != -1)
            return memo[n];
        memo[n] = countWaysMemoized(n - 1, memo) + countWaysMemoized(n - 2, memo) + countWaysMemoized(n - 3, memo);
        return memo[n];
    }

    static final Map<Long, Long> memo = new HashMap<>();

    static {
        memo.put(0l, 0l);
        memo.put(1l, 1l);
    }

    static long p(long n) {
        long result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static long fibonacciBoottomUp(int n) {
        if (n == 0) return 0;
//        long[] cache = new long[n];
//        cache[0] = 0;
//        cache[1] = 1;
        long a = 0;
        long b = 1;
        for (int i = 2; i < n; i++) {
            long c = b + a;
            a = b;
            b = c;
//            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return a + b;
    }

    static long countWays(long n) {
        if (n < 0) return 0;
        else if (n == 0) return 1;
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    static long fibonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            long result = fibonacci(n - 1) + fibonacci(n - 2);
            memo.put(n, result);
        }
        return memo.get(n);
    }

    static long fibonacciLoop(long n) {
        int a = 0;
        int b = 1;
        int fibonacci = 0;
        for (int i = 1; i < n; i++) {
//            System.out.println("a: "+a+" b: "+b);
            fibonacci = a + b;
            a = b;
            b = fibonacci;
        }
        return fibonacci;
    }

    static int[] findTwoSum(int[] numbers, int k) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int n1 = numbers[i];
            int key = k - n1;
            System.out.println(i + " - binary search");
            int index = binarySearch(numbers, key);
            if (index != -1 && index != i) {
                result[0] = numbers[i];
                result[1] = numbers[index];
                break;
            }
        }
        return result;
    }

    public static String arrayToString(int[] array) {
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            if (i < array.length - 1) {
                result += ",";
            }
        }
        result += "]";
        return result;
    }

    static int binarySearch(int[] numbers, int k) {
        if (numbers.length == 0) {
            return -1;
        }
        return search(numbers, k, 0, numbers.length);
    }

    static int search(int[] numbers, int k, int low, int upper) {
        int mid = (low + upper) / 2;

        if (numbers[mid] == k) {
            return mid;
        } else if (mid <= low || mid >= upper) {
            return -1;
        } else if (numbers[mid] > k) {
            return search(numbers, k, low, mid - 1);
        } else {
            return search(numbers, k, mid + 1, upper);
        }

    }
}
