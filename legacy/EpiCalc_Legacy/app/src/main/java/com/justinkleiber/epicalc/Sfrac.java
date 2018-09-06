package com.justinkleiber.epicalc;

import java.math.BigDecimal;

import com.google.analytics.tracking.android.EasyTracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sfrac extends Activity{

	EditText x,y;
	Button enter;
	TextView res;
	BigDecimal j,k;
	
	float num, den, swap, swapd, div=2;
	boolean simple=false, run=true;
	
	String[] works;
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.mWork:
			if(works[0]!=null)
			{
				Bundle b = new Bundle();
				b.putStringArray("workstr", works);
				Intent ws = new Intent("android.intent.action.WORK");
				ws.putExtras(b);
				startActivity(ws);
			}
			break;
		}
		return false;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater bow=getMenuInflater();
		bow.inflate(R.menu.menu, menu);
		return true;
		}
	boolean t,f,s;
	private boolean checkEmpty(EditText etText)
	{
	boolean x=true;
	 if(etText.getText().toString().trim().length() > 0){
		 x=true;
	    return x;
	 }
	 else{
		 x=false;
	   return x; 
	 }
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		menu.add(0, v.getId(), 0, "Copy");
		
		TextView cop = (TextView) v;
		
		ClipboardManager cb = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
		cb.setText(cop.getText());
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sfrac);
		
		enter=(Button) findViewById(R.id.bent);
		x=(EditText) findViewById(R.id.etnum);
		y=(EditText) findViewById(R.id.etden);
		res=(TextView) findViewById(R.id.tVans);
		registerForContextMenu(res);
		simple=false;
		run=true;
		num=0;
		den=0;
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t=checkEmpty(x);
				f=checkEmpty(y);
				simple=false;
				run=true;
				if(t&&f){
					j= new BigDecimal(x.getText().toString());
					k= new BigDecimal(y.getText().toString());
					num=j.floatValue();
					den=k.floatValue();
					double x=(num>den) ? num:den;
					double size = 1.4948*Math.log(x) - 1.4105;
					works = new String[(int) (size+1)];
					
					works[0]="("+num+"/"+den+")";
					int i=1;
					while(run){
						while(!simple){
							if(num<div || den<div){
								div=2;
								simple=true;
								run=false;
								break;
							}
							else if(num%den==0){
								swap=num/den;
								num=swap;
								den=1;
								div=2;
								works[0]+=": In this case divide the numerator by the denominator";
								works[1]=num+"/"+den;
								simple=true;
								run=false;
								break;
							}
							else if(num%div==0 && den%div==0){
								swap=num/div;
								swapd=den/div;
								num=swap;
								den=swapd;
								works[i-1]+=" / "+ div;
								works[i]="("+num+"/"+den+")";
								div=2;
								i++;
							}
							else{
								div++;
							}
						}
					}
					
					String n=num + "/" + den;
				
					res.setText(n.toString());
		
				}else{
					String err="NO INPUT";
					res.setText(err.toString());			
				}
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
