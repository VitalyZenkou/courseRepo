package Lecture2.task4.model;

import java.util.Objects;

public class MarathonParticipant {

    private final String name;
    private final int time;
    private int place;

    public MarathonParticipant(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        if (isPlaceZero()) {
            this.place = place;
        }
    }

    private boolean isPlaceZero() {
        if (this.place == 0) {
            return true;
        } else {
            System.out.println("The place was set for this participant!");
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarathonParticipant that = (MarathonParticipant) o;
        return time == that.time &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, time);
    }

    @Override
    public String toString() {
        return String.format("Place [%-2d] - Name: %-10s [time: %d]", place, name, time);
    }
}
