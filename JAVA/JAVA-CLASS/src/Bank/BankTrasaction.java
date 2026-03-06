package Bank;
import java.util.Scanner;

public class BankTrasaction {
    public static void main(String[] args) {

    Scanner scanner =new Scanner(System.in);
    System.out.println("THE FX BANK ACCOUNT");
    Account JointAccount = new Account(3000);

    System.out.println("Enter your  Name:");
    String Name = scanner.nextLine();
    System.out.println("Enter Amount you want to withdraw:");
    int Amount= scanner.nextInt();
    user user1= new user(Name, Amount );

    System.out.println("Enter your  Name:");
    String Name2 = scanner.next();
    System.out.println("Enter Amount you want to withdraw:");
    int Amount2= scanner.nextInt();
    user user2= new user(Name2, Amount2 );

    user1.start();
    user2.start();

    try {
        user1.join();
        user2.join();
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    System.out.println("Final account balance: "+ JointAccount.getBalance());

}
}

