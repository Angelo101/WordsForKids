package com.example.noobtube.spellingforkids;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GuessThatSound extends ActionBar {
    public EditText editText1, editText2;
    public EditText editTextThree, editTextFour;
    private Context context;
    public static MediaPlayer mp;
    public static int correct = 0;
    public static int incorrect = 0;
    private ImageView iv;
    public String keys;
    public String keys2;
    public String keys3;
    public String keys4;
    public static int count2 = 0;
    public int isTrue = 0;
    private SoundPoolUtil sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_that_sound);
        context = this;
        iv  = (ImageView) findViewById(R.id.imageView);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        editText1 = (EditText)findViewById(R.id.editTextCat);
        editText2 = (EditText)findViewById(R.id.editTextCat2);

        editTextThree = (EditText)findViewById(R.id.editText3);
        editTextFour = (EditText)findViewById(R.id.editText4);
        sp = new SoundPoolUtil(this);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        startNewWord();

        hideKeyBoard();
        editText1.requestFocus(isTrue);

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText1.getText().toString().equals(keys)) {
                    sp.playSound(SoundPoolUtil.CORRECT);
                    correct++;
                    editText2.requestFocus();
                    isTrue++;
                    editText1.setEnabled(false);
                    if(isTrue == 4) {
                        createDialogCorrect();
                    }
                }
                else{
                    editText1.removeTextChangedListener(this);
                    editText1.getText().clear();
                    createDialogIncorrect();
                    incorrect++;
                    sp.playSound(SoundPoolUtil.INCORRECT);
                    editText1.addTextChangedListener(this);
                    hideKeyBoard();
                }
            }

        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText2.getText().toString().equals(keys2)) {
                    correct++;
                    sp.playSound(SoundPoolUtil.CORRECT);
                    editTextThree.requestFocus();
                    isTrue++;
                    editText2.setEnabled(false);
                    if(isTrue == 4){
                        createDialogCorrect();
                    }
                }

                else{
                    editText2.removeTextChangedListener(this);
                    editText2.getText().clear();
                    createDialogIncorrect();
                    incorrect++;
                    sp.playSound(SoundPoolUtil.INCORRECT);
                    editText2.setImeOptions(isTrue);
                    editText2.addTextChangedListener(this);
                    hideKeyBoard();
                }
            }
        });
        editTextThree.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editTextThree.getText().toString().equals(keys3)) {
                    sp.playSound(SoundPoolUtil.CORRECT);
                    correct++;
                    editTextFour.requestFocus();
                    isTrue++;
//                    editText3.setEnabled(false);
                    if(isTrue == 4){
                        createDialogCorrect();
                    }
                }

                else{
                    editTextThree.removeTextChangedListener(this);
                    editTextThree.getText().clear();
                    createDialogIncorrect();
                    incorrect++;
                    sp.playSound(SoundPoolUtil.INCORRECT);
                    editTextThree.setImeOptions(isTrue);
                    editTextThree.addTextChangedListener(this);
                    hideKeyBoard();
                }
            }
        });
        editTextFour.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editTextFour.getText().toString().equals(keys4)) {
                    sp.playSound(SoundPoolUtil.CORRECT);
                    correct++;
                    editTextThree.requestFocus();
                    isTrue++;
                    editTextFour.setEnabled(false);
                    if(isTrue == 4){
                        createDialogCorrect();
                    }
                }

                else{
                    editTextFour.removeTextChangedListener(this);
                    editTextFour.getText().clear();
                    createDialogIncorrect();
                    incorrect++;
                    sp.playSound(SoundPoolUtil.INCORRECT);
                    editTextFour.setImeOptions(isTrue);
                    editTextFour.addTextChangedListener(this);
                    hideKeyBoard();
                }
            }
        });
    }



    protected void hideKeyBoard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(
                Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }
    protected void createDialogCorrect(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("CORRECT! WELL DONE!")
                .setCancelable(false)
                .setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if(count2 == 19){
                            mp = MediaPlayer.create(GuessThatSound.this, R.raw.firecrackers);
                            mp.start();
                            Intent intent = new Intent(context, LevelTwoMissingLettersCompleted.class);
                            startActivity(intent);

                        }
                        if (count2 != 19) {
                            count2++;
                            Intent intent = new Intent(context, GuessThatSound.class);
                            startActivity(intent);
                            finish();
                            sp.pool.release();
//                            mp.release();
                        }

                    }
                })
                .create();
        alert.show();
    }
    protected void createDialogIncorrect(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("SORRY, TRY AGAIN")
                .setCancelable(false)
                .setPositiveButton("CONTINUE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        InputMethodManager imm = (InputMethodManager) getSystemService(
                                Activity.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 1);
                        dialog.dismiss();
                    }
                })
                .create();
        alert.show();
    }
    public void startNewWord(){
        if(count2 == 0){
            setCall();
        }
        if(count2 == 1){
            setWall();
        }
        if(count2 == 2){
            setLand();
        }
        if(count2 == 3){
            setJump();
        }
        if(count2 == 4){
            setGate();
        }
        if(count2 == 5){
            setFive();
        }
        if(count2 == 6){
            setFeet();
        }
        if(count2 == 7){
            setCage();
        }
        if(count2 == 8){
            setCrow();
        }
        if(count2 == 9){
            setSeat();
        }
        if(count2 == 10){
            setHome();
        }
        if(count2 == 11){
            setTent();
        }
        if(count2 == 12){
            setBand();
        }
        if(count2 == 13){
            setBoat();
        }
        if(count2 == 14){
            setCube();
        }
        if(count2 == 15){
            setFork();
        }
        if(count2 == 16){
            setDuck();
        }
        if(count2 == 17){
            setKite();
        }
        if(count2 == 18){
            setFour();
        }
        if(count2 == 19){
            setGift();
        }
    }
    protected void setCall(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.call);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.call);
                mp.start();
            }
        });
