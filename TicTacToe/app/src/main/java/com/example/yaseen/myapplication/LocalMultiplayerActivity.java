package com.example.yaseen.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This Activity class has the local multiplayer gameplay , the players may reset the game at anytime.
 * WE SHOULD IMPROVE this code by using arrays instead of declaring 9 booleans and 9 buttons ...
 * should be just 2 arrays and access them accordingly , see how i implemented it in the new single player activity! - AOBRI
 */
public class LocalMultiplayerActivity extends Activity implements View.OnClickListener{

    /** boolean to determine current turn */
    boolean turn=true;
    /** booleans to check if button is checked
     * we can use Button.isChecked() or Button.isPressed() instead to just use the buttons !  */
    boolean filled =false;
    boolean filled2=false;
    boolean filled3 =false;
    boolean filled4 =false;
    boolean filled5 =false;
    boolean filled6 =false;
    boolean filled7 =false;
    boolean filled8 =false;
    boolean filled9 =false;
    boolean finished=false;

    /** button variables to find player clicks within the grid */
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button reset;
    TextView textView;
    Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_multiplayer);


        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);
        button6=(Button) findViewById(R.id.button6);
        button7=(Button) findViewById(R.id.button7);
        button8=(Button) findViewById(R.id.button8);
        button9=(Button) findViewById(R.id.button9);
        reset= (Button) findViewById(R.id.reset);
//        switch1=(Switch) findViewById(R.id.switch1);
        textView =(TextView)findViewById(R.id.textView);

        /** no need for this , using onClick in the XML does this internally
         * so the on click listeners are already set ! */
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

    }

    public void ButtonPressed(Button button, boolean fill)
    {
        if(finished)
        {
            Toast.makeText(this, "Press Reset Button", Toast.LENGTH_SHORT).show();
            return;
        }
        if(fill)
        {
            Toast.makeText(this, "Forbidden", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!turn)
        { button.setText("O"); turn=true; }
        else
        { button.setText("X"); turn=false; }
        FlipText();
        if(WinTest())
        {
            if(!turn) textView.setText("X is The Winner!");
            else textView.setText("O is The Winner!");
            finished=true;
        }
    }

    private void FlipText()
    {
        if(turn)
        textView.setText("X Turn");
        else
        textView.setText("O Turn");
    }
    public boolean ThreeButtonsEquality(Button button1, Button button2, Button button3)
    {
        if((button1.getText()==button2.getText())&&(button1.getText()==button3.getText())
                &&(button1.getText()!=""))
        return true;
        else
        return false;
    }
    public boolean WinTest()
    {
        if((ThreeButtonsEquality(button,button2,button3))||(ThreeButtonsEquality(button4,button5,button6))
                ||ThreeButtonsEquality(button7,button8,button9))
            return true;
        else if ((ThreeButtonsEquality(button,button4,button7))||(ThreeButtonsEquality(button2,button5,button8))
                ||ThreeButtonsEquality(button3,button6,button9))
            return true;
        else
            return (ThreeButtonsEquality(button, button5, button9)) || (ThreeButtonsEquality(button3, button5, button7));

    }

    public void ResetPressed(View v)
    {
        turn=true;
        filled =false;
        filled2=false;
        filled3 =false;
        filled4 =false;
        filled5 =false;
        filled6 =false;
        filled7 =false;
        filled8 =false;
        filled9 =false;
        finished=false;
        textView.setText("X Turn");
        button.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");


    }


    @Override
    public void onClick(View v)
    {
       switch (v.getId())
       {
           case (R.id.button):
           {
               ButtonPressed(button,filled);
               filled =true;
               break;
           }
           case (R.id.button2):
           {
               ButtonPressed(button2, filled2);
               filled2 =true;
               break;
           }
           case (R.id.button3):
           {
               ButtonPressed(button3, filled3);
               filled3 =true;
               break;
           }
           case (R.id.button4):
           {
               ButtonPressed(button4, filled4);
               filled4 =true;
               break;
           }
           case (R.id.button5):
           {
               ButtonPressed(button5, filled5);
               filled5 =true;
               break;
           }
           case (R.id.button6):
           {
               ButtonPressed(button6,filled6);
               filled6 =true;
               break;
           }
           case (R.id.button7):
           {
               ButtonPressed(button7, filled7);
               filled7 =true;
               break;
           }
           case (R.id.button8):
           {
               ButtonPressed(button8,filled8);
               filled8 =true;
               break;
           }
           case (R.id.button9):
           {
               ButtonPressed(button9,filled9);
               filled9 =true;
               break;
           }

       }
    }
}
