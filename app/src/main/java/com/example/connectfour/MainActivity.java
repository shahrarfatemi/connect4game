package com.example.connectfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView nameText,sloganText;

    public static int SPLASH_SCREEN = 4000;
    Animation topAnimation,bottomAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = (ImageView) findViewById(R.id.imageView);
        nameText = (TextView) findViewById(R.id.textView);
        sloganText = (TextView) findViewById(R.id.textView2);

        imageView.setAnimation(topAnimation);
        nameText.setAnimation(bottomAnimation);
        sloganText.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,HomepageActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}