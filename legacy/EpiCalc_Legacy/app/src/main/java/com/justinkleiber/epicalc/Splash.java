package com.justinkleiber.epicalc;


import com.google.analytics.tracking.android.EasyTracker;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.splash);
	
	
	
	Thread splash=new Thread(){
		public void run(){
			try{
				sleep(2000);
				Intent mi=new Intent("android.intent.action.MA");
				startActivity(mi);
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
	@Override
    public void onStart() {
      super.onStart();
      EasyTracker.getInstance(this).activityStart(this);  // Add this method.
    }

    @Override
    public void onStop() {
      super.onStop();
      EasyTracker.getInstance(this).activityStop(this);  // Add this method.
    }
}