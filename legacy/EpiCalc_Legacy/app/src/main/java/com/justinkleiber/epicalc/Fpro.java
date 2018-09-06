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

public class Fpro extends Activity{
	
	Button enter;
	EditText a, b;
	BigDecimal x,y;
	TextView res;
	boolean t,f;
	String[] works = new String[4];
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
		setContentView(R.layout.fpro);
	
		enter=(Button) findViewById(R.id.bent);
		a=(EditText) findViewById(R.id.EThv);
		b=(EditText) findViewById(R.id.ETh);
		res=(TextView) findViewById(R.id.tVans);
		registerForContextMenu(res);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t=checkEmpty(a);
				f=checkEmpty(b);
				if(t&&f){
				x= new BigDecimal(a.getText().toString());
				y= new BigDecimal(b.getText().toString());
				double n=x.doubleValue();
				double l=y.doubleValue();
				double x=(0-(Math.sqrt(-4*-4.9*l)))/(-9.8);
				double r=n*x;
				String ans=Double.toString(r);
				res.setText(ans.toString());
				
				works[0]="No need for vector decomposition because it is being dropped straight down.";
				works[1]="Find hangtime using ( 0\u00B1 \u221A( 0\u00B2 -4*-4.9*"+l+" ) ) / -9.8";
				works[2]="Solve for the positive value. t= "+x;
				works[3]="vx * t= "+r;
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
