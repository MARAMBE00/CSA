package org.example;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaTLSCServerExample {

    private static final String[] protocols = new String[]{"TLSv1.3"};
    private static final String[] cipher_suites = new String[]{"TLS_AES_128_GCM_SHA256"};

    public static void main(String[] args) throws Exception{

        SSLServerSocket serverSocket = null;

        try {
            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) factory.createServerSocket(8990);
            serverSocket.setEnabledProtocols(protocols);
            serverSocket.setEnabledCipherSuites(cipher_suites);
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String request = null;

            while((request = bufferedReader.readLine()) != null) {
                System.out.println(request);
                System.out.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                serverSocket.close();
            }
        }
    }
}
