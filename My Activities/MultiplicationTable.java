/*
* Name: Malaluan, Arvin R.
* Date: October 20, 2022
*
* Create a program that will let the computer show
  a multiplication table with m rows and m columns.

  To generate the multiplication table,
  the main method should invoke a method

  with the following header:
  public static void showMultiplicationTable(int nRows, int nColumns)

  Sample Run:
 ----------------------
       M U L T I P L I C A T I O N    T A B L E
 1       2       3       4       5       6       7       8       9      10
 2       4       6       8      10      12      14      16      18      20
 3       6       9      12      15      18      21      24      27      30
 4       8      12      16      20      24      28      32      36      40
 5      10      15      20      25      30      35      40      45      50
 6      12      18      24      30      36      42      48      54      60
 7      14      21      28      35      42      49      56      63      70
 8      16      24      32      40      48      56      64      72      80
 9      18      27      36      45      54      63      72      81      90
 10     20      30      40      50      60      70      80      90     100

* */
package Midterm.Samples;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numberOfRows=0; // desired number of rows
        int numberOfColumns=0; // desired number of columns

        System.out.print("How many rows will the multiplication table have?: ");
        numberOfRows = Integer.parseInt(keyboard.nextLine());
        System.out.print("How many columns will the multiplication table have?: ");
        numberOfColumns = Integer.parseInt(keyboard.nextLine());
        System.out.println("          M U L T I P L I C A T I O N    T A B L E");

        showMultiplicationTable(numberOfRows,numberOfColumns);
        //Exercise: Show the implementation of this method.
        System.exit(0);
    }

    /**
     * Shows a typical multiplication table
     * with nRows rows and nColumns columns
     *
     * Let row index be from 1 to the desired number of rows
     * For each row, let column index be 1 to the desired number of columns
     * For each column, print the product of the row index and column index in an area with a fixed width
     * Let the cursor move down
     **/

    public static void showMultiplicationTable(int nRows, int nColumns) {
        for (int row = 1; row <= nRows; row++) {
            for (int column = 1; column <= nColumns; column++) {
                System.out.printf("%8d", row * column);
            }
            System.out.println();
        }
        return;
    }
}
