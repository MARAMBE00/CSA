package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static DataInputStream dis = null;
    private static DataOutputStream dos = null;
    private static Scanner scanner = null;
    private static Socket socket = null;

    public static void main(String[] args) {

        try {
            // Define a socket with localhost and port number 5000 as arguments
            socket = new Socket("localhost", 5000);

            // Create new instances of dataInputStream, DataOutputStream and Scanner
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);

            while (true){
                System.out.print("Enter a message here (type 'exit' to stop): ");
                String message = scanner.nextLine();

                // Send the message to the server
                dos.writeUTF(message);
                if(message.equals("exit")){
                    break;
                }
                // Receive the response from the server
                String response = dis.readUTF();
                System.out.println("Server response: " + response);
            }
            dis.close();
            dos.close();
            scanner.close();
            socket.close();
        }catch (UnknownHostException e){
            System.out.println("Unknown host: localhost");
        }catch (IOException e){
            System.out.println("Error connecting to server.");
        }
    }
}