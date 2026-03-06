package Bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Account {
    private static double balance;
    private static final Lock lock = new ReentrantLock();

    public Account(double balance) {
        this.balance = balance;

    }

    public static void withdraw(double Amount, String Name) {
        lock.lock();
        try {
            if (balance >= Amount) {
                System.out.println(Name + " is attempting to withdraw " + Amount);
                Thread.sleep(1000);
                balance -= Amount;
                System.out.println(Name + ", Your withdrawal " + Amount + "is Successful, New balance:" + balance);
            } else {
                System.out.println(Name + ", Withdrawal failed due to insufficient balance");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }

    public double getBalance() {
        return balance;
    }
}

      class user extends Thread {
    private final String User;
    private final double Amount;



    user(String user, double amount) {
        User = user;
        Amount = amount;
    }
    @Override
    public void run(){
        Account.withdraw(Amount, User);
    }

}
