package com.justinkleiber.epicalc;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Algebra extends Activity{

	Button aos, pyl, py, qf, rads, mx, sys;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.algebra);
		aos=(Button) findViewById(R.id.baos);
	  	pyl=(Button) findViewById(R.id.bptl);
	  	py=(Button) findViewById(R.id.bpyh);
	  	qf=(Button) findViewById(R.id.bqf);
	  	rads=(Button) findViewById(R.id.bSr);
	  	mx=(Button) findViewById(R.id.bmx);
	  	sys=(Button) findViewById(R.id.bSys);
	  	
	  	
	  	 py.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
						Intent pyintent=new Intent("android.intent.action.PY");
						startActivity(pyintent);
					}
				
			});
	        qf.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
						Intent qf=new Intent("android.intent.action.QF");
						startActivity(qf);
					}
				
			});
			mx.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
						Intent mx=new Intent("android.intent.action.SLO");
						startActivity(mx);
				
				}		
			});
	        pyl.setOnClickListener(new View.OnClickListener() {
	        	@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	        		Intent pyl=new Intent("android.intent.action.PYL");
					startActivity(pyl);
			
	        	}   
	});
	aos.setOnClickListener(new View.OnClickListener() {
	        	@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	        		Intent aos=new Intent("android.intent.action.AOS");
					startActivity(aos);
			
	        	}   
	});
	rads.setOnClickListener(new View.OnClickListener() {
	        	@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	        		Intent con=new Intent("android.intent.action.RADS");
					startActivity(con);
			
	        	}   
	});
	sys.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent c = new Intent("android.intent.action.SYS");
					startActivity(c);
				}
			});
	}

	 
}
