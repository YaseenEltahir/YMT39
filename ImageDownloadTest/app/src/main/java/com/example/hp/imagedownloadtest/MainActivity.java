package com.example.hp.imagedownloadtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.key;

public class MainActivity extends AppCompatActivity {
    String LocalhostIP="192.168.1.10";
    String url="http://"+LocalhostIP+":8080/RESTfulWS/rest/app/download";


    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageView imageView = (ImageView) findViewById(R.id.img);

        //startActivity(new Intent(this,NavigationDrawerActivity.class));
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linearLayout);
        loadBitmap(R.id.img, imageView);
        /*
        for (int i=0;i<10;i++)
        {
            TextView textView=new TextView(this);
            buildTextView(textView);
            linearLayout.addView(textView);

            HorizontalScrollView horizontalScrollView=new HorizontalScrollView(this);
            buildHorizontalScrollView(horizontalScrollView);
            linearLayout.addView(horizontalScrollView);
        }*/

    }
   public void saveBitmapToCahche(String key,Bitmap bitmap){
       if (retrieveBitmapFromCache(key) == null) {
           Cache.getInstance().getLru().put(key,bitmap);
       }

    }


    public void loadBitmap(int resId, ImageView imageView) {
        final String imageKey = String.valueOf(resId);

        final Bitmap bitmap = retrieveBitmapFromCache(imageKey);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            Toast.makeText(this,"Loaded from Cache",Toast.LENGTH_SHORT).show();
        } else {
            //imageView.setImageResource(R.drawable.image_placeholder);
            Toast.makeText(this,"Loaded from Server",Toast.LENGTH_SHORT).show();
            new ImageLoadTask(url, imageView,resId,this).execute();

            /*BitmapWorkerTask task = new BitmapWorkerTask(mImageView);
            task.execute(resId);*/
            //new ImageLoadTask(url, image,this).execute();
        }
    }
    public Bitmap retrieveBitmapFromCache(String key){
        Bitmap bitmap = (Bitmap)Cache.getInstance().getLru().get(key);
        return bitmap;
    }


    public void save(View v){
        ImageView imageView = (ImageView) findViewById(R.id.img);
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

        saveBitmapToCahche("bitmap_image",bitmap);
        Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();


    }
    public void retrieve(View v){
        ImageView imageView = (ImageView) findViewById(R.id.img);
        imageView.setImageBitmap(retrieveBitmapFromCache("bitmap_image"));
        Toast.makeText(this,"retrieved",Toast.LENGTH_LONG).show();

    }
    public void change(View v){

        ImageView imageView=(ImageView) findViewById(R.id.img);
        imageView.setImageResource(R.drawable.ribbon_large);
        Toast.makeText(this,"changed",Toast.LENGTH_LONG).show();


    }



    public void buildTextView(TextView textView)
    {
        LinearLayout.LayoutParams textViewParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(textViewParams);
        textView.setText("تخفيضات");
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(24);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void buildHorizontalScrollView(HorizontalScrollView horizontalScrollView)
    {
        horizontalScrollView.setLayoutDirection(HorizontalScrollView.LAYOUT_DIRECTION_RTL);
        LinearLayout.LayoutParams horizontalScrollViewParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
        horizontalScrollView.setLayoutParams(horizontalScrollViewParams);


        LinearLayout linearLayout=new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(linearLayoutParams);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        horizontalScrollView.addView(linearLayout);


        CardView [] cardViewList=new CardView[10];
        for(int i=0;i<10;i++)
        {
            cardViewList[i]=new CardView(this);
            buildCard(cardViewList[i]);
            linearLayout.addView(cardViewList[i]);

        }
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

        LinearLayout linearLayout=new LinearLayout(this);
        LinearLayout.LayoutParams linearLayoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(linearLayoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        cardView.addView(linearLayout);

        ImageView image = new ImageView(MainActivity.this);
        image.setImageResource(R.drawable.black_oven_sm);

        //new ImageLoadTask(url, image,this).execute();
        LinearLayout.LayoutParams imageViewParams = new LinearLayout.LayoutParams((int) (100 * this.getResources().getDisplayMetrics().density)
                , (int) (100 * this.getResources().getDisplayMetrics().density));
        imageViewParams.setMargins(10,10,10,10);
        image.setLayoutParams(imageViewParams);
        linearLayout.addView(image);

        {
            RelativeLayout cardRelativeLayout = new RelativeLayout(this);
            cardRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

            ImageView ribbon = new ImageView(MainActivity.this);
            ribbon.setImageResource(R.drawable.ribbon_large);
            RelativeLayout.LayoutParams ribbonParams = new RelativeLayout.LayoutParams((int) (99 * this.getResources().getDisplayMetrics().density)
                    , (int) (38 * this.getResources().getDisplayMetrics().density));
            ribbon.setLayoutParams(ribbonParams);
            cardRelativeLayout.addView(ribbon);

            TextView priceTextView = new TextView(this);
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

        TextView textView=new TextView(this);
        LinearLayout.LayoutParams textViewParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(textViewParams);
        textView.setText("فرن سامسونج أسود");
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(14);
        linearLayout.addView(textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
