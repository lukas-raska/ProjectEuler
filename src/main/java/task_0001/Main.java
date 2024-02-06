package task_0001;

//Problem 1
//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
// The sum of these mulitples is 23.
//Find the sum of all multiples of 3 or 5 below 1000.

import java.util.Arrays;
import java.util.stream.IntStream;


public class Main {

    public static int[] specifiedMultiples = {3, 5};
    public static int lowerLimit = 0;
    public static int upperLimit = 1000;

    public static void main(String[] args) {

        int sumOfMultiples = IntStream
                .range(lowerLimit, upperLimit)
                .filter(x -> Arrays.stream(specifiedMultiples).anyMatch(multiple -> x % multiple == 0))
                .sum();

        System.out.println("Answer: " + sumOfMultiples);
    }

}
