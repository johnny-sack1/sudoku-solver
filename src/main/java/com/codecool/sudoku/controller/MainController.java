package com.codecool.sudoku.controller;

import com.codecool.sudoku.Grid;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String get(Model model) {
        model.addAttribute("test", 1234);
        return "index";
    }
}
