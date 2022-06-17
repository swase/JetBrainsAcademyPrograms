import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BigDecimal totalGold = new BigDecimal("0");
        while(scanner.hasNext()) {
            totalGold = totalGold.add(new BigDecimal(scanner.next()));
        }
        System.out.println(totalGold);
    }
}