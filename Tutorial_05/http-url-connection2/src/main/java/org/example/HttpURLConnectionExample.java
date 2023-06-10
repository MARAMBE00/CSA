package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://www.google.com/search?q=javaguides";

    private static void sendHttpGETRequest() throws IOException{

        URL url = new URL(GET_URL);
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        huc.setRequestMethod("GET");
        huc.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = huc.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        if(responseCode == HttpURLConnection.HTTP_OK){  // Success
            BufferedReader in = new BufferedReader(new InputStreamReader(huc.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString()); // Print result
        }else {
            System.out.println("GET request not worked");
        }
        for (int i=1; i<=10; i++){
            System.out.println(huc.getHeaderFieldKey(i) + " = " + huc.getHeaderField(i));
        }
    }

    public static void main(String[] args) throws Exception{
        sendHttpGETRequest();
    }
}