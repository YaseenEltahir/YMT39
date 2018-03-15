package com.example.hp.imagedownloadtest;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridFragment extends Fragment {

    View view;
    public GridFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view=inflater.inflate(R.layout.fragment_grid, container, false);
        // Inflate the layout for this fragment
        GridLayout gridLayout=(GridLayout)view.findViewById(R.id.grid);
        CardView [] cardViewList=new CardView[10];
        for(int i=0;i<10;i++)
        {
            cardViewList[i]=new CardView(view.getContext());
            buildCard(cardViewList[i]);
            gridLayout.addView(cardViewList[i]);

        }
        return view;

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void buildCard(CardView cardView)
    {

        cardView.setElevation(10);
        cardView.setRadius(20);
        LinearLayout.LayoutParams cardViewParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
        cardViewParams.setMargins(5,5,5,5);
        cardView.setLayoutParams(cardViewParams);

        LinearLayout linearLayout=new LinearLayout(view.getContext());
        LinearLayout.LayoutParams linearLayoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(linearLayoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        cardView.addView(linearLayout);

        ImageView image = new ImageView(view.getContext());
        image.setImageResource(R.drawable.black_oven_sm);
        //new ImageLoadTask(url, image,this).execute();
        LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams((int) (100 * this.getResources().getDisplayMetrics().density)
                , (int) (100 * this.getResources().getDisplayMetrics().density));
        imageViewParams.setMargins(10,10,10,10);
        image.setLayoutParams(imageViewParams);
        linearLayout.addView(image);

        {
            RelativeLayout cardRelativeLayout = new RelativeLayout(view.getContext());
            cardRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            ImageView ribbon = new ImageView(view.getContext());
            ribbon.setImageResource(R.drawable.ribbon_large);
            RelativeLayout.LayoutParams ribbonParams = new RelativeLayout.LayoutParams((int) (99 * this.getResources().getDisplayMetrics().density)
                    , (int) (38 * this.getResources().getDisplayMetrics().density));
            ribbon.setLayoutParams(ribbonParams);
            cardRelativeLayout.addView(ribbon);

            TextView priceTextView = new TextView(view.getContext());
            LinearLayout.LayoutParams priceTextViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                    , LinearLayout.LayoutParams.WRAP_CONTENT);
            priceTextViewParams.setMargins(10, 10, 10, 10);
            priceTextView.setLayoutParams(priceTextViewParams);
            priceTextView.setText("3200 جنيه");
            priceTextView.setTextColor(Color.BLACK);
            priceTextView.setTextSize(16);
            cardRelativeLayout.addView(priceTextView);

            linearLayout.addView(cardRelativeLayout);
        }

        TextView textView=new TextView(view.getContext());
        LinearLayout.LayoutParams textViewParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(textViewParams);
        textView.setText("فرن سامسونج أسود");
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(14);
        linearLayout.addView(textView);

    }

}
