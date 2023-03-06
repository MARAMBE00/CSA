package com.pasindu.sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DummyServer {

    private Scanner scanner = new Scanner(System.in);
    String serverName = "DummyDummy";

    String getConnection(){

        System.out.println("Dummy server. Connection being tested...");
        return "Connection Succeeded";
    }

    String testConnection(){
        System.out.print("Enter your ID: ");
        String id = scanner.next();

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formattedDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String newFormattedDateTime = dateTime.format(formattedDateTime);

        System.out.println("Dummy server. Connection being tested...");
        return "[" + newFormattedDateTime + "] - Server " + serverName + " : Connection from client " + id + " Succeeded";
    }
}
