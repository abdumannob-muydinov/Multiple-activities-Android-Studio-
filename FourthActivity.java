package com.ctis487.homework1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;


public class FourthActivity extends AppCompatActivity {
    Intent intent;

    TextView tvRes;
    String msg = "";
    ImageView im;
    int[] images= {R.id.img1, R.id.img2, R.id.img3};
    SeekBar seekBarVolume;
    RatingBar ratingBar;

    int index = 1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.thirdactivity);

        tvRes = findViewById(R.id.textRes);
        ratingBar = findViewById(R.id.ratingBar);
        seekBarVolume = findViewById(R.id.seekBar);
        intent = getIntent();

        Bundle b = intent.getExtras();
        assert b != null;
        int num1 = b.getInt("num1");
        int num2 = b.getInt("num2");
        double res = num1-num2*3264 ;


        tvRes.setText( "well,"+res);

        msg = " "+res;
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //called when progress level (thumb position) has been changed.
                ratingBar.setRating(3.5f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //called when the user has started a touch gesture

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //called when the user has finished a touch gesture

            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBarp, float rating, boolean fromUser) {
                seekBarVolume.setProgress(75);
            }
        });
    }

    public void onClick(View view) {

        Intent intent = new Intent();

        intent.putExtra("res", msg);

        setResult(RESULT_OK, intent);
        for(int i=0; i<images.length-1; i++){

            ImageView img = findViewById(images[i]);

            if(i == index){
                img.setVisibility(View.VISIBLE);
            }
            else{
                img.setVisibility(View.INVISIBLE);
            }
        }
        index++;
        if(index> images.length-1)
            index = 0;


        finish();

    }



}

