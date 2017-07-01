package com.example.noobtube.spellingforkids;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    private Button buttonMissingLetters, buttonGuessThatSound;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        context = this;

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
    protected void createDialogNotify(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("In this game, click the pictures to listen to the word")
                .setCancelable(false)
                .setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, GuessThatSound.class);
                        startActivity(intent);
                        InputMethodManager imm = (InputMethodManager) getSystemService(
                                Activity.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 1);
                        dialog.dismiss();
                    }
                })
                .create();
        alert.show();
    }
}
