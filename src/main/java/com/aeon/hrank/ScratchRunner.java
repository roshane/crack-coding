package com.aeon.hrank;

/**
 * Created by roshane on 7/15/17.
 */
public class ScratchRunner {


    public static int findMin(int[] prfct, int k) {

        int[] arr = new int[k + 1];
        arr[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
            for (int j = 0; j < prfct.length; j++) {

                if (prfct[j] <= i) {
                    int temp = arr[i - prfct[j]] + 1;
                    arr[i] = arr[i] > temp ? temp : arr[i] ;

                }
            }
        }



        return arr[k];

    }

    public static int[] buildArray(int N) {
        int l = (int) Math.sqrt(N);
        int[] prfct = new int[l];

        //System.out.println(prfct.length);
        for(int i=1;i<=l;i++) {
            prfct[i-1] = i*i;
        }


        return prfct;
    }

    static void printArray(int[] a){
        for(int i:a){
            System.out.printf("%d,",i);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int N = 12;
        int[] prfct = buildArray(N); // Build the perfect square array
printArray(prfct);
        int output = findMin(prfct, N); // find  the minimum using Dynamic programming approach

        System.out.println(output);
    }

}
