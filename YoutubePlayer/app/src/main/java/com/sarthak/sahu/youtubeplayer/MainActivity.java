package com.sarthak.sahu.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSingle = findViewById(R.id.btnPlaySingle);
        Button btnStandalone = findViewById(R.id.btnStandalone);
        btnSingle.setOnClickListener(this);
        btnStandalone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnPlaySingle:
                Log.i(TAG, "onClick: Pressed Button Single");
                intent = new Intent(this, YoutubeActivity.class);
                break;
            case R.id.btnStandalone:
                Log.i(TAG, "onClick: Pressed Button Stand alone");
                intent = new Intent(this, StandAloneActivity.class);
                break;
            default:
        }

        if (intent != null) {
            Log.i(TAG, "onClick: Before Start Activity");
            startActivity(intent);
            Log.i(TAG, "onClick: After Start Activity");
        }
    }
}