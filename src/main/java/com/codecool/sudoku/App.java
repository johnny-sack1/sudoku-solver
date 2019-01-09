//package com.codecool;

//import com.codecool.sudoku.Grid;
//import com.codecool.sudoku.Solver;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//public class App {
//    private static final int NUMOFTHREADS = Runtime.getRuntime().availableProcessors();
//
//    public static void main(String[] args) {
//        System.out.println("THREADS: " + NUMOFTHREADS);
//        long start = System.nanoTime();
//        Grid grid= new Grid();
//        grid.setValue(0, 3, 2);
//        grid.setValue(0, 7, 3);
//        grid.setValue(0, 8, 1);
//        grid.setValue(1, 4, 6);
//        grid.setValue(1, 6, 4);
//        grid.setValue(2, 0, 2);
//        grid.setValue(2, 1, 8);
//        grid.setValue(2, 3, 1);
//        grid.setValue(3, 0, 5);
//        grid.setValue(3, 2, 2);
//        grid.setValue(3, 4, 4);
//        grid.setValue(3, 7, 7);
//        grid.setValue(4, 0, 4);
//        grid.setValue(4, 8, 2);
//        grid.setValue(5, 1, 9);
//        grid.setValue(5, 4, 1);
//        grid.setValue(5, 6, 8);
//        grid.setValue(5, 8, 3);
//        grid.setValue(6, 5, 1);
//        grid.setValue(6, 7, 9);
//        grid.setValue(6, 8, 6);
//        grid.setValue(7, 2, 4);
//        grid.setValue(7, 4, 8);
//        grid.setValue(8, 0, 1);
//        grid.setValue(8, 1, 5);
//        grid.setValue(8, 5, 6);
//
//        solvePuzzle(grid);
//
//        grid.printGrid();
//        long end = System.nanoTime();
//        System.out.println((end - start) * 1e-6);
//    }
//
//    private static void solvePuzzle(Grid grid)
//    {
//        ExecutorService threadPool = Executors.newFixedThreadPool(NUMOFTHREADS);
//        List<Future<Boolean>> resultList = new ArrayList<>();
//        for (int i = 0;  i < NUMOFTHREADS; i++)
//        {
//            Solver solver = new Solver(grid);
            //Future<Boolean> result = threadPool.submit(solver);
            //resultList.add(result);
        //}
        //
        //for (Future<Boolean> future : resultList)
        //{
        //    try
        //    {
        //        if (!future.get())
        //        {
        //            threadPool.shutdown();
        //        }
        //    }
        //    catch (InterruptedException | ExecutionException ex)
        //    {
        //        ex.printStackTrace();
        //    }
        //}
        //
        //threadPool.shutdown();
    //}
//}