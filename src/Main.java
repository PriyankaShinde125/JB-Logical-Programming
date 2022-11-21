import java.util.Scanner;

public class Main {
    public static final int SQUARE_ROOT = 1;
    public static final int CONVERT_TO_BINARY = 2;
    public static final int SWAP_NIBBLES = 3;
    static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Enter your choice : ");
        System.out.println("1 : find square root");
        System.out.println("2 : print equivalent binary");
        System.out.println("3 : Print decimal number after swapping two nibbles");
        sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case SQUARE_ROOT:
                findSqrt();
                break;
            case CONVERT_TO_BINARY:
                String binaryNum = toBinary();
                System.out.println(binaryNum);
                break;
            case SWAP_NIBBLES:
                Binary b = new Binary();
                b.swapNibbles();
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
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