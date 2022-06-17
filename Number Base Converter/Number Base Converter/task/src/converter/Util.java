package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;

public class Util {


    public static String getLetterFromVal(int decVal) {
        return "" + (char)(decVal + 87);
    }

    public static int getValueFromLetter(char hexChar) {
        return (int)(Character.toLowerCase(hexChar) - 87);
    }

    public static void printConversionResult(String result) {
        if (result.contains(".")) {formatNumberForPrinting(result);}
        System.out.printf("Conversion result: %s%n", result);
    }

    public static void formatNumberForPrinting(String number) {
        int indexOfDecPoint = number.indexOf(".");
        if (number.length() - indexOfDecPoint < 5) {
            number += "0".repeat(number.length() - indexOfDecPoint);
        }
    }
}
