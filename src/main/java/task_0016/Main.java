package task_0016;

//2^15 = 32768 and the sum of its digits is 3+2+7+6+8=26
//What is the sum of the digits of the number 2^1000?

import java.math.BigInteger;

public class Main {

    public static final int BASE = 2;
    public static final int EXPONENT = 1000;

    public static void main(String[] args) {

        System.out.println("Answer: " + sumOfDigits(pow(BASE,EXPONENT).toString()));
    }

    public static BigInteger pow(int base, int power) {
        return BigInteger
                .valueOf(base)
                .pow(power);
    }
    public static int sumOfDigits(String number) {
        return number
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
