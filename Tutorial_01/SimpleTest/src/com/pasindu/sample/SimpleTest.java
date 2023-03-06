package com.pasindu.sample;

public class SimpleTest {

    DummyServer server = new DummyServer();

    public static void main(String[] args) {

        SimpleTest test = new SimpleTest();
        test.execute();
    }

    private void execute(){
        System.out.println(server.testConnection());
    }
}
