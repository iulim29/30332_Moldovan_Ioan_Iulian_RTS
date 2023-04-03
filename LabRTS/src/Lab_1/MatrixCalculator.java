package Lab_1;

import java.util.Scanner;

public class MatrixCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the values of the first 3x3 matrix:");
        double[][] matrix1 = readMatrix(scanner);

        System.out.println("Enter the values of the second 3x3 matrix:");
        double[][] matrix2 = readMatrix(scanner);


        double[][] sum = addMatrices(matrix1, matrix2);

        double[][] product = multiplyMatrices(matrix1, matrix2);

        System.out.println("Sum of the matrices:");
        printMatrix(sum);
        System.out.println("Product of the matrices:");
        printMatrix(product);

        scanner.close();
    }

    public static double[][] readMatrix(Scanner scanner) {
        double[][] matrix = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public static double[][] addMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

