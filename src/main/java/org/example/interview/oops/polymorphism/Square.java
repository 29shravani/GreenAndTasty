package org.example.interview.oops.polymorphism;

public class Square extends Shape {

    private int side;

    public Square(int side){
        this.side = side;
        System.out.println("Square object created");
    }

    public void area(){
        System.out.println("Area of Square = "+side*4);
    }
}
