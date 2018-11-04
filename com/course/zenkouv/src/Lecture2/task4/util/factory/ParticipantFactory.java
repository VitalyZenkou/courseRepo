package Lecture2.task4.util.factory;

import Lecture2.task4.model.MarathonParticipant;

import java.util.ArrayList;
import java.util.List;

public class ParticipantFactory {

    private ParticipantFactory() {
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
}
