<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="javax.servlet.http.Cookie"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page session="true" %>

<%
    // Set the number of questions
    int numberOfQuestions = 5;

    // Create a list to hold the questions and answers
    List<String> questions = new ArrayList<>();
    List<Integer> answers = new ArrayList<>();
    Random rand = new Random();

    // Generate random addition questions
    for (int i = 0; i < numberOfQuestions; i++) {
        int num1 = rand.nextInt(100); // Random number between 0 and 99
        int num2 = rand.nextInt(100); // Random number between 0 and 99
        questions.add(num1 + " + " + num2 + " = ?");
        answers.add(num1 + num2);
    }

    // Store questions and answers in the session
    session.setAttribute("questions", questions);
    session.setAttribute("answers", answers);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Addition Quiz</title>
</head>
<body>
    <h1>Addition Quiz</h1>
    <form action="result.jsp" method="post">
        <%
            // Display questions
            for (int i = 0; i < questions.size(); i++) {
                out.println("<label>" + questions.get(i) + "</label><br>");
                out.println("<input type='text' name='answer" + i + "' required><br><br>");
            }
        %>
        <input type="submit" value="Submit Answers">
    </form>
</body>
</html>
