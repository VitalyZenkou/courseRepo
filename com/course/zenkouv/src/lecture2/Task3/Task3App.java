package lecture2.Task3;

import java.util.Scanner;

public class Task3App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final char SYMBOL = '*';
    private static final char SPACE = ' ';
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static int buff1;
    private static int buff2;
    private static int sideSize;
    private static int maxLength;

    public static void main(String[] args) {
        do {
            System.out.print("Enter side size: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("You entered not a number!");
            }
            sideSize = scanner.nextInt();
            if (sideSize > 1) {
                scanner.close();
                break;
            } else {
                System.out.println("Side size must be more than 2!");
            }
        } while (true);

        maxLength = sideSize * TWO + ONE;
        buff1 = buff2 = sideSize;
        printTop();
        printBottom();
    }

    private static void printTop() {
        printLine(buff1, buff2);
        for (int i = 1; i < sideSize; i++) {
            buff1 -= ONE;
            buff2 += ONE;
            printLine(buff1, buff2);
        }
    }

    private static void printBottom() {
        for (int i = 0; i < sideSize - ONE; i++) {
            buff1 += ONE;
            buff2 -= ONE;
            printLine(buff1, buff2);
        }
    }

    private static void printLine(int first, int second) {
        for (int i = 0; i < maxLength; i++) {
            if (i == first || i == second) {
                System.out.print(SYMBOL);
            } else {
                System.out.print(SPACE);
            }
        }
        System.out.println();
    }
}
