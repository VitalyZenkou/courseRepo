package lecture5;

import lecture5.util.reader.Reader;

public class CalcApp {

    private static final String EXIT = "quit";
    private static final Calculator CALCULATOR = new Calculator();

    public static void main(String[] args) {
        String check = "";
        while (!check.equals(EXIT)) {
            CALCULATOR.run();
            check = Reader.readWord();
        }
    }
}
