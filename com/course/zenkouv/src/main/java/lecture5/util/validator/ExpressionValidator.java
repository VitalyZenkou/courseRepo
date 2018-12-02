package lecture5.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator {

    private static final Pattern VARIABLE_PATTERN = Pattern.compile("^[0-9]*[.]?[0-9]+$");
    private static final Pattern SIGN_PATTERN = Pattern.compile("^[/*+-]$");
    private static final Pattern WORD_PATTERN = Pattern.compile("^[a-z]{1,4}$");

    private ExpressionValidator() {
    }

    public static boolean isNumber(String number) {
        Matcher matcher = VARIABLE_PATTERN.matcher(number);
        return matcher.matches();
    }

    public static boolean isSign(String sign){
        Matcher matcher = SIGN_PATTERN.matcher(sign);
        return matcher.matches();
    }

    public static boolean isWord(String word){
        Matcher matcher = WORD_PATTERN.matcher(word);
        return matcher.matches();
    }
}