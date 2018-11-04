package Lecture2.task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern regex = Pattern.compile("^[1-7]$");

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

        switch (dayNumber) {
            case "1": {
                System.out.println("Monday");
                break;
            }
            case "2": {
                System.out.println("Tuesday");
                break;
            }
            case "3": {
                System.out.println("Wednesday");
                break;
            }
            case "4": {
                System.out.println("Thursday");
                break;
            }
            case "5": {
                System.out.println("Friday");
                break;
            }
            case "6": {
                System.out.println("Saturday");
                break;
            }
            case "7": {
                System.out.println("Sunday");
                break;
            }
        }
    }

    private static boolean isWeekDay(String string) {
        Matcher m = regex.matcher(string);
        return m.matches();
    }
}
