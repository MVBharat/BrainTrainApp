package com.example.bharat.braintrain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView sumTextView;
    ArrayList<Integer> answer;
    int locationOfCorrectAnswer;
    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.startButton);
        sumTextView = (TextView)findViewById(R.id.sumTextView);
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);

        for (int i = 0 ; i< 4; i++){
            if(i==locationOfCorrectAnswer){
                answer.add(a+b);
            }else{
                int inCorrectAnswer = rand.nextInt(41);
                while(inCorrectAnswer == a + b){
                    inCorrectAnswer = rand.nextInt(41);
                }
                answer.add(inCorrectAnswer);
            }
        }
    }
}
