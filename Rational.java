import java.math.BigInteger;
import java.util.Scanner;

public class Rational extends Number implements Comparable<Rational> {
    private BigInteger numerator;
    private BigInteger denominator;

    // Default constructor
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    // Constructor with specified numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        BigInteger gcd = gcd(numerator.abs(), denominator.abs());
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);

        // Ensure the denominator is positive
        if (this.denominator.compareTo(BigInteger.ZERO) < 0) {
            this.numerator = this.numerator.negate();
            this.denominator = this.denominator.abs();
        }
    }

    // Find GCD of two BigIntegers
    private static BigInteger gcd(BigInteger a, BigInteger b) {
        return a.gcd(b);
    }

    // Return numerator
    public BigInteger getNumerator() {
        return numerator;
    }

    // Return denominator
    public BigInteger getDenominator() {
        return denominator;
    }

    // Add a rational number to this rational
    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                             .add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Subtract a rational number from this rational
    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                             .subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Multiply a rational number by this rational
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Divide a rational number by this rational
    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator.toString();
        else
            return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Rational that = (Rational) other;
        return this.subtract(that).getNumerator().equals(BigInteger.ZERO);
    }


    @Override
    public int intValue() {
        return (int) doubleValue();  // Cast double to int
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();  // Cast double to float
    }

    @Override
    public long longValue() {
        return (long) doubleValue();  // Cast double to long
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public int compareTo(Rational o) {
        return this.subtract(o).getNumerator().signum();
    }

    // Test the Rational class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the first rational number
        System.out.print("Enter the first rational number (numerator denominator): ");
        BigInteger num1 = new BigInteger(scanner.next());
        BigInteger denom1 = new BigInteger(scanner.next());
        Rational r1 = new Rational(num1, denom1);

        // Read the second rational number
        System.out.print("Enter the second rational number (numerator denominator): ");
        BigInteger num2 = new BigInteger(scanner.next());
        BigInteger denom2 = new BigInteger(scanner.next());
        Rational r2 = new Rational(num2, denom2);

        // Perform operations
        Rational sum = r1.add(r2);
        Rational difference = r1.subtract(r2);
        Rational product = r1.multiply(r2);
        Rational quotient = r1.divide(r2);

        // Display results
        System.out.println(r1 + " + " + r2 + " = " + sum);
        System.out.println(r1 + " - " + r2 + " = " + difference);
        System.out.println(r1 + " * " + r2 + " = " + product);
        System.out.println(r1 + " / " + r2 + " = " + quotient);
        System.out.println(r2 + " is " + r2.doubleValue());
    }
}
