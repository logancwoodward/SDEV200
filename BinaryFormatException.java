/*12.9 (BINARYFORMATEXCEPTION) 
Exercise 12.7 implements the bin2Dec method to throw a BinaryFormatException if the string is not a binary string. 
Define a custom exception called BinaryFormatException. 
Implement the bin2Dec method to throw a BinaryFormatException if the string is not a binary string.*/

/*Program name: BinaryFormatException.java
Author: Logan Woodward
This program allows a user to convert a binary string into a decimal value. The program throws and error if the input is not valid.*/

import java.util.Scanner;

public class BinaryFormatException extends Exception {
    //default error
    public BinaryFormatException() {
        super("Invalid Binary format.");
    }
    //custom error
    public BinaryFormatException(String message) {
        super(message);
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        //Make sure the string isn't empty of null
        if (binaryString == null || binaryString.isEmpty()) {
            throw new BinaryFormatException("The input string is ");
        }
        //Make sure the string is actual binary
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("The string contains non-binary characters");
            }
        }
        //Convert binary to decimal:
        int decimalValue = 0;
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            char bit = binaryString.charAt(length - 1 - i);
            if (bit == '1') {
                decimalValue += Math.pow(2, i);
            }
        }

        return decimalValue;
    }
        // Main method to test the bin2Dec method
    public static void main(String[] args) {
        try (Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Enter a binary number: ");
            String binaryString = scanner.nextLine();
            try {
                int decimalValue = bin2Dec(binaryString);
                System.out.println("Decimal equivalent: " + decimalValue);
            } catch (BinaryFormatException e) {
                System.out.println("Not a binary number");
            }
        }
    }
}