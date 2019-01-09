package com.codecool;

public final class Grid
{
    private final int SIZE = 9;
    private final int SUBGRID_SIZE = 3;
    private final int grid[][];

    public Grid()
    {
        grid = new int[SIZE][SIZE];
    }

    public int getValue(int row, int column)
    {
        return grid[row][column];
    }

    public void setValue(int row, int column, int value)
    {
        grid[row][column] = value;
    }

    public void printGrid()
    {
        for (int i = 0; i < SIZE; i++)
        {
            if (i % SUBGRID_SIZE == 0 && i != 0)
            {
                System.out.println("");
            }

            for (int j = 0; j < SIZE; j++)
            {
                if (j % SUBGRID_SIZE == 0 && j != 0)
                {
                    System.out.print("|");
                }

                System.out.printf("%2d ", grid[i][j]);
            }
            System.out.println("");
        }
    }

    public boolean isGridValid(int row, int column, int value)
    {
        int rowSubGrid = row / SUBGRID_SIZE * SUBGRID_SIZE;
        int columnSubGrid = column / SUBGRID_SIZE * SUBGRID_SIZE;

        for (int i = 0; i < SIZE; i++)
        {

            if (grid[row][i] == value)
            {
                return false;
            }
            else if (grid[i][column] == value)
            {
                return false;
            }
            else if (grid[rowSubGrid + i % SUBGRID_SIZE][columnSubGrid + i / SUBGRID_SIZE] == value)
            {
                return false;
            }
        }

        return true;
    }
}

