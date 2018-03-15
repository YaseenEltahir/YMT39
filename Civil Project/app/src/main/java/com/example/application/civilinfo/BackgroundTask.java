package com.example.application.civilinfo;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Yaseen on 25/04/2017.
 */

public class BackgroundTask extends AsyncTask<String,Void,String>{



    Context context;
    BackgroundTask(Context context)
    {
        this.context=context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String reg_url="https://yaseeneltahir.000webhostapp.com/civilinfo/register.php";//"http://192.168.43.81:8080/civilinfo/register.php";
        String method=strings[0];
        if(method.equals("register"))
        {
            String info1= strings[1];
            String info2= strings[2];
            String info3= strings[3];
            String info4= strings[4];
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data= URLEncoder.encode("info1","UTF-8")+"="+URLEncoder.encode(info1,"UTF-8")+"&"+
                        URLEncoder.encode("info2","UTF-8")+"="+URLEncoder.encode(info2,"UTF-8")+"&"+
                        URLEncoder.encode("info3","UTF-8")+"="+URLEncoder.encode(info3,"UTF-8")+"&"+
                        URLEncoder.encode("info4","UTF-8")+"="+URLEncoder.encode(info4,"UTF-8")+"&";
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                inputStream.close();
                return "Registration Success";



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context,result.toString(),Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onProgressUpdate(Void...values) {
        super.onProgressUpdate(values);
    }
}
