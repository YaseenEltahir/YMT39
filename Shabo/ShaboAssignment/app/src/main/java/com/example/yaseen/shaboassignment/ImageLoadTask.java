package com.example.yaseen.shaboassignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yaseen on 24/08/2017.
 */

public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap>{


    private String url;
    private ImageView imageView;
    private Context context;
    private Integer imageId;

    public ImageLoadTask(String url, ImageView imageView,Integer imageId, Context context) {
        this.url = url;
        this.imageView = imageView;
        this.context=context;
        this.imageId=imageId;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        try {
            URL urlConnection = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);

            return myBitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);

        imageView.setImageBitmap(result);
    }

    }
