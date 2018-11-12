package Lecture2.task2;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern regex = Pattern.compile("^[1-7]$");
    private static final String[] weekDays = new DateFormatSymbols(new Locale("En","BY")).getWeekdays();

    public static void main(String[] args) {
        String dayNumber;
        do {
            System.out.print("Enter day's week: ");
            dayNumber = scanner.next();
            if (isWeekDay(dayNumber)) {
                scanner.close();
                break;
            } else {
                System.out.println("You entered wrong day!");
            }
        } while (true);

        System.out.println(weekDays[Integer.parseInt(dayNumber)]);
    }

    private static boolean isWeekDay(String string) {
        Matcher m = regex.matcher(string);
        return m.matches();
    }
}
