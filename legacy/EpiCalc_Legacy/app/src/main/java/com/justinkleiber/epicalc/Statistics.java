package com.justinkleiber.epicalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Statistics extends Activity{

	Button pe, frac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistics);
		
		pe=(Button) findViewById(R.id.bPE);
     	frac=(Button) findViewById(R.id.bFE);
     	
     	 frac.setOnClickListener(new View.OnClickListener() {
    	@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
    		Intent fra=new Intent("android.intent.action.FRAC");
			startActivity(fra);
	
    	}   
		});
		pe.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent thy=new Intent("android.intent.action.PE");
    		startActivity(thy);
		}
	});
	}

}
