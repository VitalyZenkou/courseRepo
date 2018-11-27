package Lecture3.Task2.util.random;

public class RandomUtil {

    private RandomUtil(){
    }

    public static String generateRandomString() {
        StringBuilder rand = new StringBuilder();
        int size = (int) (Math.random() * 5) + 5;
        for (int i = 0; i < size; i++) {
            char c = (char) ((int) (Math.random() * 26) + 'a');
            if (i == 0) {
                c = Character.toUpperCase(c);
            }
            rand.append(c);
        }
        return rand.toString();
    }
}
