package org.example.task_4_1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void downloadWebPage(String webPage){
        try {
            // Create URL object
            URL url = new URL(webPage);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            // Enter filename in which you want to download
            BufferedWriter writer = new BufferedWriter(new FileWriter("page.html"));

            // Read each line from stream till end
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
            }
            reader.close();
            writer.close();
            System.out.println("Page downloaded.");
        }catch (MalformedURLException mue){
            System.out.println("Malformed URL Exception raised.");
        }catch (IOException ie){
            System.out.println("IOException raised.");
        }
    }

    public static void main(String[] args) throws IOException {
        String url = "https://www.google.com";
        downloadWebPage(url);
    }
}
