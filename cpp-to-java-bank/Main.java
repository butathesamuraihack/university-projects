package cpptojava.bank;

public class Main{

    public void ShowAccount(Account t){

        System.out.println("Account number:" + t.getNumber());
        System.out.printf("Balance:%.2f\n", t.getBalance());
    }

    public void ShowRate(Saving t){

        System.out.println("Rate:"+ t.getRate());
    }

    public void Transfer(Saving m, Saving n, double amount){

        m.withdraw(amount);
        n.deposit(amount);
    }

    public void Transfer(Checking m, Saving n, double amount){

        m.withdraw(amount);
        n.deposit(amount);
    }

    public void ShowMinimum(Checking t){

        System.out.println("Minimum Balance:" + t.getMinimum());
    }

    public static void main(String[] args){

        Saving A = new Saving(1010,1000.0);
        Saving B = new Saving(2020);

        Checking C = new Checking(3030,3000.0,100);
        Checking D = new Checking(4040,4000.0);

        Main operations = new Main();

        A.setRate(0.10f);
        B.setBalance(2000);
        B.setRate(0.12f);

        System.out.println("Saving Account A");
        operations.ShowAccount(A);
        operations.ShowRate(A);

        System.out.println("\nSaving Account B");
        operations.ShowAccount(B);
        operations.ShowRate(B);

        System.out.println("\nBs 250 Has been transferred From A to B\n");

        operations.Transfer(A, B, 250);
        operations.ShowAccount(A);
        operations.ShowAccount(B);

        D.setMinimum(50.0f);
        System.out.println("\nChecking Account C");
        operations.ShowAccount(C);
        operations.ShowMinimum(C);

        System.out.println("\nChecking Account D");
        operations.ShowAccount(D);
        operations.ShowMinimum(D);

        System.out.println("\nBs 500 Has been transferred From D to A\n");

        operations.Transfer(D, A, 500);
        operations.ShowAccount(D);
        operations.ShowAccount(A);
    }
}
