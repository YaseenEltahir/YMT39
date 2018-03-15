package com.example.yaseen.shaboassignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Yaseen on 24/08/2017.
 */

public class GetStateTask  extends AsyncTask<Void, Void, String> {


    private String url;
    private String imageUrl;


    private Context context;
    private ImageView imageView;



    public GetStateTask(String url,String imageUrl,Context context,ImageView imageView) {
        this.url = url;
        this.context=context;
        this.imageView=imageView;
        this.imageUrl=imageUrl;
    }

    @Override
    protected String doInBackground(Void... params) {

            String response = null;
            try {
                URL url1 = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
                conn.setRequestMethod("GET");
                // read the response
                InputStream in = new BufferedInputStream(conn.getInputStream());
                response = convertStreamToString(in);
            } catch (MalformedURLException e) {
                //Log.e(TAG, "MalformedURLException: " + e.getMessage());
            } catch (ProtocolException e) {
                //Log.e(TAG, "ProtocolException: " + e.getMessage());
            } catch (IOException e) {
                //Log.e(TAG, "IOException: " + e.getMessage());
            } catch (Exception e) {
                e.getMessage();
                //Log.e(TAG, "Exception: " + e.getMessage());
            }
            return response;

    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        if(response.equals("1\n"))
            new ImageLoadTask(imageUrl, imageView,R.id.image3,context).execute();

    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}

