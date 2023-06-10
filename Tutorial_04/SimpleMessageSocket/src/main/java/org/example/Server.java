package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static DataOutputStream dos = null;
    private static DataInputStream dis = null;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000.");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostName());

            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            while (true){
                String message = dis.readUTF();
                System.out.println("Received message: " + message);

                if(message.equals("exit")){
                    break;
                }
                dos.writeUTF("Server received message: " + message);
            }
            dis.close();
            dos.close();
            socket.close();
            serverSocket.close();
        }catch (IOException e){
            System.out.println("Error starting server.");
        }
    }
}
