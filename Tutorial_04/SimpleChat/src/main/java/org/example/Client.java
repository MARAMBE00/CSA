package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client{

    private String host;
    private int port;
    private String nickname;

    public Client(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void run() throws UnknownHostException, IOException{
        Socket socket = new Socket(host, port);
        System.out.println("Successfully connected to server at " + host + " : " + port);

        new Thread(new ReceivedMessagesHandler(socket.getInputStream())).start();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your nickname: ");
        nickname = scanner.nextLine();

        PrintStream output = new PrintStream(socket.getOutputStream(), true);
        while (true){
            String message = scanner.nextLine();
            if(message.equalsIgnoreCase("quit")){
                output.close();
                scanner.close();
                socket.close();
                break;
            }else {
                output.println(nickname + " : " + message);
            }
        }
    }
}

class ReceivedMessagesHandler implements Runnable{

    private InputStream server;

    public ReceivedMessagesHandler(InputStream server) {
        this.server = server;
    }

    @Override
    public void run() {
        // receive server messages and print out to screen
        Scanner s = new Scanner(server);
        while (s.hasNextLine()){
            System.out.println(s.nextLine());
        }
        s.close();
    }
}