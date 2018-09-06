package com.justinkleiber.epicalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Physics extends Activity{

	Button time, lpro, fpro, vpm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.physics);
		
		time=(Button) findViewById(R.id.bTime);
       	lpro=(Button) findViewById(R.id.bpm);
    	fpro=(Button) findViewById(R.id.bfpr);
    	vpm=(Button) findViewById(R.id.bvpm);
    	
    	
    	lpro.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
				Intent lpo=new Intent("android.intent.action.LPO");
				startActivity(lpo);
		}
		
	});
    fpro.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
				Intent fpo=new Intent("android.intent.action.FPO");
				startActivity(fpo);
		
		}
	});
	vpm.setOnClickListener(new View.OnClickListener() {
    	@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
    		Intent vpm=new Intent("android.intent.action.VPM");
			startActivity(vpm);
	
    	}   
	});
	time.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent thy=new Intent("android.intent.action.TPM");
    		startActivity(thy);
		}
	});
	}

}
