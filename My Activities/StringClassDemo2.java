/**
 *Name: Malaluan, Arvin R.
 *Class Code and Schedule: 9415A, 11:30 - 12:30pm (M,W)
 *Date: October 21, 2022
 *
 *
 *Problem:
 *Write a program that for replacing every occurence of
 *a character by another character in a given String.
 *For example, if the given String is "Ako ay Pilipino"
 *and every occurrence of 'i' is replaced by 'o', the
 *program should produce "Ako ay Polopono".
 *
 Sample run:
 --------------------------------------------------------------
 Enter a string: Si Filimon, si Filimon, namasyal sa karagatan.
 What character would you like to replace? i
 What character should replace every i? a
 Original String: Si Filimon, si Filimon, namasyal sa karagatan.
 Modified String: Sa Falamon, sa Falamon, namasyal sa karagatan.
 ---------------------------------------------------------------
 Required: Complete the given program by providing
 what were missed. Write the complete program on
 your paper. Use a short bond paper.
 **/

package Midterm.Samples;
import java.util.*;

public class StringClassDemo2 {
    static Scanner kbd= new Scanner(System.in);

    public static String replaceChar(String s, char a, char b){
        String r="";
        for ( int x=0 ; x < s.length(); x++){
            if (s.charAt(x)== a)
                r = r+b;
            else
                r = r+s.charAt(x);
        }
        return r;
    }

    public static void main(String[] args){
        System.out.print("Enter a string: ");
        String input= kbd.nextLine();
        System.out.print("What character would you like to replace? ");
        char orig = kbd.nextLine().charAt(0);
        System.out.print("What character should replace every " + orig +"? ");
        char newChar = kbd.nextLine().charAt(0);

        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + replaceChar(input,orig,newChar));
        System.exit(0);
    }
}
