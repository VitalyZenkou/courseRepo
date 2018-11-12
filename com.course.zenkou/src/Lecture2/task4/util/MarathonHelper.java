package Lecture2.task4.util;

import Lecture2.task4.model.MarathonParticipant;

import java.util.ArrayList;
import java.util.List;

public class MarathonHelper {

    private MarathonHelper() {
    }

    public static List<MarathonParticipant> createParticipants(String[] names, int[] time) {
        int length = names.length;
        List<MarathonParticipant> participants = new ArrayList<>();
        if (names.length != time.length) {
            System.out.println("The name array doesn't equals time array!!\n" +
                    "The length will be equals lower value!");
            if (names.length > time.length) {
                length = time.length;
            }
        }
        for (int i = 0; i < length; i++) {
            participants.add(new MarathonParticipant(names[i], time[i]));
        }
        return participants;
    }

    public static void printParticipants(List<MarathonParticipant> participants) {
        for (MarathonParticipant participant : participants) {
            System.out.println(participant);
        }
    }

    public static void setPlaces(List<MarathonParticipant> participants) {
        int place = 1;
        for (MarathonParticipant participant : participants) {
            participant.setPlace(place);
            place++;
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
