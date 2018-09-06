package com.justinkleiber.epicalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Geometry extends Activity{
Button mf, df, law,surf, circ, tfs, tat;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.geometry);
		mf=(Button) findViewById(R.id.bMf);
	  	df=(Button) findViewById(R.id.bDf);
	  	law=(Button) findViewById(R.id.bLSC);
	  	surf=(Button) findViewById(R.id.bSur);
	 	//circ=(Button) findViewById(R.id.bCF);
	   	tfs=(Button) findViewById(R.id.bTfs);
	   	tat=(Button) findViewById(R.id.bTat);
	   	
	   	
	   	    mf.setOnClickListener(new View.OnClickListener() {
	        	@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	        		Intent con=new Intent("android.intent.action.MF");
					startActivity(con);
			
	        	}   
			});
	        df.setOnClickListener(new View.OnClickListener() {
	        	@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	        		Intent con=new Intent("android.intent.action.DF");
					startActivity(con);
			
	        	}   
			});
			law.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent thy=new Intent("android.intent.action.LSC");
	        		startActivity(thy);
				}
			});
	        surf.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent thy=new Intent("android.intent.action.FSA");
	        		startActivity(thy);
				}
			});
			tat.setOnClickListener(new View.OnClickListener() {
	        	@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	        		Intent tat=new Intent("android.intent.action.THET");
					startActivity(tat);
			
	        	}   
			});
/*		    circ.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent thy=new Intent("android.intent.action.CIRC");
	        		startActivity(thy);
				}
			});		*/
			tfs.setOnClickListener(new View.OnClickListener() {
	        	@Override
	        	public void onClick(View v) {
	        		// TODO Auto-generated method stub
	        		Intent thy=new Intent("android.intent.action.TS");
	        		startActivity(thy);

	        	}   
	        });
	}

}
