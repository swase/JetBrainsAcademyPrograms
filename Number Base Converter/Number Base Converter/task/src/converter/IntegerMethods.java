package converter;

import java.math.BigDecimal;
import java.math.BigInteger;

import static converter.Util.getLetterFromVal;
import static converter.Util.getValueFromLetter;

public class IntegerMethods {
    public static String decimalToTarget(String decValueAsString, int targetBase) {
        StringBuilder res = new StringBuilder();
        BigInteger decVal = new BigInteger(decValueAsString);
        if (decVal.intValue() == 0) {
            return "0";
        }
        BigInteger targetBaseBI = new BigInteger("" + targetBase);
        BigInteger[] pair = decVal.divideAndRemainder(targetBaseBI);
        while (pair[0].intValue() != 0 || pair[1].intValue() != 0) {
            if (pair[1].intValue() < 10) {
                res.append(pair[1].intValue());
            } else {
                //System.out.println();
                res.append(getLetterFromVal(pair[1].intValue()));
            }
            decVal = decVal.divide(targetBaseBI);
            pair = decVal.divideAndRemainder(targetBaseBI);
        }
        return res.reverse().toString();
    }

    public static String targetToDecimal(String sourceNum, int sourceBase) {
        //System.out.println("converting int from sourcebase to base 10: " + sourceNum);
        BigInteger result = new BigInteger("0");
        int indexOfDecimalPoint = sourceNum.indexOf(".");
        if (indexOfDecimalPoint > 0) {
            sourceNum = sourceNum.substring(0,indexOfDecimalPoint);
        }
        String source = new StringBuilder(sourceNum).reverse().toString().toLowerCase();
        //System.out.println("sourceNum: " + source);
        //System.out.println(source);
        int tempAccum;
        //char currentVal;
        for(int i = 0; i < source.length(); i++) {
            //currentVal = source.charAt(i);
            if (Character.isDigit(source.charAt(i))) {
                tempAccum = Character.getNumericValue(source.charAt(i));
            } else {
                tempAccum = getValueFromLetter(source.charAt(i));
            }
            result = result.add(BigDecimal.valueOf(
                    (tempAccum * Math.pow(sourceBase, i))).toBigInteger());

            //result += tempAccum * Math.pow(sourceBase, i);
            //System.out.println(result);
        }
        return "" + result;
    }
}
