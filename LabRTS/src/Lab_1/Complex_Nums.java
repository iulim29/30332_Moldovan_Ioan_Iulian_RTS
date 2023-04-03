package Lab_1;
import java.util.Scanner;

public class Complex_Nums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the real and imaginary parts of the first complex number: ");
        double real1 = scanner.nextDouble();
        double imaginary1 = scanner.nextDouble();

        System.out.print("Enter the real and imaginary parts of the second complex number: ");
        double real2 = scanner.nextDouble();
        double imaginary2 = scanner.nextDouble();

        double productReal = real1 * real2 - imaginary1 * imaginary2;
        double productImaginary = real1 * imaginary2 + imaginary1 * real2;

        double sumReal = real1 + real2;
        double sumImaginary = imaginary1 + imaginary2;

        System.out.println("Product: " + productReal + " + " + productImaginary + "i");
        System.out.println("Sum: " + sumReal + " + " + sumImaginary + "i");

        scanner.close();
    }
}


