/*
* Name: Malaluan, Arvin R.
* Date: September 30, 2022
*
* OBJECTIVE:
* Create a program that has a method that is invoked by the main method
*
*
* Create a program that computes and displays the grade that is corresponding
* to a given score based on the following specifications:
*
* The grade is the integer value of (rawScore/perfectScore * 50 +50 )
*
* The perfectScore is an input by the program user at runtime.
* The perfectScore should be validated such that a perfectScore that is
*    0 or negative should let the program user re-enter a valid perfectScore.
*
* The rawScore is an input by the program user at runtime.
* The rawScore should be validated such that a rawScore that is greater than the
*  perfectScore should let the program user re-enter a valid rawScore.
*  In addition, a rawScore that is less than 0 should let the program user
*  re-enter a valid rawScore.
*
* The program execution will stop only if the user answers no to the question
*   Do you want to compute another grade<Yes/No> ?
*
*
*
* */package Midterm.Samples;

import java.util.Scanner;

public class GradeCalculator1 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        int rawScore = 0;
        int perfectScore = 0;
        int grade = 50;

        boolean computeAgain = true;
        while (computeAgain) {
            do {
                System.out.print("ENTER THE PERFECT SCORE: ");
                perfectScore = Integer.parseInt(kbd.nextLine());
                if (perfectScore <= 0) {
                    System.out.print("The perfect score should be greater than 0. Please enter valid perfect score.");
                }
            } while (perfectScore <= 0);

            do {
                System.out.print("ENTER A RAW SCORE: ");
                rawScore = Integer.parseInt((kbd.nextLine()));
                if (rawScore > perfectScore) {
                    System.out.println("\nThe raw score cannot be higher than the perfect score. \nPlease Enter valid raw score");
                }
                else if (rawScore < 0) {
                    System.out.println("\nThe raw score cannot be lower than 0. \nPlease Enter valid raw score");
                }

            } while (rawScore < 0 || rawScore > perfectScore);

            grade = (int) ((double) rawScore / (double) perfectScore*50 + 50);

            System.out.println("Grade = " + grade);
            System.out.println("\nDo you want to compute again<Yes/No>?");
            String answer = kbd.nextLine();
            if (answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
                computeAgain = true;
            } else {
                computeAgain = false;
            }
        }
    }
}
