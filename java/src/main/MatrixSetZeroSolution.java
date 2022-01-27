package main;

import java.util.HashSet;
import java.util.Set;

public class MatrixSetZeroSolution {

    public static void main(String[] args) {

        int[][] matrixA = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrixB = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        printMatrix(solution(matrixA));
        printMatrix(solution(matrixB));

    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int[][] solution(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j< matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j< matrix[i].length; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

}
