/**
 * Copyright 2016 GwynnieBee Inc.
 */

package com.udacity.project.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * This file contains the code for the {@link ScoreKeeperActivity} which is the main activity for
 * handling the score counter for two different teams.
 *
 * @author sarath
 * @version 1.0
 * @since 20/12/2016
 */
public class ScoreKeeperActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int mScoreTeamA = 0;

    // Tracks the score for Team B
    int mScoreTeamB = 0;

    // End game banner view.
    TextView mEndGameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keeper);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        // This adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        mEndGameTextView = (TextView) findViewById(R.id.end_game_text);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_end_game) {
            if (mEndGameTextView != null) {
                mEndGameTextView.setVisibility(View.VISIBLE);
                if (mScoreTeamA == mScoreTeamB) {
                    mEndGameTextView.setText(R.string.end_banner_draw);
                } else {
                    String winner = (mScoreTeamA < mScoreTeamB) ? "Team B" : "Team A";
                    mEndGameTextView.setText(String.format(getResources().getString(R.string.end_banner), winner));
                }
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        mScoreTeamA = mScoreTeamA + 1;
        displayForTeamA(mScoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        mScoreTeamA = mScoreTeamA + 2;
        displayForTeamA(mScoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        mScoreTeamA = mScoreTeamA + 3;
        displayForTeamA(mScoreTeamA);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        mScoreTeamB = mScoreTeamB + 1;
        displayForTeamB(mScoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        mScoreTeamB = mScoreTeamB + 2;
        displayForTeamB(mScoreTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        mScoreTeamB = mScoreTeamB + 3;
        displayForTeamB(mScoreTeamB);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        mScoreTeamA = 0;
        mScoreTeamB = 0;
        displayForTeamA(mScoreTeamA);
        displayForTeamB(mScoreTeamB);
        if (mEndGameTextView != null) {
            mEndGameTextView.setVisibility(View.GONE);
        }
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
