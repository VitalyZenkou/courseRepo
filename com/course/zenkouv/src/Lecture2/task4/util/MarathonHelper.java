package Lecture2.task4.util;

import Lecture2.task4.model.MarathonParticipant;

import java.util.ArrayList;
import java.util.List;

public class MarathonHelper {

    private MarathonHelper() {
    }

    public static void printParticipants(List<MarathonParticipant> participants) {
        for (MarathonParticipant participant : participants) {
            System.out.println(participant);
        }
    }

    public static void printParticipantByPlace(List<MarathonParticipant> participants, int place) {
        for (MarathonParticipant participant : participants) {
            if (participant.getPlace() == place) {
                System.out.println(participant);
                break;
            }
        }
    }
}
