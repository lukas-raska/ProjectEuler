package task_0009;

//A Pythagorean triplet is a set of three natural numbers, a<b<c, for which a(pow2) + b(pow2) = c(pow2)

//For example : 3(pow2) + 4(pow2) = 9 + 16 = 25 = 5(pow2)

//There exists exactly one Pythagorean triplet for which a+b+c=1000

//Find the product abc

public class Main {

    public static void main(String[] args) {

        System.out.println("Answer: " + getProductOfSides());

    }


    public static int getProductOfSides() {
        int a;
        int b;
        int c;
        int product = 0;

        for (a = 1; a < 1000; a++) {
            for (b = 1; b < 1000; b++) {
                for (c = 1; c < 1000; c++) {
                    if (
                            a + b + c == 1000
                                    && a < b
                                    && b < c
                                    && a * a + b * b == c * c
                    ) {
                        return a * b * c;
                    }
                }
            }
        }
        throw new RuntimeException();
    }
}


