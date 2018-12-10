package lecture5.util.reader;

import lecture5.util.validator.ExpressionValidator;

import java.util.Scanner;

public class Reader {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Reader() {
    }

    public static double readNumber() {
        String number;
        while (true) {
            System.out.print("Enter variable: ");
            number = SCANNER.next();
            if (ExpressionValidator.isNumber(number)) {
                return Double.valueOf(number);
            } else {
                System.out.println("You entered wrong variable - " + number);
            }
        }
    }

    public static String readSign() {
        String sign;
        while (true) {
            System.out.print("Enter sign: ");
            sign = SCANNER.next();
            if (ExpressionValidator.isSign(sign)) {
                return sign;
            } else {
                System.out.println("You entered wrong sign - " + sign);
            }
        }
    }

    public static String readWord() {
        String word;
        while (true) {
            System.out.print("quit for exit or any symbol for continue: ");
            word = SCANNER.next();
            if (ExpressionValidator.isWord(word)) {
                return word;
            } else {
                System.out.println("You entered wrong keyword for exit - " + word);
            }
        }
    }
}
