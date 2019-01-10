package com.codecool.sudoku.controller;

import com.codecool.sudoku.model.Grid;
import com.codecool.sudoku.service.SudokuSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ApiController {

    private SudokuSolverService solverService;

    @Autowired
    public ApiController(SudokuSolverService solverService) {
        this.solverService = solverService;
    }

    @PostMapping(value = "api/grid")
    public String setGrid(@RequestParam("file") MultipartFile file) {
        // manipulate file
        return "";
    }

    @GetMapping(value = "api/grid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Grid getGrid() {
        return this.solverService.solveSudoku();
    }

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
}
