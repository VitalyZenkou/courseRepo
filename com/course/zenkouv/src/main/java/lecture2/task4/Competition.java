package lecture2.task4;

import lecture2.task4.model.MarathonParticipant;
import lecture2.task4.util.comparator.TimeComparator;

import java.util.ArrayList;
import java.util.List;

class Competition {

    List<MarathonParticipant> setPlaces(List<MarathonParticipant> participants) {
        int place = 1;
        List<MarathonParticipant> participants1WithPlace = new ArrayList<>(participants);
        sortByTime(participants1WithPlace);
        for (MarathonParticipant participant : participants1WithPlace) {
            participant.setPlace(place);
            place++;
        }
        return participants1WithPlace;
    }

    private void sortByTime(List<MarathonParticipant> participants) {
        participants.sort(new TimeComparator());
    }

}