//        editText3.getText().clear();
        keys = "c";
        keys2 = "a";
        keys3 = "l";
        keys4 = "l";

    }
    protected void setWall(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.wall);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.wall);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "w";
        keys2 = "a";
        keys3 = "l";
        keys4 = "l";
    }
    protected void setLand(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.land);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.land);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "l";
        keys2 = "a";
        keys3 = "n";
        keys4 = "d";
    }
    protected void setJump(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.jump);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.jump);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "j";
        keys2 = "u";
        keys3 = "m";
        keys4 = "p";
    }
    protected void setGate(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.gate);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.gate);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "g";
        keys2 = "a";
        keys3 = "t";
        keys4 = "e";
    }
    protected void setFive(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.five);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.five);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "f";
        keys2 = "i";
        keys3 = "v";
        keys4 = "e";
    }
    protected void setFeet(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.feet);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.feet);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "f";
        keys2 = "e";
        keys3 = "e";
        keys4 = "t";
    }
    protected void setCage(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.cage);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.cage);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "c";
        keys2 = "a";
        keys3 = "g";
        keys4 = "e";
    }
    protected void setCrow(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.crow);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.crow);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "c";
        keys2 = "r";
        keys3 = "o";
        keys4 = "w";
    }
    protected void setSeat(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.seat);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.seat);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "s";
        keys2 = "e";
        keys3 = "a";
        keys4 = "t";
    }
    protected void setHome(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.home);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.home);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "h";
        keys2 = "o";
        keys3 = "m";
        keys4 = "e";
    }
    protected void setTent(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tent);
        iv.setImageBitmap(bitmap);iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.tent);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "t";
        keys2 = "e";
        keys3 = "n";
        keys4 = "t";
    }
    protected void setBand(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.band);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.band);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "b";
        keys2 = "a";
        keys3 = "n";
        keys4 = "d";
    }
    protected void setBoat(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.boat);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.boat);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "b";
        keys2 = "o";
        keys3 = "a";
        keys4 = "t";
    }
    protected void setCube(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.cube);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.cube);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "c";
        keys2 = "u";
        keys3 = "b";
        keys4 = "e";
    }
    protected void setFork(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fork);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.fork);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "f";
        keys2 = "o";
        keys3 = "r";
        keys4 = "k";
    }
    protected void setDuck(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.duck);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.duck);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "d";
        keys2 = "u";
        keys3 = "c";
        keys4 = "k";
    }
    protected void setKite(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.kite);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.kite);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "k";
        keys2 = "i";
        keys3 = "t";
        keys4 = "e";
    }
    protected void setFour(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.four);
        iv.setImageBitmap(bitmap);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.four);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "f";
        keys2 = "o";
        keys3 = "u";
        keys4 = "r";
    }
    protected void setGift(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.gift);
        iv.setImageBitmap(bitmap);iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                mp = MediaPlayer.create(GuessThatSound.this, R.raw.gift);
                mp.start();
            }
        });
        editText1.getText().clear();
        keys = "g";
        keys2 = "i";
        keys3 = "f";
        keys4 = "t";
    }
}


