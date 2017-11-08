package com.bryankoproject.cmps121_asg2.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bryankoproject.cmps121_asg2.R;

public class MainActivity extends AppCompatActivity {

    Button newGame, prevGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGame = (Button) findViewById(R.id.btnNew);
        prevGame = (Button) findViewById(R.id.btnPrev);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameContent.class);
                startActivity(intent);
            }
        });

        prevGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameContent gameContent = new GameContent();
                Intent intent = new Intent(getApplicationContext(), GameContent.class);
                //gameContent.onRestoreInstanceState(gameContent.bundle);
                startActivity(intent);
            }
        });
    }
}
