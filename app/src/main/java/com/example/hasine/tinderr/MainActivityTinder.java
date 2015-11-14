package com.example.hasine.tinderr;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivityTinder extends AppCompatActivity {

    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_tinder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void hasineclicked(View view) {

    }

//    Intent intent = new Intent(this, MainActivityTinder.class);
//    intent.putExtra("name",value);

    @Override
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
    }

    public void wallaclick(View view) {

    }


//    Resources res = getResources();
//    String[] friend_names = res.getStringArray(R.array.friend_names);
//    String[] friend_full_names = res.getStringArray(R.array.friend_full_names);
//    String[] friend_details = res.getStringArray(R.array.friend_details);

//    MediaPlayer mp = MediaPlayer.create(this,R.raw.zorunnesevgilim);
//    mp.start();
}
