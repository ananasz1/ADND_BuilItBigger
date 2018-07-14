package com.example.jokesandrolib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "EXTRA_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_show_joke );

        TextView showJokeTextView = (TextView) findViewById( R.id.joke_text );

        String jokeResult = null;
        Intent intent = getIntent();

        if (null != intent && intent.hasExtra( EXTRA_DATA )) {
            jokeResult = intent.getStringExtra( EXTRA_DATA );
            showJokeTextView.setText( jokeResult );
        } else {
            showJokeTextView.setText( getString( R.string.error_no_joke_available ) );
        }

    }
}

