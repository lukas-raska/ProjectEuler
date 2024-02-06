package task_0005;

//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

//What is the smallest positive number that is evenly divisible by all the numbers from 1 to 20.

public class Main {

    public static int MAX_DIVISOR = 20;

    public static boolean isEvenlyDivisible (int maxDivisor, int dividedNumber){
        for (int i = maxDivisor; i>1; i--){
            if (dividedNumber%i !=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int searchedNumber = 0;

        for (int i = MAX_DIVISOR; i<Integer.MAX_VALUE; i++){
            if (isEvenlyDivisible(MAX_DIVISOR, i)){
                searchedNumber=i;
                break;
            }
        }

        System.out.println("Answer: " + searchedNumber);
   }


}
