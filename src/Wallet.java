public class Wallet {
    private String name;
    private final double originalBalance;
    private double modifiedBalance;

    public Wallet(String name, double balance) {
        this.name = name;
        this.originalBalance = balance;
        this.modifiedBalance = balance;
    }

    public double getModifiedBalance() {
        return modifiedBalance;
    }

    public double getOriginalBalance() {
        return originalBalance;
    }

    public void setBalance(double balance) {
        this.modifiedBalance = balance;
    }

    public String toString() {
        return "Name: " + name + "\nOriginal balance: " + originalBalance + "\nNew balance: " + modifiedBalance;
    }
}
