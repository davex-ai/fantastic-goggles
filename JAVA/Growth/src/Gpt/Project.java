package Gpt;

import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Analyzer 🥳");

        String name = "";
        while (true) {
            System.out.print("Enter a name (or type 'exit' to quit): ");
            name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye! Come again!");
                break;
            }

            String lowerName = name.toLowerCase();
            char first = lowerName.charAt(0);
            char last = lowerName.charAt(lowerName.length() - 1);

            if (first == last) {
                System.out.println(name + " starts and ends with the same letter.");
            }

            int vowelCount = 0;
            for (int i = 0; i < lowerName.length(); i++) {
                if ("aeiou".indexOf(lowerName.charAt(i)) != -1) {
                    vowelCount++;
                }
            }

            System.out.println("Vowels in " + name + ": " + vowelCount);

            if (vowelCount > 3 && name.length() >= 6) {
                System.out.println("This name is musical.");
            }

            System.out.println(); // spacing
        }
    }

}


//Challenge: Name Analyzer
//
//Ask the user for a name. Then:
//
//Say whether it starts and ends with the same letter
//
//Count how many vowels are in the name
//
//If the name has more than 3 vowels and is at least 6 letters long, print “This name is musical.”
//
//Keep looping until the user types “exit”