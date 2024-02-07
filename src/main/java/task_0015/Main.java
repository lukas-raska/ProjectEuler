package task_0015;

import java.math.BigInteger;

//starting in the top left corner of a 2x2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner
//How many such routes are there through a 20x20 grid
public class Main {

    public static void main(String[] args) {

        BigInteger numberOfPaths = getNumberOfPaths(20, 20);
        System.out.println("Answer: " + numberOfPaths);
    }

    public static BigInteger getNumberOfPaths(int x, int y) {
        return factorial(BigInteger.valueOf(x + y))
                .divide(factorial(BigInteger.valueOf(x)).multiply(factorial(BigInteger.valueOf(y))));
    }

    public static BigInteger factorial(BigInteger number) {
        if (number.equals(BigInteger.valueOf(1))) {
            return BigInteger.valueOf(1);
        }
        return number.multiply(factorial(number.subtract(BigInteger.valueOf(1))));
    }
}
