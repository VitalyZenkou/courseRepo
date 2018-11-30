package lecture2.task1;

import java.util.Scanner;

public class Task1App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = "----------------------------------";
    private static final int START_INDEX = 5;
    private static final int END_INDEX = 10;
    private static final char NEW_SYMBOL = '*';

    public static void main(String[] args) {
        printString("Enter the sentence: ");
        String sentence = scanner.nextLine().trim();
        scanner.close();
        printString(SEPARATOR);
        printReverse(sentence);
        printAllWords(sentence);
        printReplace(sentence);
        printUpper(sentence);
        printSubstring(sentence);
    }

    private static void printReverse(String sentence) {
        for (int i = sentence.length() - 1; i >= 0; i--) {
            System.out.print(sentence.charAt(i));
        }
        System.out.println("\n" + SEPARATOR);
    }

    private static void printAllWords(String sentence) {
        String[] words = sentence.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        printString(SEPARATOR);
    }

    private static void printReplace(String sentence) {
        String replace = sentence.replace(' ', NEW_SYMBOL);
        printString(replace);
    }

    private static void printUpper(String sentence) {
        String sentenceInUpperCase = sentence.toUpperCase();
        printString(sentenceInUpperCase);
    }

    private static void printSubstring(String sentence) {
        String subString = sentence.substring(START_INDEX, END_INDEX);
        printString(subString);
    }

    private static void printString(String string) {
        System.out.println(string);
        if (!string.equals(SEPARATOR)) {
            System.out.println(SEPARATOR);
        }
    }
}
