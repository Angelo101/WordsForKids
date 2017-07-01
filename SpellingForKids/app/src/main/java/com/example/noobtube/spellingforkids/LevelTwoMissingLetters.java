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

public class LevelTwoMissingLetters extends ActionBar {
    private EditText editText2, editText3;
    private Context context;
    MediaPlayer mp = new MediaPlayer();
    public static int correct = 0;
    public static int incorrect = 0;
    private ImageView iv;
    public TextView textView2;
    public String keys;
    public String keys2;
    public static int count2 = 0;
    public int isTrue = 0;
    private SoundPoolUtil sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two_missing_letters);
        context = this;
        iv  = (ImageView) findViewById(R.id.imageView2);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        textView2 = (TextView)findViewById(R.id.wordViewCat2);
        editText2 = (EditText)findViewById(R.id.editTextCat);
        editText3 = (EditText)findViewById(R.id.editTextCat2);
        editText2.setFocusableInTouchMode(true);
        editText3.setFocusableInTouchMode(true);
        sp = new SoundPoolUtil(this);
        startNewWord();
        hideKeyBoard();

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText2.getText().toString().equals(keys)) {
                    sp.playSound(SoundPoolUtil.CORRECT);
                    correct++;
                    editText3.requestFocus();
                    isTrue++;
                    editText2.setEnabled(false);
                    if(isTrue == 2) {
                        createDialogCorrect();
                    }
                }
                else{
                    editText2.removeTextChangedListener(this);
                    editText2.getText().clear();
                    createDialogIncorrect();
                    incorrect++;
                    sp.playSound(SoundPoolUtil.INCORRECT);
                    editText2.addTextChangedListener(this);
                    hideKeyBoard();
                }
            }
        });

        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText3.getText().toString().equals(keys2)) {
                    sp.playSound(SoundPoolUtil.CORRECT);
                    correct++;
                    editText2.requestFocus();
                    isTrue++;
                    editText3.setEnabled(false);
                    if(isTrue == 2){
                        createDialogCorrect();
                    }
                }

                else{
                    editText3.removeTextChangedListener(this);
                    editText3.getText().clear();
                    createDialogIncorrect();
                    incorrect++;
                    sp.playSound(SoundPoolUtil.INCORRECT);
                    editText3.setImeOptions(isTrue);
                    editText3.addTextChangedListener(this);
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
                            mp = MediaPlayer.create(LevelTwoMissingLetters.this, R.raw.firecrackers);
                            mp.start();
                            Intent intent = new Intent(context, LevelTwoMissingLettersCompleted.class);
                            startActivity(intent);

                        }
                        if (count2 != 19) {
                            count2++;
                            Intent intent = new Intent(context, LevelTwoMissingLetters.class);
                            startActivity(intent);
                            finish();
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
        if(count2 == 0){
            setShip();
        }
        if(count2 == 1){
            setWell();
        }
        if(count2 == 2){
            setBack();
        }
        if(count2 == 3){
            setLook();
        }
        if(count2 == 4){
            setLake();
        }
        if(count2 == 5){
            setDown();
        }
        if(count2 == 6){
            setDrum();
        }
        if(count2 == 7){
            setFish();
        }
        if(count2 == 8){
            setBell();
        }
        if(count2 == 9){
            setBook();
        }
        if(count2 == 10){
            setWolf();
        }
        if(count2 == 11){
            setKing();
        }
        if(count2 == 12){
            setTime();
        }
        if(count2 == 13){
            setStar();
        }
        if(count2 == 14){
            setBall();
        }
        if(count2 == 15){
            setCake();
        }
        if(count2 == 16){
            setMoon();
        }
        if(count2 == 17){
            setRock();
        }
        if(count2 == 18){
            setFood();
        }
        if(count2 == 19){
            setKids();
        }
    }
    protected void setShip(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ship);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  h");
        keys = "i";
        keys2 = "p";

    }
    protected void setWell(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.well);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("w  e");
        keys = "l";
        keys2 = "l";
    }
    protected void setBack(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.back);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  a");
        keys = "c";
        keys2 = "k";
    }
    protected void setLook(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.look);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("l  o");
        keys = "o";
        keys2 = "k";
    }
    protected void setLake(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lake);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("l  a");
        keys = "k";
        keys2 = "e";
    }
    protected void setDown(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.down);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("d  o");
        keys = "w";
        keys2 = "n";
    }
    protected void setDrum(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.drum);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("d  r");
        keys = "u";
        keys2 = "m";
    }
    protected void setFish(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fish);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  i");
        keys = "s";
        keys2 = "h";
    }
    protected void setBell(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bell);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  e");
        keys = "l";
        keys2 = "l";
    }
    protected void setBook(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.book);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  o");
        keys = "o";
        keys2 = "k";
    }
    protected void setWolf(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.wolf);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("w  o");
        keys = "l";
        keys2 = "f";
    }
    protected void setKing(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.king);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("k  i");
        keys = "n";
        keys2 = "g";
    }
    protected void setTime(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.time);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("t  i");
        keys = "m";
        keys2 = "e";
    }
    protected void setStar(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.star);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  t");
        keys = "a";
        keys2 = "r";
    }
    protected void setBall(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  a");
        keys = "l";
        keys2 = "l";
    }
    protected void setCake(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.cake);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("c  a");
        keys = "k";
        keys2 = "e";
    }
    protected void setMoon(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.moon);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("m  o");
        keys = "o";
        keys2 = "n";
    }
    protected void setRock(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.rock);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("r  o");
        keys = "c";
        keys2 = "k";
    }
    protected void setFood(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.food);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  o");
        keys = "o";
        keys2 = "d";
    }
    protected void setKids(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.kids);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("k  i");
        keys = "d";
        keys2 = "s";
    }

}


