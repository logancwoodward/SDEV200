/**Author: Logan Woodward
 * Program name: CountKeywords.java
 * 
 * 21.3 (COUNT THE KEYWORDS IN JAVA SOURCE CODE) 
 * Revise the program in Listing 21.7. 
 * If a keyword is in a comment or in a string, don’t count it. 
 * Pass the Java file name from the command line. 
 * Assume the Java source code is correct and line comments and paragraph comments do not overlap.
 */

import java.io.*;
import java.util.*;

public class CountKeywords {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java CountKeywords <source-file>");
            return;
        }

        String filename = args[0];
        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of keywords in " + filename
                + " is " + countKeywords(file));
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    public static int countKeywords(File file) throws Exception {
        String[] keywordString = {
            "abstract", "assert", "boolean", "break", "byte", "case", 
            "catch", "char", "class", "const", "continue", "default", 
            "do", "double", "else", "enum", "extends", "for", 
            "final", "finally", "float", "goto", "if", "implements", 
            "import", "instanceof", "int", "interface", "long", 
            "native", "new", "package", "private", "protected", 
            "public", "return", "short", "static", "strictfp", 
            "super", "switch", "synchronized", "this", "throw", 
            "throws", "transient", "try", "void", "volatile", 
            "while", "true", "false", "null"
        };

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        try (Scanner input = new Scanner(file)) {
            boolean inString = false;
            boolean inComment = false;
            
            while (input.hasNextLine()) {
                String line = input.nextLine();
                int i = 0;
                while (i < line.length()) {
                    char ch = line.charAt(i);
                    
                    //handle string literals
                    if (ch == '"') {
                        inString = !inString; //toggle inString
                    }
                    
                    // Handle comments
                    if (!inString) {
                        if (i < line.length() - 1 && line.startsWith("//", i)) {
                            break; //ignore the rest of the line for line comments
                        } else if (i < line.length() - 1 && line.startsWith("/*", i)) {
                            inComment = true; //entering a block comment
                            i++; //move index to skip next character
                        } else if (inComment) {
                            if (i < line.length() - 1 && line.startsWith("*/", i)) {
                                inComment = false; //exiting block comment
                                i++; //move index to skip next character
                            }
                            //if still in comment, just move to next character
                        } else if (Character.isJavaIdentifierStart(ch)) {
                            StringBuilder word = new StringBuilder();
                            while (i < line.length() && (Character.isJavaIdentifierPart(line.charAt(i)))) {
                                word.append(line.charAt(i));
                                i++;
                            }
                            if (keywordSet.contains(word.toString())) {
                                count++;
                            }
                            continue; //skip the increment of i as it's already handled
                        }
                    }
                    i++; //move to the next character
                }
            }
        }
        return count;
    }
}
