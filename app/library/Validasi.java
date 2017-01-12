package library;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validasi {
	
	public static boolean validNumeric(String input, String regexPattern, int min, int max) {
        boolean status = false;
        try {
            String INPUT_PATTERN = "^[0-9]{"+min+","+max+"}$";

            if (regexPattern != null && !regexPattern.trim().equals("")) {
                INPUT_PATTERN = regexPattern;
            }

            Pattern pattern = Pattern.compile(INPUT_PATTERN);
            Matcher matcher = pattern.matcher(input);
            status = matcher.matches();
        } catch (Exception e) {
            
        }
        return status;
    }

}
