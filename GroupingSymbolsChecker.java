/*Authoer: Logan Woodward
Program name: GroupingSymbolsChecker.java
This program checks whether a Java source-code fill has correct pairs of grouping symbols.

20.11 (MATCH GROUPING SYMBOLS) A Java program contains various pairs of grouping symbols, such as:

Parentheses: ( and )

Braces: { and }

Brackets: [ and ]

Note the grouping symbols cannot overlap. For example, (a{b)} is illegal. 
Write a program to check whether a Java source-code file has correct pairs of grouping symbols. 
Pass the source-code file name as a command-line argument
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class GroupingSymbolsChecker {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GroupingSymbolsChecker <source-code-file>");
            return;
        }

        String fileName = args[0];
        try {
            if (checkGroupingSymbols(fileName)) {
                System.out.println("The grouping symbols are correctly matched.");
            } else {
                System.out.println("The grouping symbols are not correctly matched.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static boolean checkGroupingSymbols(String fileName) throws IOException {
        Stack<Character> stack = new Stack<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    switch (ch) {
                        case '(', '{', '[' -> stack.push(ch);
                        case ')' -> {
                            if (stack.isEmpty() || stack.pop() != '(') {
                                return false;
                            }
                        }
                        case '}' -> {
                            if (stack.isEmpty() || stack.pop() != '{') {
                                return false;
                            }
                        }
                        case ']' -> {
                            if (stack.isEmpty() || stack.pop() != '[') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return stack.isEmpty(); //return true if stack is empty (all symbols matched)
    }
}
