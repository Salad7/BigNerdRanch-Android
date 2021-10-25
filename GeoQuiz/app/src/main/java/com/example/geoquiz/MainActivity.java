package com.example.geoquiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mTrueButton;
    Button mFalseButton;
    Button mNextButton;
    TextView mQuestionTextView;
    Button mCheatButton;
    boolean mIsCheater;
    private static final int REQUEST_CODE_CHEAT = 0;
    private static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";

    private static final String TAG = "QuizActivity";
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, true),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, false),
            new Question(R.string.question_asia, true)
    };
    int mCurrentIndex = 0;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy called");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle) called");


        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mNextButton = findViewById(R.id.next_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mCheatButton = findViewById(R.id.cheat_button);
        updateQuestion();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                mIsCheater = false;
                updateQuestion();

            }
        });
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CheatActivity.class);
                intent.putExtra("cheater",mQuestionBank[mCurrentIndex].getAnswerTrue());
                startActivityForResult(intent,REQUEST_CODE_CHEAT);
            }
        });
    }
    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra("cheater",false);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {

            return;
        }
        if(resultCode == RESULT_OK){
            if(data == null){
                return;
            }
            mIsCheater = MainActivity.wasAnswerShown(data);
        }
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].getAnswerTrue();
                int messageResId = 0;
                if(mIsCheater) {
                    messageResId = R.string.judgment_toast;
                }
                else {
                    if (userPressedTrue == answerIsTrue) {
                        messageResId = R.string.correct_toast;
                    } else {
                        messageResId = R.string.incorrect_toast;
                    }
                }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
}