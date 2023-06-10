package org.example.task_3_2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

public class PhysicalAddress {

    static String format = "%02X";  // To get 2 char output.

    private static String[] getPhysicalAddress() throws Exception{

        Set<String> macs = new LinkedHashSet<String>();
        Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();

        try {
            while (nis.hasMoreElements()) {
                NetworkInterface ni = nis.nextElement();

                // Physical Address (MAC - Medium Access Control)
                byte mac[] = ni.getHardwareAddress();
                if (mac != null) {
                    final StringBuilder macAddress = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macAddress.append(String.format("%s" + format, (i == 0) ? "" : ":", mac[i]));
                        //macAddress.append(String.format(format + "%s", mac[i], (i<mac.length-1) ? ":" : ""));
                    }
                    System.out.println(macAddress.toString());
                    macs.add(macAddress.toString());
                }
            }
        }catch (Exception ex){
            System.err.println("Exception:: " + ex.getMessage());
            ex.printStackTrace();
        }
        return macs.toArray(new String[0]);
    }

    public static void main(String[] args) throws Exception{

        //printing out the Host name and IP address of the local system.
        InetAddress localIPAddress = InetAddress.getLocalHost();
        System.out.println("Host name: " + localIPAddress.getHostName());
        System.out.println("IP address: " + localIPAddress.getHostAddress() + "\n");

        String macs2[] = getPhysicalAddress();
        //Create a for loop here and printing out MAC addresses
        for(int i=0; i<macs2.length; i++){

        }
    }
}
