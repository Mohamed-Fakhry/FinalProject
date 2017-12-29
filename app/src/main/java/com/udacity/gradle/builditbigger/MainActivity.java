package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.displayjokes.DisplayJokeActivity;
import com.udacity.gradle.jokes.Joker;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        final Context context = this;
        new EndpointsAsyncTask().execute(new OnGetJokeListener() {
            @Override
            public void onRecive(String joke) {
                startActivity(DisplayJokeActivity.openJokeActivity(context, joke));
            }
        });
    }

    interface OnGetJokeListener {
        void onRecive(String joke);
    }
}
