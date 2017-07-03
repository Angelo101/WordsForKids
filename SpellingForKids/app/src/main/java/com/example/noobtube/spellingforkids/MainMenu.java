package com.example.noobtube.spellingforkids;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {
    private Button buttonMissingLetters, buttonGuessThatSound;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2);
        context = this;
        Display display ;
        int width =0;
        display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        if(width>=1200)
        {
            setContentView(R.layout.activity_main_menu);
        }
        else if(width<900)
        {
            setContentView(R.layout.activity_main_menu);
        }

        buttonMissingLetters = (Button)findViewById(R.id.buttonPlayLetters);
        buttonMissingLetters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MissingLettersMenu.class);
                startActivity(intent);
            }
        });
        buttonGuessThatSound = (Button)findViewById(R.id.playGuessThatSound);
        buttonGuessThatSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DisplayHelp.class);
                startActivity(intent);
            }
        });
    }
}
