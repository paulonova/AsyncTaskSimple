package com.hanselandpetal.catalog;

import android.net.http.AndroidHttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPManager {

    /*
    * TODO: This method is all I need to make REQUEST and have back the RESPONSE...*/


    public static String getData(String uri){


//        AndroidHttpClient client = AndroidHttpClient.newInstance("AndroidAgent");
//        HttpGet request = new HttpGet(uri);
//        HttpResponse response;
//
//        try {
//            response = client.execute(request);
//            return EntityUtils.toString(response.getEntity());
//
//        }catch(Exception e) {
//            e.printStackTrace();
//            return null;
//
//        }finally {
//            client.close();
//        }


        BufferedReader reader = null;

        try {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while((line = reader.readLine()) != null){
                sb.append(line + "\n");
            }

            return sb.toString();

        }catch(Exception e){
            e.printStackTrace();
            return null;

        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }




}
