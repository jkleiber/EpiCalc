package com.justinkleiber.epicalc;

import java.math.BigDecimal;

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
import java.lang.Math;

import com.google.analytics.tracking.android.EasyTracker;

public class Quad extends Activity{
	
	EditText x,y,z;
	Button enter;
	TextView res, resu;
	BigDecimal j,k,l;
	String[] works = new String[5];
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
		
		TextView result = (TextView) v;
		
		ClipboardManager cb = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
		cb.setText(result.getText());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qf);
		
		x=(EditText) findViewById(R.id.ETqa);
		y=(EditText) findViewById(R.id.ETqb);
		z=(EditText) findViewById(R.id.ETqc);
		res=(TextView) findViewById(R.id.tVans);
		resu=(TextView) findViewById(R.id.tVan);
		registerForContextMenu(res);
		registerForContextMenu(resu);
		enter=(Button) findViewById(R.id.bent);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t=checkEmpty(x);
				f=checkEmpty(y);
				s=checkEmpty(z);
				if(t&&f&&s){
				j= new BigDecimal(x.getText().toString());
				k= new BigDecimal(y.getText().toString());
				l= new BigDecimal(z.getText().toString());
				double a=j.doubleValue();
				double b=k.doubleValue();
				double c=l.doubleValue();
				double r=(-4)*a*c;
				double l=(b*b);
				double z=l+r;
				double y= Math.sqrt(z);
				double n=(-b)+y;
				double p=(-b)-y;
				double m=n/(2*a);
				double o=p/(2*a);
				String aa=Double.toString(m);
				String ab=Double.toString(o);
				res.setText(aa.toString());
				resu.setText(ab.toString());
				
				works[0]="(-b \u00B1 \u221A(b\u00B2 - (-4*a*c)) ) / 2 * a";
				works[1]="(-"+b+" \u00B1 \u221A"+b+"\u00B2 - (-4*"+a+"*"+c+")) / 2 *"+a;
				works[2]="(-"+b+" \u00B1 \u221A"+l+"- ("+r+")) / 2 *"+a;
				works[3]="Solution 1= "+aa;
				works[4]="Solution 2= "+ab;
				}else{
					String err="NO INPUT";
					res.setText(err.toString());
					resu.setText(err.toString());
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