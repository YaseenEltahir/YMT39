package com.example.application.AnsarAlsunaDonations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        /*if(DataClass.getServiceState(this)==1)
            Toast.makeText(this,"service is running",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"service is off",Toast.LENGTH_LONG).show();*/
        if(DataClass.getZainNum(this).equals("default"))
            DataClass.setZainNum(this,"0962987874");
        if(DataClass.getMTNNum(this).equals("default"))
            DataClass.setMTNNum(this,"0928616468");
        if(DataClass.getSudaniNum(this).equals("default"))
            DataClass.setSudaniNum(this,"0117911936");
        if(DataClass.getHour(this)==-1)
            DataClass.setHour(this,12);
        if(DataClass.getMinute(this)==-1)
            DataClass.setMinute(this,0);
        if(DataClass.getAmount(this).equals("default"))
            DataClass.setAmount(this,"1");
        if(DataClass.getServiceState2(this)==-1)
            DataClass.setServiceState2(this,0);



    }

    public void goToNext(View view)
    {
        if(DataClass.getUserISP(this)==-1)
            startActivity(new Intent(this,ISPActivity.class));
        else
            startActivity(new Intent(this,MainActivity.class));

    }
}
