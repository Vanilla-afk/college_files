/**
 Name: Malaluan, Arvin R.
 Date: October 25, 2022
 Program that reads data from a datafile (textfile).

 Create a program that reads contact details that are
 in a text file. The data read from the datafile
 are then displayed on the output screen.
 The details are written in the
 text file that has the names.txt
 The data in the file are in the following order:
 name
 address
 contact number

 Sample content of names.txt
 John
 Baguio City
 092100111222
 Kris
 Quezon City
 091522233333

 Input: Contact Data in a datafile
 Output: Data read displayed on the output screen
 Process:
 1. Declare the variables name, address and number
 and initialize each variable to an empty string.

 2. Declare fileReader as Scanner with the initial value null

 3.Print the header for the data that are to be shown on the screen

 4. try
 4.1. Open the file by letting
 fileReader be a Scanner object that points to the datafile
 4.2. While the fileReader is pointing to a string in the data file
 4.2.1. Read the string and store it to name
 4.2.2. Read the next string and store it to address
 4.2.3. Read the next string and store it to number
 4.2.4. Print the name, address and number
 4.2.5. Repeat 4.2.
 5. Close the file opened

 */

package Midterm.Samples;
import java.util.Scanner;
import java.io.*;

public class Contacts {
    public static void main(String[] args) {
        String name = "";
        String address = "";
        String number = "";
        Scanner fileReader = null;
        System.out.printf("%-20s%-25s%-15s%n", "Name", "Address", "Number");

        try {
            fileReader = new Scanner(new File("names.txt"));
            while (fileReader.hasNext()) {
                name = fileReader.nextLine();
                address = fileReader.nextLine();
                number = fileReader.nextLine();
                System.out.printf("%-20s%-25s%-15s%n", name, address, number);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        fileReader.close();  /*Note: After using an opened file
                                it is important to close the file.*/
        System.exit(0);
    } // end of main method
}
