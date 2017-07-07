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

public class Level6MissingLetters extends AppCompatActivity {

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
        setContentView(R.layout.activity_level6_missing_letters);
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
                            mp = MediaPlayer.create(Level6MissingLetters.this, R.raw.firecrackers);
                            mp.start();
                            Intent intent = new Intent(context, LevelThreeCompleted.class);
                            startActivity(intent);

                        }
                        if (count2 != 19) {
                            count2++;
                            Intent intent = new Intent(context, Level6MissingLetters.class);
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
            setPear();
        }
        if(count2 == 1){
            setMango();
        }
        if(count2 == 2){
            setLemon();
        }
        if(count2 == 3){
            setCoconut();
        }
        if(count2 == 4) {
            setLime();
        }
        if(count2 == 5){
            setPlum();
        }
        if(count2 == 6){
            setPea();
        }
        if(count2 == 7){
            setCarrot();
        }
        if(count2 == 8){
            setGarlic();
        }
        if(count2 == 9){
            setLeek();
        }
        if(count2 == 10){
            setChili();
        }
        if(count2 == 11){
            setHotdog();
        }
        if(count2 == 12){
            setNugget();
        }
        if(count2 == 13){
            setMilk();
        }
        if(count2 == 14){
            setIcecream();
        }
        if(count2 == 15){
            setRice();
        }
        if(count2 == 16){
            setNoodles();
        }
        if(count2 == 17){
            setPotato();
        }
        if(count2 == 18){
            setBanana();
        }
        if(count2 == 19){
            setHoney();
        }
    }
    protected void setPear(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pear);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("p  ");
        keys = "e";
        keys2 = "a";
        keys3 = "r";

    }
    protected void setMango(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.mango);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("m  a");
        keys = "n";
        keys2 = "g";
        keys3 = "o";
    }
    protected void setLemon(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lemon);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("l  e");
        keys = "m";
        keys2 = "o";
        keys3 = "n";
    }
    protected void setCoconut(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.coconut);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("c  o  c  o");
        keys = "n";
        keys2 = "u";
        keys3 = "t";
    }
    protected void setLime(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lime);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("l  ");
        keys = "i";
        keys2 = "m";
        keys3 = "e";
    }
    protected void setPlum(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.plum);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("p  ");
        keys = "l";
        keys2 = "u";
        keys3 = "m";
    }
    protected void setPea(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pea);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("p  ");
        keys = "e";
        keys2 = "a";
        keys3 = "s";
    }
    protected void setCarrot(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.carrot);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("c  a  r");
        keys = "r";
        keys2 = "o";
        keys3 = "t";
    }
    protected void setGarlic(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.garlic);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("g  a  r");
        keys = "l";
        keys2 = "i";
        keys3 = "c";
    }
    protected void setLeek(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.leak);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("l  ");
        keys = "e";
        keys2 = "e";
        keys3 = "k";
    }
    protected void setChili(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.chili);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("c  h");
        keys = "i";
        keys2 = "l";
        keys3 = "i";
    }
    protected void setHotdog(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.hotdog);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("h  o  t");
        keys = "d";
        keys2 = "o";
        keys3 = "g";
    }
    protected void setNugget(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.nugget);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("n  u  g");
        keys = "g";
        keys2 = "e";
        keys3 = "t";
    }
    protected void setMilk(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.milk);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("m  ");
        keys = "i";
        keys2 = "l";
        keys3 = "k";
    }
    protected void setIcecream(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.icecream);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("i  c  e  c  r");
        keys = "e";
        keys2 = "a";
        keys3 = "m";
    }
    protected void setRice(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.rice);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("r  ");
        keys = "i";
        keys2 = "c";
        keys3 = "e";
    }
    protected void setNoodles(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.noodles);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("n  o  o  d");
        keys = "l";
        keys2 = "e";
        keys3 = "s";
    }
    protected void setPotato(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.potato);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("p  o  t");
        keys = "a";
        keys2 = "t";
        keys3 = "o";
    }
    protected void setBanana(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.banana);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  a  n");
        keys = "a";
        keys2 = "n";
        keys3 = "a";
    }
    protected void setHoney(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.honey);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("h  o");
        keys = "n";
        keys2 = "e";
        keys3 = "y";
    }
    public static void playSoundIncorrect(){
        sp.playSound(SoundPoolUtil.INCORRECT);
    }
    public static void playSoundCorrect(){
        sp.playSound(SoundPoolUtil.CORRECT);
    }

}