package com.example.bharat.braintrain;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    Button playAgainButton;
    Button button0,button1,button2,button3;
    TextView sumTextView, resultTextView, pointsTextView, timerTextView;

    ArrayList<Integer> answer = new ArrayList<Integer>();
    int score = 0, numberOfQuetions =0;
    int locationOfCorrectAnswer;

    public void generateQuestion(){
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+ "+" + Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);
        answer.clear();

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
        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));

    }

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    private void playAgain(View view) {
        Log.e("Play again clicked", "Clicked");
        score = 0;
        numberOfQuetions = 0;
        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(view.INVISIBLE);

        generateQuestion();

        new CountDownTimer(3100, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000)+"s");
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your score"+ Integer.toString(score)+"/"+Integer.toString(numberOfQuetions));
            }
        }.start();
    }

    public void chooseAnswer(View view){
        Log.e("Tag:::::", (String)view.getTag());
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            Log.e("Correct", "correct");
            score++;
            resultTextView.setText("Correct!");
        }
        else{
            resultTextView.setText("Wrong!");
        }

        numberOfQuetions++;
        pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuetions));
        generateQuestion();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = (TextView)findViewById(R.id.sumTextView);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
        pointsTextView = (TextView)findViewById((R.id.pointsTextView));
        timerTextView = (TextView)findViewById(R.id.timerTextView);

        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);

        startButton = (Button)findViewById(R.id.startButton);
        playAgainButton = (Button)findViewById(R.id.playAgainButton);

        Log.e("Play again clicked", "initaiting");
        playAgain(findViewById(R.id.playAgainButton));


    }
}
