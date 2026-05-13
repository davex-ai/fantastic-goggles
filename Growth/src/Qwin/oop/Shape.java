package Qwin.oop;
class School {
    Students students = new Students();
    Teacher teacher = new Teacher();
}
class Students {}
class Teacher {}
// OR DO U MEAN ??
class Schools{
    String Students;
    String Teachers;
}

class Circle extends Shape {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(
        circle.area(3,4));
        Rectangle rectangle = new Rectangle();
        System.out.println(
                rectangle.area(4,8));
    }

}
class Rectangle extends Shape {
}
abstract class Shape {
    int area(int breadth, int height) {
        return breadth * height;
    }
}