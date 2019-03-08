package projects.personal.bruteforce;

import java.util.Scanner;

/*
    Find and display all pairs of 5-digit numbers that collectively use the digits 0 through 9 once each, such that the
    first number divided by the second is equal to an integer N, where 2 ≤ N ≤ 79. That is, abcde / fghij = N, where each
    letter represents a different digit. The first digit of one of the numbers is allowed to be zero, e.g. forN = 62,
    we have 79546 / 01283 = 62; 94736 / 01528 = 62.
 */
public class Uva725Division {
    private static void getNumbers(int target) {
        for(int denominator = 1234; denominator <= 98765/target; denominator++) {
            int numerator = denominator * target;
            if(areNumbersUnique(numerator,denominator)) {
                System.out.println("numerator = " + numerator + " denominator = " + denominator);
            }
        }
    }

    private static boolean areNumbersUnique(int numerator, int denominator) {
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = 62;
        getNumbers(target);
    }
}
