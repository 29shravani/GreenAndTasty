package org.example.interview.oops.inheritance;

public class Employee extends Person{
    protected int salary;
    public Employee(String name, int age, int salary){
        super(name, age);
        this.salary = salary;
    }
    public void displayDetails(){
        System.out.println("name : "+name);
        System.out.println("age : "+age);
        System.out.println("salary : "+salary);
    }

}
