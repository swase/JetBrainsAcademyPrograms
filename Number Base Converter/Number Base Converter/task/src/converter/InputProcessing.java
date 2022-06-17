package converter;

import static converter.IntegerMethods.decimalToTarget;
import static converter.IntegerMethods.targetToDecimal;

public class InputProcessing {

    public static void process(String input, int sourceBase, int targetBase) {
        if (input.contains(".")) {
            Util.printConversionResult(processFractionInput(input, sourceBase, targetBase));
        } else {
            Util.printConversionResult(processIntegerInput(input, sourceBase, targetBase));
        }
    }
    public static String processFractionInput(String userInput, int sourceBase, int targetBase) {
        //System.out.println("User input: " + userInput);
        int indexOfDecimal = userInput.indexOf(".");
        String[] parts = new String[2];
        parts[0] = userInput.substring(0,indexOfDecimal);
        parts[1] = userInput.substring(indexOfDecimal + 1);
        String result = "";
        if (sourceBase != 10) {
            parts[0] = targetToDecimal(parts[0],sourceBase);
            parts[1] = FractionMethods.getDecimalBaseAsString(parts[1], sourceBase).substring(1);
        }
        result += decimalToTarget(parts[0], targetBase);
        result += FractionMethods.decimalToTargetBase(parts[1], targetBase, 5);
        return result;
    }

    public static String processIntegerInput(String userInput, int sourceBase, int targetBase) {
        //System.out.println("Unchanged UI: " + userInput);
        String result;
        if (sourceBase != 10) {
            userInput = targetToDecimal(userInput, sourceBase);
            //System.out.println("Converted to base 10 : " + userInput);
        }
        userInput = decimalToTarget(userInput, targetBase);
        //System.out.println("Converted to target base : " + userInput);
        return userInput;
    }

}
