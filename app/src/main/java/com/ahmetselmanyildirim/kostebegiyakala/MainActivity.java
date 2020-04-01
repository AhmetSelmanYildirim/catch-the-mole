package com.ahmetselmanyildirim.kostebegiyakala;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    int score;
    ImageView [] imageArray;
    Handler handler;
    Runnable run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};

        hideImages();

        score = 0;

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText = findViewById(R.id.textTime);
                timeText.setText("Zaman: " + millisUntilFinished /1000);
            }

            @Override
            public void onFinish() {
                timeText = findViewById(R.id.textTime);
                timeText.setText("Oyun Bitti");
                handler.removeCallbacks(run);
                imageView1.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
                imageView3.setVisibility(View.INVISIBLE);
                imageView4.setVisibility(View.INVISIBLE);
                imageView5.setVisibility(View.INVISIBLE);
                imageView6.setVisibility(View.INVISIBLE);
                imageView7.setVisibility(View.INVISIBLE);
                imageView8.setVisibility(View.INVISIBLE);
                imageView9.setVisibility(View.INVISIBLE);




            }
        }.start();

    }
    public void increaseScore(View view){
        scoreText = findViewById(R.id.textScore);

        score++;

        scoreText.setText("Puan: " + score);

    }

    public void hideImages() {

        handler = new Handler();
        run = new Runnable() {
            @Override
            public void run() {

                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);

                }

                Random r = new Random();
                int i = r.nextInt(8-0);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);
            }

        };
        handler.post(run);
    }

}
