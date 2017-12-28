package com.hsuan.games;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    boolean info = false;
    public static final int FUNC_INFO = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case FUNC_INFO:
                if (resultCode == RESULT_OK){
                    String city = data.getStringExtra("INFO_CITY");
                    String area = data.getStringExtra("INFO_AREA");
                    String name = data.getStringExtra("INFO_NAME");
                    Toast.makeText(this, ("您好, "  + city + area + "的" + name), Toast.LENGTH_SHORT).show();
                }else {
                    finish();
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!info){
            startActivityForResult(new Intent(this, PlayerInfoActivity.class), FUNC_INFO);
        }
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
    public void b_get30(View view){
        Intent get30 = new Intent(this, Get30Activity.class);
        startActivity(get30);
    }
}
