/**
 Name: Malaluan, Arvin R.
 Class Code & Schedule: 9415A, 11:30 - 12:30pm (M,W)
 Date: October 21, 2022
 *
 *Write a program that will let the computer asks the
 * user to enter a string that is a name of a product
 * at run-time.
 *
 * If the name of product entered is not one of
 *   "sugar", "milk", "pants", "shirt", "paper" or "pen",
 *    the computer should give a message telling the user that
 *    "<product> IS NOT AVAILABLE".
 *
 * If the name of the product is "sugar" or "milk",
 *    the computer will display the message "Please proceed to  GROCERIES area."
 *
 * If the name of the product is "pants" or "shirt",
 *    the computer will display the message "Please proceed to the DRY GOODS area."
 *
 * If the name of the product is "paper" or "pen",
 *    the computer will display the message "Please proceed to the SCHOOL SUPPLIES area."
 *
 * */

package Midterm.Samples;
import javax.swing.*;

public class StringValidationDemoA {
    public static void main(String[] args) {
        String productName="";
        productName = JOptionPane.showInputDialog("Please type a name of a product.");
        if (!isFound(productName)){
            JOptionPane.showMessageDialog(null, productName+" is not available");
        }  else {
            giveDirection(productName);
        }
        System.exit(0);
    }

    public static boolean isFound(String pName){
        boolean result = false;
        if (pName.equalsIgnoreCase("pants") || pName.equalsIgnoreCase(
                "shirt") || pName.equalsIgnoreCase("milk") ||
                pName.equalsIgnoreCase("sugar") || pName.equalsIgnoreCase("paper")
                || pName.equalsIgnoreCase("pen"))
            result = true;
        return result;
    }

    public static void giveDirection(String pName) {
        if (pName.equalsIgnoreCase("paper") || pName.equalsIgnoreCase("pen"))
            JOptionPane.showMessageDialog(null, "Please proceed to the SCHOOL SUPPLIES area.");
        else if (pName.equalsIgnoreCase("milk") || pName.equalsIgnoreCase("sugar"))
            JOptionPane.showMessageDialog(null, "Please proceed to the GROCERIES area.");
        else
            JOptionPane.showMessageDialog(null, "Please proceed to the DRY GOODS area.");
    }
}
