import java.util.Scanner;

public class Main {
    public static final int PRINT_FIBONACCI_SERIES = 1;
    public static final int SQUARE_ROOT = 5;
    public static final int CONVERT_TO_BINARY = 6;
    public static final int SWAP_NIBBLES = 7;
    static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Enter your choice : ");
        System.out.println("1 : Print fibonacci series");
        System.out.println("5 : find square root");
        System.out.println("6 : print equivalent binary");
        System.out.println("7 : Print decimal number after swapping two nibbles");
        sc = new Scanner(System.in);
        Main mainObj = new Main();
        int choice = sc.nextInt();
        switch (choice) {
            case PRINT_FIBONACCI_SERIES:
                mainObj.printFibonacci();
                break;
            case SQUARE_ROOT:
                findSqrt();
                break;
            case CONVERT_TO_BINARY:
                String binaryNum = toBinary();
                System.out.println(binaryNum);
                break;
            case SWAP_NIBBLES:
                Binary b = new Binary();
                b.isPowerOfTwo();
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }

    private void printFibonacci() {
        int num1 = 0;
        int num2 = 1;
        int num3;
        System.out.println("How many terms do you want : ");
        int uptoTerm = sc.nextInt();
        System.out.print(num1 + " " + num2);
        for (int term = 2; term < uptoTerm; ++term) {
            num3 = num1 + num2;
            System.out.print(" " + num3);
            num1 = num2;
            num2 = num3;
        }
    }

    private static void findSqrt() {
        double num;
        double epsilon = 1.0E-15;
        System.out.println("Enter a number : ");
        num = sc.nextDouble();
        double t = num;
        double root;
        int count = 0;

        while (true) {
            count++;
            root = 0.5 * (t + (num / t));
            if (Math.abs(root - t) < epsilon)
                break;
            t = root;
        }
        System.out.println("Square root of " + num + " is " + t);
    }

    public static String toBinary() {
        int decimal;
        System.out.println("Enter a decimal integer ");
        decimal = sc.nextInt();
        int size = 8;
        int base = 2;
        int binary[] = new int[size];
        int index = 0;
        int binaryNum = 0;
        while (decimal > 0) {
            binary[index++] = decimal % base;
            decimal = decimal / base;
        }
        for (int i = size - 1; i >= 0; i--) {
            binaryNum = binaryNum * 10 + binary[i];
        }
        return String.valueOf(binaryNum);
    }
}