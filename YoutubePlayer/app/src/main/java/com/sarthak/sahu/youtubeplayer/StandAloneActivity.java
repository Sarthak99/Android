package com.sarthak.sahu.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandAloneActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "StandAloneActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button btnPlayVideo = findViewById(R.id.btnPlayVideo);
        Button btnPlayList = findViewById(R.id.btnplaylist);

        btnPlayVideo.setOnClickListener(this);
        btnPlayList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnPlayVideo:
                Log.i(TAG, "onClick: Clicked on Play Video");
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEYS, YoutubeActivity.YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnplaylist:
                Log.i(TAG, "onClick: Clicked on Play Playlist");
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEYS, YoutubeActivity.YOUTUBE_PLAYLIST_ID);
                break;
            default:
        }

        if (intent != null) {
            Log.i(TAG, "onClick: Standalone before start intent");
            startActivity(intent);
            Log.i(TAG, "onClick: Standalone after start intent");
        }
    }
}
