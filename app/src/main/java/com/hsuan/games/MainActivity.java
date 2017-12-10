package com.hsuan.games;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void b_guess(View view) {
        Intent guess = new Intent(this, GuessActivity.class);
        startActivity(guess);
    }
    public void b_1A2B(View view){
        Intent abguess = new Intent(this, ABguessActivity.class);
        startActivity(abguess);
    }
    public void b_roll(View view){
        Intent roll = new Intent(this, RollActivity.class);
        startActivity(roll);
    }
}
