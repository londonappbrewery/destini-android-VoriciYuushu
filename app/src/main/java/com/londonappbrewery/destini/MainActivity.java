package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;
    String mStoryIndex = "start";
    Button mPlayAgainButton;
    Button mQuitAppButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mPlayAgainButton = findViewById(R.id.playAgainButton);
        mQuitAppButton = findViewById(R.id.quitButton);

        mPlayAgainButton.setVisibility(View.GONE);
        mQuitAppButton.setVisibility(View.GONE);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelection('a');
            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSelection('b');
            }
        });


    }

    public void userSelection (char userChoice) {
        if (mStoryIndex == "start" && userChoice == 'a') {
            mStoryTextView.setText(R.string.T3_Story);
            mButtonTop.setText(R.string.T3_Ans1);
            mButtonBottom.setText(R.string.T3_Ans2);
            mStoryIndex = "hop_in";
        } else if (mStoryIndex == "start" && userChoice == 'b') {
            mStoryTextView.setText(R.string.T2_Story);
            mButtonTop.setText(R.string.T2_Ans1);
            mButtonBottom.setText(R.string.T2_Ans2);
            mStoryIndex = "ask_if_murderer";
        } else if (mStoryIndex == "ask_if_murderer" && userChoice == 'a') {
            mStoryTextView.setText(R.string.T3_Story);
            mButtonTop.setText(R.string.T3_Ans1);
            mButtonBottom.setText(R.string.T3_Ans2);
            mStoryIndex = "hop_in";
        } else if (mStoryIndex == "ask_if_murderer" && userChoice == 'b') {
            mStoryTextView.setText(R.string.T4_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            gameOver();
        } else if (mStoryIndex == "hop_in" && userChoice == 'a') {
            mStoryTextView.setText(R.string.T6_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            gameOver();
        } else if (mStoryIndex == "hop_in" && userChoice == 'b') {
            mStoryTextView.setText(R.string.T5_End);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            gameOver();
        }
    }

    public void gameOver () {

        mPlayAgainButton.setVisibility(View.VISIBLE);
        mPlayAgainButton.setText(R.string.playAgain);
        mQuitAppButton.setVisibility(View.VISIBLE);
        mQuitAppButton.setText(R.string.Quit);

        mPlayAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStoryIndex = "start";
                mButtonTop.setVisibility(View.VISIBLE);
                mButtonBottom.setVisibility(View.VISIBLE);
                mStoryTextView.setText(R.string.T1_Story);
                mButtonTop.setText(R.string.T1_Ans1);
                mButtonBottom.setText(R.string.T1_Ans2);
                mPlayAgainButton.setVisibility(View.GONE);
                mQuitAppButton.setVisibility(View.GONE);
            }
        });

        mQuitAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

//        AlertDialog.Builder alert = new AlertDialog.Builder(this);
//        alert.setTitle("Game Over");
//        alert.setCancelable(false);
//        alert.setMessage("Play Again?");
//        alert.setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
//            }
//        });
//        alert.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                mStoryIndex = "start";
//                mButtonTop.setVisibility(View.VISIBLE);
//                mButtonBottom.setVisibility(View.VISIBLE);
//                mStoryTextView.setText(R.string.T1_Story);
//                mButtonTop.setText(R.string.T1_Ans1);
//                mButtonBottom.setText(R.string.T1_Ans2);
//            }
//        });
//        alert.show();
//    }
}
