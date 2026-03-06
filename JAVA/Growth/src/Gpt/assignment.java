package Gpt;

import java.util.Scanner;

public class assignment {
    public static void main(String[] args) {
        


        System.out.println("Analyzer 2.0");
        Scanner sc = new Scanner(System.in);
        String name = "";

        while (true){
            System.out.println("Enter a name: ");
            name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("exit")){
                System.out.println("Goodbye");
                break;
            }

//crosschecked with your previous example
            String lowerName = name.toLowerCase();
            char first = lowerName.charAt(0);
            char last = lowerName.charAt(lowerName.length() -1);


            if (first == last ) {
                System.out.println("Same letter at beginning and end");
            }

            if (name.length() > 6){
                System.out.println("That’s a long name!");
            }

            int vowelCount = 0;
            for (int i = 0; i < lowerName.length(); i++) {
                if ("aeiou".indexOf(lowerName.charAt(i)) != -1) {
                    vowelCount++;
                }
            }

            if (vowelCount > 0){
                System.out.println("This name sings!");

            }


            //I googled this one cuz I couldn't figure it out 😓
            String rev = "";
            for (int i = lowerName.length() - 1; i >= 0; i--) {
                rev = rev + lowerName.charAt(i);
            }

            if (rev.equals(lowerName)) {
                System.out.println("Whoa! A mirror name 🥳");
            }
            }
        }
    }

