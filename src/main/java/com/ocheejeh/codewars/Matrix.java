package com.ocheejeh.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class Matrix {

    public static int determinant(int[][] matrix) {

        //when there is only one element present
        if(matrix.length == 1 && matrix[0].length == 1) return matrix[0][0]; //only one element

        //determinant is only valid for square matrix
        for (int [] col: matrix) {
            if(col.length != matrix.length) throw new InputMismatchException("The provided matrix is not a square matrix");
        }

        int posNum = 1;
        int negNum = 1;
        for (int row = 0; row < matrix.length; row++) {
            //check if higher square matrix
            //int[] subMatrix = new int[][];
            for (int col = 0; col < matrix[row].length; col++) {
                if((row + col) % 2 == 0) posNum *= matrix[row][col];
                if((row + col) % 2 == 1) negNum *= matrix[row][col];

            }
        }
        // Your code here!
        return posNum - negNum;
    }
    
    public static void traverseMatrix(int[][] matrix){
        int[][] newMatrix = matrix;
        newMatrix = new int[matrix.length - 1][matrix[0].length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];
                List<List<Integer>> subItem = new ArrayList<>();
                for (int k = 0; k < matrix.length; k++) {
                    List<Integer> innerList = new ArrayList<>();
                    for (int l = 0; l < matrix[k].length; l++) {
                        if (k == i || l == j) continue;
                        innerList.add(matrix[k][l]);
                    }
                    if(!innerList.isEmpty()) subItem.add(innerList);
                }

                final int[][] out = new int[subItem.size()][subItem.size()];
                for (int l = 0; l < subItem.size(); l++) {
                    Arrays.setAll(out[l], subItem.get(l)::get);
                }
            }
            break;
        }

    }
    
    //driver method
    public static void main(String[] args) {
        traverseMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Matrix.determinant(new int[][]{{2}}));
//        System.out.println(Matrix.determinant(new int[][]{{1, 0}, {2, 1}}));
//        System.out.println(Matrix.determinant(new int[][]{{5, 2}, {3, 1}}));
//        System.out.println(Matrix.determinant(new int[][]{{5, 2}, {3, 4}}));
    }

}
