public class Wallet {
    private String name;
    private double balance;

    public Wallet(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getMoney() {
        return balance;
    }

    public void setMoney(double balance) {
        this.balance = balance;
    }

}
