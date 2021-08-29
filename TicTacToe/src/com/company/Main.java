package com.company;
import java.util.Scanner;
public class Main {

    private final static String LINE = "---------";
    private final static String FIELD = "| %c %c %c |";
    private static boolean cont = true;
    private static int counterEmpty = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] grid = new int[3][];

        grid[0] = new int[]{' ', ' ', ' '};
        grid[1] = new int[]{' ', ' ', ' '};
        grid[2] = new int[]{' ', ' ', ' '};

        printGrid(grid);        // print empty board
        int counter = 0;

        //request coordinates and win draw
        while (cont) {
            System.out.println("Enter the coordinates: ");                 // enter coordinates
            String[] coordinates = scanner.nextLine().split(" ");       // coord before space - coord after space
            int x, y;

            try {
                x = Integer.parseInt(coordinates[0]);
                y = Integer.parseInt(coordinates[1]);
                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (grid[x - 1][y - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    counterEmpty++;
                    if (counter % 2 == 0) {
                        grid[x - 1][y - 1] = 'X';
                        printGrid(grid);
                        playerHasWon(grid,counterEmpty);
                        counter++;
                        continue;
                    } else {
                        grid[x - 1][y - 1] = 'O';
                        printGrid(grid);
                        playerHasWon(grid,counterEmpty);
                        counter++;
                        continue;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nYou should enter numbers!");
            }
        }
    }
    //print grid
    private static void printGrid(int[][] grid) {
        System.out.println(LINE);
        for (int[] row : grid) {
            System.out.printf(FIELD, row[0], row[1], row[2]);
            System.out.println();
        }
        System.out.println(LINE);
    }
    //win - draw
    private static void playerHasWon(int[][] grid, int counterEmpty) {
        //Check each row
        int draw = 0;
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != ' ') {
                if (grid[i][0] == 'X') {
                    System.out.println("X wins");
                    cont = false;
                    draw = 1;
                } else {
                    System.out.println("O wins");
                    cont = false;
                    draw = 1;
                }
            }
        }
        //Check each column
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j] && grid[0][j] != ' ') {
                if (grid[0][j] == 'X') {
                    System.out.println("X wins");
                    cont = false;
                    draw = 1;
                } else {
                    System.out.println("O wins");
                    cont = false;
                    draw = 1;
                }
            }
        }
        //Check the diagonals
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ') {
            if (grid[0][0] == 'X') {
                System.out.println("X wins");
                cont = false;
                draw = 1;
            } else {
                System.out.println("O wins");
                cont = false;
                draw = 1;
            }
        }
        if (grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[2][0] != ' ') {
            if (grid[2][0] == 'X') {
                System.out.println("X wins");
                cont = false;
                draw = 1;
            } else {
                System.out.println("O wins");
                cont = false;
                draw = 1;
            }
        }
        if (draw == 0 && counterEmpty == 9) {
            System.out.println("Draw");
            cont = false;
        }
    }
}

