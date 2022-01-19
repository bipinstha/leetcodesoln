package main;

import com.sun.tools.javac.util.Assert;

/***
 0 0 0 0 1 0
 0 1 1 0 0 0
 0 1 0 0 0 1
 0 0 1 0 1 1
 1 0 0 0 1 0
 0 1 0 0 0 1
 */
public class CountOneDFSSolution {

    public static void main(String[] args) {
        int[][] metrics = {
                {0,0,0,0,1,0},
                {0,1,1,0,0,0},
                {0,1,0,0,0,1},
                {0,0,1,0,1,1},
                {1,1,0,0,1,0},
                {0,1,0,0,0,1}
        };
//        System.out.println(solution(metrics));
        Assert.check(7 == solution(metrics));
    }

    /***
     * This function counts and return maximum connected 1 in mxn metric
     * Connected means, it can be left, right, top, bottom, diagonal
     * @param metrics mxn metric contains 0 and 1
     * @return return maximum connected 1 on the given mxn metric
     */
    public static int solution(int[][] metrics) {
        // initialize count with 0;
        int maxCount = 0;
        // start iterating through metrics with two traditional for loop.
        for(int row = 0; row <  metrics.length; row++) {
            for(int col = 0; col < metrics[row].length; col++) {
                // while iterating if item found as 1
                if(metrics[row][col] == 1) {
                    // call searchDFS function which will search for connected 1s from the given element.
                    int count = searchUsingDFS(metrics, row, col);
                    // replace max count with current count return from searchDFS
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        // return value in maxCount variable
        return maxCount;
    }

    /**
     * DFS search in metric which will return connected 1s
     * @param metrics 3x3 inner metric
     * @param row current row
     * @param col current col
     * @return count of 1s in given metric
     */
    static int searchUsingDFS(int[][] metrics, int row, int col) {
        // exit condition i.e. if row or col is less than 0 or greater than metric length
        if(row < 0 || col < 0 || row >= metrics.length || col >= metrics[row].length){
            return 0;
        }
        // exit condition i.e. if element is 0
        if(metrics[row][col] == 0)
            return 0;
        // initialize cellCount with 1 (i.e. metrics[row][col] = 1 thus cellCount start with 1)
        int cellCount = 1;
        // convert counted metrics[row][col] 1 to 0
        metrics[row][col] = 0;
        // r = row - 1 :: row + 1
        // c = col -1 :: col + 1
        // which will select 3x3 inner metrics
        for(int r = row - 1; r < row + 2; r++) {
            for(int c = col - 1; c < col + 2; c++) {
                // save visit myself
                if(row != r || col != c) {
                    // increase cellCount by calling searchDFS iteratively
                    cellCount += searchUsingDFS(metrics, r, c);
                }
            }
        }
        // return final cellCount
        return cellCount;
    }
}
