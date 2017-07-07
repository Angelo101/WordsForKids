package com.example.noobtube.spellingforkids;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LevelOneMissingLetters extends ActionBar {
    private EditText editText;
    private Context context;
    MediaPlayer mp = new MediaPlayer();
    public static int correct = 0;
    public static int incorrect = 0;
    public ImageView iv;
    public TextView textView;
    public String keys;
    public static int count = 0;
    private static SoundPoolUtil sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one_missing_letters);
        context = this;
        iv  = (ImageView) findViewById(R.id.imageView);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        textView = (TextView)findViewById(R.id.wordViewCat);
        editText = (EditText)findViewById(R.id.editTextCat);
        editText.setFocusableInTouchMode(true);
        sp = new SoundPoolUtil(this);
//        setCat();

        startNewWord();
        hideKeyboard();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText.getText().toString().equals(keys)) {
                    playSoundCorrect();
                    createDialogCorrect();
                    correct++;
                }
                else{
                    editText.removeTextChangedListener(this);
                    editText.getText().clear();
                    createDialogIncorrect();
                    incorrect++;
                    hideKeyboard();
                    playSoundIncorrect();
                    editText.addTextChangedListener(this);
                }


            }
        });


    }

    protected void hideKeyboard(){
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
                                    if(count == 9){
                                        mp = MediaPlayer.create(LevelOneMissingLetters.this, R.raw.firecrackers);
                                        mp.start();
                                        Intent intent = new Intent(context, LevelOneMissingLettersCompleted.class);
                                        startActivity(intent);

                                    }
                                    if (count != 9) {
                                        count++;
                                        Intent intent = new Intent(context, LevelOneMissingLetters.class);
                                        startActivity(intent);
//                                        recreate();

                                        sp.pool.release();
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
            if(count == 0){
                setCat();
            }
            if(count == 1){
                setPig();
            }
            if(count == 2){
                setAnt();
            }
            if(count == 3){
                setBee();
            }
            if(count == 4){
                setCow();
            }
            if(count == 5){
                setDog();
            }
            if(count == 6){
                setEmu();
            }
            if(count == 7){
                setOwl();
            }
            if(count == 8){
                setFly();
            }
            if(count == 9){
                setCar();
            }


    }
    protected void setCat(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.cat);
        iv.setImageBitmap(bitmap);
        textView.setText("a t");
        keys = "c";
    }
    protected void setPig(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pig);
        iv.setImageBitmap(bitmap);
        textView.setText("i g");
        keys = "p";
    }
    protected void setAnt(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ant);
        iv.setImageBitmap(bitmap);
        textView.setText("n t");
        keys = "a";
    }
    protected void setOwl(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.owl);
        iv.setImageBitmap(bitmap);
        textView.setText("w l");
        keys = "o";
    }
    protected void setDog(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dog);
        iv.setImageBitmap(bitmap);
        textView.setText("o g");
        keys = "d";
    }
    protected void setCow(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.cow);
        iv.setImageBitmap(bitmap);
        textView.setText("o w");
        keys = "c";
    }
    protected void setBee(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bee);
        iv.setImageBitmap(bitmap);
        textView.setText("e e");
        keys = "b";
    }
    protected void setFly(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fly);
        iv.setImageBitmap(bitmap);
        textView.setText("l y");
        keys = "f";
    }
    protected void setEmu(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.emu);
        iv.setImageBitmap(bitmap);
        textView.setText("m u");
        keys = "e";
    }
    protected void setCar(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.car);
        iv.setImageBitmap(bitmap);
        textView.setText("a r");
        keys = "c";
    }
        public static void playSoundIncorrect(){
            sp.playSound(SoundPoolUtil.INCORRECT);
        }
        public static void playSoundCorrect(){
            sp.playSound(SoundPoolUtil.CORRECT);
        }

    }



