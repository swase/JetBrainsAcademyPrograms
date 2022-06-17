package converter;

import java.util.Scanner;

import static converter.IntegerMethods.decimalToTarget;
import static converter.IntegerMethods.targetToDecimal;

public class Controller {
    Scanner scanner;
    private boolean exit = false;
    private boolean baseChosen = false;
    private int sourceBase;
    private int targetBase;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        while (!exit) {
            loadMenu();
            getUserInput();
        }
    }

    public void loadMenu() {
        if (!baseChosen) {
            System.out.printf("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
        } else {
            System.out.printf("Enter number in base %d to convert to base " +
                    "%d (To go back type /back) ", sourceBase, targetBase);
        }
    }

    private void getUserInput() {
        if (scanner.hasNext("/.*")) {
            doControlAction(scanner.nextLine());
        } else {
            if (scanner.hasNext(">.*")) {
                scanner.skip(">");
        }
            doProgramAction();
        }
    }

    private void doProgramAction() {
            if (!baseChosen) {
                sourceBase = scanner.nextInt();
                targetBase = scanner.nextInt();
                scanner.nextLine();
                baseChosen = true;
            } else {
                String result;
                result = scanner.nextLine().replace(">", "").trim();
                InputProcessing.process(result, sourceBase, targetBase);
            }
    }

    private void doControlAction(String action) {
        switch (action.toLowerCase()) {
            case "/exit":
                exit = true;
                break;
            case "/back":
                baseChosen = false;
                sourceBase = 10;
                targetBase = 10;
        }
    }


}
