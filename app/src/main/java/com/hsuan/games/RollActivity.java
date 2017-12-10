package com.hsuan.games;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);
    }

    private ImageView dice;
    private int images[] = {R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6};

    public void b_roll(View view){
        int num = (int) (Math.random() * 6 + 1);
        dice = (ImageView) findViewById(R.id.dice);
        dice.setImageResource(images[num - 1]);
    }



}
