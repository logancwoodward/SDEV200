/*Program name: MyDate.java
Author: Logan Woodward
Assignment 10.14*/

// |  MyDate                                    |
// | -------------------------------------------|
// | - year: int                                |
// | - month: int                               |
// | - day: int                                 |
// | -------------------------------------------|
// | + MyDate()                                 |
// | + MyDate(elapsedTime: 1970, 0, 1)          |
// | + MyDate(year: int, month: int, day: int)  |
// | + getYear()                                |
// | + getMonth()                               |
// | + getDay()                                 |
// | + setDate(elapsedTime long): void          |

import java.util.GregorianCalendar;

public class MyDate {
    private int year;
    private int month;
    private int day;

    //A no-arg constructor that creates a MyDate object for the current date.
    public MyDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
    //A constructor that constructs a MyDate object with a specified elapsed time since midnight, January 1, 1970, in milliseconds.    
    public MyDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    //A constructor that constructs a MyDate object with the specified year, month, and day.
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    //Three getter methods for the data fields year, month, and day, respectively.
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    //A method named setDate(long elapsedTime) that sets a new date for the object using the elapsed time.
    public void setDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
    //Write a test program that creates two MyDate objects (using new MyDate() and new MyDate(34355555133101L)) and displays their year, month, and day.
    public static void main(String[] args) {

        MyDate date1 = new MyDate(); //current date
        MyDate date2 = new MyDate(34355555133101L); //specified date

        System.out.println("Date1: " + date1); //current date
        System.out.println("Date2: " + date2); //specified date
    }
}
