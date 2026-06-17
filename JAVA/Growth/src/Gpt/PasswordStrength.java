package Gpt;

import java.util.Scanner;

public class PasswordStrength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//submit
        System.out.println("Password Strength Evaluator");

        while (true) {

            System.out.print("Enter a password: ");
            String password = sc.nextLine().trim();
            if (password.length() < 10) {
                System.out.println("Must be at least 10 characters ✅");
            }
            boolean lowercase = false;
            boolean uppercase = false;
            String small = password.toLowerCase();
            String space = "";

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isLetter(c)) {
                    lowercase = true;
                }
                if (Character.isLetter(c)) {
                    uppercase = true;
                }
            }
            if (!lowercase && !uppercase) {
                System.out.println("Must include both upper and lower case letters ✅");
            }
            String num = "1234567890";
            for (int n = 0; n < password.length(); n++) {
                if (!password.contains(num)) {
                    System.out.println("Must have at least one digit ✅");
                }
            }
            if (password.equals(num) && password.equals(small)){
                System.out.println("Must have at least one symbol (like @#$%) ✅");
            }

            if (password.contains(space)){
                System.out.println("Must not contain spaces ❌");
            }break;
        }
    }
}

