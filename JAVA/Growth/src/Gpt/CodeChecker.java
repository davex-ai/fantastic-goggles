package Gpt;

import java.util.Scanner;

public class CodeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To The Secret Code Checker");

        while (true) {
            System.out.print("Enter a code word (or type 'exit' to quit): ");
            String code = sc.nextLine().trim();

            if (code.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye");
                break;
            }

            boolean hasLetter = false;
            boolean hasDigit = false;
            boolean hasSpace = code.contains(" ");


            // Check for letters and numbers
            for (int i = 0; i < code.length(); i++) {
                char ch = code.charAt(i);
                if (Character.isLetter(ch)) {
                    hasLetter = true;
                }
                if (Character.isDigit(ch)) {
                    hasDigit = true;
                }
            }


            // Now handle the checks
            if (code.length() < 8) {
                System.out.println("❌ Too short!");
            }
            if (!hasLetter) {
                System.out.println("❌ Needs letters!");
            }
            if (!hasDigit) {
                System.out.println("❌ Needs numbers!");
            }
            if (hasSpace) {
                System.out.println("❌ No spaces allowed!");
            }

            // If all are good, it's a strong code word
            if (code.length() >= 8 && hasLetter && hasDigit && !hasSpace) {
                System.out.println("✅ Strong code word!");
            }

            // Palindrome check
            String lower = code.toLowerCase();
            String reversed = "";
            for (int i = lower.length() - 1; i >= 0; i--) {
                reversed += lower.charAt(i);
            }

            if (lower.equals(reversed)) {
                System.out.println("👀 Suspicious! Palindromes are predictable.");
            }

            System.out.println(); // Just to space things nicely
        }
    }
}
