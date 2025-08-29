/*
Name: Malaluan, Arvin R.

Algorithm (Simplified Water Bill Computation)
The bill for a electric service subscriber is prepared as follows:
1. Read the name of the electric consumer (consumer).
2. Read previous electric power consumption in kilowatt hour (previousR).
3. Read the present electric power consumption in kilowatt hour (presentR). presentR cannot be less than the previous.
4. Compute the total electric power consumption (consumption) by subtracting the previousR from presentR.
5. Read The classification (cType) of the consumer (commercial or residential).
6. Compute the amount due (amountDue) from the consumer based on the following rules
If cType is residential and consumption <= 12,
the amount due is 180.00
If cType is residential and consumption > 12,
the amount due is 180.00 + (consumption – 12) * 30.00
If cType is commercial and consumption <= 30,
the amount due is 600.00
If cType is commercial and consumption > 30,
the amount due is 600.00 + (consumption – 30) * 50.00
7. Print the name of the consumer, the consumer type, the readings, the consumption and the amount due.
 */

package Midterm.Samples;
import java.lang.*;
import java.util.*;

public class ElectricBill {
    public static void main(String[] args) {
        int presentReading = 0, previousReading = 0;
        Scanner kbd = new Scanner(System.in);
        String consumer = "";
        char cType = 'x';
        int nCMUsed;
        int minCMResidential = 12;
        double minBillResidential = 180.00;
        float rateResidential = 30.00F;
        int minCMCommercial = 30;
        double minBillCommercial = 600.00;
        float rateCommercial = 50.00F;
        double amountDue = 0.0;

        showIntroduction();
        System.out.print("Enter the name of the electric consumer: ");
        consumer = kbd.nextLine();
        previousReading = readPreviousReading();
        presentReading = readPresentReading(previousReading);
        nCMUsed = presentReading - previousReading;
        cType = readTypeOfConsumer();
        amountDue = computeAmountDue(nCMUsed, cType, minCMResidential,
                minBillResidential, minCMCommercial,
                minBillCommercial, rateResidential,
                rateCommercial);
        showBill(consumer, cType, previousReading, presentReading, nCMUsed,
                amountDue);
        System.exit(0);

    }

    public static void showBill(String n, char t, int previous, int present,
                                int c, double amount){
        System.out.println();
        System.out.println("Electric Billing Statement");
        System.out.println("Name of the Consumer: " + n);
        System.out.print("Type of consumer: ");
        if (Character.toLowerCase(t) == 'R')
            System.out.println("Residential");
        if (Character.toLowerCase(t) == 'C')
            System.out.println("Commercial");
        System.out.println("KWh reading last month = " + previous +
                "KWh");
        System.out.println("KWh reading last month = " + present +
                "KWh");
        System.out.println("KWh Consumed = " + c + "KWh");
        System.out.println("Amount Due = Php " + amount);
        return;
    }

    public static void showIntroduction() {
        System.out.println("This program will prepare a bill for a electric " +
                "distribution consumer.");
        System.out.println("You will ne asked to enter the name of the" +
                "consumer,\n\tthe electric consumption reading last month, " +
                "\n\t and the electric reading this month.");
        System.out.println();
        return;
    }
    public static int readPreviousReading() {
        int reading = 0;
        Scanner kbd = new Scanner(System.in);
        do {
            System.out.print("Enter the electric reading last month: ");
            reading = Integer.parseInt(kbd.nextLine());
            if (reading < 0) {
                System.out.println("The meter reading cannot be negative.");
            }
        } while (reading < 0);
        return reading;
    }

    public static int readPresentReading(int previous) {
        int reading = 0;
        Scanner kbd = new Scanner(System.in);

        do {
            System.out.print("Enter the electric reading for this month: ");
            reading = Integer.parseInt(kbd.nextLine());
            if (reading < previous) {
                System.out.println("Invalid data entry! The present reading " +
                        "must be greater than the previous reading.");
            }
        } while (reading < previous);
        return reading;
    }

    public static char readTypeOfConsumer() {
        char t = 'x';
        Scanner kbd = new Scanner(System.in);

        do {
            System.out.print("Enter the type of the consumer< you may type R " +
                    "for residential or C for commercial>: ");
            String input = kbd.nextLine();
            t = input.charAt(0);
            if (t != 'r' && t != 'R' && t != 'c' && t != 'C') {
                System.out.println("The valid types are R for residential " +
                        "and C for commercial.");
            }
        } while (t != 'r' && t != 'R' && t != 'c' && t != 'C');
        return t;
    }

    public static double computeAmountDue(int c, char t, int min1, double minB1,
                                          int min2, double minB2, float rate1,
                                          float rate2) {
        double amount = 0;
        switch (t) {
            case 'r':
            case 'R':
                if (c <= min1) {
                    amount = minB1;
                } else {
                    amount = minB1 + (c - min1) * rate1;
                }
                break;

            case 'c':
            case 'C':
                if (c <= min2) {
                    amount = minB2;
                } else {
                    amount = minB2 + (c - min2) * rate2;
                }
        }
        return amount;
    }
}
