package task_0014;

//The following iterative sequence is defined for the set of positive integers:
//n-> n/2 (n is even)
//n-> 3n+1 (n is odd)

//Using the rule above and starting with 13, we generate the following sequence:

// 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1.

//It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been
// proved yet (Collatz problem), it is thought that all starting numbers finish at 1.

//Which starting number, under one million, produces the longest chain?

//NOTE: Once the chain starts the terms ar allowed to go above one million

import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {


    public static final int UPPER_LIMIT = 1000000;

    public static void main(String[] args) {

        int maxChainLength = 0;
        int searchedNumber = -1;

        for (int testedNumber = 1; testedNumber < UPPER_LIMIT; testedNumber++) {
            int length = getSequenceLength(testedNumber);
            if (length > maxChainLength) {
                maxChainLength = length;
                searchedNumber = testedNumber;
            }
        }
        System.out.println("Answer: " + searchedNumber);
    }

    public static int getSequenceLength(int testedNumber) {
        int chainLength = 1;
        long term = testedNumber;
        while (term > 1) {
            if (isEven(term)) {
                term /= 2;
            } else {
                term = 3 * term + 1;
            }
            chainLength++;
        }
        return chainLength;
    }

    public static boolean isEven(long number) {
        return number % 2 == 0;
    }

}

