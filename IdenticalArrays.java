import java.util.Scanner;
//Logan Woodward, Assignment8.29
//This program prompts the user for two 3x3 arrays and them compares them to see if they are identical
public class IdenticalArrays {

    //arrays are identical?
    public static boolean equals(int[][] m1, int[][] m2) {
        // Check if both arrays have the same number of rows
        if (m1.length != m2.length) {
            return false;
        }
        
        //same number of columns?
        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }
        }
        
        //compare each element of both arrays
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix1;
        int[][] matrix2;
        try (Scanner scanner = new Scanner(System.in)) {
            final int SIZE = 3;
            matrix1 = new int[SIZE][SIZE];
            matrix2 = new int[SIZE][SIZE];
            System.out.println("Enter the elements of the first 3x3 matrix:");
            readMatrix(scanner, matrix1);
            System.out.println("Enter the elements of the second 3x3 matrix:");
            readMatrix(scanner, matrix2);
        }

        //matrices are identical?
        if (equals(matrix1, matrix2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }
    }

    //method to read a 3x3 matrix from the scanner
    public static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                matrix1[j] = scanner.nextInt();
            }
        }
    }
}