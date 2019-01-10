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

