package com.example.connectfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class HomepageActivity extends AppCompatActivity implements View.OnClickListener{

    Button instructionsButton,playButton,regardsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_homepage);

        instructionsButton = (Button) findViewById(R.id.buttonInstruction);
        playButton = (Button) findViewById(R.id.buttonPlay);
        regardsButton = (Button) findViewById(R.id.buttonRegards);

        instructionsButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        regardsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonInstruction){

        }
        else if(v.getId() == R.id.buttonPlay){
            Intent intent = new Intent(HomepageActivity.this,PlayActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.buttonRegards){

        }
    }
}