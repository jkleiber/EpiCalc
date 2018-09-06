package com.justinkleiber.epicalc;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class General extends Activity{
	Button are, rtd, ftd, prop, vol, sf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.general);
		
        are=(Button) findViewById(R.id.barea);
        rtd=(Button) findViewById(R.id.bR2D); 
        ftd=(Button) findViewById(R.id.bFtd);
        prop=(Button) findViewById(R.id.bProps);
        vol=(Button) findViewById(R.id.bVOL);
        sf=(Button) findViewById(R.id.bSF);
        
        are.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		Intent thy=new Intent("android.intent.action.ARE");
        		startActivity(thy);

        	}   
        });
        rtd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent c = new Intent("android.intent.action.RTD");
				startActivity(c);
			}
		});
        ftd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent c = new Intent("android.intent.action.FTD");
				startActivity(c);
			}
		});
        prop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent c = new Intent("android.intent.action.PROPS");
				startActivity(c);
			}
		});
        vol.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent thy=new Intent("android.intent.action.VOL");
        		startActivity(thy);
			}
		});
        sf.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent thy=new Intent("android.intent.action.SF");
        		startActivity(thy);
			}
		});
	}
}
