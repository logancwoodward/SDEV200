import java.util.Scanner;
//Logan Woodward
//Program takes the input of a creditcard number, and determines whether the number is valid or not
public class CCVerification {

    public static void main(String[] args) {
        long cardNumber;
        // Prompt the user to enter a credit card number
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter a credit card number
            System.out.print("Enter credit card number: ");
            cardNumber = scanner.nextLong();
        }
        
/** Check card validity */
        if (isValid(cardNumber)) {
            System.out.println(cardNumber + " is valid");
        } else {
            System.out.println(cardNumber + " is invalid");
        }
    }

/** Return true if the card number is valid */
    public static boolean isValid(long number) {
        return (getSize(number) >= 13 && getSize(number) <= 16) &&
               (prefixMatched(number, 4) || prefixMatched(number, 5) || 
                prefixMatched(number, 37) || prefixMatched(number, 6)) &&
               (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
    }

/** Get the result from Step 2 */   
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numberStr = Long.toString(number);
        for (int i = numberStr.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(numberStr.charAt(i));
            sum += getDigit(digit * 2);
        }
        return sum;
    }

/** Return this number if it is a single digit, otherwise,
* return the sum of the two digits */
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

/** Return this number if it is a single digit, otherwise,
* return the sum of the two digits */
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numberStr = Long.toString(number);
        for (int i = numberStr.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(numberStr.charAt(i));
        }
        return sum;
    }

/** Return true if the number d is a prefix for number */ 
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

/** Return the number of digits in d */
    public static int getSize(long d) {
        return Long.toString(d).length();
    }

/** Return the first k number of digits from number. If the
   * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) {
        String numberStr = Long.toString(number);
        if (numberStr.length() <= k) {
            return number;
        }
        return Long.parseLong(numberStr.substring(0, k));
    }
}
