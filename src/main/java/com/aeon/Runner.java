package com.aeon;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by roshane on 7/8/17.
 */
public class Runner {

    public static void main(String[] args) {
//        printPattern(100);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        int[] a = {1, 0, 0, 0, 0, 1};
//        int[] b = {1, 7, 5, 9, 2, 12, 3, 22, 20, 0};
//        printArray(a);
//        sort10Array(a);
//        printArray(a);

//        long start, end;
//        String s = "abbc";
//        String b = "cbabadcbbabbcbabaabccbabc";
//        System.out.println(s);
//        System.out.println(b);
//
//        start = System.nanoTime();
//        System.out.println(findPermutations(s, b));
//        end = System.nanoTime();
//        System.out.println("runtime: " + (end - start));
//
//        start = System.nanoTime();
//        System.out.println(findPermutationsViaHashCode(s, b));
//        end = System.nanoTime();
//        System.out.println("runtime: " + (end - start));

//        System.out.println(strHashCode("abbc"));
//        System.out.println(strHashCode("abad"));
//
//        Integer a = Integer.valueOf("ff", 16);
//        Integer b = Integer.valueOf("11111111", 2);
//        Integer c = Integer.valueOf("377", 8);
//        System.out.printf("a: %d | b: %d | c: %d\n", a, b, c);
//
//        System.out.println("convertFromBase: " + convertFromBase("377", 8));
//        findMinMaxIndex();
//        System.out.println(findPairs(2, b));
//        System.out.printf("A = %d, Z = %d, a = %d, z = %d", (int) 'A', (int) 'Z', (int) 'a', (int) 'z');

//        System.out.println(reverseWork("roshane"));

        Arrays.asList("HELLO", "WoRLd", "rOsHAnE")
                .forEach(s -> {
                    System.out.printf("toLoserCase[%s]: %s\n", s, toLowerCase(s));
                });
        System.out.println(" ',' int value: " + (int) ',');
        doSomething();
    }


    public static String toLowerCase(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (isUppercaseChar(current)) {
                result += toLowercaseChar(current);
            } else {
                result += current;
            }
        }
        return result;
    }

    private static boolean isUppercaseChar(char c) {
        int A = (int) 'A';
        int Z = (int) 'Z';
        int val = (int) c;
        return (val >= A && val <= Z);
    }

    private static boolean isAlphabeticChar(char c) {
        int a = (int) 'a';
        int z = (int) 'z';
        int A = (int) 'A';
        int Z = (int) 'Z';
        int current = (int) c;
        return (current >= a && current <= z) || (current >= A && current <= Z);
    }

    private static char toLowercaseChar(char c) {
        int diff = ((int) 'a' - (int) 'A');
        int converted = (((int) c) + diff);
        return (char) converted;
    }


    private static void doSomething() {
        System.out.println("### doSomething ###");
//        String str = "Ratzs live on no evil starz";
        String str = "Zeus was deified, saw Suez";
        str = toLowerCase(str);
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (c != ' ' && isAlphabeticChar(c)) {
                map.compute(c, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        System.out.println(map);
        boolean foundOddChar = false;
        boolean passed = true;
        System.out.println("Checking String : " + str);
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() % 2 != 0 && foundOddChar) {
                System.out.println("Permutation of palindrome: Nooooooo");
                passed = false;
                break;
            }
            if (e.getValue() % 2 != 0) {
                foundOddChar = true;
            }
        }
        if (passed)
            System.out.println("Permutation of palindrome: Yeeees");
    }



//    static int perMutation(int i) {
//        if (i == 0) {
//            return 1;
//        }
//    }

    private static String reverseWork(String word){
        StringBuilder sb=new StringBuilder();
        for(int i=word.length()-1;i>=0;i--){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

    private static void findMinMaxIndex() {
        System.out.println("min max index: ");
        int[] numbers = {12, 2, 3, 21, 1, 9, 0};
        printArray(numbers);
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[maxIndex]) {
                maxIndex = i;
            }
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        System.out.printf("min: %d| max: %d \n", numbers[minIndex], numbers[maxIndex]);
    }

    private static int convertFromBase(String number, int base) {
        int result = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.digit(number.charAt(i), base);
            int exponent = number.length() - 1 - i;
            result += Math.pow(base, exponent) * digit;
        }
        return result;
    }

    private static int parseDigit(char c) {
        return 0;
    }

    private static long strHashCode(String s) {
        long i = 31;
        for (int j = 0; j < s.length(); j++) {
            i = i * (7 * (long) s.charAt(j));
        }
        return i;
    }


    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    // TODO: 7/9/17 this works array[i]>=0
    private static Set<Pair> findPairs(int k, int[] array) {
        Stream<Integer> stream = Arrays.stream(array).boxed();

        Map<Integer, Integer> numberCount = stream
                .collect(Collectors.toMap(_identity(), v -> 1, (v1, v2) -> v2, LinkedHashMap::new));
        System.out.println("numberCount: " + numberCount);
        Set<Pair> pairs = new HashSet<>();

        for (int x : array) {
            if (numberCount.containsKey(x + k)) {
                pairs.add(new Pair(x, x + k));
            }
            if (numberCount.containsKey(x - k)) {
                pairs.add(new Pair(x, x - k));
            }
        }
        return pairs;
    }


    private static <T> Function<T, T> _identity() {
        return i -> i;
    }

    private static List<Integer> findPermutationsViaHashCode(String sub, String txt) {

        long hasCode = strHashCode(sub);
        int subLength = sub.length();

        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < txt.length() && i + subLength <= txt.length(); i++) { // B
            if (strHashCode(txt.substring(i, i + sub.length())) == hasCode) {// S
                positions.add(i); // C1
            }
        }
        return positions;
    }

    private static List<Integer> findPermutations(String sub, String txt) {
        List<Integer> positions = new ArrayList<>();

        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : sub.toCharArray()) {
            charMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }//  S

        for (int i = 0; i < txt.length(); i++) { // B
            Character current = txt.charAt(i);
            if (charMap.containsKey(current)) {
                Map<Character, Integer> map = new HashMap<>(charMap);// S
                for (int j = 0; j < sub.length() && (i + j) < txt.length(); j++) { // S
                    if (map.containsKey(txt.charAt(i + j))) {
                        map.compute(txt.charAt(i + j), (k, v) -> v - 1);
                    }
                }

                boolean foundIndex = map.entrySet() // S
                        .stream()
                        .map(Map.Entry::getValue)
                        .allMatch(count -> count == 0);

                if (foundIndex) {
                    positions.add(i);
                }
            }// 2S
        }// 2BS

        System.out.println(charMap);

        return positions;
    }

    static void sort10Array(int[] input) {
        for (int x = 0, y = input.length - 1; x < y; ) {
            if (input[x] == 0) {
                x += 1;
            }
            if (input[y] == 1) {
                y -= 1;
            }
            if (input[x] > input[y]) {
                input[x] = 0;
                input[y] = 1;
                x += 1;
                y -= 1;
            }
        }
    }

    static void printPattern(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = n; j > 0; j--) {
                if (j > i) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}

class Pair {

    private int k, v;

    Pair(int k, int v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public String toString() {
        return String.format("%d:%d", k, v);
    }

    @Override
    public int hashCode() {
        return 31 * k + 31 * v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Pair) {
            Pair that = (Pair) o;
            return (this.k == that.k && this.v == that.v)
                    || (this.k == that.v && this.v == that.k);
        }
        return false;
    }
}