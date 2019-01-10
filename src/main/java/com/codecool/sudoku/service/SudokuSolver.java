package com.codecool.sudoku.service;

import com.codecool.sudoku.model.Grid;
import java.util.concurrent.Callable;

public class SudokuSolver implements Callable<Boolean> {

    private final Grid grid;

    public SudokuSolver(Grid grid) {
        this.grid = grid;
    }

    @Override
    public Boolean call() {
        return runSolver(0);
    }

    private boolean runSolver(int cell) {
        synchronized (grid) {
            int GRID_SIZE = 9;
            if (cell == (GRID_SIZE * GRID_SIZE)) {
                return true;
            }

            int row = cell / GRID_SIZE;
            int column = cell % GRID_SIZE;

            if (grid.getValue(row, column) != 0) {
                return runSolver(cell + 1);
            }

            for (int value = 1; value <= GRID_SIZE; value++) {
                if (grid.isGridValid(row, column, value)) {
                    grid.setValue(row, column, value);

                    if (runSolver(cell + 1)) {
                        return true;
                    }

                    grid.setValue(row, column, 0);
                }
            }

            return false;
        }
    }
}
