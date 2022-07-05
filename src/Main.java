import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Log logic = new Log();
        Scanner scanner = new Scanner(System.in);
        System.out.println(logic.getCrypt(scanner.nextLine()));
    }
}
