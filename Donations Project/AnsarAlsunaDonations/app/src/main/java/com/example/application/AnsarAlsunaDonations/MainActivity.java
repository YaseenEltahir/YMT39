package com.example.application.AnsarAlsunaDonations;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String ISP="zain";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(DataClass.getServiceState(this))

        {
            CoordinatorLayout CLayout = (CoordinatorLayout) findViewById(R.id.CLayout);
            CLayout.setBackgroundResource(R.drawable.green);
            Button Start=(Button) findViewById(R.id.StartAlarm);
            Start.setEnabled(false);

        }
        else
        {
            CoordinatorLayout CLayout = (CoordinatorLayout) findViewById(R.id.CLayout);
            CLayout.setBackgroundResource(R.drawable.orange);
            Button Start=(Button) findViewById(R.id.StartAlarm);
            Start.setEnabled(true);

        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.isp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        RelativeLayout main_view=(RelativeLayout) findViewById(R.id.main_view);
        switch (id)
        {
            case R.id.menu_settings:
                startActivity(new Intent(this,LoginActivity.class));
                return true;
            case R.id.menu_dual_sim_settings:
                startActivity(new Intent(this,DualSIMSettings.class));
                return true;
            case R.id.menu_about:
                startActivity(new Intent(this,About.class));
                return true;



            default:return super.onOptionsItemSelected(item);
        }


    }
    public void checkBalance(View view)
    {
        callUssd("*888#");

    }

    public void start(View view)
    {
        CoordinatorLayout CLayout = (CoordinatorLayout) findViewById(R.id.CLayout);
        CLayout.setBackgroundResource(R.drawable.green);
        Button Start=(Button) findViewById(R.id.StartAlarm);
        Start.setEnabled(false);
        final Intent intent1=new Intent(this,MainService.class);
        startService(intent1);
        DataClass.setServiceState(this,true);
    }
    public void stop(View view)
    {
        stopService(new Intent(this,MainService.class));
        //DataClass.setServiceState(this,false);
    }

    public void goToNext(View view)
    {
        Intent intent=new Intent(this,ISPActivity.class);
        startActivity(intent);
    }

    public void callUssd(String ussdCode)
    {

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(ussdToCallableUri(ussdCode));
        intent.putExtra("simSlot",1);
        //intent.putExtra("com.android.phone.extra.slot",0);


        try{
            startActivity(intent);

        } catch (SecurityException e){
            Toast.makeText(getApplicationContext(), "intent failed to start", Toast.LENGTH_LONG).show();

            e.printStackTrace();
        }
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


}
