package task_0017;

//If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3+3+5+4+4=19 letters used in total.

//If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static final int UPPER_LIMIT = 1000;
    public static final int LOWER_LIMIT = 1;

    public static void main(String[] args) {

        NumberConvertor convertor = new NumberConvertor();

        int result = IntStream
                .rangeClosed(LOWER_LIMIT, UPPER_LIMIT)
                .mapToObj(convertor::convertNumberToWord)
                .map(n -> n.replaceAll("[-\\s]+", ""))
                .mapToInt(String::length)
                .sum();

        System.out.println("Answer: " + result);
    }

}




