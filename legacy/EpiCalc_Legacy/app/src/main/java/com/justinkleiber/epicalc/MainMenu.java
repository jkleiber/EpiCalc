package com.justinkleiber.epicalc;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;



public class MainMenu extends Activity {
    
	int x=1;

//	Button py,qf,apo,fpro,lpro,mx,pyl,tat,aos,vpm,frac,tfs,mf,df,rads,sres,are,sf,vol,law,surf,fact,perm,comb,pe,time, circ, rtd, ftd, sys, prop;
//	private Interstitial interstitial;
	TextView t;
	
	Button gen, alg, geo, pre, phy, sta, ele, info;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        gen=(Button) findViewById(R.id.bgen);
        alg=(Button) findViewById(R.id.balg);
        geo=(Button) findViewById(R.id.bgeom);
        pre=(Button) findViewById(R.id.bprecal);
        sta=(Button) findViewById(R.id.bstats);
        info=(Button) findViewById(R.id.bci);
        
        
    

        
        
        info.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent thy=new Intent("android.intent.action.IN");
        		startActivity(thy);
			}
		});
        
        gen.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent thy=new Intent("android.intent.action.GEN");
        		startActivity(thy);
			}
		});
        alg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent thy=new Intent("android.intent.action.ALG");
        		startActivity(thy);
			}
		});
        geo.setOnClickListener(new View.OnClickListener() {
	
        	@Override
        	public void onClick(View v) {
			// TODO Auto-generated method stub
        		Intent thy=new Intent("android.intent.action.GEOM");
        		startActivity(thy);
			}
        });
        
        pre.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent thy=new Intent("android.intent.action.PRE_C");
        		startActivity(thy);
			}
		});

        sta.setOnClickListener(new View.OnClickListener() {
        	
        	@Override
        	public void onClick(View v) {
			// TODO Auto-generated method stub
        		Intent thy=new Intent("android.intent.action.STATIS");
        		startActivity(thy);
			}
        });
  
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