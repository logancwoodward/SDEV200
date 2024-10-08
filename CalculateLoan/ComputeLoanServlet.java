package CalculateLoan;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/computeLoan")
public class ComputeLoanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get parameters from the form
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double interestRate = Double.parseDouble(request.getParameter("interestRate"));
        int years = Integer.parseInt(request.getParameter("years"));
        
        //create Loan object
        Loan loan = new Loan(loanAmount, interestRate, years);
        
        //compute monthly and total payments
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();

        //set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        //display the results
        out.println("<html><body>");
        out.println("<h2>Loan Payment Calculation</h2>");
        out.printf("Loan Amount: $%.2f<br>", loanAmount);
        out.printf("Annual Interest Rate: %.2f%%<br>", interestRate);
        out.printf("Number of Years: %d<br>", years);
        out.printf("Monthly Payment: $%.2f<br>", monthlyPayment);
        out.printf("Total Payment: $%.2f<br>", totalPayment);
        out.println("</body></html>");
    }
}
