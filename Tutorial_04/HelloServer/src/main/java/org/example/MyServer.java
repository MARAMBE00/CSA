package org.example;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args) {
        try{
            //Create a server socket using port number 6666
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept(); //Establish connection

            //Create inputStream to get the message from the client as an input
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("message= " + str);

            //Close server connection
            ss.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
