/*
* Name: Malaluan, Arvin R.
* Class Code and Schedule: 9451A (11:30 - 12:30am)
* Date: November 1, 2022
*
* Problem:
* Improve the application for computing the interest (MoneyInBank.java) so that the
* application can handle deposit and withdrawal transactions within the year. When executed,
* the program should let the computer display a menu of operations from which the user may
* choose from. One menu item should be <Make a Deposit to account>. One menu item should
* be <Withdraw from account>. One menu item should be <Show the data associated with the
* account at the end of each quarter within a year>. One menu item is <Quit the application>.
*
*
*
*
*
*
* */
package Midterm.Exercise;
import java.io.IOException;
import java.lang.*;
import java.util.*;

public class MoneyInBank {
    public static void main(String[] args) {
        double account = 0.0;
        int x = 10;
        do {
            x = menu();
            switch (x) {
                case 1:
                    account = makeAccountDeposit(account);
                    break;
                case 2:
                    account = makeAccountWithdrawal(account);
                    break;
                case 3:
                    account = checkAccountData(account);
                    break;
                case 4:
                    System.out.println("Thank you for using the Application!");
                    System.out.println("Closing application...");
                    System.exit(0);
                    break;
            }
        } while (x != 0);
    }

    public static int menu() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("---------------------------------");
        System.out.println("(1) Deposit to account");
        System.out.println("(2) Withdraw from account");
        System.out.println("(3) Show the data associated with the account " +  "at the end of each quarter within a year");
        System.out.println("(4) Quit the application");
        System.out.println("---------------------------------");
        System.out.print("Input here: ");
        int input = Integer.parseInt(kbd.nextLine());
        return input;
    }

    public static double makeAccountDeposit(double account) {
        int deposit = 0;
        boolean denomination = false;
        int checker = 0;
        Scanner kbd = new Scanner(System.in);
        do {
            System.out.print("Enter amount to deposit (100, 500, 1000 denominations only): ");
            deposit = Integer.parseInt(kbd.nextLine());
            checker = deposit % 100;
            if (checker != 0)
                System.out.println("Enter amounts in 100, 500, 1000 denominations only. Try Again.");
            if (deposit < 100)
                System.out.println("Deposit amount should be greater than or equal to 100. Try Again.");
            if (deposit >= 100 && checker == 0) {
                account += deposit;
                System.out.println("Deposited " + deposit + " to account.");
                System.out.println("Your new balance is " + account + ".");
                System.out.println("---------------------------------");
                denomination = true;
            }
        } while (denomination == false || deposit < 100 || checker != 0);
        return account;
    }

    public static double makeAccountWithdrawal(double account) {
        int withdraw = 0;
        double checker = 0.0;
        boolean denomination = false;
        Scanner kbd = new Scanner(System.in);
        do {
            System.out.print("Enter amount to withdraw (100, 500, 1000 denominations only): ");
            withdraw = Integer.parseInt(kbd.nextLine());
            checker = withdraw % 100;
            if (account == 0) {
                System.out.println("Sorry. You have 0.00 balance in your account.");
                System.out.println("You will be returned to the menu...");
                System.out.println("---------------------------------");
                denomination = true;
            } else if (checker != 0)
                System.out.println("You can withdraw amounts in 100, 500, 1000 denominations only. Try Again.");
            else if (withdraw > account)
                System.out.println("You cannot withdraw more than your account balance. Try Again.");
            else if (withdraw <= account && checker == 0) {
                account -= withdraw;
                System.out.println("Withdrawn " + withdraw + " from account.");
                System.out.println("Your new balance is " + account + ".");
                System.out.println("---------------------------------");
                denomination = true;
            }
        } while (denomination == false || checker != 0);
        return account;
    }

    public static double checkAccountData(double account) {
        Scanner kbd = new Scanner(System.in);
        int n = 4;
        double interest;
        double principal = account;
        double quarterlyRate = 0.0125;
        double finalAmount;

        for (int x = 1; x <= n; x++) {
            interest = principal * quarterlyRate;
            finalAmount = principal + interest;
            principal = finalAmount;
            System.out.printf("%s%d%s%.2f%s%n", "Your balance at the end of quarter ", x, " will be ", finalAmount, ".");
        }
        System.out.println("---------------------------------");
        return account;
    }
}

