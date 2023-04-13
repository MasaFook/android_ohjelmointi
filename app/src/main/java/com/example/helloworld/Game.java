package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class Game extends AppCompatActivity {

    private ImageButton kortti1;
    private ImageButton kortti2;
    private ImageButton kortti3;
    private ImageButton kortti4;

    private FloatingActionButton refreshBtn;

    int randomNumber;

    public void refresh(){
        finish();
        startActivity(getIntent());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        kortti1 = findViewById(R.id.imageButton);
        kortti2 = findViewById(R.id.imageButton2);
        kortti3 = findViewById(R.id.imageButton3);
        kortti4 = findViewById(R.id.imageButton4);
        refreshBtn = findViewById(R.id.floatingActionButton2);

        Random rand = new Random();

        randomNumber = rand.nextInt(3);


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation1);



        kortti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kortti1.startAnimation(animation);
                if(randomNumber==0){
                    kortti1.setImageResource(R.drawable.diamond);
                }
                else{
                    kortti1.setVisibility(View.INVISIBLE);
                }
            }
        });

        kortti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kortti2.startAnimation(animation);
                if(randomNumber==1){
                    kortti2.setImageResource(R.drawable.diamond);
                }
                else{
                    kortti2.setVisibility(View.INVISIBLE);
                }
            }
        });

        kortti3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kortti3.startAnimation(animation);
                if(randomNumber==2){
                    kortti3.setImageResource(R.drawable.diamond);
                }
                else{
                    kortti3.setVisibility(View.INVISIBLE);
                }
            }
        });

        kortti4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kortti4.startAnimation(animation);
                if(randomNumber==3){
                    kortti4.setImageResource(R.drawable.diamond);
                }
                else{
                    kortti4.setVisibility(View.INVISIBLE);
                }
            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();

            }
        });

    }
}