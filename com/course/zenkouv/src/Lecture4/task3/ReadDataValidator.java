package Lecture4.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadDataValidator {

    private static final Pattern OUTFIT_PATTERN = Pattern.compile("\\d+\\s[0-9.]+\\s\\d+\\s[A-Z]+\\s[A-Z]+");

    private ReadDataValidator() {
    }

    public static boolean isOutfit(String outfitParams) {
        Matcher matcher = OUTFIT_PATTERN.matcher(outfitParams);
        return matcher.matches();
    }
}
