/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Ваня
 */
public class App {
    private static final String REQUEST="http://www.fbi.gov/";
    public static void main(String[] args) throws MalformedURLException, IOException {
        try{
            URL url=new URL(REQUEST);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            String serverField=conn.getHeaderField("Server");
            if(serverField!=null){
                System.out.println("Informatsiq za servera: "+serverField);
            }else{
                System.out.println("WEB servera ne vrushta informatsiq za imeto na survura!");
            }
            conn.disconnect();
        }catch(MalformedURLException ex){
            System.err.println("Greshka: Nevaliden URL address.");
        }catch(IOException ex){
            System.err.println("Greshka pri izvlichane informatsiq ot WEB servera.");
        }
    }
}
