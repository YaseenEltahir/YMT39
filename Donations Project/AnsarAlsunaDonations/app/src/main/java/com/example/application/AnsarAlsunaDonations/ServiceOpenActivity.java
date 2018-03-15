package com.example.application.AnsarAlsunaDonations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ServiceOpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_open);

        DataClass.setServiceState(this,true);
        this.finish();

    }
}
