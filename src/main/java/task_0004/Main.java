package task_0004;

//A palindromic number reads the same both ways.
// The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99

//Find the largest palindrome made from the product of two 3-digit number

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Answer: " + getLargestPalindrom(999));

    }

    public static int getLargestPalindrom (int maxNumber){
        List<Integer>palindromeList = new ArrayList<>();
        for (int i = maxNumber; i>100; i--){
            for(int j = maxNumber; j>100; j--){
                if (isPalindrome(i*j)){
                    palindromeList.add(i*j);
                }
            }
        }
        System.out.println(palindromeList.size());
        return Collections.max(palindromeList);
    }

    public static boolean isPalindrome(int number) {
        String numberStr = String.valueOf(number);
        return numberStr.equals(reverseString(numberStr));
    }


    public static String reverseString(String input) {
        StringBuilder original = new StringBuilder(input);
        return original.reverse().toString();
    }
}

