/**
 * Created by Ope on 12/12/16.
 *
 * This application prompts determines a person's Heart Rate and Targeted Heart Rate based on information that they provide when prompted.
 * The information includes: First Name, Last Name and Date of Birth (which is used to compute the person's age, which in turn is used to calculate the
 * Heart Rate, Maximum Heart Rate as well as Targeted Heart Rate.
 *
 * NB: The formula used for calculating the above was obtained from the American Heart Association (AHA)
 */


//Import statements for the classes used for the GUI
import java.lang.*;
import javax.swing.*;

//Class HeartRate declaration

public class HeartRate {

    //Instance variables declaration
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private int monthOfBirth;
    private int dayOfBirth;

    private int dateOfBirth;

    //Constructor declaration

    public HeartRate (String firstName, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;
        this.dateOfBirth = dateOfBirth;
    }

    //Method definition to set the respect instance variables

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setYearOfBirth(int yearOfBirth){
        this.yearOfBirth = yearOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth){
        this.monthOfBirth = monthOfBirth;
    }

    public void setDayOFBirth (int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setDateOfBirth (int dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    //Method definition to retrieve the values of the values passed to the instance variables
    public String getFirstName(){
        return firstName;

    }

    public String getLastName(){
        return lastName;
    }

    public int getYearOfBirth (){
        return yearOfBirth;

    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getDayOFBirth () {
        return dayOfBirth;
    }

    public int getDateOfBirth (){
        return dateOfBirth;
    }

    //Method calculating the person's age by subtracting the date of birth from the present year (2016)

    public int personAge (int yearOfBirth){
        this.yearOfBirth = yearOfBirth;
        int age = (2016 - this.yearOfBirth);
        return age;
    }

    //Method calculating the Max Heart Rate by subtracting the person's age from 220
    public int maxHeartRate (int age) {
        int maxHeartRate = 220 - age;
        return maxHeartRate;
    }

    //Method calculating max target heart rate
    public double targetHearRateMax (int maxHeartRate) {
        double target1 = 0.85 * maxHeartRate;
        return target1;
    }

    //Method calculating min target heart rate
    public double targetHeartRateMin (int maxHeartRate) {
        double target2 = 0.50 * maxHeartRate;
        return  target2;
    }

    //Main method
    public static void main (String [] args) {
        String name1;
        String name2;
        String birthyear;
        String birthmonth;
        String birthday;
        int birth;

     //GUI Output that collects info from users

        name1 = JOptionPane.showInputDialog("Please enter your First name: ");
        name2 = JOptionPane.showInputDialog("Please enter your Last name: ");
        birthyear = JOptionPane.showInputDialog("Please enter your Year of Birth:");
        birthmonth = JOptionPane.showInputDialog("Please enter your Month of Birth");
        birthday = JOptionPane.showInputDialog("Please enter your Day of Birth");

        birth = Integer.parseInt(birthyear);
        int month = Integer.parseInt(birthmonth);
        int day = Integer.parseInt(birthday);

        HeartRate human = new HeartRate(name1, name2, birth, month, day);

        String output =  String.format("%s %s", human.getFirstName(), human.getLastName());
        String output_age = String.format("Age: %d", human.personAge(birth));
        String output_maxHeart = String.format("Maximum Heart Rate: %d", human.maxHeartRate(human.personAge(birth)));
        String output_targetMax = String.format("%.3f", human.targetHearRateMax(human.maxHeartRate(human.personAge(birth))));
        String output_targetMin = String.format("%.3f", human.targetHeartRateMin(human.maxHeartRate(human.personAge(birth))));
        String output_compare = String.format("The target Heart Rate for you is between %s and %s", output_targetMin, output_targetMax);


        JOptionPane.showMessageDialog(null, output + "\n" +output_age + "\n" + output_maxHeart + "\n" + output_compare);

    }
}
