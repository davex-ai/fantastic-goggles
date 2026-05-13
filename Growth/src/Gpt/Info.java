package Gpt;

import java.util.Scanner;

public class Info {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = "";
        System.out.println("Press exit to stop program");

        while (!name.equalsIgnoreCase("exit")) {
            System.out.print("Enter a name: ");
            name = sc.nextLine();

            if (!name.equalsIgnoreCase("exit")) {
                System.out.println("Hi " + name + " welcome to the loop club!");
            }
        }
        System.out.println("Program ended");
    }
}

//        System.out.print("Enter your name: ");
//        String name = sc.nextLine();

//        System.out.println("Hi " + name + ", How old are you? ");
//        int age = sc.nextInt();
//        sc.nextLine();
//
//        System.out.print(name +" Enter your favourite number:");
//        int num = sc.nextInt();

//        if (num % 2 == 0){
//        if (age < 13){
//                System.out.println("Woah! "+name +" You’re a budding odd genius!");
//        } else if (age >= 13 && age <= 19) {
//            System.out.println(name + " You're a teen math genius!");
//            } else if (age > 19) {
//            System.out.println(name +" You're a number master!");
//            }
//        }
//
//        if (num % 2 != 0){
//            if (age < 13){
//                System.out.println("Woah! "+name +" You’re a budding even genius!");
//            } else if (age >= 13 && age <= 19) {
//                System.out.println(name + " You're EVEN a teen math genius!");
//            } else if (age > 19) {
//                System.out.println(name +" You're an EVENLY number master!");
//            }
//        }

//        int age = 15;//recently did my birthday 😅
//        String name = "Nexora";
//        double height = 5.4;
//        boolean islearning = true;
//        String dream = "better than Gazi";
//        System.out.println("Name: " + name);
//        System.out.println("Age: " + age);
//        System.out.println("Height: "+ height + "ft");
//        System.out.println("Learning CS: " + islearning);
//        System.out.println(age+ " yr old " +name + " who is dreaming  to be " + dream);

//        int a = 10;
//        int b = 3;
//        double c = 1;
//        System.out.println("Addition: " + (a + b));
//        System.out.println("Subtraction: " + (a - b));
//        System.out.println("Multiplication: " + (a * b));
//        System.out.println("Division: " + (a / b));
//        System.out.println("Remainder: " + (a % b));
//        System.out.println("Exponation of 10: " +(a*a));
//        System.out.println("Average: "+ ((c+b)/2));




//
//        System.out.print("Enter your Age: ");
//        int age = sc.nextInt();
//        sc.nextLine();
//
//        System.out.print("Enter a hobby: ");
//        String hobby = sc.nextLine();
//S
//        System.out.println("Hi "+name +" you're "+age+ " years old and love "+hobby+" Keep going!");




//        if (age < 13){
//            System.out.println("Hey "+name+" you're a kid genius!");
//        } else if (age == 15) {
//            System.out.println("Scary and Uncertain 15! You’re Nexora’s age!");
//        } else if (age > 13 && age < 17) {
//            System.out.println("Hey " + name + ", you're a smart teenager!");
//        }else {
//            System.out.println("Hey "+name+", you're an adult in the making!");
//        }


