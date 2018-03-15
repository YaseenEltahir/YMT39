package com.example.yaseen.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.Collections;
import java.util.Vector;

public class MainActivity extends Activity implements View.OnClickListener{
    boolean turn=true;      //X Turn
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
    boolean FirstTime=true;


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
    TextView textView2;
    TextView textView3;



    char [] state;

    int FilledButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
        textView2=(TextView) findViewById(R.id.textView2);
        textView3=(TextView) findViewById(R.id.textView3);



        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        state=new char[9];
        state="EEEEEEEEE".toCharArray();

        textView2.setText(new String(state));



        FilledButtons =0;
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
        { button.setText("O");turn=true;   }
        else
        { button.setText("X"); turn=false; }
        FlipText();


        if(++FilledButtons==9)
            finished=true;

        if(WinTest(state))
        {
            if(!turn) textView.setText("X is The Winner!");
            else      textView.setText("O is The Winner!");
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
    public boolean ThreeStateCharEquality(char state [ ],int i, int j, int k)
    {
        i--; j--; k--;
        return (state[i] == state[j]) && (state[j] == state[k])
                && state[i] != 'E';
    }
    public boolean WinTest(char state [])
    {
        if(( ThreeStateCharEquality(state,1, 2, 3))||( ThreeStateCharEquality(state,4, 5, 6))
                || ThreeStateCharEquality(state,7, 8, 9))
            return true;
        else if (( ThreeStateCharEquality(state,1, 4, 7))||( ThreeStateCharEquality(state,2, 5, 8))
                || ThreeStateCharEquality(state,3,6,9))
            return true;
        else
            return ( ThreeStateCharEquality(state,1, 5,9)) || ( ThreeStateCharEquality(state,3, 5, 7));

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
        FirstTime=true;

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
        state="EEEEEEEEE".toCharArray();
        textView2.setText(new String(state));



        FilledButtons=0;

    }
    void UpdateState(int i,boolean turn)
    {
        if(!finished)
        state[i-1]=(turn)? 'X':'O';
    }

    void ThinkSet()
    {
        textView3.setText("Thinking...");
    }
    @Override
    public void onClick(View v)
    {
       ThinkSet();
       switch (v.getId())
       {
           case (R.id.button):
           {


               if(!filled) UpdateState(1, turn);
               ButtonPressed(button,filled);
               filled =true;

               break;
           }
           case (R.id.button2):
           {
               if(!filled2)  UpdateState(2, turn);
               ButtonPressed(button2, filled2);
               filled2 =true;

               break;
           }
           case (R.id.button3):
           {
               if(!filled3) UpdateState(3, turn);
               ButtonPressed(button3, filled3);
               filled3 =true;

               break;
           }
           case (R.id.button4):
           {
               if(!filled4) UpdateState(4, turn);
               ButtonPressed(button4, filled4);
               filled4 =true;

               break;
           }
           case (R.id.button5):
           {
               if(!filled5) UpdateState(5, turn);
               ButtonPressed(button5, filled5);
               filled5 =true;

               break;
           }
           case (R.id.button6):
           {
               if(!filled6) UpdateState(6, turn);
               ButtonPressed(button6,filled6);
               filled6 =true;

               break;
           }
           case (R.id.button7):
           {
               if(!filled7) UpdateState(7, turn);
               ButtonPressed(button7, filled7);
               filled7 =true;

               break;
           }
           case (R.id.button8):
           {
               if(!filled8)  UpdateState(8, turn);
               ButtonPressed(button8,filled8);
               filled8 =true;

               break;
           }
           case (R.id.button9):
           {
               if(!filled9) UpdateState(9, turn);
               ButtonPressed(button9,filled9);
               filled9 =true;

               break;
           }

       }
       textView2.setText(new String(state));

        if(!turn) //O turn
        {

            //textView3.setText("Thinking...");

            Integer Choice;
            Choice = BestChoice(new String(state),1, false).choice + 1;

            switch (Choice)
           {
           case 1:
               if (!filled) UpdateState(1, turn);
               ButtonPressed(button, filled);
               filled = true;
               break;
           case 2:
               if (!filled2) UpdateState(2, turn);
               ButtonPressed(button2, filled2);
               filled2 = true;
               break;
           case 3:
               if (!filled3) UpdateState(3, turn);
               ButtonPressed(button3, filled3);
               filled3 = true;
               break;
           case 4:
               if (!filled4) UpdateState(4, turn);
               ButtonPressed(button4, filled4);
               filled4 = true;
               break;
           case 5:
               if (!filled5) UpdateState(5, turn);
               ButtonPressed(button5, filled5);
               filled5 = true;
               break;
           case 6:
               if (!filled6) UpdateState(6, turn);
               ButtonPressed(button6, filled6);
               filled6 = true;
               break;
           case 7:
               if (!filled7) UpdateState(7, turn);
               ButtonPressed(button7, filled7);
               filled7 = true;
               break;
           case 8:
               if (!filled8) UpdateState(8, turn);
               ButtonPressed(button8, filled8);
               filled8 = true;
               break;
           case 9:
               if (!filled9) UpdateState(9, turn);
               ButtonPressed(button9, filled9);
               filled9 = true;
               break;
            }
           textView3.setText("");

       }
    }

    boolean isFinished (char [] state)
    {
        for(char c:state)
            if(c=='E')
                return false;
        return true;
    }
    private Move BestChoice (String state,int call_num, boolean turn)//O turn
    {
        char [] state_array= state.toCharArray();

        if(WinTest(state_array)&&turn) //O wins
            return new Move(0,-10);
        else if(WinTest(state_array)&&!turn) //X wins
            return new Move(0,10);
        else if(isFinished(state_array))
            return new Move(0,0);
        else
        {
            if(!turn) //O turn
            {
                Vector <Integer> scores=new Vector<Integer>();
                Vector <Integer> moves=new Vector<Integer>();
                for (int i = 0; i < 9; i++)
                    if (state_array[i] == 'E')
                    {
                        state_array[i]='O';
                        Move Choice=BestChoice(new String(state_array),call_num+1, !turn);
                        scores.add(new Integer(Choice.score));
                        moves.add(i);
                        state_array[i]='E';
                    }
                int min_score=Collections.min(scores);
                int index_of_min_score=RandomIndexOf(scores,min_score);//scores.indexOf(min_score);
                int move_with_min_score=moves.get(index_of_min_score);

                return new Move(move_with_min_score,min_score);
            }

            else //X turn
            {

                    Vector <Integer> scores=new Vector<Integer>();
                    Vector <Integer> moves=new Vector<Integer>();

                    for (int i = 0; i < 9; i++)
                        if (state_array[i] == 'E')
                        {
                            state_array[i]='X';
                            Move Choice=BestChoice(new String(state_array),call_num+1, !turn);
                            scores.add(new Integer(Choice.score));
                            moves.add(i);
                            state_array[i]='E';
                        }
                    int max_score=Collections.max(scores);
                    int index_of_max_score=RandomIndexOf(scores,max_score);//scores.indexOf(max_score);
                    int move_with_max_score=moves.get(index_of_max_score);

                    return new Move(move_with_max_score,max_score);
                //Vector <Integer> scores=new Vector<Integer>();


                //Vector <Integer> moves=new Vector<Integer>();


                //for (int i = 0; i < 9; i++)


                //if (state_array[i] == 'E')


                //{


                //state_array[i]='X';


                //scores.add(new Integer(BestChoice(new String(state_array), !turn)));


                //state_array[i]='E';


                //}


                //return (!turn)? moves.get(scores.indexOf(Collections.max(scores))):


                //moves.get(scores.indexOf(Collections.min(scores)));
            }

        }


    }
    static Integer RandomIndexOf(Vector<Integer> scores, int var)
    {
        Vector indexes_of_var=new Vector<Integer>();

        for(int i=0;i<scores.size();i++)
            if(scores.get(i)==var)
                indexes_of_var.add(new Integer(i));
        Random rn=new Random();
        int r=rn.nextInt(indexes_of_var.size());
        return  (Integer) indexes_of_var.get(r);


    }


class Move
{
    public int choice;
    public int score;
    Move(int choice,int score)
    {
        this.choice=choice;
        this.score=score;
    }
}
}

