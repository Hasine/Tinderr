package com.example.hasine.tinderr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class SecondActivity extends AppCompatActivity {

    public float rate,r_0,r_1,r_2,r_3,r_4,r_5;
    private String name;
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        //      get info from intent
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        String detail = intent.getStringExtra("detail");
        int image = intent.getIntExtra("image", 1);

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(image);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(detail);


        // Add the following lines to the end of the onCreate method:
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                //write the rating back to the data source :]
                rate = rating;
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor Edit = prefs.edit();
                Edit.putFloat(name, rate);
                Edit.apply();
            }
        });

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        float r = prefs.getFloat(name, 0);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        if (r != 0) {
            ratingBar.setRating(r);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            // get rating from sharedPreferences
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            float r = prefs.getFloat(name,0);

            Toast.makeText(this, "You rated " + name + ": " + r, Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}