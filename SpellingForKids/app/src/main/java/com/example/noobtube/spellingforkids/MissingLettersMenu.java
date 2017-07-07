package com.example.noobtube.spellingforkids;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MissingLettersMenu extends ActionBar {
    private Context context;
    private Button level1, level2, level3, level4, level5,level6, level7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_letters_menu);
        context = this;
        level1 = (Button)findViewById(R.id.buttonLevel1);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LevelOneMissingLetters.class);
                startActivity(intent);
            }
        });
        level2 = (Button)findViewById(R.id.buttonLevel2);
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LevelTwoMissingLetters.class);
                startActivity(intent);
            }
        });
        level3 = (Button)findViewById(R.id.buttonLevel3);
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LevelThreeMissingLetters.class);
                startActivity(intent);
            }
        });
        level4 = (Button)findViewById(R.id.buttonLevel4);
        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Level4MissingLetters.class);
                startActivity(intent);
            }
        });

        level5 = (Button)findViewById(R.id.buttonLevel5);
        level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Level5MissingLetters.class);
                startActivity(intent);
            }
        });
        level6 = (Button)findViewById(R.id.buttonLevel6);
        level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Level6MissingLetters.class);
                startActivity(intent);
            }
        });
        level7 = (Button)findViewById(R.id.buttonLevel7);
        level7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Level7.class);
                startActivity(intent);
            }
        });

    }
}
