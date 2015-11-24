package com.example.hasine.tinderr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivityTinder extends AppCompatActivity {

    GridView gv;
    public String name;

    public static String [] friendNames;
    public static int [] friendImages={R.drawable.hasineklein,R.drawable.wallaklein,R.drawable.harpreetklein,
                                    R.drawable.amandeepklein,R.drawable.yektaklein,R.drawable.natalieklein};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_tinder);

        friendNames = getResources().getStringArray(R.array.friend_names);
        gv=(GridView) findViewById(R.id.gridview);
        gv.setAdapter(new CustomAdapter(this, friendNames, friendImages));

    }
}