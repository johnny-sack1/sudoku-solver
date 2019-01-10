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
    private Grid grid;

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public long getTime() {
        return this.time;
    }

    public void solvePuzzle() {
        long caluclationTime = System.nanoTime();
        ExecutorService threadPool = Executors.newFixedThreadPool(NUMOFTHREADS);
        List<Future<Boolean>> resultList = new ArrayList<>();
        for (int i = 0; i < NUMOFTHREADS; i++) {
            SudokuSolver solver = new SudokuSolver(this.grid);
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
