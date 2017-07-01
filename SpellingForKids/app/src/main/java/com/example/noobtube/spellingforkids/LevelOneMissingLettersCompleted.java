package com.example.noobtube.spellingforkids;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelOneMissingLettersCompleted extends AppCompatActivity {
    private Button button;
    Context context;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one_missing_letters_completed);
        context = this;
        button = (Button)findViewById(R.id.birdButton);
        mp = MediaPlayer.create(LevelOneMissingLettersCompleted.this, R.raw.firecrackers);
        mp.start();
        mp.setLooping(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MissingLettersMenu.class);
                startActivity(intent);
                mp.stop();
                LevelOneMissingLetters.count = 0;
            }
        });
    }
}
