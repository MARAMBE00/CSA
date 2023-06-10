package org.example;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args){

        String s = "https://www.google.com";

        try{
            // Fetch IP address by getByName() and getHost()
            InetAddress ip = InetAddress.getByName(new URL(s).getHost());
            System.out.println("IP address is: " + ip);
        }catch (UnknownHostException e){
            System.out.println("Unknown");
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        }
    }
}