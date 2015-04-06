package com.example.priteshpatel.vplayer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView myvideoview=(VideoView)findViewById(R.id.myVideoview);
        myvideoview.setVideoPath("https://www.thenewboston.com/forum/project_files/006_testVideo.mp4");

        MediaController mycontroller=new MediaController(this);
        mycontroller.setAnchorView(myvideoview);

        myvideoview.setMediaController(mycontroller);
        myvideoview.start();

    }



}
