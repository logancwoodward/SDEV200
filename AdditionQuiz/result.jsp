<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page session="true" %>

<%
    // Retrieve questions and answers from the session
    List<String> questions = (List<String>) session.getAttribute("questions");
    List<Integer> correctAnswers = (List<Integer>) session.getAttribute("answers");
    
    int score = 0; // To track the score
    int numberOfQuestions = questions.size(); // Number of questions
    List<Integer> userAnswers = new ArrayList<>();
    
    // Retrieve user answers and calculate score
    for (int i = 0; i < numberOfQuestions; i++) {
        String userAnswer = request.getParameter("answer" + i);
        if (userAnswer != null) {
            userAnswers.add(Integer.parseInt(userAnswer));
            if (Integer.parseInt(userAnswer) == correctAnswers.get(i)) {
                score++; // Increase score for correct answers
            }
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Results</title>
</head>
<body>
    <h1>Quiz Results</h1>
    <p>You answered <strong><%= score %></strong> out of <strong><%= numberOfQuestions %></strong> questions correctly.</p>
    
    <h2>Your Answers:</h2>
    <ul>
        <%
            for (int i = 0; i < numberOfQuestions; i++) {
                out.println("<li>" + questions.get(i) + " Your answer: " + userAnswers.get(i) +
                            " Correct answer: " + correctAnswers.get(i) + "</li>");
            }
        %>
    </ul>
    
    <a href="quiz.jsp">Take Quiz Again</a>
</body>
</html>
