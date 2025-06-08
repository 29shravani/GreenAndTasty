package org.example.interview.oops.abstraction;

public abstract class BaseTest {

    public BaseTest(){
        System.out.println("Base Test");
    }
    abstract void setUp();

    protected void tearDown(){
        System.out.println("Closing Browser......");
    }
}
