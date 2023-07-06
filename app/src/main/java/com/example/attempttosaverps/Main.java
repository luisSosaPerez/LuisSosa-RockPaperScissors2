package com.example.attempttosaverps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Main extends AppCompatActivity {
    Button btn_rock, btn_paper, btn_scissors;
    TextView human_score, bot_score, result;
    ImageView iv_bot, iv_human;
    int botScoreCount, humanScoreCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign variables to their id´s in the  xml file.
        btn_rock = (Button) findViewById(R.id.btn_rock);
        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_scissors = (Button) findViewById(R.id.btn_scissors);

        iv_bot = (ImageView) findViewById(R.id.iv_bot);
        iv_human = (ImageView) findViewById(R.id.iv_human);
        result = (TextView) findViewById(R.id.result);



        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_human.setImageResource(R.drawable.paper);
                String message = runGame("paper");

                Toast.makeText(Main.this, message, Toast.LENGTH_SHORT).show();
                result.setText(message);

            }
        });
        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_human.setImageResource(R.drawable.rock);
                String message = runGame("rock");
                Toast.makeText(Main.this, message, Toast.LENGTH_SHORT).show();
                result.setText(message);
            }
        });
        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_human.setImageResource(R.drawable.scissors);
                String message = runGame("scissors");
                Toast.makeText(Main.this, message, Toast.LENGTH_SHORT).show();
                result.setText(message);

            }
        });
    }
    public String runGame(String humanChoice){
        String botChoice = "";

        //create a random number instance, connect that to a var called botRandChoice.int from 0-2
        //then connect that rand int to th string botChoice 0=paper 1=rock 2=scissors
        Random rand = new Random();
        int botRandChoice = rand.nextInt(3);
        if ( botRandChoice == 0 ){
            iv_bot.setImageResource(R.drawable.paper);
            botChoice = "paper";
        } else
        if (botRandChoice == 1) {
            iv_bot.setImageResource(R.drawable.rock);
            botChoice = "rock";
        } else
        if (botRandChoice == 2) {
            iv_bot.setImageResource(R.drawable.scissors);
            botChoice = "scissors";
        }
        //if conditions that depending on the botChoice will be show results results.
        // Compare who chose what
        if(botChoice == humanChoice){
            return "DRAW nobody wins";
        }else
        if(botChoice=="paper"&&humanChoice=="rock"){
            botScoreCount++;
            return "Computer Won, Paper Wraps Rock";

        } else if(botChoice=="rock"&&humanChoice=="scissors"){
            botScoreCount++;
            return "Computer Won, Rock crushes Scissors";

        } else if(botChoice=="scissors"&&humanChoice=="paper"){
            botScoreCount++;
            return  "Computer Won, scissors cut paper";
        }else if(botChoice=="rock"&&humanChoice=="paper"){
            humanScoreCount++;
            return "YOU Won Paper Wraps Rock";

        }else if(botChoice=="scissors"&&humanChoice=="rock"){
            humanScoreCount++;
            return "YOU Won, Paper Wraps Rock";

        }else if(botChoice=="paper"&&humanChoice=="scissors"){
            humanScoreCount++;
            return "YOU Won, Paper Wraps Rock";
        }
        return "something went wrong";
    }
}