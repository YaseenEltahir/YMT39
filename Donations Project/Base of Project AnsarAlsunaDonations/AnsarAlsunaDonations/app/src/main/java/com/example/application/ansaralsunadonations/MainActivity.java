package com.example.application.ansaralsunadonations;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button balance = (Button) findViewById(R.id.balance);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getLayoutInflater().inflate(R.menu.isp, (ViewGroup) menu);
        return true;

    }

    private Uri ussdToCallableUri(String ussd) {

        String uriString = "";

        if(!ussd.startsWith("tel:"))
            uriString += "tel:";

        for(char c : ussd.toCharArray()) {

            if(c == '#')
                uriString += Uri.encode("#");
            else
                uriString += c;
        }

        return Uri.parse(uriString);
    }
    public void checkBalance(View view)
    {
        String ussdCode = "*888#";

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(ussdToCallableUri(ussdCode));

        try{
            startActivity(intent);

        } catch (SecurityException e){
            Toast.makeText(getApplicationContext(), "intent failed to start", Toast.LENGTH_LONG).show();

            e.printStackTrace();
        }
    }

}
