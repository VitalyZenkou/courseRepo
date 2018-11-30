package lecture2.task4;

import lecture2.task4.model.*;
import lecture2.task4.util.factory.ParticipantFactory;
import lecture2.task4.view.Menu;

import java.util.List;

public class Task4App {

    private static final Competition competition = new Competition();
    private static final Menu menu = new Menu();

    public static void main(String[] args) {
        List<MarathonParticipant> participants = ParticipantFactory.
                createParticipants(MarathonStatistic.getNames(), MarathonStatistic.getTime());
        participants = competition.setPlaces(participants);
        menu.printMenu(participants);
    }
}
