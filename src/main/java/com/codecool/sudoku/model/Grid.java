package com.codecool.sudoku.model;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class Grid {
    private final int SIZE = 9;
    private final int SUBGRID_SIZE = 3;
    private final int grid[][];
    private long time;

    public Grid() {
        grid = new int[SIZE][SIZE];
    }

    public int getValue(int row, int column) {
        return grid[row][column];
    }

    public void setValue(int row, int column, int value) {
        grid[row][column] = value;
    }

    public boolean isGridValid(int row, int column, int value) {
        int rowSubGrid = row / SUBGRID_SIZE * SUBGRID_SIZE;
        int columnSubGrid = column / SUBGRID_SIZE * SUBGRID_SIZE;

        for (int i = 0; i < SIZE; i++) {

            if (grid[row][i] == value) {
                return false;
            } else if (grid[i][column] == value) {
                return false;
            } else if (grid[rowSubGrid + i % SUBGRID_SIZE][columnSubGrid + i / SUBGRID_SIZE]
                == value) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(Grid grid) {
        if (grid.getGrid() == null || grid.getGrid().length != 9 || grid.getGrid()[0].length != 9)
            return false;
        // check each column
        for (int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (grid.getGrid()[i][j] != 0) {
                    if (m[(grid.getGrid()[i][j] - 1)]) {
                        return false;
                    }
                    m[(grid.getGrid()[i][j] - 1)] = true;
                }
            }
        }

        //check each row
        for (int j = 0; j < 9; j++) {
            boolean[] m = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (grid.getGrid()[i][j] != 0) {
                    if (m[(int) (grid.getGrid()[i][j] - 1)]) {
                        return false;
                    }
                    m[(int) (grid.getGrid()[i][j] - 1)] = true;
                }
            }
        }

        //check each 3*3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (grid.getGrid()[i][j] != 0) {
                        if (m[(int) (grid.getGrid()[i][j] - 1)]) {
                            return false;
                        }
                        m[(int) (grid.getGrid()[i][j] - 1)] = true;
                    }
                }
            }
        }

        return true;
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return this.time;
    }
}

