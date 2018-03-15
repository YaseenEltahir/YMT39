package com.example.application.AnsarAlsunaDonations;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.Calendar;

public class UssdCallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussd_call);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());

        if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY)
            this.finish();

        if(DataClass.getUserISP(this)==1)
        callUssd("*200*"+ DataClass.getZainPUK(this)+"*"+ DataClass.getAmount(this)+
                "*"+ DataClass.getZainNum(this)
                +"*"+ DataClass.getZainNum(this)+"#");
        else if(DataClass.getUserISP(this)==2)
            callUssd("*121*"+ DataClass.getMTNNum(this)+"*00000*"+ DataClass.getAmount(this)+"00#");
        else
            callUssd("*303*"+ DataClass.getAmount(this)+"*"+ DataClass.getSudaniNum(this)+"*0000#");

        this.finish();
    }
    public void callUssd(String ussdCode)
    {

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(ussdToCallableUri(ussdCode));


        if(DataClass.getUserDeviceType(this))   //samsung
        {
            if(DataClass.getUserSelectedSlot(this))
                intent.putExtra("simSlot", 0);
            else
                intent.putExtra("simSlot", 1);

        }
        else {
            if(DataClass.getUserSelectedSlot(this))
                intent.putExtra("com.android.phone.extra.slot",0);

            else
                intent.putExtra("com.android.phone.extra.slot",1);

        }

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
