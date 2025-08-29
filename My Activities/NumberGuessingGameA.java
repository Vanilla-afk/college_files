/*
Name: Malaluan, Arvin R.
Class Code and Schedule: 9415A, 11:30 - 12:30pm (M,W)
Date: October 20, 2022

This program allows the user to guess a randomly
    generated integer between 1 and 100 (inclusive).

    The user is given 3 chances to guess the number.
    For every guess that is not correct, the program tells
     the user to try something higher or lower, whichever
     is appropriate.
*/
package Midterm.Samples;
import javax.swing.*;
import java.util.Random;

public class NumberGuessingGameA {
    public static void main(String[] args) {
        showIntroduction();
        int secretNo = generateRandomNumber(100);
        int guess = 0;
        int guessCount=0;
        boolean gotIt = false;
        while (!gotIt && guessCount< 5) {
            guess = readGuess(100);
            guessCount +=1;
            if (areEqual(guess, secretNo)){
                gotIt = true;
                JOptionPane.showMessageDialog(null, "Congratulations! You won.");
            }
            else {
                gotIt = false;
                String stringToDisplay = "";
                if (guessCount >= 5){
                    stringToDisplay += "You have guessed for 5 times already!  No more chance to guess!";
                    stringToDisplay += "The secret num ber is "+ secretNo + ".\n";
                    stringToDisplay += "\nThank you for playing anyway";
                } else {
                    if (guess < secretNo )
                        stringToDisplay = "You have to enter a number that is greater than your previous guess.";
                    else
                        stringToDisplay = "You have to enter a number that is lower than your previous guess.";
                }
                JOptionPane.showMessageDialog(null, stringToDisplay);
            }
        } // end of while

        System.exit(0);
    } // end of main method

    /**
     * Returns true if number1 is equal to number2
     * */
    public static boolean areEqual(int number1, int number2){
        return (number1 == number2);
    }

    /**
     * Returns an integer in the range 1 to upperLimit that is randomly generated
     */
    public static int generateRandomNumber(int upperLimit){
        Random randomNumberGenerator = new Random();
        int result = 0;
        result = 1 + randomNumberGenerator.nextInt(100);
        return result;
    }

    /**
     * Shows an introductory message on the output screen
     * */
    public static void showIntroduction(){
        String stringToDisplay = "This is a simple game program. \n";
        stringToDisplay += "I have a secret whole number. \n";
        stringToDisplay += "You have to guess my number. \n";
        stringToDisplay += "You have at most 5 chances to guess my secret number";
        JOptionPane.showMessageDialog(null, stringToDisplay);
    }

    /**
     * Returns an integer in the range 1 to upperLimit
     * that is entered by the program user
     * */
    public static int readGuess(int upperLimit){
        int result= 0;
        String promptMessage = "Enter your guess of my secret number that falls in the range 1 to " + upperLimit+".";
        try {
            while (result < 1 || result > upperLimit) {
                result = Integer.parseInt(JOptionPane.showInputDialog(promptMessage));
                if (result < 1 || result > upperLimit){
                    JOptionPane.showMessageDialog(null, "You must enter a whole number that is in the range 1 to "+ upperLimit +".");
                }
            }
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "You have to enter a number.");
            result = 0;
        }
        return result;
    } // end of readGuess Method
}
