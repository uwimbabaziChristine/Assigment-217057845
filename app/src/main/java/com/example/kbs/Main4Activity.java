package com.example.kbs;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity{
    Button play, stop;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        play= (Button) findViewById(R.id.play);
        stop= (Button) findViewById(R.id.stop);
    }
    public void download(View view){
        progress= new ProgressDialog(this);
        progress. setMessage("Downloading Music");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();

        final int totalProgressTime= 100;
        final Thread t=new Thread(){

            @Override
            public void run(){
                int jumpTime=0;
                while (jumpTime<totalProgressTime){

                    try{
                        sleep(200);
                        jumpTime +=5;
                        progress.setProgress(jumpTime);

                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}
