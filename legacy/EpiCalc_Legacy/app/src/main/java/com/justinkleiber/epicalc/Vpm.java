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

public class Vpm extends Activity{
	EditText x,y,z;
	Button enter;
	TextView res;
	BigDecimal j,k,l;
	boolean f,t,s;
	String[] works = new String[5];
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
		setContentView(R.layout.vlpro);
		x=(EditText) findViewById(R.id.ETrng);
		y=(EditText) findViewById(R.id.ETdeg);
		z=(EditText) findViewById(R.id.ETht);
		res=(TextView) findViewById(R.id.tVans);
		registerForContextMenu(res);
		
		enter=(Button) findViewById(R.id.bent);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t=checkEmpty(x);
				f=checkEmpty(y);
				s=checkEmpty(z);
				if(t&&f){
				j= new BigDecimal(x.getText().toString());
				k= new BigDecimal(y.getText().toString());
				l= new BigDecimal(z.getText().toString());
				double a=j.doubleValue();
				double b=k.doubleValue();
				double c=l.doubleValue();
				double n=a/c;
				double pp=Math.cos(b*Math.PI/180);
				double ans=n/Math.cos(b*Math.PI/180);
				String ab=Double.toString(ans);
				res.setText(ab.toString());
				
				works[0]="Velocity (V)= (Range(R)/Hangtime(t))/cos(Angle(a)) (in degrees)";
				works[1]="V=(R/t)/cos(a)";
				works[2]="V= ("+a+"/"+c+")/cos("+b+")";
				works[3]="V= "+n+"/"+pp;
				works[4]="V= "+ans;
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
