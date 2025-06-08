package org.example.interview.oops.abstraction;

public class LoginTest extends BaseTest{
    public LoginTest(){
        System.out.println("Login Test");
    }
    @Override
    void setUp() {
        System.out.println("setUp driver and navigate to login page");
    }

}
