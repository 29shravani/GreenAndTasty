package org.example.interview.oops.polymorphism;

public class Circle extends Shape {
    private int radius;
    public Circle(int radius){
        this.radius = radius;
    }

    public void area(){
        System.out.println("Circle area = "+3.14*radius*radius);
    }
    public double add(double a, int b){
        return a+b;
    }
    public double add(int a, double b){
        return a+b;
    }
}
