package org.example.task_4_3;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args){

        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()){
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if(networkInterface.isUp()){
                    System.out.println("Interface: " + networkInterface.getName());

                    Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                    while (addresses.hasMoreElements()){
                        InetAddress address = addresses.nextElement();
                        if(address instanceof InetAddress && !address.isLinkLocalAddress()){
                            System.out.println("Active Address: " + address.getHostAddress());
                        }
                    }
                }
            }
        }catch (SocketException e){
            System.out.println("Error occurred while getting active addresses: " + e.getMessage());
            // Logging the error using Java Logging API
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
