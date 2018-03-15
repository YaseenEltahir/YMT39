package com.example.application.AnsarAlsunaDonations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        EditText ZainEditText=(EditText) findViewById(R.id.editText);
        ZainEditText.setText(DataClass.getZainNum(this));

        EditText MTNEditText=(EditText) findViewById(R.id.editText2);
        MTNEditText.setText(DataClass.getMTNNum(this));

        EditText SudaniEditText=(EditText) findViewById(R.id.editText3);
        SudaniEditText.setText(DataClass.getSudaniNum(this));


        EditText AmountEditText=(EditText) findViewById(R.id.editText5);
        AmountEditText.setText(DataClass.getAmount(this));

        EditText HourEditText=(EditText) findViewById(R.id.editText8);
        HourEditText.setText(new Integer(DataClass.getHour(this)).toString());

        EditText MinuteEditText=(EditText) findViewById(R.id.editText7);
        MinuteEditText.setText(new Integer(DataClass.getMinute(this)).toString());





    }

    public void finish(View view)
    {
        EditText ZainEditText=(EditText) findViewById(R.id.editText);
        String ZainEditTextString=ZainEditText.getText().toString();
        DataClass.setZainNum(this,ZainEditTextString);

        EditText MTNEditText=(EditText) findViewById(R.id.editText2);
        String MTNEditTextString=MTNEditText.getText().toString();
        DataClass.setMTNNum(this,MTNEditTextString);

        EditText SudaniEditText=(EditText) findViewById(R.id.editText3);
        String SudaniEditTextString=SudaniEditText.getText().toString();
        DataClass.setSudaniNum(this,SudaniEditTextString);

        EditText AmountEditText=(EditText) findViewById(R.id.editText5);
        String AmountEditTextString=AmountEditText.getText().toString();
        DataClass.setAmount(this,AmountEditTextString);

        EditText HourEditText=(EditText) findViewById(R.id.editText8);
        String HourEditTextString=HourEditText.getText().toString();
        DataClass.setHour(this,Integer.valueOf(HourEditTextString));

        EditText MinuteEditText=(EditText) findViewById(R.id.editText7);
        String MinuteEditTextString=MinuteEditText.getText().toString();
        DataClass.setMinute(this,Integer.valueOf(MinuteEditTextString));



        this.finish();

      /*  EditText SudaniEditText=(EditText) findViewById(R.id.editText3);
        String SudaniEditTextString=SudaniEditText.getText().toString();
        ReturningClass.setSudaniNum(this,SudaniEditTextString);

        EditText SudaniEditText=(EditText) findViewById(R.id.editText3);
        String SudaniEditTextString=SudaniEditText.getText().toString();
        ReturningClass.setSudaniNum(this,SudaniEditTextString);*/



    }
}
