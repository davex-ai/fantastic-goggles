package DSA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OOP {}

//why too rou to give up do ta to personal


    //Class + Object → Create a Car class with fields model, year, color. Instantiate 3 different cars and print their details.
      class Car {
        private String model;
        public int year;
        public String colour;

        public String details(String model, int year, String colour) {
            String colour1 = colour;
            return model + colour;
//            return colour;
//        return year
        }

        public Car(String model, int year, String colour) {
            this.model = model;
            this.year = year;
            this.colour = colour;
        }

        public static void main(String[] args) {
            Car ferrari = new Car("Ferrari", 2020, "White");
            Car bmw = new Car("BMW", 2022, "Grey");
            Car Bugatti = new Car("Bugatti", 2024, "Black");

        }

    }


    //Encapsulation → Make a BankAccount class with private balance. Add deposit(), withdraw(), getBalance().
    class BankAccount {
        private double balance;

        public double deposit(int amount) {
            balance += amount;
            return balance;
        }

        public double withdraw(int amount) {
            balance -= amount;
            return balance;
        }

        public double getBalance() {
            return balance;
        }
    }


    //Constructor practice → Student class with constructor that sets name and id.
    class Student {
        public String name;
        public int id;

        public Student(String name, int id) {
            name = this.name;
            id = this.id;
        }
    }


//Inheritance → Animal → Dog, Cat. Each has a makeSound() method. Call them from a single main().


    class Animal {
        void makeSound() {
            System.out.println("make a sound");
        }
    }

    class Dog extends Animal {
        void makeSound() {
            System.out.println("Bark!");
        }
    }

    class Cat extends Animal {
        void makeSound() {
            System.out.println("Meow!");
        }

        public static void main(String[] args) {
            Cat cat = new Cat();
            Dog dog = new Dog();
            Animal animal = new Animal();

            cat.makeSound();
            dog.makeSound();
            animal.makeSound();
        }
    }


//Polymorphism → Use an Animal reference to hold Dog/Cat and see overridden methods in action.
//        Animal c = new Cat();
//c.makeSound();

//Overloading → Make a Calculator with multiple add() methods (int, double, 3 params).


    class Calculator {
        public int add(int a, int b, int c) {
            return a + b + c;
        }

        public double add(double a, double b, double c) {
            return a + b + c;
        }

    }


    //Create an abstract class Shape with method area(). Implement Circle and Rectangle.
    class Circle extends Shape {
    }

    class Rectangle extends Shape {
    }

    abstract class Shape {
        int area(int breadth, int height) {
            return breadth * height;
        }
    }

//Question: Difference between interface and inheritance(why would i wanna use abstract class and not a normal class and inherit its properties, besides doesn't abstract still use inheritance relationship)
//
//
//
//Create an interface Playable with play(). Implement in Football, Chess.

    class Football implements Playable {
        int meat;

        public String play() {
            return "Field Game";
        }

        public static void main(String[] args) {
            Chess playable = new Chess();
            System.out.println(playable.play());
        }
    }

    class Chess implements Playable {
        int meat;

        public String play() {
            return "Board Game";
        }
    }

    interface Playable {
        int meat = 0;

        default String play() {
            return "play Game";
        }
    }

//Question: What does the default keyword do? and why must all methods in interface have it but not all properties, Is it compulsory to implement all methods and properties of an interface, why do we need abstract and interfaces when we have inheritance for regular class
//
//Combine: Abstract class + Interface together in one program. dont know how
//
//Inheritance (is-a) → Teacher extends Person.

    class Person {
        void job() {
            System.out.println("normal");
        }
    }

    class Teacher extends Person {
        void job() {
            System.out.println("Teaching");
        }
    }


//Composition (has-a) → Library has Books, Book has Author.
//Do u mean like books as a method in library class
//I don't understand the Composition (has-a); use cases, meaning etc
//        if getters and setters are use to modify data in constructor why does author getter and setter work in the book class

    class Libraryz {
        Books books = new Books();
        List<Books> book = new ArrayList< >();
}

    class Books {
        private Author author;
public String detail(){
    return author.name;
}

        public static void main(String[] args) {
            Books books = new Books();
            Author author1 = new Author();


            System.out.println(books.getAuthor());
            System.out.println(books.detail());
        }

//        author.name; // doesn't work

        public void setAuthor(Author author) {
            this.author = author;
        }

        public Author getAuthor() {
            return author;
        }
    }

    class Author {
        String name = "Shakespare";
        int age = 53;
    }


    //Make a mini system: School has Students, Teachers.
    class School {
        Students students = new Students();
        Teachers teacher = new Teachers();
    }

    class Students {
    }

    class Teachers {
    }

    // OR DO U MEAN ??
    class Schools {
        String Students;
        String Teachers;
    }


//Create a MathUtils class with static methods (add, subtract).Mix them into a program.Make constants with final (PI, MAX_USERS).

class MathUtils {

        public final double PI = 3.141;
        public final double e = 2.718;

        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiplication(int a, int b) {
            return a * b;
        }

        public int divide(int a, int b) {
            return a / b;
        }

        public int mod(int a, int b) {
            return a % b;
        }
    }

    //dont think i go the hang of it 📚 Library Book Tracker → Add books, borrow/return, list available books.
     class Library {
        public String books;
        public int bookId;
        public String category;
        public String author;
        private Date date;

        public Library(String books, String category) {
            this.books = books;
            this.category = category;
        }

        public String getBooks() {
            return books;
        }

        public void setBooks(String books, String author, String category) {
            this.books = books;
            this.bookId += 1;
            this.author += author;
            this.category += category;
        }

        public void borrow(String name, Date date) {
            this.books = name;
            this.date = date;
        }

        public String listBook() {
            return getBooks();
        }

    }

//explain static, final, native ; use cases, concept, constraints and condition for use etc



