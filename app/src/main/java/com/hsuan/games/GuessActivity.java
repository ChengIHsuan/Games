package com.hsuan.games;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuessActivity extends AppCompatActivity {

    private EditText edNum;
    private TextView tvMax;
    private TextView tvMin;
    int max;
    int min;
    int ans;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        Button bInfo = (Button) findViewById(R.id.b_info);
        bInfo.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         new AlertDialog.Builder(GuessActivity.this)
                                                 .setMessage("Enter a number in the range.")
                                                 .setPositiveButton("OK", null)
                                                 .show();
                                     }
                                 }
        );
        range();
    }

    public void range() {
        tvMin = (TextView) findViewById(R.id.tv_min);
        tvMax = (TextView) findViewById(R.id.tv_max);

        final String[] items = new String[]{"10", "50", "100", "200"};
        new AlertDialog.Builder(this)
                .setTitle("Please choose the range.")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvMin.setText("0");
                        tvMax.setText(items[i]);
                        min = Integer.parseInt(tvMin.getText().toString());
                        max = Integer.parseInt(tvMax.getText().toString());
                        ans = (int) (Math.random() * (max - 1) + 1);
                    }
                })
                .show();
    }

    public void b_guess(View view) {
        edNum = (EditText) findViewById(R.id.ed_num);
        num = Integer.parseInt(edNum.getText().toString());
        String sNum = String.valueOf(num);
        if (num > min && num < max) {
            if (num > ans) {
                tvMax.setText(sNum);
                max = num;
            } else if (num < ans) {
                tvMin.setText(sNum);
                min = num;
            } else if (num == ans) {
                new AlertDialog.Builder(this)
                        .setMessage("BINGO!!!")
                        .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                range();
                                edNum.setText("");
                            }
                        })
                        .setNegativeButton("CLOSE", null)
                        .show();
            }
        } else {
            Toast.makeText(GuessActivity.this, ("Please enter a number between " + min + " and " + max + " ."), Toast.LENGTH_SHORT).show();
        }
    }

}
