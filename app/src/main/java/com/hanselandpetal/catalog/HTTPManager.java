package com.hanselandpetal.catalog;

import android.net.http.AndroidHttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class HTTPManager {

    /*
    * TODO: This method is all I need to make REQUEST and have back the RESPONSE...*/


    public static String getData(String uri){

        AndroidHttpClient client = AndroidHttpClient.newInstance("AndroidAgent");
        HttpGet request = new HttpGet(uri);
        HttpResponse response;

        try {
            response = client.execute(request);
            return EntityUtils.toString(response.getEntity());

        }catch(Exception e) {
            e.printStackTrace();
            return null;

        }finally {
            client.close();
        }

    }


}