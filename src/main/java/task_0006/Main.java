package task_0006;

//The sum of the squares of the first ten natural numbers is: 1(pow2) + 2(pow2) + ... + 10(pow2) = 385

//The square of the sum of the first ten natural numbers is: (1+2+...+10)(pow2) = 55(pow2) = 3025
//
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is:
// 3025-385 = 2640
//.
//
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

import java.util.stream.IntStream;

public class Main {

    private static final int LIMIT = 100;

    private static int getSumOfSquares() {
        return IntStream
                .rangeClosed(1, Main.LIMIT)
                .map(n -> n * n)
                .sum();
    }

    private static int getSquareOfTheSum() {
        int sum = IntStream
                .rangeClosed(1, Main.LIMIT)
                .sum();
        return sum * sum;
    }

    public static void main(String[] args) {

        int difference = getSquareOfTheSum() - getSumOfSquares();

        System.out.println("Answer: " + difference);

    }
}
