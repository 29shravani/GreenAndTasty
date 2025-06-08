package org.example.interview.oops.inheritance;

public class Manager extends Employee{
    protected String department;
    public Manager(String name, int age, int salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    public void displayDetails(){
        System.out.println("name : "+name);
        System.out.println("age : "+age);
        System.out.println("salary : "+salary);
        System.out.println("department : "+department);
    }
}
