import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        BigDecimal num = new BigDecimal(scanner.next());
        int newScale = scanner.nextInt();

        System.out.println(num.setScale(newScale, RoundingMode.HALF_DOWN));
    }   
}