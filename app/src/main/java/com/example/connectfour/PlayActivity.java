package com.example.connectfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    HashMap<String,TextView> table;
    boolean playersTurn;
    int numberOfMoves = 0;
    Game game;

    TextView helloText;

    TextView textview_0_0, textview_0_1, textview_0_2, textview_0_3, textview_0_4, textview_0_5;
    TextView textview_1_0, textview_1_1, textview_1_2, textview_1_3, textview_1_4, textview_1_5;
    TextView textview_2_0, textview_2_1, textview_2_2, textview_2_3, textview_2_4, textview_2_5;
    TextView textview_3_0, textview_3_1, textview_3_2, textview_3_3, textview_3_4, textview_3_5;
    TextView textview_4_0, textview_4_1, textview_4_2, textview_4_3, textview_4_4, textview_4_5;
    TextView textview_5_0, textview_5_1, textview_5_2, textview_5_3, textview_5_4, textview_5_5;
    TextView textview_6_0, textview_6_1, textview_6_2, textview_6_3, textview_6_4, textview_6_5;

    Button colButton_0, colButton_1, colButton_2, colButton_3, colButton_4, colButton_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play);

        init();
        helloText = (TextView) findViewById(R.id.helloText);
    }

    private void init(){

        //COL BUTTON
        game = new Game();
        colButton_0 = (Button) findViewById(R.id.buttonColumn_0);
        colButton_1 = (Button) findViewById(R.id.buttonColumn_1);
        colButton_2 = (Button) findViewById(R.id.buttonColumn_2);
        colButton_3 = (Button) findViewById(R.id.buttonColumn_3);
        colButton_4 = (Button) findViewById(R.id.buttonColumn_4);
        colButton_5 = (Button) findViewById(R.id.buttonColumn_5);

        colButton_0.setOnClickListener(this);
        colButton_1.setOnClickListener(this);
        colButton_2.setOnClickListener(this);
        colButton_3.setOnClickListener(this);
        colButton_4.setOnClickListener(this);
        colButton_5.setOnClickListener(this);

        //1ST COL                                               2ND COL
        textview_0_0 = (TextView) findViewById(R.id.textview0_0);textview_0_1 = (TextView) findViewById(R.id.textview0_1);
        textview_1_0 = (TextView) findViewById(R.id.textview1_0);textview_1_1 = (TextView) findViewById(R.id.textview1_1);
        textview_2_0 = (TextView) findViewById(R.id.textview2_0);textview_2_1 = (TextView) findViewById(R.id.textview2_1);
        textview_3_0 = (TextView) findViewById(R.id.textview3_0);textview_3_1 = (TextView) findViewById(R.id.textview3_1);
        textview_4_0 = (TextView) findViewById(R.id.textview4_0);textview_4_1 = (TextView) findViewById(R.id.textview4_1);
        textview_5_0 = (TextView) findViewById(R.id.textview5_0);textview_5_1 = (TextView) findViewById(R.id.textview5_1);
        textview_6_0 = (TextView) findViewById(R.id.textview6_0);textview_6_1 = (TextView) findViewById(R.id.textview6_1);

        //3RD COL                                               4TH COL
        textview_0_2 = (TextView) findViewById(R.id.textview0_2);textview_0_3 = (TextView) findViewById(R.id.textview0_3);
        textview_1_2 = (TextView) findViewById(R.id.textview1_2);textview_1_3 = (TextView) findViewById(R.id.textview1_3);
        textview_2_2 = (TextView) findViewById(R.id.textview2_2);textview_2_3 = (TextView) findViewById(R.id.textview2_3);
        textview_3_2 = (TextView) findViewById(R.id.textview3_2);textview_3_3 = (TextView) findViewById(R.id.textview3_3);
        textview_4_2 = (TextView) findViewById(R.id.textview4_2);textview_4_3 = (TextView) findViewById(R.id.textview4_3);
        textview_5_2 = (TextView) findViewById(R.id.textview5_2);textview_5_3 = (TextView) findViewById(R.id.textview5_3);
        textview_6_2 = (TextView) findViewById(R.id.textview6_2);textview_6_3 = (TextView) findViewById(R.id.textview6_3);
        //5TH COL                                               6TH COL
        textview_0_4 = (TextView) findViewById(R.id.textview0_4);textview_0_5 = (TextView) findViewById(R.id.textview0_5);
        textview_1_4 = (TextView) findViewById(R.id.textview1_4);textview_1_5 = (TextView) findViewById(R.id.textview1_5);
        textview_2_4 = (TextView) findViewById(R.id.textview2_4);textview_2_5 = (TextView) findViewById(R.id.textview2_5);
        textview_3_4 = (TextView) findViewById(R.id.textview3_4);textview_3_5 = (TextView) findViewById(R.id.textview3_5);
        textview_4_4 = (TextView) findViewById(R.id.textview4_4);textview_4_5 = (TextView) findViewById(R.id.textview4_5);
        textview_5_4 = (TextView) findViewById(R.id.textview5_4);textview_5_5 = (TextView) findViewById(R.id.textview5_5);
        textview_6_4 = (TextView) findViewById(R.id.textview6_4);textview_6_5 = (TextView) findViewById(R.id.textview6_5);

        table = new HashMap<>();
        //1st row
        table.put("0 0",textview_0_0);table.put("0 1",textview_0_1);table.put("0 2",textview_0_2);table.put("0 3",textview_0_3);
        table.put("0 4",textview_0_4);table.put("0 5",textview_0_5);
        //2nd row
        table.put("1 0",textview_1_0);table.put("1 1",textview_1_1);table.put("1 2",textview_1_2);table.put("1 3",textview_1_3);
        table.put("1 4",textview_1_4);table.put("1 5",textview_1_5);
        //3rd row
        table.put("2 0",textview_2_0);table.put("2 1",textview_2_1);table.put("2 2",textview_2_2);table.put("2 3",textview_2_3);
        table.put("2 4",textview_2_4);table.put("2 5",textview_2_5);
        //4th row
        table.put("3 0",textview_3_0);table.put("3 1",textview_3_1);table.put("3 2",textview_3_2);table.put("3 3",textview_3_3);
        table.put("3 4",textview_3_4);table.put("3 5",textview_3_5);
        //5th row
        table.put("4 0",textview_4_0);table.put("4 1",textview_4_1);table.put("4 2",textview_4_2);table.put("4 3",textview_4_3);
        table.put("4 4",textview_4_4);table.put("4 5",textview_4_5);
        //6th row
        table.put("5 0",textview_5_0);table.put("5 1",textview_5_1);table.put("5 2",textview_5_2);table.put("5 3",textview_5_3);
        table.put("5 4",textview_5_4);table.put("5 5",textview_5_5);
        //7th row
        table.put("6 0",textview_6_0);table.put("6 1",textview_6_1);table.put("6 2",textview_6_2);table.put("6 3",textview_6_3);
        table.put("6 4",textview_6_4);table.put("6 5",textview_6_5);
        
        playersTurn = true;

    }

    @Override
    public void onBackPressed() {
        //alert dialogue box , you are about to end the game
        super.onBackPressed();
    }

    public void setSign(int row, int col, char sign){
        TextView textview = table.get(row+" "+col);
//        Toast.makeText(PlayActivity.this, row+" "+col, Toast.LENGTH_SHORT).show();
        Character c = new Character(sign);
        textview.setText(c.toString());
    }

    @Override
    public void onClick(View v) {
        if(playersTurn) {
            String tag = v.getTag().toString();
            int col = Integer.parseInt(tag);
            if (game.validMove(col)) {
                int row = game.updatePosition(col, game.playerSign);
                Toast.makeText(PlayActivity.this, "Click "+row, Toast.LENGTH_SHORT).show();
                playersTurn = false;
                setSign(row, col, game.playerSign);
                game.gameScore = game.calculateGame(col, game.gameScore);
                if (game.gameScore == game.NEG_INF) {
                    //plaier wins
                    // NEG_INF;
                    Toast.makeText(PlayActivity.this, "You won", Toast.LENGTH_SHORT).show();
                    //new alertBox
                    return;
                }

                int aiCol = game.aiTurn(3);
                if (game.validMove(aiCol)) {
                    int aiRow = game.updatePosition(aiCol, game.aiSign);//0 for ai
                    playersTurn = true;
                    setSign(aiRow, aiCol, game.aiSign);
                    numberOfMoves += 2;
                    game.gameScore = game.calculateGame(aiCol, game.gameScore);
                    //check result
                    if (game.gameScore == game.POS_INF) {
                        //ai wins
                        Toast.makeText(PlayActivity.this, "You lost", Toast.LENGTH_SHORT).show();
                        //new alerBox
                        return;
                    }
                    if (isDrawn()) {
                        Toast.makeText(PlayActivity.this, "Drawn", Toast.LENGTH_SHORT).show();
                    }
                }

            } else {
                Toast.makeText(this, "there is no empty box!! ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isDrawn(){
        if(numberOfMoves >= 42){
            //player wins
            // POS_INF;
             return true;
        }
        return false;
    }

}