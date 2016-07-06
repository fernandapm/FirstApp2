package com.example.fernanda.firstapp;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.media.MediaRecorder;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;




public class sentence2 extends AppCompatActivity {

    MediaRecorder myAudioRecorder;
    private String outputFile = null;
    private Button start, stop, play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final MediaPlayer sentence = MediaPlayer.create(this, R.raw.sentence3);
        Button preview = (Button) this.findViewById(R.id.preview);
        View playpreview = null;
        playpreview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sentence.start(); }
        });

        start = (Button) findViewById(R.id.button);
        stop = (Button) findViewById(R.id.button2);
        play = (Button) findViewById(R.id.button3);

        stop.setEnabled(false);
        play.setEnabled(false);
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/myrec.wav";

        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(outputFile);
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.next){
            Intent i = new Intent(sentence2.this, sentence3.class);
            startActivity(i);
        }
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.previous){
            Intent i = new Intent(sentence2.this, sentence1.class);
            startActivity(i);
        }
    }

    public void start(View v) {
        try
        {
            myAudioRecorder.prepare();
            myAudioRecorder.start();
        }
        catch (IllegalStateException e1)
        {
            e1.printStackTrace();
        }
        catch (IOException e2)
        {
            e2.printStackTrace();
        }

        start.setEnabled(false);
        stop.setEnabled(true);

        Toast.makeText(this, "Recording started", Toast.LENGTH_SHORT).show();

    }

    public void stop(View v) {
        myAudioRecorder.stop();
        myAudioRecorder.release();
        myAudioRecorder = null;
        stop.setEnabled(false);
        play.setEnabled(true);
        Toast.makeText(this, "Audio recorded successfully", Toast.LENGTH_SHORT).show();

    }

    public void play(View v)
    {
        MediaPlayer m = new MediaPlayer();
        try
        {
            m.setDataSource(outputFile);
            m.prepare();
        }
        catch (IOException e2)
        {
            e2.printStackTrace();
        }
        m.start();
        Toast.makeText(this, "Playing audio", Toast.LENGTH_SHORT).show();
    }
}

