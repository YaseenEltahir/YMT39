package com.example.application.AnsarAlsunaDonations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ServiceCloseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_close);

        DataClass.setServiceState(this,false);



        this.finish();

    }
}
