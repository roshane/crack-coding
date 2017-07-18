package com.aeon.cict;

/**
 * Created by roshane on 7/16/17.
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
    }

    static void rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            System.out.println("stop not a square matrix!");
        } else {

        }
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if (j + 1 < matrix[0].length) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
