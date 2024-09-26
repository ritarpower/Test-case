package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean isValidCodeFile(String codeFile) {
        Pattern pattern = Pattern.compile("^BA-\\d{3}$");
        Matcher matcher = pattern.matcher(codeFile);
        return matcher.matches();
    }

    public static boolean isValidCodePatient(String codePatient) {
        Pattern pattern = Pattern.compile("^BN-\\d{3}$");
        Matcher matcher = pattern.matcher(codePatient);
        return matcher.matches();
    }

    public static boolean isValidDate(String date) {
        Pattern pattern = Pattern.compile("^\\d{4}[-|/]\\d{2}[-|/]\\d{2}$");
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public static boolean isAfterInDate(String date, String date2) {
        LocalDate localDate = LocalDate.parse(date);
        LocalDate localDate2 = LocalDate.parse(date2);
        return localDate2.isAfter(localDate);
    }

    public static boolean isValidVIPType(String vipType) {
        if (vipType.equalsIgnoreCase("VIP 1")) {
            return true;
        } else if (vipType.equalsIgnoreCase("VIP 2")) {
            return true;
        } else if (vipType.equalsIgnoreCase("VIP 3")) {
            return true;
        } else {
            return false;
        }
    }
}
