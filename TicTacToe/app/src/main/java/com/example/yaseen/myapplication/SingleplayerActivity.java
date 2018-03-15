package com.example.yaseen.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

/**
 * This activity should include the implementeation for the AI algorithm that plays against the single player.
 * (the minimax algorithm)
 * use the buttons just as in the multiplayer game , and could possible access them using the ids found in the xml
 * i named the buttons like ( button_single_1 ...)
 * , also there is a textView to make messages appear there , but we can change how messages appear later on.
 * - AOBRI
 */
public class SingleplayerActivity extends Activity implements View.OnClickListener{

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
    Button[] buttons;
    Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        buttons = new Button[9];
        buttons[0] = (Button) findViewById(R.id.button_single_1);
        buttons[1] = (Button) findViewById(R.id.button_single_2);
        buttons[2] = (Button) findViewById(R.id.button_single_3);
        buttons[3] = (Button) findViewById(R.id.button_single_4);
        buttons[4] = (Button) findViewById(R.id.button_single_5);
        buttons[5] = (Button) findViewById(R.id.button_single_6);
        buttons[6] = (Button) findViewById(R.id.button_single_7);
        buttons[7] = (Button) findViewById(R.id.button_single_8);
        buttons[8] = (Button) findViewById(R.id.button_single_9);
        // instead of using button1 , button2 variables , use buttons[0] , buttons[1] ...
        // and forloops

        for (Button bt : buttons){
            bt.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case (R.id.button):
            {
//                ButtonPressed(button,filled);
                filled =true;
                /**
                 * HERE YOU SHOULD CALL THE NEW ALGORITHM FUNCTION , TO MAKE THE AI PLAY THEIR TURN
                 * AND SHOW A MESSAGE FOR THE PLAYER TO PLAY AFTER THAT.
                 */
                break;
            }
            case (R.id.button2):
            {
//                ButtonPressed(button2, filled2);
                filled2 =true;
                /////
                break;
            }
            case (R.id.button3):
            {
//                ButtonPressed(button3, filled3);
                filled3 =true;
                /// ...
                break;
            }
            case (R.id.button4):
            {
//                ButtonPressed(button4, filled4);
                filled4 =true;
                break;
            }
            case (R.id.button5):
            {
//                ButtonPressed(button5, filled5);
                filled5 =true;
                break;
            }
            case (R.id.button6):
            {
//                ButtonPressed(button6,filled6);
                filled6 =true;
                break;
            }
            case (R.id.button7):
            {
//                ButtonPressed(button7, filled7);
                filled7 =true;
                break;
            }
            case (R.id.button8):
            {
//                ButtonPressed(button8,filled8);
                filled8 =true;
                break;
            }
            case (R.id.button9):
            {
//                ButtonPressed(button9,filled9);
                filled9 =true;
                break;
            }
        }
    }
}
