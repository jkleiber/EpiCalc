package com.justinkleiber.epicalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Precalc extends Activity{

	Button fact, perm, comb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.precalc);
		
		fact=(Button) findViewById(R.id.bfact);
    	perm=(Button) findViewById(R.id.bPerm);
    	comb=(Button) findViewById(R.id.bCE);
    	
    	fact.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent thy=new Intent("android.intent.action.FACT");
    		startActivity(thy);
		}
	});
    perm.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent thy=new Intent("android.intent.action.PERM");
    		startActivity(thy);
		}
	});
    comb.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent thy=new Intent("android.intent.action.CO");
    		startActivity(thy);
		}
	});
	}

}
