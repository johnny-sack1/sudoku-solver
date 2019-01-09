package com.codecool.sudoku.controller;

import com.codecool.sudoku.Grid;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping(value = "api")
    public Grid getGrid() {
        return new Grid();
    }
}
