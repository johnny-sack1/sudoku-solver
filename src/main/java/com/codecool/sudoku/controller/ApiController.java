package com.codecool.sudoku.controller;

import com.codecool.sudoku.model.Grid;
import com.codecool.sudoku.service.FileParser;
import com.codecool.sudoku.service.SudokuSolverService;
import java.io.IOException;
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
    //private FileParser parser;

    @Autowired
    public ApiController(SudokuSolverService solverService) {
        this.solverService = solverService;
    }

    @PostMapping(value = "api/grid")
    public Grid setGrid(@RequestParam("file") MultipartFile file) throws IOException {

        String fileContent = new String(file.getBytes());
        Grid grid = (new FileParser(fileContent)).getStartingGrid();
        this.solverService.setGrid(grid);
        Grid grid1 = this.solverService.getGrid();
        System.out.println(grid1);
        return grid1;
    }

    @GetMapping(value = "api/grid", produces = MediaType.APPLICATION_JSON_VALUE)
    public Grid getGrid() {
        this.solverService.solvePuzzle();
        return this.solverService.getGrid();
    }
}
