import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static Wallet wallet;

    public static void main(String[] args) {
        System.out.println("WELCOME TO SLOT!!");
        intro();

        Slot game = new Slot(wallet);
        game.start();
    }

    public static void intro() {
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        System.out.print("Enter the amount of money in your wallet (with decimals): ");
        double num = scan.nextDouble();

        if (Utility.numDigits(num) > 4 || Utility.numDigits(num) < 2) {
            System.out.println("Enter a valid amount.");
            intro();
        }
        if (num <= 5.00) {
            System.out.println("You must have more than $5 to play BlackJack.");
            intro();
        }

        wallet = new Wallet(name, num);
    }

}
