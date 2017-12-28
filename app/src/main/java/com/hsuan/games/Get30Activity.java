package com.hsuan.games;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Get30Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get30);
        number = (ImageView) findViewById(R.id.img_num);
        player();
    }

    private ImageView number;
    private int numbers[] = {R.drawable.num0, R.drawable.num1, R.drawable.num2, R.drawable.num3, R.drawable.num4, R.drawable.num5,
            R.drawable.num6, R.drawable.num7, R.drawable.num8, R.drawable.num9, R.drawable.num10,
            R.drawable.num11, R.drawable.num12, R.drawable.num13, R.drawable.num14, R.drawable.num15,
            R.drawable.num16, R.drawable.num17, R.drawable.num18, R.drawable.num19, R.drawable.num20,
            R.drawable.num21, R.drawable.num22, R.drawable.num23, R.drawable.num24, R.drawable.num25,
            R.drawable.num26, R.drawable.num27, R.drawable.num28, R.drawable.num29, R.drawable.num30,
            R.drawable.bomb, R.drawable.bomb};
    int num;
    int times;

    public void get30() {
        times++;
        if (num == 30) {
            if ((times % 2) == 0) {
                new AlertDialog.Builder(this)
                        .setMessage("Player2 Get 30~~~")
                        .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                num = 0;
                                times = 0;
                                number.setImageResource(numbers[num]);
                                player();
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();
            } else {
                new AlertDialog.Builder(this)
                        .setMessage("Player1 Get 30~~~")
                        .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                num = 0;
                                times = 0;
                                number.setImageResource(numbers[num]);
                                player();
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();
            }
        }
        if (num != 30) {
            if (num > 30) {
                if ((times % 2) == 0) {
                    Log.d("Get30AC", ">30");
                    new AlertDialog.Builder(this)
                            .setMessage("BOMB!!!Player1 WIN")
                            .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    num = 0;
                                    times = 0;
                                    number.setImageResource(numbers[num]);
                                    player();
                                }
                            })
                            .setNegativeButton("Close", null)
                            .show();
                } else {
                    new AlertDialog.Builder(this)
                            .setMessage("BOMB!!!PLAYER2 WIN")
                            .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    num = 0;
                                    times = 0;
                                    number.setImageResource(numbers[num]);
                                    player();
                                }
                            })
                            .setNegativeButton("Close", null)
                            .show();
                }
            } else {
                number.setImageResource(numbers[num]);
                player();
            }
        }
    }

    public void player() {
        ImageView p1 = (ImageView) findViewById(R.id.player1);
        ImageView p2 = (ImageView) findViewById(R.id.player2);
        if ((times % 2) == 0) {
            p1.setVisibility(View.VISIBLE);
            p2.setVisibility(View.INVISIBLE);
        } else {
            p1.setVisibility(View.INVISIBLE);
            p2.setVisibility(View.VISIBLE);
        }
    }

    public void b_one(View view) {
        num = num + 1;
        get30();
    }

    public void b_two(View view) {
        num = num + 2;
        get30();
    }

    public void b_three(View view) {
        num = num + 3;
        get30();
    }
}
