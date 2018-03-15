package com.example.application.AnsarAlsunaDonations;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ISPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isp);


        String [] ISPs={"ZAIN","MTN","SUDANI"};
        ListAdapter myAdapter=new CustomAdapter(this,ISPs);
        ListView myListView=(ListView) findViewById(R.id.isp_list);
        myListView.setAdapter(myAdapter);
        final Intent intent=new Intent(this,MainActivity.class);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String isp=String.valueOf(adapterView.getItemAtPosition(i));



        if(isp.equals("ZAIN"))
        {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(ISPActivity.this);
            alertDialog.setTitle("YOUR PUK");
            alertDialog.setMessage("Enter ZAIN PUK");
            final EditText input = new EditText(ISPActivity.this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            input.setLayoutParams(lp);
            alertDialog.setView(input); // uncomment this line
            alertDialog.setNeutralButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            DataClass.setZainPUK(ISPActivity.this,input.getText().toString());

                            dialog.cancel();
                            boolean FirstTime=false;
                            if(DataClass.getUserISP(ISPActivity.this)==-1)
                                FirstTime=true;
                            DataClass.setUserISP(ISPActivity.this,1);

                            if(!FirstTime)
                                ISPActivity.this.finish();
                            else
                                startActivity(intent);


                        }
                    });
            alertDialog.show();

        }
        else if(isp.equals("MTN"))
        {
            boolean FirstTime=false;
            if(DataClass.getUserISP(ISPActivity.this)==-1)
                FirstTime=true;
            DataClass.setUserISP(ISPActivity.this,2);

            if(!FirstTime)
                ISPActivity.this.finish();
            else
                startActivity(intent);


        }
        else
        {
            boolean FirstTime=false;
            if(DataClass.getUserISP(ISPActivity.this)==-1)
                FirstTime=true;
            DataClass.setUserISP(ISPActivity.this,3);

            if(!FirstTime)
                ISPActivity.this.finish();
            else
                startActivity(intent);


        }




            }
        });
    }
}
