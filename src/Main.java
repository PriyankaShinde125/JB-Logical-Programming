import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static final int PRINT_FIBONACCI_SERIES = 1;
    public static final int PERFECT_NUMBER = 2;
    public static final int IS_PRIME = 3;
    public static final int REVERSE_NUMBER = 4;
    public static final int SQUARE_ROOT = 5;
    public static final int CONVERT_TO_BINARY = 6;
    public static final int SWAP_NIBBLES = 7;
    public static final int COUPON_NUMBER = 8;
    public static final int STOPWATCH_SIMULATOR = 9;
    public static final int ZERO = 0;
    public static final int TEN = 10;
    public static final int TWO = 2;
    public static final int ONE = 1;


    static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Enter your choice : ");
        System.out.println("1 : Print fibonacci series");
        System.out.println("2 : Check whether it is perfect number");
        System.out.println("3 : Check whether number is prime or not");
        System.out.println("4 : Print reverse number");
        System.out.println("5 : find square root");
        System.out.println("6 : print equivalent binary");
        System.out.println("7 : Print decimal number after swapping two nibbles");
        System.out.println("8 : Generate coupon number");
        System.out.println("9 : Stopwatch simulator");
        sc = new Scanner(System.in);
        Main mainObj = new Main();
        int choice = sc.nextInt();
        switch (choice) {
            case PRINT_FIBONACCI_SERIES:
                mainObj.printFibonacci();
                break;
            case PERFECT_NUMBER:
                mainObj.isPerfect();
                break;
            case IS_PRIME:
                mainObj.isPrime();
                break;
            case REVERSE_NUMBER:
                mainObj.reverseNumber();
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
            case COUPON_NUMBER:
                mainObj.generateCouponNumber();
                break;
            case STOPWATCH_SIMULATOR:
                mainObj.getElapseTime();
                break;
            default:
                System.out.println("INVALID CHOICE");
                break;
        }
    }

    private void getElapseTime() {
        long startTime = 0;
        long endTime;
        DateFormat simple = new SimpleDateFormat("hh:mm:ss");

        System.out.println("Enter 1 for start stopwatch");
        sc.nextByte();
        startTime = System.currentTimeMillis();

        System.out.println("Enter 2 for end stopwatch");
        sc.nextByte();
        endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        Duration duration = Duration.ofMillis(elapsedTime);
        long elapsedTimeHh = duration.toHours();
        long elapsedTimeMm = duration.toMinutesPart();
        long elapsedTimeSs = duration.toSecondsPart();
        String elapsedTimeString = String.format("%02d:%02d:%02d", elapsedTimeHh, elapsedTimeMm, elapsedTimeSs);

        System.out.println("start time = " + simple.format(new Date(startTime)));
        System.out.println("end time = " + simple.format(new Date(endTime)));
        System.out.println("Elapsed Time is = "+ elapsedTimeString);
    }

    private void generateCouponNumber() {
        System.out.println("Enter number length");
        short num = sc.nextShort();
        LinkedHashSet<Byte> couponDigits = new LinkedHashSet<>();
        short iterations = 0;

        while (couponDigits.size() < num) {
            byte randomNum = (byte) (Math.random() * TEN);
            couponDigits.add(randomNum);
            iterations++;
        }

        String couponNumber = "";
        for (byte couponDigit : couponDigits) {
            couponNumber = couponNumber + couponDigit;
        }

        System.out.println("Coupon Code: " + couponNumber);
        System.out.println("Number of times random number generated to get distinct values = " + iterations);
    }

    private void reverseNumber() {
        System.out.println("Enter a number : ");
        int num = sc.nextInt();
        int reverse = ZERO;
        while (num > ZERO) {
            int rem = num % TEN;
            reverse = reverse * TEN + rem;
            num = num / TEN;
        }
        System.out.println("Reverse number is " + reverse);
    }

    private void isPrime() {
        System.out.println("Enter a number : ");
        int num = sc.nextInt();
        boolean isPrime = true;
        if (num == TWO)
            isPrime = true;
        else {
            for (int i = TWO; i < num / TWO; i++) {
                if (num % i == ZERO) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(isPrime ? "It is prime number" : "It is not prime number");
    }

    private void isPerfect() {
        System.out.println("Enter a number : ");
        int num = sc.nextInt();
        int sum = ZERO;
        int upto = num / TWO;
        for (int term = ONE; term <= upto; term++) {
            if (num % term == ZERO) {
                sum += term;
            }
        }
        System.out.println(num == sum ? "It is perfect number" : "It is not perfect number");
    }

    private void printFibonacci() {
        int num1 = ZERO;
        int num2 = ONE;
        int num3;
        System.out.println("How many terms do you want : ");
        int uptoTerm = sc.nextInt();
        System.out.print(num1 + " " + num2);
        for (int term = TWO; term < uptoTerm; ++term) {
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
        int count = ZERO;

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
        int base = TWO;
        int binary[] = new int[size];
        int index = ZERO;
        int binaryNum = ZERO;
        while (decimal > ZERO) {
            binary[index++] = decimal % base;
            decimal = decimal / base;
        }
        for (int i = size - ONE; i >= ZERO; i--) {
            binaryNum = binaryNum * TEN + binary[i];
        }
        return String.valueOf(binaryNum);
    }
}