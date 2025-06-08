package org.example.interview.oops.inheritance;

public class Person {
    protected String name;
    protected int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void displayDetails(){
        System.out.println("name : "+name);
        System.out.println("age : "+age);
    }
}
