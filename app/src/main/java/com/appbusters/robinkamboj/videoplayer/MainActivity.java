package com.appbusters.robinkamboj.videoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.halilibo.bettervideoplayer.BetterVideoCallback;
import com.halilibo.bettervideoplayer.BetterVideoPlayer;

import uk.co.jakelee.vidsta.VidstaPlayer;

public class MainActivity extends AppCompatActivity implements BetterVideoCallback{

    private BetterVideoPlayer player;
    private static final String TAG = "BVP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grabs a reference to the player view
        player = (BetterVideoPlayer) findViewById(R.id.player);

        // Sets the callback to this Activity, since it inherits EasyVideoCallback
        player.setCallback(this);

        // Sets the source to the HTTP URL held in the TEST_URL variable.
        // To play files, you can use Uri.fromFile(new File("..."))
        player.setSource(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));

        // From here, the player view will show a progress indicator until the player is prepared.
        // Once it's prepared, the progress indicator goes away and the controls become enabled for the user to begin playback.

//
//        VidstaPlayer player = (VidstaPlayer) findViewById(R.id.player2);
//        player.setVideoSource("http://www.quirksmode.org/html5/videos/big_buck_bunny.mp4");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Make sure the player stops playing if the user presses the home button.
        player.pause();
    }

    // Methods for the implemented EasyVideoCallback

    @Override
    public void onStarted(BetterVideoPlayer player) {
        Log.e(TAG, "Started");
    }

    @Override
    public void onPaused(BetterVideoPlayer player) {
        Log.e(TAG, "Paused");
    }

    @Override
    public void onPreparing(BetterVideoPlayer player) {
        Log.e(TAG, "Preparing");
    }

    @Override
    public void onPrepared(BetterVideoPlayer player) {
        Log.e(TAG, "Prepared");
    }

    @Override
    public void onBuffering(int percent) {
        Log.e(TAG, "Buffering " + percent);
    }

    @Override
    public void onError(BetterVideoPlayer player, Exception e) {
        Log.e(TAG, "Error " +e.getMessage());
    }

    @Override
    public void onCompletion(BetterVideoPlayer player) {
        Log.e(TAG, "Completed");
    }

    @Override
    public void onToggleControls(BetterVideoPlayer player, boolean isShowing) {
        Log.e(TAG, "Controls toggled " + isShowing);
    }
}
