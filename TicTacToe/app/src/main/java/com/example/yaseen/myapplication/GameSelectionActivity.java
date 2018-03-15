package com.example.yaseen.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * This screen contains the mode choices for the user to start a game mode.
 * it also should include difficulty choices for the AI
 * and then decide the algorithm by passing it to the intent
 * in an extra , but for now all will have the same difficulty - AOBRI
 */
public class GameSelectionActivity extends Activity implements View.OnClickListener{

    LinearLayout linearLayoutDifficulty ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selection);
        linearLayoutDifficulty = (LinearLayout) findViewById(R.id.linearLayout_difficulty);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_sp: /**show difficulties to choose from and  if visible make it diappear */
                linearLayoutDifficulty.setVisibility(
                        (linearLayoutDifficulty.getVisibility() == View.VISIBLE )? View.GONE : View.VISIBLE);
                break ;
            case R.id.button_easy:/** go to easy single player game */
                startSingleplayerGame(1); // assuming 1 = easy , 2 = med , 3 = hard
                break;
            case R.id.button_medium:
                startSingleplayerGame(2);
                break;
            case R.id.button_hard:
                startSingleplayerGame(3);
                break ;
            case R.id.button_mp:/** go to local multiplayer game which we already implemented*/
                Intent intentMP = new Intent(this , LocalMultiplayerActivity.class);
                startActivity(intentMP);
                break ;
        }
    }

    private void startSingleplayerGame(int difficulty ){
        Intent intentSP = new Intent(this , SingleplayerActivity.class);
        intentSP.putExtra("difficulty" , difficulty); // put the difficulty here so the game can later decide what algorithm to choose.
//        linearLayoutDifficulty.setVisibility(View.GONE);
        startActivity(intentSP);
    }
}
