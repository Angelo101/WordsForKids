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

public class Level4MissingLetters extends AppCompatActivity {

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
        setContentView(R.layout.activity_level4_missing_letters);
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
                            mp = MediaPlayer.create(Level4MissingLetters.this, R.raw.firecrackers);
                            mp.start();
                            Intent intent = new Intent(context, LevelThreeCompleted.class);// change!
                            startActivity(intent);

                        }
                        if (count2 != 19) {
                            count2++;
                            Intent intent = new Intent(context, Level4MissingLetters.class);
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
            setPuppy();
        }
        if(count2 == 1){
            setZebra();
        }
        if(count2 == 2){
            setSnail();
        }
        if(count2 == 3){
            setSheep();
        }
        if(count2 == 4) {
            setRhino();
        }
        if(count2 == 5){
            setKoala();
        }
        if(count2 == 6){
            setGecko();
        }
        if(count2 == 7){
            setMoose();
        }
        if(count2 == 8){
            setApple();
        }
        if(count2 == 9){
            setChips();
        }
        if(count2 == 10){
            setPizza();
        }
        if(count2 == 11){
            setBacon();
        }
        if(count2 == 12){
            setSteak();
        }
        if(count2 == 13){
            setGrape();
        }
        if(count2 == 14){
            setBread();
        }
        if(count2 == 15){
            setToast();
        }
        if(count2 == 16){
            setSushi();
        }
        if(count2 == 17){
            setFlour();
        }
        if(count2 == 18){
            setPeach();
        }
        if(count2 == 19){
            setOlive();
        }
    }
    protected void setPuppy(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.puppy);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("p  u  p");
        keys = "p";
        keys2 = "y";

    }
    protected void setZebra(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.zebra);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("z  e  b");
        keys = "r";
        keys2 = "a";
    }
    protected void setSnail(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.snail);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  n  a");
        keys = "i";
        keys2 = "l";
    }
    protected void setSheep(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.sheep);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  h  e");
        keys = "e";
        keys2 = "p";
    }
    protected void setOlive(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.olive);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("o  l  i");
        keys = "v";
        keys2 = "e";
    }
    protected void setRhino(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.rhino);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("r  h  i");
        keys = "n";
        keys2 = "o";
    }
    protected void setKoala(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.koala);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("k  o  a");
        keys = "l";
        keys2 = "a";
    }
    protected void setGecko(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.gecko);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("g  e  c");
        keys = "k";
        keys2 = "o";
    }
    protected void setMoose(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.moose);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("m  o  o");
        keys = "s";
        keys2 = "e";
    }
    protected void setApple(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.apple);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("a  p  p");
        keys = "l";
        keys2 = "e";
    }
    protected void setChips(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.chips);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("c  h  i");
        keys = "p";
        keys2 = "s";
    }
    protected void setPizza(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pizza);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("p  i  z");
        keys = "z";
        keys2 = "a";
    }
    protected void setBacon(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bacon);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  a  c");
        keys = "o";
        keys2 = "n";
    }
    protected void setSteak(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.steak);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  t  e");
        keys = "a";
        keys2 = "k";
    }
    protected void setGrape(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.grape);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("g  r  a");
        keys = "p";
        keys2 = "e";
    }
    protected void setBread(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bread);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  r  e");
        keys = "a";
        keys2 = "d";
    }
    protected void setToast(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.toast);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("t  o  a");
        keys = "s";
        keys2 = "t";
    }
    protected void setSushi(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.sushi);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  u  s");
        keys = "h";
        keys2 = "i";
    }
    protected void setFlour(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.flour);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("f  l  o");
        keys = "u";
        keys2 = "r";
    }
    protected void setPeach(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.peach);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("p  e  a");
        keys = "c";
        keys2 = "h";
    }

}