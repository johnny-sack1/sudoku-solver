package com.codecool.sudoku.service;

import com.codecool.sudoku.model.Grid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.springframework.stereotype.Service;

@Service
public class SudokuSolverService {
    private static final int NUMOFTHREADS = Runtime.getRuntime().availableProcessors();
    private long time;

    public Grid solveSudoku() {
        Grid grid = new Grid();
        grid.setValue(0, 3, 2);
        grid.setValue(0, 7, 3);
        grid.setValue(0, 8, 1);
        grid.setValue(1, 4, 6);
        grid.setValue(1, 6, 4);
        grid.setValue(2, 0, 2);
        grid.setValue(2, 1, 8);
        grid.setValue(2, 3, 1);
        grid.setValue(3, 0, 5);
        grid.setValue(3, 2, 2);
        grid.setValue(3, 4, 4);
        grid.setValue(3, 7, 7);
        grid.setValue(4, 0, 4);
        grid.setValue(4, 8, 2);
        grid.setValue(5, 1, 9);
        grid.setValue(5, 4, 1);
        grid.setValue(5, 6, 8);
        grid.setValue(5, 8, 3);
        grid.setValue(6, 5, 1);
        grid.setValue(6, 7, 9);
        grid.setValue(6, 8, 6);
        grid.setValue(7, 2, 4);
        grid.setValue(7, 4, 8);
        grid.setValue(8, 0, 1);
        grid.setValue(8, 1, 5);
        grid.setValue(8, 5, 6);
        solvePuzzle(grid);
        grid.setTime(this.time);
        //System.out.println(Arrays.deepToString(grid.getGrid()));
        return grid;
    }

    private void solvePuzzle(Grid grid) {
        long caluclationTime = System.nanoTime();
        ExecutorService threadPool = Executors.newFixedThreadPool(NUMOFTHREADS);
        List<Future<Boolean>> resultList = new ArrayList<>();
        for (int i = 0; i < NUMOFTHREADS; i++) {
            SudokuSolver solver = new SudokuSolver(grid);
            Future<Boolean> result = threadPool.submit(solver);
            resultList.add(result);
        }

        for (Future<Boolean> future : resultList) {
            try {
                if (!future.get()) {
                    threadPool.shutdown();
                }
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }

        this.time = System.nanoTime() - caluclationTime;
        threadPool.shutdown();
    }
}
