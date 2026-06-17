package Qwin;

import java.util.Scanner;

public class Assignment {
    public String GradeCalc(){
        Scanner sc = new Scanner(System.in);
        double mark = 0;
        boolean validInput = false;
        System.out.println("Welcome To Robust Grade Calculator");

        System.out.print("Enter Student Name: ");
        String name1 = sc.nextLine();  // better than next() for full names

        while (!validInput) {
            try {
                System.out.print("Enter your score (over 500): ");

                if (sc.hasNextDouble()) {
                    mark = sc.nextDouble();

                    if (mark >= 0 && mark <= 500) {
                        validInput = true;  // exit loop if valid
                    } else {
                        System.out.println("Please enter a value between 0 and 500.");
                    }
                } else {
                    String invalid = sc.next(); // consume bad token
                    System.out.println("Invalid input. Please enter a number.");
                }

            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
                sc.next(); // clear scanner buffer
            }
        }

        // Now calculate
        double percentage = (mark / 500) * 100;

        String grade = "";
        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        return "Hello %s, your percentage is %.2f%% and your grade is %s.%n"+
                name1 + percentage + grade;
    }

    public static void main(String[] args) {
        Assignment assignment = new Assignment();
        assignment.GradeCalc();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Welcome To Robust Grade Calculator");
//
//
//        System.out.print("Enter Student Name: ");
//        String name1 = sc.nextLine();  // better than next() for full names
//
//        double mark = 0;
//        boolean validInput = false;
//
//        while (!validInput) {
//            try {
//                System.out.print("Enter your score (over 500): ");
//
//                if (sc.hasNextDouble()) {
//                    mark = sc.nextDouble();
//
//                    if (mark >= 0 && mark <= 500) {
//                        validInput = true;  // exit loop if valid
//                    } else {
//                        System.out.println("Please enter a value between 0 and 500.");
//                    }
//                } else {
//                    String invalid = sc.next(); // consume bad token
//                    System.out.println("Invalid input. Please enter a number.");
//                }
//
//            } catch (Exception e) {
//                System.out.println("An unexpected error occurred. Please try again.");
//                sc.next(); // clear scanner buffer
//            }
//        }
//
//        // Now calculate
//        double percentage = (mark / 500) * 100;
//
//        String grade = "";
//        if (percentage >= 90) {
//            grade = "A";
//        } else if (percentage >= 80) {
//            grade = "B";
//        } else if (percentage >= 70) {
//            grade = "C";
//        } else if (percentage >= 60) {
//            grade = "D";
//        } else {
//            grade = "F";
//        }
//
//        System.out.printf("Hello %s, your percentage is %.2f%% and your grade is %s.%n",
//                name1, percentage, grade);
    }
}

//90–100 → A
//80–89 → B
//70–79 → C
//60–69 → D
//Below 60 → F