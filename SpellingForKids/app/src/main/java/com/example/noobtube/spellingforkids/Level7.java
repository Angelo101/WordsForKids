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

public class Level7 extends AppCompatActivity {

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
    private static SoundPoolUtil sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level7);
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
                    playSoundCorrect();
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
                    playSoundIncorrect();
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
                    playSoundCorrect();
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
                    playSoundIncorrect();
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
                    playSoundCorrect();
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
                    playSoundIncorrect();
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
                            mp = MediaPlayer.create(Level7.this, R.raw.firecrackers);
                            mp.start();
                            Intent intent = new Intent(context, LevelThreeCompleted.class);
                            startActivity(intent);

                        }
                        if (count2 != 19) {
                            count2++;
                            Intent intent = new Intent(context, Level7.class);
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
            setOnePlusOne();
        }
        if(count2 == 1){
            setOnePlusTwo();
        }
        if(count2 == 2){
            setOnePlusFour();
        }
        if(count2 == 3){
            setOnePlusSeven();
        }
        if(count2 == 4) {
            setOnePlusSix();
        }
        if(count2 == 5){
            setTwoPlusTwo();
        }
        if(count2 == 6){
            setTwoPlusThree();
        }
        if(count2 == 7){
            setTwoPlusFour();
        }
        if(count2 == 8){
            setTwoPlusSeven();
        }
        if(count2 == 9){
            setThreePlusZero();
        }
        if(count2 == 10){
            setThreePlusTwo();
        }
        if(count2 == 11){
            setThreePlusFour();
        }
        if(count2 == 12){
            setThreePlusSeven();
        }
        if(count2 == 13){
            setThreePlusThree();
        }
        if(count2 == 14){
            setFourPlusOne();
        }
        if(count2 == 15){
            setFourPlusFour();
        }
        if(count2 == 16){
            setFourPlusFive();
        }
        if(count2 == 17){
            setFourPlusZero();
        }
        if(count2 == 18){
            setFourPlusSix();
        }
        if(count2 == 19){
            setFourPlusTwo();
        }
    }
    protected void setOnePlusOne(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.oneplusone);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
//        textView2.setText("p  ");
        keys = "t";
        keys2 = "w";
        keys3 = "o";

    }
    protected void setOnePlusTwo(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.oneplustwo);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("t  h");
        keys = "r";
        keys2 = "e";
        keys3 = "e";
    }
    protected void setOnePlusFour(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.oneplusfour);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  ");
        keys = "i";
        keys2 = "v";
        keys3 = "e";
    }
    protected void setOnePlusSeven(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.oneplusseven);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("e  i");
        keys = "g";
        keys2 = "h";
        keys3 = "t";
    }
    protected void setOnePlusSix(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.oneplussix);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  e");
        keys = "v";
        keys2 = "e";
        keys3 = "n";
    }
    protected void setTwoPlusTwo(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.twoplustwo);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f ");
        keys = "o";
        keys2 = "u";
        keys3 = "r";
    }
    protected void setTwoPlusThree(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.twoplusthree);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  ");
        keys = "i";
        keys2 = "v";
        keys3 = "e";
    }
    protected void setTwoPlusFour(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.twoplusfour);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
//        textView2.setText("c  a  r");
        keys = "s";
        keys2 = "i";
        keys3 = "x";
    }
    protected void setTwoPlusSeven(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.twoplusseven);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("n  ");
        keys = "i";
        keys2 = "n";
        keys3 = "e";
    }
    protected void setThreePlusZero(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.threeepluszero);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("t  h");
        keys = "r";
        keys2 = "e";
        keys3 = "e";
    }
    protected void setThreePlusTwo(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.threeeplustwo);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  ");
        keys = "i";
        keys2 = "v";
        keys3 = "e";
    }
    protected void setThreePlusFour(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.threeeplusfour);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  e");
        keys = "v";
        keys2 = "e";
        keys3 = "n";
    }
    protected void setThreePlusSeven(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.threeeplusseven);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
//        textView2.setText("n  u  g");
        keys = "t";
        keys2 = "e";
        keys3 = "n";
    }
    protected void setThreePlusThree(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.threeeplusthree);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
//        textView2.setText("m  ");
        keys = "s";
        keys2 = "i";
        keys3 = "x";
    }
    protected void setFourPlusOne(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fourplusone);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  ");
        keys = "i";
        keys2 = "v";
        keys3 = "e";
    }
    protected void setFourPlusFour(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fourplusfour);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("e  i");
        keys = "g";
        keys2 = "h";
        keys3 = "t";
    }
    protected void setFourPlusFive(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fourplusfive);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("n  ");
        keys = "i";
        keys2 = "n";
        keys3 = "e";
    }
    protected void setFourPlusZero(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fourpluszero);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  ");
        keys = "o";
        keys2 = "u";
        keys3 = "r";
    }
    protected void setFourPlusSix(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fourplussix);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
//        textView2.setText("b  a  n");
        keys = "t";
        keys2 = "e";
        keys3 = "n";
    }
    protected void setFourPlusTwo(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fourplustwo);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
//        textView2.setText("h  o");
        keys = "s";
        keys2 = "i";
        keys3 = "x";
    }
    public static void playSoundIncorrect(){
        sp.playSound(SoundPoolUtil.INCORRECT);
    }
    public static void playSoundCorrect(){
        sp.playSound(SoundPoolUtil.CORRECT);
    }

}