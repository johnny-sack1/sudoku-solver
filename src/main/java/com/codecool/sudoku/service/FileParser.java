package com.codecool.sudoku.service;

import com.codecool.sudoku.model.Grid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileParser {
    private String path;

    public FileParser(String path) {
        this.path = path;
    }

    private List<Integer> getParsedNumbers() throws IOException {
        List<String> strList = new ArrayList<>();
        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        while (line != null) {
            Collections.addAll(strList, line.split(""));
            line = br.readLine();
        }
        List<Integer> intList = new ArrayList<>();
        for (String aStrList : strList) {
            intList.add(Integer.parseInt(aStrList));
        }
        return intList;
    }

    public Grid getStartingGrid() {
        List<Integer> parsedNumbers = new ArrayList<>();
        try {
            parsedNumbers = getParsedNumbers();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Grid grid = new Grid();
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid.setValue(i, j, parsedNumbers.get(index));
                index++;
            }
        }

        return grid;
    }
}
