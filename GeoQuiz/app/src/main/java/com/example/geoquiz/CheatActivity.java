package com.example.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra("cheater",false);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else{
                    mAnswerTextView.setText(R.string.false_button);

                }
                setAnswerShownResult(true);
            }
        });

    }

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra("cheater",isAnswerShown);
        setResult(RESULT_OK,data);
    }
}
