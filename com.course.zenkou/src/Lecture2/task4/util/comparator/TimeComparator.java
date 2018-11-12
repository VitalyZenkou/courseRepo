package Lecture2.task4.util.comparator;

import Lecture2.task4.model.MarathonParticipant;

import java.util.Comparator;

public class TimeComparator implements Comparator<MarathonParticipant> {

    @Override
    public int compare(MarathonParticipant o1, MarathonParticipant o2) {
        return o1.getTime() < o2.getTime() ? -1 : o1.getTime() == o2.getTime() ? 0 : 1;
    }
}
