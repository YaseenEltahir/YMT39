package com.example.application.AnsarAlsunaDonations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    public void goBack (View view)
    {
        this.finish();
    }
}
