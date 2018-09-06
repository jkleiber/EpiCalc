package com.justinkleiber.epicalc;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Electrical extends Activity{

	Button apo, sres;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.electric);
		sres=(Button) findViewById(R.id.bress);
        apo=(Button) findViewById(R.id.bapo);
       
         
        apo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
					Intent apo=new Intent("android.intent.action.AP");
					startActivity(apo);
				}
			
		});
        sres.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		Intent sr=new Intent("android.intent.action.SRES");
        		startActivity(sr);

        	}   
        });
	}
	
}
