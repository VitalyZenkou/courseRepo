package lecture2.task4.model;

public final class MarathonStatistic {

    private static final String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John",
            "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
    private static final int[] time = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};

    private MarathonStatistic() {
    }

    public static String[] getNames() {
        return names;
    }

    public static int[] getTime() {
        return time;
    }
}
