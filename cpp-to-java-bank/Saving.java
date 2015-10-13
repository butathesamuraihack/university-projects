package cpptojava.bank;


public class Saving extends Account {

    private float rate;

    public float getRate() { return rate; }
    public void setRate(float rate) { this.rate = rate; }

    public Saving(){

        setNumber(0);
        setBalance(0.0);
        this.rate = 0;
    }

    public Saving(int n){

        setNumber(n);
        setBalance(0.0);
        this.rate = 0;
    }

    public Saving(int n, double s){

        setNumber(n);
        setBalance(s);
        this.rate = 0;
    }

    public Saving(int n, double s, float t){

        setNumber(n);
        setBalance(s);
        this.rate = t;
    }

    @Override
    public void deposit(double amount) {

        setBalance(getBalance()+amount);
        if (getBalance() > 1000){ setBalance(getBalance() * (1+ this.rate)); }
    }

    @Override
    public void withdraw(double amount) {

        if(getBalance() >= amount){ setBalance(getBalance() - amount); }
    }
}
