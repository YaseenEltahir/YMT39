package com.example.yaseen.shaboassignment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //String string=makeServiceCall("http://192.168.43.81:8080/shaboAssignment/checkActive.php?id=1");
        //Toast.makeText(this,string,Toast.LENGTH_LONG).show();
        ImageView image1=(ImageView) findViewById(R.id.image1);
        new GetStateTask("http://192.168.43.81:8080/shaboAssignment/checkActive.php?id=1","http://192.168.43.81:8080/shaboAssignment/downloadFile.php?id=1",MainActivity.this,image1).execute();
        ImageView image2=(ImageView) findViewById(R.id.image2);
        new GetStateTask("http://192.168.43.81:8080/shaboAssignment/checkActive.php?id=2","http://192.168.43.81:8080/shaboAssignment/downloadFile.php?id=2",MainActivity.this,image2).execute();
        ImageView image3=(ImageView) findViewById(R.id.image3);
        new GetStateTask("http://192.168.43.81:8080/shaboAssignment/checkActive.php?id=3","http://192.168.43.81:8080/shaboAssignment/downloadFile.php?id=3",MainActivity.this,image3).execute();
        /*new ImageLoadTask("http://192.168.43.81:8080/shaboAssignment/downloadFile.php?id=1", image1,R.id.image1,this).execute();
        ImageView image2=(ImageView) findViewById(R.id.image2);
        new ImageLoadTask("http://192.168.43.81:8080/shaboAssignment/downloadFile.php?id=2", image2,R.id.image2,this).execute();
        ImageView image3=(ImageView) findViewById(R.id.image3);
        new ImageLoadTask("http://192.168.43.81:8080/shaboAssignment/downloadFile.php?id=3", image3,R.id.image3,this).execute();
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
