package com.example.lesson04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button newGame;
    Button check1;
    Button check2;
    Button check3;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    EditText et1;
    EditText et2;
    EditText et3;
    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    int i, j, amount, uAnswer, correct, sum, k, d,  time;
    String str;
    boolean flag2, flag3, flag1,next1,next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newGame = findViewById(R.id.newGame);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        i = j = amount = uAnswer = correct = sum = k = d = 0;
        flag2 = flag3 = false;
        flag1 = next1 = next2 = true;
        i = (int) (Math.random() * 89) + 10;
        j = (int) (Math.random() * 89) + 10;
        k = (int) (Math.random() * 89) + 10;
        d = (int) (Math.random() * 89) + 10;
        tv1.setText(String.valueOf(i));
        tv2.setText(String.valueOf(j));
        sum = i + j;
    }

    public void newGame(View view) {
        time = correct = amount = sum = 0;
        flag2 = flag3 = false;
        flag1 = next1 = next2 = true;
        i = (int) (Math.random() * 89) + 10;
        j = (int) (Math.random() * 89) + 10;
        k = (int) (Math.random() * 89) + 10;
        d = (int) (Math.random() * 89) + 10;
        tv1.setText(String.valueOf(i));
        tv2.setText(String.valueOf(j));
        tv3.setText("");
        tv4.setText("");
        tv5.setText("");
        tv6.setText("");
        iv1.setImageBitmap(null);
        iv2.setImageBitmap(null);
        iv3.setImageBitmap(null);
    }

    public void checkFirst(View view) {
        if (flag1){
            str = et1.getText().toString();
            if (str.equals("")) {
                Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
                iv1.setImageResource(R.drawable.x);
            }
            else{
                uAnswer = Integer.parseInt(str);
                sum = i + j;
                if (uAnswer == sum) {
                    iv1.setImageResource(R.drawable.v);
                    tv3.setText(String.valueOf(sum));
                    tv4.setText(String.valueOf(k));
                    if (next1) {
                        sum += k;
                        flag2 = true;
                    }
                    next1  = false;
                    amount ++;
                    correct ++;
                }
                else{
                    iv1.setImageResource(R.drawable.x);
                    if (next1) {
                        sum += k;
                        flag2 = true;
                    }
                    next1 = false;
                    tv3.setText(String.valueOf(sum));
                    tv4.setText(String.valueOf(k));
                    sum += k;
                    amount++;
                }
            }
        }
    }

    public void checkSecond(View view) {
        if(flag2){
            flag1 = false;
            str = et2.getText().toString();
            if (str.equals("")) {
                Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
                iv2.setImageResource(R.drawable.x);
            }
            else {
                uAnswer = Integer.parseInt(str);
                if (uAnswer == sum) {
                    iv2.setImageResource(R.drawable.v);
                    tv5.setText(String.valueOf(sum));
                    tv6.setText(String.valueOf(d));
                    if (next2) {
                        sum += d;
                        flag3 = true;
                    }
                    next2  = flag2 = false;
                    amount ++;
                    correct ++;
                } else {
                    iv2.setImageResource(R.drawable.x);
                    tv5.setText(String.valueOf(sum));
                    tv6.setText(String.valueOf(d));
                    if (next2) {
                        sum += d;
                        flag3 = true;
                    }
                    next2 = flag2 = false;
                    amount ++;
                }
            }
        }
    }

    public void checkThird(View view) {
        if (flag3) {
            flag2 = false;
            str = et3.getText().toString();
            if (str.equals("")) {
                Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
                iv3.setImageResource(R.drawable.x);
            } else {
                uAnswer = Integer.parseInt(str);
                if (uAnswer == sum) {
                    correct++;
                    amount++;
                    iv3.setImageResource(R.drawable.v);
                } else {
                    amount++;
                    iv3.setImageResource(R.drawable.x);
                }
            }
            Toast.makeText(this, "Your score: " + (correct + "/" + amount), Toast.LENGTH_SHORT).show();
        }
    }
}
