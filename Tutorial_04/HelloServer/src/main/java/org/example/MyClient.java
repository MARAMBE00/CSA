package org.example;

import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient {

    public static void main(String[] args) {

        try{
            //Create a socket with two parameters; hostname and port number
            Socket s = new Socket("localhost", 6666);

            //Output stream to send the message to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            //Writes a string to the underlying output stream using modified UTF-8 encoding.
            dout.writeUTF("Hello Server");

            //Flush the characters from the buffered writer stream
            dout.flush();

            dout.close();
            //Close the connection
            s.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}