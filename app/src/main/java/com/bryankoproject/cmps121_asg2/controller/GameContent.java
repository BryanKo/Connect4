package com.bryankoproject.cmps121_asg2.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.bryankoproject.cmps121_asg2.model.GameLogic;
import com.bryankoproject.cmps121_asg2.view.GridFragment;
import com.bryankoproject.cmps121_asg2.R;

/**
 * Created by imbko on 11/7/2017.
 */

public class GameContent extends AppCompatActivity {

    Button exitGame, resetGame;
    TextView p1Score, p2Score;
    GridView gridView;
    int counter = 0;
    int p1Counter = 0;
    int p2Counter = 0;


    int positionList[] = {
            0, 1, 2, 3, 4, 5, 6,
            7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27,
            28, 29, 30, 31, 32, 33, 34,
            35, 36, 37, 38, 39, 40, 41 };

    int takenList[] = {
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,

            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,

            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0};

    int gameBoard[] = {
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq,
            R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq, R.drawable.board_sq };


    @Override
    protected void onCreate (Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.game_layout);

        exitGame = (Button) findViewById(R.id.btnExit);
        resetGame = (Button) findViewById(R.id.btnReset);
        p1Score = (TextView) findViewById(R.id.tvP1Score);
        p2Score = (TextView) findViewById(R.id.tvP2Score);
        gridView = (GridView) findViewById(R.id.boardGrid);
        GridFragment fragment = new GridFragment(GameContent.this, gameBoard);


        gridView.setAdapter(fragment);

        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        resetGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameContent.class);
                finish();
                startActivity(intent);
                Toast.makeText(GameContent.this, "Game Reset", Toast.LENGTH_SHORT).show();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int newPosition;
                GridFragment fragment = new GridFragment(GameContent.this, gameBoard);
                GameLogic gameLogic = new GameLogic();
                counter = counter%2;
                if (takenList[position+35] == 0) {

                    if(counter == 0) {
                        counter++;
                        //newPosition = col1Check(takenList, positionList, position);
                        takenList[position+35] = 1;
                        gameBoard[position] = R.drawable.board_sq_p1;
                        if (gameLogic.horCheck(takenList, counter, position) == true ||
                                gameLogic.virtCheck(takenList, counter, position) == true ||
                                gameLogic.rdiagCheck(takenList, counter, position) == true ||
                                gameLogic.ldiagCheck(takenList, counter, position) == true) {
                            Toast.makeText(GameContent.this, "Player " + counter + " winner", Toast.LENGTH_SHORT).show();
                            p1Counter++;
                            p1Score.setText(String.valueOf(p1Counter));
                        }
                    } else {
                        counter++;
                        //newPosition = col1Check(takenList, positionList, position);
                        takenList[position+35] = 2;
                        gameBoard[position] = R.drawable.board_sq_p2;
                        if (gameLogic.horCheck(takenList, counter, position) == true ||
                                gameLogic.virtCheck(takenList, counter, position) == true ||
                                gameLogic.rdiagCheck(takenList, counter, position) == true ||
                                gameLogic.ldiagCheck(takenList, counter, position) == true) {
                            Toast.makeText(GameContent.this, "Player " + counter + " Winner", Toast.LENGTH_SHORT).show();
                            p2Counter++;
                            p2Score.setText(String.valueOf(p2Counter));
                        }
                    }

                    //Toast.makeText(GameContent.this, "Clicked cell " + positionList[position] + " by Player " + (counter), Toast.LENGTH_SHORT).show();
                }

                gridView.setAdapter(fragment);
            }
        });
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("boardgame", gameBoard);
        outState.putIntArray("takenlist", takenList);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        gameBoard = savedInstanceState.getIntArray("boardgame");
        takenList = savedInstanceState.getIntArray("takenlist");
    }

    private int col1Check(int taken[], int gridPos[], int pos) {
        int newPos = pos;
        while (newPos != gridPos[35] )
            if (taken[newPos] != 1)
            newPos += 7;
        return newPos;
    }



}
