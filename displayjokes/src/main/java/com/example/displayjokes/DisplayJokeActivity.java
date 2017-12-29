package com.example.displayjokes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE = "extra_joke";

    public static Intent openJokeActivity(Context context, String joke) {
        Intent intent = new Intent(context, DisplayJokeActivity.class);
        intent.putExtra(EXTRA_JOKE, joke);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String joke = getIntent().getStringExtra(EXTRA_JOKE);
        if (joke != null) ((TextView) findViewById(R.id.jokeTV)).setText(joke);
    }
}
