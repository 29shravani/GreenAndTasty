package org.example.interview.oops.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(2);
        circle.area();

        Shape square = new Square(4);
        square.area();

        Circle circle1 = new Circle(2);
        circle1.add(2.0,3);
        circle1.add(2, 3.0);
    }
}
