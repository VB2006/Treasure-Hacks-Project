import java.util.Scanner;

public class Slot {
    private Wallet wallet;
    private Scanner scan;
    private Double creds;
    private int rand1, rand2, rand3;
    private int[] numArray;

    public Slot(Wallet wallet) {
        this.wallet = wallet;
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.print("How many credits will you bet? (1 dollar = 4 credits): ");
        creds = scan.nextDouble();
        if ((creds / 4) > wallet.getModifiedBalance()) {
            System.out.println("Sorry, you do not have enough money. Retry with a valid value.");
            start();
        } else if (creds < 4) {
            System.out.println("Invalid input.");
            start();
        }

        numArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        rand1 = (int) (Math.random() * numArray.length);
        rand2 = (int) (Math.random() * numArray.length);
        rand3 = (int) (Math.random() * numArray.length);

        checkForWin();
        retryPrompt();
    }

    public void checkForWin() {
        int a = numArray[rand1];
        int b = numArray[rand2];
        int c = numArray[rand3];

        System.out.println(a + " " + b + " " + c);

        if ((a == b) && (b == c)) {
            wallet.setBalance(wallet.getModifiedBalance() + (creds / 4));
            System.out.println("Congrats! You have won $" + (creds / 4) + "!");
        } else {
            wallet.setBalance(wallet.getModifiedBalance() - (creds / 4));
            System.out.println("Sorry, you did not win anything this round.");
        }
        System.out.println("New balance: " + wallet.getModifiedBalance());

        if ((a == 7) && (b == 7) && (c == 7)) {
            wallet.setBalance(wallet.getModifiedBalance() + 5000000.00);
            System.out.println("CONGRATS, YOU WON THE JACKPOT! 5 million dollars added to your account!");
            System.out.println("New balance: " + wallet.getModifiedBalance());
        }
    }

    public void retryPrompt() {
        System.out.println("FUN FACT: 99% of gamblers quit before they hit the jackpot!");
        System.out.print("Would you like to play again? (Y/N): ");
        String confirm = scan.next();

        if (confirm.equalsIgnoreCase("Y")) {
            start();
        } else if (confirm.equalsIgnoreCase("N")) {
            System.out.println();
            System.out.println("Thanks for playing!");
            System.out.println("Original balance: " + wallet.getOriginalBalance());
            System.out.println("New balance: " + wallet.getModifiedBalance());
        } else {
            System.out.println("Invalid input. Try again.");
            retryPrompt();
        }
    }
}
