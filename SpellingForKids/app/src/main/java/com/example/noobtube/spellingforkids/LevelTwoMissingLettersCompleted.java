package com.example.noobtube.spellingforkids;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelTwoMissingLettersCompleted extends AppCompatActivity {
    MediaPlayer mp;
    Button button;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_missing_letters_completed);
        context = this;
        button = (Button)findViewById(R.id.birdButton);
        mp = MediaPlayer.create(LevelTwoMissingLettersCompleted.this, R.raw.firecrackers);
        mp.start();
        mp.setLooping(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MissingLettersMenu.class);
                startActivity(intent);
                mp.stop();
                LevelTwoMissingLetters.count2 = 0;
            }
        });
    }
}
