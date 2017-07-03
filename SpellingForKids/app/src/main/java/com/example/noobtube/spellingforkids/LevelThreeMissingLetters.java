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

public class LevelThreeMissingLetters extends AppCompatActivity {

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
        setContentView(R.layout.activity_level_three_missing_letters);
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
                            mp = MediaPlayer.create(LevelThreeMissingLetters.this, R.raw.firecrackers);
                            mp.start();
                            Intent intent = new Intent(context, LevelThreeCompleted.class);
                            startActivity(intent);

                        }
                        if (count2 != 19) {
                            count2++;
                            Intent intent = new Intent(context, LevelThreeMissingLetters.class);
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
            setHare();
        }
        if(count2 == 1){
            setBear();
        }
        if(count2 == 2){
            setBull();
        }
        if(count2 == 3){
            setCrab();
        }
        if(count2 == 4){
            setDeer();
        }
        if(count2 == 5){
            setDove();
        }
        if(count2 == 6){
            setHawk();
        }
        if(count2 == 7){
            setIbis();
        }
        if(count2 == 8){
            setLamb();
        }
        if(count2 == 9){
            setMole();
        }
        if(count2 == 10){
            setMoth();
        }
        if(count2 == 11){
            setPony();
        }
        if(count2 == 12){
            setSeal();
        }
        if(count2 == 13){
            setSlug();
        }
        if(count2 == 14){
            setSwan();
        }
        if(count2 == 15){
            setWorm();
        }
        if(count2 == 16){
            setTick();
        }
        if(count2 == 17){
            setClam();
        }
        if(count2 == 18){
            setLion();
        }
        if(count2 == 19){
            setMice();
        }
    }
    protected void setHare(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.hare);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("h  a");
        keys = "r";
        keys2 = "e";

    }
    protected void setBear(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bear);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  e");
        keys = "a";
        keys2 = "r";
    }
    protected void setBull(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bull);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("b  u");
        keys = "l";
        keys2 = "l";
    }
    protected void setCrab(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.crab);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("c  r");
        keys = "a";
        keys2 = "b";
    }
    protected void setDeer(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.deer);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("d  e");
        keys = "e";
        keys2 = "r";
    }
    protected void setDove(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dove);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("d  o");
        keys = "v";
        keys2 = "e";
    }
    protected void setHawk(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.hawk);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("h  a");
        keys = "w";
        keys2 = "k";
    }
    protected void setIbis(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ibis);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("i  b");
        keys = "i";
        keys2 = "s";
    }
    protected void setLamb(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lamb);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("l  a");
        keys = "m";
        keys2 = "b";
    }
    protected void setMole(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.mole);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("m  o");
        keys = "l";
        keys2 = "e";
    }
    protected void setMoth(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.moth);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("m  o");
        keys = "t";
        keys2 = "h";
    }
    protected void setPony(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pony);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("p  o");
        keys = "n";
        keys2 = "y";
    }
    protected void setSeal(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.seal);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  e");
        keys = "a";
        keys2 = "l";
    }
    protected void setSlug(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.slug);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  l");
        keys = "u";
        keys2 = "g";
    }
    protected void setSwan(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.swan);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("s  w");
        keys = "a";
        keys2 = "n";
    }
    protected void setWorm(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.worm);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("w  o");
        keys = "r";
        keys2 = "m";
    }
    protected void setTick(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.tick);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("t  i");
        keys = "c";
        keys2 = "k";
    }
    protected void setClam(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.clam);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("c  l");
        keys = "a";
        keys2 = "m";
    }
    protected void setLion(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.lion);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("l  i");
        keys = "o";
        keys2 = "n";
    }
    protected void setMice(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.mice);
        iv.setImageBitmap(bitmap);
        editText2.getText().clear();
        textView2.setText("m  i");
        keys = "c";
        keys2 = "e";
    }

}