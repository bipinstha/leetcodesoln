package main;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 *Input: board =
 * [
 * [0,  1,  0],
 * [0,  0,  1],
 * [1,  1,  1],
 * [0,  0,  0]
 * ]
 *
 * Output:
 * [
 * [0,  0,  0],
 * [1,  0,  1],
 * [0,  1,  1],
 * [0,  1,  0]
 * ]
 */
public class GameOfLifeSolution {

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        MatrixSetZero.printMatrix(solution(board));
    }

    static int[][] solution(int[][] board){
        int[][] newMatrix = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveNeighbour = countLiveNeighbour(board,i, j);
                if(board[i][j] == 1)  {
                    // 3 Rules for live cell
                    if(liveNeighbour < 2) { // Rule 1
                        newMatrix[i][j] = 0;
                    } else if (liveNeighbour == 2 || liveNeighbour == 3) {  // Rule 2
                        newMatrix[i][j] = 1;
                    } else if (liveNeighbour > 3) { // Rule 3
                        newMatrix[i][j] = 0;
                    }
                }
                // Rule 1 for dead cell
                if(board[i][j] == 0 && liveNeighbour == 3) {
                    newMatrix[i][j] = 1;
                }
            }
        }
        board = newMatrix;
        return board;
    }

    private static int countLiveNeighbour(int[][] matrix, int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if(i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length // avoid getting out of index exception
                        && (i != row || j != col)
                        && matrix[i][j] == 1) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

    //DFS for given element
//    static void applyRule(int[][] matrix, int row, int col) {
//        for (int i = row - 1; i < row + 1; i++) {
//            for (int j = col - 1; j < col + 1; j++) {
//                // Rule 1
//                if()
//            }
//        }
//    }
}
