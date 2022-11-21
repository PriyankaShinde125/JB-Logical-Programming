import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to logical programming");
        double epsilon = 1.0E-15;
        double num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextDouble();
        findSqrt(num, epsilon);
        toBinary((int) num);

    }

    private static void findSqrt(double c, double epsilon) {
        double t = c;
        double root;
        int count = 0;

        while (true) {
            count++;
            root = 0.5 * (t + (c / t));
            if (Math.abs(root - t) < epsilon)
                break;
            t = root;
        }
        System.out.println("Square root of " + c + " is " + t);
    }

    private static void toBinary(int decimal) {
        int MAX_SIZE=100;
        int binary[] = new int[MAX_SIZE];
        int index = 0;
        while (decimal > 0) {
            binary[index++] = decimal % 2;
            decimal = decimal / 2;
        }
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
    }
}