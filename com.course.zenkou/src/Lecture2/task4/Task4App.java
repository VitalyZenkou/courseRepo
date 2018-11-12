package Lecture2.task4;

import Lecture2.task4.model.*;
import Lecture2.task4.util.MarathonHelper;
import Lecture2.task4.util.comparator.TimeComparator;
import Lecture2.task4.view.Menu;

import java.util.List;

public class Task4App {

    private static final List<MarathonParticipant> participants = MarathonHelper.
            createParticipants(MarathonStatistic.getNames(), MarathonStatistic.getTime());
    private static final Menu menu = new Menu();

    public static void main(String[] args) {
        participants.sort(new TimeComparator());
        MarathonHelper.setPlaces(participants);
        menu.printMenu(participants);
    }
}
