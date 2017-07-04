package com.example.noobtube.spellingforkids;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Level5MissingLetters extends AppCompatActivity {

    private EditText editText2, editText3, editText4;
    private Context context;
    MediaPlayer mp = new MediaPlayer();
    public static int correct = 0;
    public static int incorrect = 0;
    private ImageView iv;
    public TextView textView2;
    public String keys;
    public String keys2;
    public String keys3;

    public static int count2 = 0;
    public int isTrue = 0;
    private SoundPoolUtil sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5_missing_letters);
        context = this;
        iv  = (ImageView) findViewById(R.id.imageView2);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        textView2 = (TextView)findViewById(R.id.wordViewCat2);
        editText2 = (EditText)findViewById(R.id.editTextCat);
        editText3 = (EditText)findViewById(R.id.editTextCat2);
        editText4 = (EditText)findViewById(R.id.editTextCat3);
        editText2.setFocusableInTouchMode(true);
        editText3.setFocusableInTouchMode(true);
//        editText4.setFocusableInTouchMode(true);
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
                    if(isTrue == 3) {
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
                    editText4.requestFocus();
                    isTrue++;
                    editText3.setEnabled(false);
                    if(isTrue == 3){
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

        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText4.getText().toString().equals(keys3)) {
                    sp.playSound(SoundPoolUtil.CORRECT);
                    correct++;
                    editText4.requestFocus();
                    isTrue++;
                    editText4.setEnabled(false);
                    if(isTrue == 3){
                        createDialogCorrect();
                    }
                }

                else{
                    editText4.removeTextChangedListener(this);
                    editText4.getText().clear();
                    createDialogIncorrect();
                    incorrect++;
                    sp.playSound(SoundPoolUtil.INCORRECT);
                    editText4.setImeOptions(isTrue);
                    editText4.addTextChangedListener(this);
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
                            mp = MediaPlayer.create(Level5MissingLetters.this, R.raw.firecrackers);
                            mp.start();
                            Intent intent = new Intent(context, LevelThreeCompleted.class);// change!
                            startActivity(intent);

                        }
                        if (count2 != 19) {
                            count2++;
                            Intent intent = new Intent(context, Level5MissingLetters.class);
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
            setFarm();
        }
        if(count2 == 1){
            setLeaf();
        }
        if(count2 == 2){
            setLamp();
        }
        if(count2 == 3){
            setPink();
        }
        if(count2 == 4) {
            setSnow();
        }
        if(count2 == 5){
            setTruck();
        }
        if(count2 == 6){
            setWave();
        }
        if(count2 == 7){
            setGlass();
        }
        if(count2 == 8){
            setString();
        }
        if(count2 == 9){
            setCity();
        }
        if(count2 == 10){
            setHair();
        }
        if(count2 == 11){
            setBlack();
        }
        if(count2 == 12){
            setHand();
        }
        if(count2 == 13){
            setFight();
        }
        if(count2 == 14){
            setRain();
        }
        if(count2 == 15){
            setSoup();
        }
        if(count2 == 16){
            setFlower();
        }
        if(count2 == 17){
            setBottle();
        }
        if(count2 == 18){
            setTaco();
        }
        if(count2 == 19){
            setStorm();
        }
    }
    protected void setFarm(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.farm);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  ");
        keys = "a";
        keys2 = "r";
        keys3 = "m";

    }
    protected void setLeaf(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.leaf);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("l  ");
        keys = "e";
        keys2 = "a";
        keys3 = "f";
    }
    protected void setLamp(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lamp);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("l  ");
        keys = "a";
        keys2 = "m";
        keys3 = "p";
    }
    protected void setPink(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pink);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("p  ");
        keys = "i";
        keys2 = "n";
        keys3 = "k";
    }
    protected void setSnow(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.snow);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  ");
        keys = "n";
        keys2 = "o";
        keys3 = "w";
    }
    protected void setTruck(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.truck);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("t  r");
        keys = "u";
        keys2 = "c";
        keys3 = "k";
    }
    protected void setWave(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.wave);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("w  ");
        keys = "a";
        keys2 = "v";
        keys3 = "e";
    }
    protected void setGlass(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.glass);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("g  l");
        keys = "a";
        keys2 = "s";
        keys3 = "s";
    }
    protected void setString(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.string);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  t");
        keys = "i";
        keys2 = "n";
        keys3 = "g";
    }
    protected void setCity(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.city);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("c  ");
        keys = "i";
        keys2 = "t";
        keys3 = "y";
    }
    protected void setHair(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.hair);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("h  ");
        keys = "a";
        keys2 = "i";
        keys3 = "r";
    }
    protected void setBlack(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.black);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  l");
        keys = "a";
        keys2 = "c";
        keys3 = "k";
    }
    protected void setHand(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.hand);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("h  ");
        keys = "a";
        keys2 = "n";
        keys3 = "d";
    }
    protected void setFight(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fight);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  i");
        keys = "g";
        keys2 = "h";
        keys3 = "t";
    }
    protected void setRain(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.rain);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("r  ");
        keys = "a";
        keys2 = "i";
        keys3 = "n";
    }
    protected void setSoup(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.soup);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  ");
        keys = "o";
        keys2 = "u";
        keys3 = "p";
    }
    protected void setFlower(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.flower);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  l  o");
        keys = "w";
        keys2 = "e";
        keys3 = "r";
    }
    protected void setBottle(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bottle);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  o  t");
        keys = "t";
        keys2 = "l";
        keys3 = "e";
    }
    protected void setTaco(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.taco);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("t  ");
        keys = "a";
        keys2 = "c";
        keys3 = "o";
    }
    protected void setStorm(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.storm);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s t");
        keys = "o";
        keys2 = "r";
        keys3 = "m";
    }

}