package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server{

    private int port;
    private ArrayList<PrintStream> clients;
    private ServerSocket server;

    public static void main(String[] args) throws IOException {

        new Server(12345).run();
    }

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<PrintStream>();
    }

    public void run() throws IOException{
        server = new ServerSocket(port){
            protected void finalize() throws IOException{
                this.close();
            }
        };
        System.out.println("Port 12345 is now open.");

        while (true){
            Socket socket = server.accept();
            String clientAddress = socket.getInetAddress().getHostAddress();

            PrintStream clientOutput = new PrintStream(socket.getOutputStream());
            clients.add(clientOutput);

            new Thread(new ClientHandler(this, socket.getInputStream())).start();
        }
    }

    void broadcastMassage(String msg){
        for(PrintStream client : this.clients){
            client.println(msg);
        }
    }
}

class ClientHandler implements Runnable{

    private Server server;
    private InputStream client;

    public ClientHandler(Server server, InputStream client) {
        this.server = server;
        this.client = client;
    }

    @Override
    public void run() {
        String message;

        Scanner sc = new Scanner(this.client);
        while(sc.hasNextLine()){
            message = sc.nextLine();
            server.broadcastMassage(message);
        }
        sc.close();
        System.out.println("Client disconnected");
    }
}
