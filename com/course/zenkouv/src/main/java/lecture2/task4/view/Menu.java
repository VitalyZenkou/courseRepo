package lecture2.task4.view;

import lecture2.task4.model.MarathonParticipant;
import lecture2.task4.util.MarathonHelper;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern regex = Pattern.compile("^[a-z0-9]$");

    public void printMenu(List<MarathonParticipant> participants) {
        String menu;
        do {
            System.out.println("---------------------------------------");
            System.out.println("1 - Print all participants");
            System.out.println("2 - Print participant by place");
            System.out.println("q - Exit");
            menu = readMenu();
            switch (menu) {
                case "1": {
                    MarathonHelper.printParticipants(participants);
                    break;
                }
                case "2": {
                    MarathonHelper.printParticipantByPlace(participants, readPlace(participants.size()));
                    break;
                }
            }
        } while (!menu.equals("q"));
    }

    private static String readMenu() {
        String string;
        while (true) {
            System.out.print("Choose: ");
            string = scanner.next();
            if (isMenu(string)) {
                return string;
            }
            System.out.println("You entered incorrect data!");
        }
    }

    private static boolean isMenu(String string) {
        Matcher m = regex.matcher(string);
        return m.matches();
    }

    private static int readPlace(int maxPlace) {
        int place;
        do {
            System.out.print("Enter place: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("You entered not a number!");
            }
            place = scanner.nextInt();
            if (place <= maxPlace) {
                return place;
            } else {
                System.out.println("You entered wrong place, max place is: " + maxPlace);
            }
        } while (true);
    }
}
