package com.pasindu.simpleTestTwo;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleClient {

    SimpleCalculatorServer server = new SimpleCalculatorServer();

    public static void main(String[] args) {

        SimpleClient simpleClient = new SimpleClient();
        simpleClient.executeTest();
    }

    private void executeTest(){
        System.out.println("[CLIENT] - Testing if the server is connected...");

        if(server.isServerConnected()){
            System.out.println("[CLIENT] - The server is connected, the test can proceed...\n");

            //invoke the addIntegerNumbers
            int x = 2;
            int y = 3;

            System.out.println("[CLIENT] - Asking the server what is the sum of " + x + " and " + y);

            int z = server.addIntegerNumbers(x, y);

            System.out.println("[CLIENT] - The server has replied that the sum of " + x + " and " + y + " is " + z);

            if(z == x+y){
                System.out.println("[CLIENT] - The server has returned the correct answer");
            }else{
                System.out.println("[CLIENT] - The server has returned the WRONG answer");
            }

            //invoke the divideIntegerNumbers
            double a = 4;
            double b = 3;
            double s = 0;
            //y = 0;

            System.out.println("\n[CLIENT] - Asking the server what is the ratio of " + a + " and " + b);

            try {
                s = server.divideIntegerNumbers(a, b);
                System.out.println("[CLIENT] - The server has replied that the division of " + a + " and " + b + " is " + s);
                //System.out.println("This line will not be seen!!!");
                if(s == a/b)
                    System.out.println("[CLIENT] - The server has returned the correct answer");
                else
                    System.out.println("[CLIENT] - The server has returned the WRONG answer");

            }catch (Exception ex){
                System.out.println("[CLIENT] - Exception caught!");
                Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            //invoke the subtractIntegerNumbers
            x = 5;
            y = 3;

            System.out.println("\n[CLIENT] - Asking the server what is the subtract of " + x + " and " + y);

            z = server.subtractIntegerNumbers(x, y);

            System.out.println("[CLIENT] - The server has replied that the subtract of " + x + " and " + y + " is " + z);

            if(z == x-y){
                System.out.println("[CLIENT] - The server has returned the correct answer");
            }else{
                System.out.println("[CLIENT] - The server has returned the WRONG answer");
            }

            //invoke the multiplyIntegerNumbers
            x = 2;
            y = 3;

            System.out.println("\n[CLIENT] - Asking the server what is the multiply of " + x + " and " + y);

            z = server.multiplyIntegerNumbers(x, y);

            System.out.println("[CLIENT] - The server has replied that the multiply of " + x + " and " + y + " is " + z);

            if(z == x*y){
                System.out.println("[CLIENT] - The server has returned the correct answer");
            }else{
                System.out.println("[CLIENT] - The server has returned the WRONG answer");
            }

            //invoke the addIntegerArray
            int[] d = {1,2,3};
            int[] e = {3,4};

            System.out.println("\n[CLIENT] - Asking the server what is the sum of array " + Arrays.toString(d) + " and " + Arrays.toString(e));

            try {
                String g;
                g = server.addIntegerArray(d, e);
                System.out.println("[CLIENT] - The server has replied that the sum of array " + Arrays.toString(d) + " and " + Arrays.toString(e) + " is " + g);

//            if(g == d + e){
//                System.out.println("[CLIENT] - The server has returned the correct answer");
//            }else{
//                System.out.println("[CLIENT] - The server has returned the WRONG answer");
//            }
            }catch (Exception ex){
                System.out.println("[CLIENT] - Exception caught!");
                Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
            }

            //invoke the divideIntegerArray
            int[] h = {6,2,3};
            int[] i = {3,4,5};

            System.out.println("\n[CLIENT] - Asking the server what is the subtract of array " + Arrays.toString(h) + " and " + Arrays.toString(i));

            try {
                String k;
                k = server.divideIntegerArray(h, i);
                System.out.println("[CLIENT] - The server has replied that the subtract of array " + Arrays.toString(h) + " and " + Arrays.toString(i) + " is " + k);

//            if(g == d + e){
//                System.out.println("[CLIENT] - The server has returned the correct answer");
//            }else{
//                System.out.println("[CLIENT] - The server has returned the WRONG answer");
//            }
            }catch (Exception ex){
                System.out.println("[CLIENT] - Exception caught!");
                Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("[CLIENT] - The server is NOT connected, the test has failed.");
        }
    }
}
