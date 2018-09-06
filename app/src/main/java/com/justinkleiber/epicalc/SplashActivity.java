package com.justinkleiber.epicalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Justin on 7/26/2015.
 */
public class SplashActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread splash=new Thread(){
            public void run(){
                try{
                    sleep(2000);
                    Intent i=new Intent("android.intent.action.MAIN_SCREEN");
                    startActivity(i);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }finally{
                    finish();
                }
            }
        };
        splash.start();
    }
}
