package cpptojava.bank;

public abstract class Account {

    private int number;
    private double balance;

    public Account() {

        this.number = 0;
        this.balance = 0;
    }
    public Account(int number){

        this.number = number;
        this.balance=0;
    }

    public Account(int number, double balance){

        this.number= number;
        this.balance = balance;
    }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);


}
