package org.example.interview.oops.abstraction;

public class Main {
    public static void main(String[] args) {
        BaseTest logintest = new LoginTest();
        logintest.setUp();
        logintest.tearDown();
    }
}
