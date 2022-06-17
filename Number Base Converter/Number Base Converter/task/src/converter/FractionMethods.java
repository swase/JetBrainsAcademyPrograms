package converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FractionMethods {
    public static String decimalToTargetBase(String number, int targetBase, int newScale) {
        /** Convert fractional part of base 10 number to target base.
         * Take in numbers right of the fraction point */

        BigDecimal sourceNum = new BigDecimal("0." + number);
        if (sourceNum.doubleValue() == 0.0) {return "." + "0".repeat(newScale);}
        StringBuilder result = new StringBuilder();
        int tempVal = 0;
        while (result.length() < newScale && sourceNum.doubleValue() != 0 ) {
            sourceNum = sourceNum.multiply(BigDecimal.valueOf(targetBase));
            tempVal = sourceNum.intValue();
            sourceNum = sourceNum.subtract(BigDecimal.valueOf(tempVal));
            if (tempVal > 9) {
                result.append(Util.getLetterFromVal(tempVal));
            } else {result.append(tempVal);}
        }
        if (result.length() < newScale) {
            result.append("0".repeat(newScale - result.length()));
        }
        return "." + result.toString();
    }

    public static String getDecimalBaseAsString(String num, int sourceBase, int newScale) {
        String result = getDecimalValue(num, sourceBase).toString();
        if (result.equals("0")) {
            return ".00000";
        }
        return getDecimalValue(num, sourceBase).setScale(newScale, RoundingMode.HALF_DOWN).toString().substring(1);
    }

    public static String getDecimalBaseAsString(String num, int sourceBase) {

        String result = getDecimalValue(num, sourceBase).toString();
        if (result.equals("0")) {
            return ".00000";
        }
        return result.substring(1);
    }

    private static BigDecimal getDecimalValue(String num, int sourceBase) {
        BigDecimal total = new BigDecimal("0");
        BigDecimal baseAccum;
        int currentVal = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                continue;
            }
            baseAccum = BigDecimal.valueOf(1/Math.pow(sourceBase, i + 1));
            if (Character.isDigit(num.charAt(i))) {
                currentVal = Character.getNumericValue(num.charAt(i));
            } else {
                currentVal = Util.getValueFromLetter(num.charAt(i));
            }
            total = total.add(BigDecimal.valueOf(currentVal).multiply(baseAccum));
        }
        return total;
    }

}
