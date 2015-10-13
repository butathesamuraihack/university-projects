package cpptojava.bank;


public class Checking extends Account {

    private float minimum;

    public float getMinimum() { return minimum; }
    public void setMinimum(float minimum) { this.minimum = minimum; }

    public Checking(){

        setNumber(0);
        setBalance(0.0);
        this.minimum = 0;
    }

    public Checking(int n){

        setNumber(n);
        setBalance(0.0);
        this.minimum = 0;
    }

    public Checking(int n, double s){

        setNumber(n);
        setBalance(s);
        this.minimum = 0;
    }

    public Checking(int n, double s, float m){

        setNumber(n);
        setBalance(s);
        this.minimum = m;
    }

    @Override
    public void deposit(double amount) {

        setBalance(getBalance()+amount);
    }

    @Override
    public void withdraw(double amount) {

        if (getBalance() >= amount){ setBalance(getBalance() - amount); }
        if (getBalance() < this.minimum){ setBalance(getBalance() - 10); }
    }
}
