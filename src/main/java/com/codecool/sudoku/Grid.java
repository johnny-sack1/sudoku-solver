package com.codecool.sudoku;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class Grid extends JsonSerializer<Grid> {
    private final int SIZE = 9;
    private final int SUBGRID_SIZE = 3;
    private final int grid[][];

    public Grid() {
        grid = new int[SIZE][SIZE];
    }

    @Override
    public void serialize(Grid grid, JsonGenerator jsonGenerator,
        SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("grid");
        jsonGenerator.writeObject(this.grid);
        jsonGenerator.writeEndObject();
    }

    //private String generateJsonGrid() {
    //    for (int[] i : this.grid) {
    //        for (int j : i) {
    //
    //        }
    //    }
    //}

    int getValue(int row, int column) {
        return grid[row][column];
    }

    void setValue(int row, int column, int value) {
        grid[row][column] = value;
    }

    public void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            if (i % SUBGRID_SIZE == 0 && i != 0) {
                System.out.println();
            }

            for (int j = 0; j < SIZE; j++) {
                if (j % SUBGRID_SIZE == 0 && j != 0) {
                    System.out.print("|");
                }

                System.out.printf("%2d ", grid[i][j]);
            }
            System.out.println();
        }
    }

    boolean isGridValid(int row, int column, int value) {
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
}

