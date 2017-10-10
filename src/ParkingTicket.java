/*This application calculates charges for a parking garage. A $2.00 minimum fee to park up to 3 hours .
  The garage charges an additional $0.50 per hour for each hour, the maximum charge any given 24-hour period
  is $10.00, assuming that no car parks for longer than 24 hours at a time..
* */

import java.util.*;

public class ParkingTicket {
    /*Declaring constants. The constants and variables are being
      declared Static as they will be accessed from a Static context, i.e. the Static
      method calculateCharges
    */

    private static final double minTkt = 2.00;
    private static final int minHrs = 3;
    private static final double hourlyRate = 0.5;

    private static double y=0;
    private static double hourlyCost=0;

    //Scanner object used to read user entry/input

    private static Scanner numberOfHours = new Scanner(System.in);

    /*Method calculateCharges to calculate the cost of Parking tickets.
    The static keyword makes the method not dependent on objects but applies to the class as a whole.
    */


    private static double calculateCharges (int hoursEntered) {
        if (hoursEntered <= minHrs) {
            y = minTkt;

        }

        else if (hoursEntered > minHrs && hoursEntered<=24) {
            while (hoursEntered > 3) {
                if (hourlyCost==8)
                {break;}

                hourlyCost += hourlyRate;
                hoursEntered--;
            }

            y= hourlyCost + minTkt;

        }

        return y;

    }
    /*The main method is also a static method within the same class as the calculateCharges method,
    * so a method call can be made without being prepended by a class or object */

    public static void main (String [] args) {
        System.out.println("Please enter the number of parking hours: ");
        int numHrs = numberOfHours.nextInt();

        if (numHrs <= 24) {
            System.out.printf("The total parking charge is $%.2f", calculateCharges(numHrs));
        }

        else {
            System.out.println("You have entered over 24 Hours!!");
        }
    }

}
