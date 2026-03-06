package Gpt;

import java.util.Random;
import java.util.Scanner;

public class RPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pick Rock, Paper or Scissors: ");

        Random random = new Random();

        String[] options = {"Rock", "Paper", "Scissors" };
        String input = sc.nextLine();
        int randomIndex = random.nextInt(options.length);
        String computer =  options[randomIndex];

        System.out.println("You: "+input+", Computer: "+computer);
        if (computer.equalsIgnoreCase(input)){
            System.out.println("It's a tie");
        } else if (computer.equals("Rock") && input.equalsIgnoreCase("Paper")) {
            System.out.println("You Win!🥳");
        } else if (computer.equals("Scissors") && input.equalsIgnoreCase("Rock")) {
            System.out.println("You Win!🥳");
        } else if (computer.equals("Paper") && input.equalsIgnoreCase("Scissors")) {
            System.out.println("You Win!🥳");
        } else {
            System.out.println("Computer Wins!");
        }


//            switch (input) {
//                case "Rock":
//                    System.out.println("You: " + input + ", Computer: Scissors: You won🥳");
//                    break ;
//                case "Paper":
//                    System.out.println("You: " + input + ", Computer: Rock: You won🥳");
//                    break ;
//                case "Scissors":
//                    System.out.println("You: " + input + ", Computer: Paper: You won🥳");
//                    break ;
//                default:
//                    System.out.println("Not an option");
//                    break;
//            }
     }
}
