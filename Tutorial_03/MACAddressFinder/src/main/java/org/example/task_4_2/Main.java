package org.example.task_4_2;

import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try{
            String s = "http://www.java2novice.com/java_constructor_examples/?query=ok#header";
            URL url = new URL(s);

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host Name: " + url.getHost());
            System.out.println("Port Number: " + url.getPort());
            System.out.println("Authority of the URL: " + url.getAuthority());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Reference: " + url.getRef());
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
