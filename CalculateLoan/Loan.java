package CalculateLoan;

/*37.5 (Calculate loan) Write an HTML form that prompts the user to enter loan amount,
interest rate, and number of years, as shown in Figure 37.28a. Clicking the Compute
Loan Payment button invokes a servlet to compute and display the monthly and
total loan payments, as shown in Figure 37.28b. Use the Loan class given in
Listing 10.2, Loan.java, to compute the monthly and total payments.

 */




 public class Loan {
    private double loanAmount;
    private double annualInterestRate;
    private int years;

    public Loan(double loanAmount, double annualInterestRate, int years) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int numberOfPayments = years * 12;
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

    public double getTotalPayment() {
        return getMonthlyPayment() * years * 12;
    }
}
