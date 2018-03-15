package com.example.application.civilinfo;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
//import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    //private FirebaseAnalytics mFirebaseAnalytics;
    EditText e_info1, e_info2, e_info3, e_info4;
    Button button;
    TextView status;
    String info1, info2, info3, info4;
    String json_url = "https://yaseeneltahir.000webhostapp.com/civilinfo/getjson.php";//"http://192.168.43.81:8080/civilinfo/getjson.php";
    String json_string;
    String json_string1;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        e_info1 = (EditText) findViewById(R.id.editText1);
        e_info2 = (EditText) findViewById(R.id.editText2);
        e_info3 = (EditText) findViewById(R.id.editText3);
        e_info4 = (EditText) findViewById(R.id.editText4);
        button=(Button) findViewById(R.id.button);
        status=(TextView) findViewById(R.id.status);

        if(isNetworkAvailable())
            new ReadingBackgroundTask().execute();
        else
        {
            Toast.makeText(this, "Internet is unAvailable!", Toast.LENGTH_LONG).show();
            status.setText("Offline");
            status.setTextColor(Color.parseColor("#FFFFFF"));
            status.setTextColor(Color.RED);


        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void parseJson()
    {
        try {
            jsonObject = new JSONObject(json_string1);
            int count = 0;
            jsonArray = jsonObject.getJSONArray("server_response");
            while (count < jsonArray.length()) {
                JSONObject jsonObject = jsonArray.getJSONObject(count);
                info1 = jsonObject.getString("info1");
                info2 = jsonObject.getString("info2");
                info3 = jsonObject.getString("info3");
                info4 = jsonObject.getString("info4");

                e_info1.setText(info1);
                e_info2.setText(info2);
                e_info3.setText(info3);
                e_info4.setText(info4);

                e_info1.setEnabled(true);
                e_info2.setEnabled(true);
                e_info3.setEnabled(true);
                e_info4.setEnabled(true);
                button.setEnabled(true);
                status.setText("Online");
                status.setTextColor(Color.GREEN);



                count++;


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void save(View view) {

        if(!isNetworkAvailable())
        {
            Toast.makeText(this,"Internet is unAvailable!",Toast.LENGTH_LONG).show();
            return;
        }

        info1 = e_info1.getText().toString();
        info2 = e_info2.getText().toString();
        info3 = e_info3.getText().toString();
        info4 = e_info4.getText().toString();
        status.setText("Sending Data..");
        status.setTextColor(Color.parseColor("#FFFFFF"));
        String method = "register";
        WritingBackGroundTask writingBackGroundTask = new WritingBackGroundTask(this);
        writingBackGroundTask.execute(method, info1, info2, info3, info4);


    }
    /*public void push(View view) {
        EditText input = (EditText)findViewById(R.id.editText5);

        // Read the input field and push a new instance
        // of ChatMessage to the Firebase database
        FirebaseDatabase.getInstance()
                .getReference()
                .push()
                .setValue(new ChatMessage(input.getText().toString(),
                        FirebaseAuth.getInstance()
                                .getCurrentUser()
                                .getDisplayName())
                );

        // Clear the input
        input.setText("");


    }
*/



    class ReadingBackgroundTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {

            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((json_string = bufferedReader.readLine()) != null) {
                    stringBuilder.append(json_string + "\n");

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String string) {
            json_string1 = string;
            parseJson();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
    public class WritingBackGroundTask extends AsyncTask<String,Void,String>{



        Context context;
        WritingBackGroundTask(Context context)
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
            //Toast.makeText(context,result.toString(),Toast.LENGTH_LONG).show();
            status.setText("Online");
            status.setTextColor(Color.GREEN);

        }

        @Override
        protected void onProgressUpdate(Void...values) {
            super.onProgressUpdate(values);
        }
    }








}