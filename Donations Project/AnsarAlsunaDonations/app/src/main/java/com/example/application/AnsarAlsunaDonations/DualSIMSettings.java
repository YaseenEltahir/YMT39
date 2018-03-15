package com.example.application.AnsarAlsunaDonations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DualSIMSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_simsettings);

        RadioButton radioButton1=(RadioButton) findViewById(R.id.radio1);
        RadioButton radioButton2=(RadioButton) findViewById(R.id.radio2);
        RadioButton radioButton3=(RadioButton) findViewById(R.id.radio3);
        RadioButton radioButton4=(RadioButton) findViewById(R.id.radio4);
        if(DataClass.getUserDeviceType(this)) {
            radioButton1.setChecked(true);
            radioButton2.setChecked(false);
        }
        else {
            radioButton2.setChecked(true);
            radioButton1.setChecked(false);
        }
        if(DataClass.getUserSelectedSlot(this)) {
            radioButton3.setChecked(true);
            radioButton4.setChecked(false);
        }
        else
        {
            radioButton4.setChecked(true);
            radioButton3.setChecked(false);
        }



    }
    public void toOk(View view)
    {
        RadioGroup radioGroup1=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioGroup radioGroup2=(RadioGroup)findViewById(R.id.radioGroup2);


        int radioButtonID1 = radioGroup1.getCheckedRadioButtonId();
        View radioButton1 = radioGroup1.findViewById(radioButtonID1);
        int idx = radioGroup1.indexOfChild(radioButton1);
        if(idx==0)
            DataClass.setUserDeviceType(this,true);
        else
            DataClass.setUserDeviceType(this,false);


        int radioButtonID2 = radioGroup2.getCheckedRadioButtonId();
        View radioButton2 = radioGroup2.findViewById(radioButtonID2);
        int idx2 = radioGroup2.indexOfChild(radioButton2);
        if(idx2==0)
            DataClass.setUserSelectedSlot(this,true);
        else
            DataClass.setUserSelectedSlot(this,false);

        this.finish();





    }
}
