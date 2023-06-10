package com.pasindu.simpleTestTwo;

import java.util.Arrays;

public class SimpleCalculatorServer {

    public boolean isServerConnected(){
        System.out.println("[SERVER] - Connection is being tested...");
        return true;
    }

    public int addIntegerNumbers(int a, int b){
        System.out.println("[SERVER] - Adding " + a + " add " + b);
        return a + b;
    }

    public double divideIntegerNumbers(double a, double b) throws Exception{
        if(b == 0)
            throw new Exception();
        if(b ==0 && a == 0)
            throw new Exception();
        System.out.println("[SERVER] - Dividing " + a + " add " + b);
        return a / b;
    }

    public int subtractIntegerNumbers(int a, int b){
        System.out.println("[SERVER] - subtracting " + a + " subtract " + b);
        return a - b;
    }

    public int multiplyIntegerNumbers(int a, int b){
        System.out.println("[SERVER] - multiplying " + a + " multiply " + b);
        return a * b;
    }

    public String addIntegerArray(int[] a, int[] b) throws Exception{
        if(a != b)
            throw new Exception();
        System.out.println("[SERVER] - Adding " + Arrays.toString(a) + " add " + Arrays.toString(b));
        int[] result = new int[a.length];
        for(int i=0; i<result.length; i++){
            result[i] = a[i] + b[i];
        }
        return Arrays.toString(result);
    }

    public String divideIntegerArray(int[] a, int[] b) /*throws Exception*/{
//        if(a != b)
//            throw new Exception();
        System.out.println("[SERVER] - Dividing " + Arrays.toString(a) + " add " + Arrays.toString(b));
        int[] result = new int[a.length];
        for(int i=0; i<result.length; i++){
            result[i] = a[i] / b[i];
        }
        return Arrays.toString(result);
    }
}
