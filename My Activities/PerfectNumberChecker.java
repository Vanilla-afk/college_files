/**
 Name: Malaluan, Arvin R.
 Class Code & Schedule: 9415A, 11:30 - 12:30pm (M,W)
 Date: October 21, 2022

 If the sum of the factors of the integer n, that are less than n,
 is equal to n, n is a perfect number.

 For example, 6 is a perfect number because the factors of 6
 that are less than 6 are 1,2 and 3 and the sum of these
 factors (1+2+3) is equal to 6.

 Because the factors of 28 that are less than 28 are 1, 2, 4, 7
 and 14 and that 1+2+4+7+14 is 28, 28 is a perfect number.

 The following is a program that allows the user to enter
 a positive integer in the range 1 to 32000.  The computer will
 then state whether the number is perfect number or not.
 */

package Midterm.Samples;
import java.util.*;

public class PerfectNumberChecker {
    /**
     Method that returns true if a number f is a factor
     of a number n
     */
    public static boolean isFactor(int f, int n){
        if (n%f == 0)  // n divided by f yields a 0 remainder
            return true;
        else
            return false;
    }

    /**
     Method that returns the sum of the factors of an
     integer n. Only the factors that are less than n
     are summed.
     */
    public static int sumFactors(int n) {
        int sum=0; // initialize sum of factors to 0
        for (int x=1; x<=n/2; x++) {
            if (isFactor(x,n))  // Invoke the isFactor method
                sum = sum + x; // add x to sum because x is a factor
        }
        return sum;
    }

    /**
     Method that returns true if an integer n is a perfect number.
     */
    public static boolean isPerfect (int n) {
        if ( sumFactors(n) == n )  // Invoke sumFactors method
            return true;  // because sum of factors(< n) is n
        else
            return false;
    }

    /**
     Method that reads an returns an integer in the range 1 to
     a specified limit.
     */
    static public int readNumber(String promptMessage, int limit){
        Scanner keyboard = new Scanner(System.in);
        int n=0;
        boolean invalidValueIsEntered=false;
        do {
            try {
                System.out.print(promptMessage + " : ");
                n = keyboard.nextInt();
                invalidValueIsEntered=false;
                if (n>=limit) {
                    System.out.println("You have entered a number beyond the limit.  You have to enter a number that is lower than "+ limit + ".");
                    invalidValueIsEntered=true;
                }
            } catch (NumberFormatException exception){
                System.out.println("You hvae entered an invalid number.");
                invalidValueIsEntered = true;
            }
        }while ( invalidValueIsEntered);

        return n;
    } // end of readNumber

    /**
     The main method reads and evaluate if a number is perfect
     */
    public static void main(String[] args) {

        int testNumber;
        testNumber = readNumber("Enter an integer that is not greater than 32000", 32000);
        if (isPerfect(testNumber)) {
            System.out.println(testNumber + " is a perfect number.");
        } else {
            System.out.println(testNumber + " is not a perfect number.");
        }
    }
}
