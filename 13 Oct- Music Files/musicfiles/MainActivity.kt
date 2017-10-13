package com.bmpl.musicfiles

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import com.bmpl.musicfiles.R.id.*
import com.bmpl.musicfiles.R.raw.song

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var videoView = findViewById(videoView) as VideoView

        var playbutton  = findViewById(playButton) as Button
        var pauseButton = findViewById(pauseButton) as Button
        var stopButton = findViewById(stopButton) as Button

        var path : String = "android.resource://" + this.packageName + "/" + R.raw.small

        videoView.setVideoPath(path)

        videoView.setMediaController(MediaController(this))

        videoView.start() //video will start playing

        // .mp3 or wav or sound format -->Predefined-->
        // MediaPlayer class --> start(), stop(), pause()

        var songFile = MediaPlayer.create(this, song)//default cons or non-empty--> paramterized cons

        playbutton.setOnClickListener {
            songFile.start()
        }
        pauseButton.setOnClickListener {
            songFile.pause()
        }

        stopButton.setOnClickListener {
            songFile.stop()
        }
    }
}
