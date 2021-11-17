package com.hediyeyildirim.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread mSplashThread;//thread classdan obje olustrduk uygulamann 4 saniye uyutulmasi icin
        mSplashThread = new Thread(){
            @Override public void run(){
                try {

                    synchronized(this){
                        wait(4000);
                    }
                }catch(InterruptedException ex){

                }
                finally{

                    Intent i=new Intent(getApplicationContext(),SignUpActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        };//thread objesini olustrduk ve istedmz sekilde sekillendrdik
        mSplashThread.start();// thread objesini calistriyoruz

    }
    }
