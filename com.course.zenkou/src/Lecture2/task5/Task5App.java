package Lecture2.task5;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5App {

    private static final char SYMBOL = '*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> variants = Arrays.asList("Vitaly Zenkou", "Vlad Bankov", "Vitaly Plisko");
    private static final List<String> guessesCharacter = new ArrayList<>();
    private static final Pattern regex = Pattern.compile("^[a-z A-z]{1,20}$");
    private static StringBuffer result = new StringBuffer();
    private static String hiddenName;

    public static void main(String[] args) {
        boolean isWin;
        hiddenName = variants.get(new Random().nextInt(variants.size()));
        result = fillStringBySymbol();
        do {
            System.out.println("The hidden name is " + result.toString());
            String guess = readString();
            compare(guess);
            isWin = isWin();
        } while (!isWin);
        System.out.println("You win! The hidden name is " + hiddenName);
    }

    private static StringBuffer fillStringBySymbol() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < hiddenName.length(); i++) {
            if (hiddenName.charAt(i) != ' ') {
                result.append(SYMBOL);
            } else {
                result.append(' ');
            }
        }
        return result;
    }

    private static String readString() {
        String str;
        while (true) {
            System.out.print("Enter symbol or full name: ");
            str = scanner.nextLine();
            if (isString(str)) {
                break;
            }
            System.out.println("You entered not a string or symbol!");
        }
        return str;
    }

    private static boolean isString(String guess) {
        Matcher m = regex.matcher(guess);
        return m.matches();
    }

    private static void compare(String guess) {
        if (guess.length() == 1) {
            if (wasEntered(guess)) {
                System.out.println("This symbol was entered before!");
            } else {
                guessesCharacter.add(guess);
                result = changeSymbolByLetter(guess);
            }
        } else {
            String str = hiddenName.toLowerCase();
            if (str.equals(guess.toLowerCase())) {
                result.replace(0, guess.length(), guess);
            }
        }
    }

    private static boolean wasEntered(String symbol) {
        for (String s : guessesCharacter) {
            if (symbol.toLowerCase().equals(s.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isWin() {
        return result.toString().toLowerCase().equals(hiddenName.toLowerCase());
    }

    private static StringBuffer changeSymbolByLetter(String symbol) {
        StringBuffer changedString = new StringBuffer(result);
        for (int i = 0; i < hiddenName.length(); i++) {
            if (Character.toLowerCase(hiddenName.charAt(i)) == Character.toLowerCase(symbol.charAt(0))) {
                changedString.replace(i, i + 1, symbol);
            }
        }
        return changedString;
    }
}
