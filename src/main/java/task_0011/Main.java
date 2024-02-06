package task_0011;

//In the 20 x 20 grid below, four numbers along a diagonal line have been marked in red (input.html)

//The product of these numbers is 26x63x78x14 = 1788696

//What is the greatest product of four adjacent numbers in the same direction (up, down, left, right or diagonally


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    public static final Path RELATIVE_PATH = Paths.get("src/main/java/task_0011/input.txt");
    public static final int NUMBER_OF_ADJACENT_NUMBERS = 4;

    public static void main(String[] args) {

        //načtení dat ze souboru
        List<String> fetchedLines = new ArrayList<>();
        try {
            fetchedLines = Files.readAllLines(RELATIVE_PATH.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("File reading error: " + e.getLocalizedMessage());
        }

        //převedení na číselné pole
        int[][] grid = convertListTo2DArray(fetchedLines);

        //výpočet a uložení výsledků
        List<Integer> results = new ArrayList<>(4);
        results.add(checkHorizontally(grid));
        results.add(checkVertically(grid));
        results.add(checkRisingDiagonal(grid));
        results.add(checkFallingDiagonal(grid));

        //výpis
        System.out.println("Answer: " + Collections.max(results));
    }


    private static int[][] convertListTo2DArray(List<String> stringList) {
        int[][] convertedArray = new int[stringList.size()][20];

        for (int i = 0; i < stringList.size(); i++) {
            String[] numbers = stringList.get(i).split(" ");

            for (int j = 0; j < numbers.length; j++) {
                convertedArray[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        return convertedArray;
    }

    private static int checkHorizontally(int[][] grid) {
        int maxProduct = 0;

        for (int[] ints : grid) {
            int product;
            for (int column = 0; column < ints.length - NUMBER_OF_ADJACENT_NUMBERS; column++) {
                product = ints[column];
                for (int k = 1; k < NUMBER_OF_ADJACENT_NUMBERS; k++) {
                    product *= ints[column + k];
                }
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    private static int checkVertically(int[][] grid) {
        int product;
        int maxProduct = 0;
        for (int row = 0; row < grid.length - NUMBER_OF_ADJACENT_NUMBERS; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                product = grid[row][column];
                for (int k = 1; k < NUMBER_OF_ADJACENT_NUMBERS; k++) {
                    product *= grid[row + k][column];
                }
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    private static int checkRisingDiagonal(int[][] grid) {
        int product;
        int maxProduct = 0;
        for (int row = NUMBER_OF_ADJACENT_NUMBERS; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length - NUMBER_OF_ADJACENT_NUMBERS; column++) {
                product = grid[row][column];
                for (int k = 1; k < NUMBER_OF_ADJACENT_NUMBERS; k++) {
                    product *= grid[row - k][column + k];
                }
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    private static int checkFallingDiagonal(int[][] grid) {
        int product;
        int maxProduct = 0;
        for (int row = 0; row < grid.length - NUMBER_OF_ADJACENT_NUMBERS; row++) {
            for (int column = 0; column < grid[row].length - NUMBER_OF_ADJACENT_NUMBERS; column++) {
                product = grid[row][column];
                for (int k = 1; k < NUMBER_OF_ADJACENT_NUMBERS; k++) {
                    product *= grid[row + k][column + k];
                }
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }


}
