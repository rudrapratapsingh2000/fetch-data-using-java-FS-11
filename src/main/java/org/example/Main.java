package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        URL url=null;
        HttpURLConnection httpURLConnection=null;
        String urlString="https://api.chucknorris.io/jokes/random";
        int responsecode=0;
        try {
            url=new URL(urlString);

        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            httpURLConnection= (HttpURLConnection) url.openConnection();
            responsecode=httpURLConnection.getResponseCode();
        }catch (IOException e){
            e.printStackTrace();
        }
        if(responsecode==200){
            try{
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()) );
                StringBuilder apiData=new StringBuilder();
                String readLine=null;
                while((readLine=bufferedReader.readLine())!=null){
                    apiData.append(readLine);
                }
                bufferedReader.close();
                System.out.println(apiData);
            }catch(IOException e){
                e.printStackTrace();
            }

        }else{
            System.out.println("Some Problem Occured");
        }

    }
}