package com.example.yaseen.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

/**
 * This is the main menu screen , should later all be implemented using fragments and AppcompatActivity
 * for better control and animations.
 * but for now it has buttons that lead to other screens (gameplay , settings , about , exit).
 */
public class MainMenuActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_start:
                Intent intent = new Intent(this , GameSelectionActivity.class);
                startActivity(intent);
                break ;
            case R.id.button_settings:

                break ;

            case R.id.button_about:

                break ;

            case R.id.button_exit:
                finish();
                break ;
        }
    }
}
