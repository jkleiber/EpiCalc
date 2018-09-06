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

public class Distance extends Activity{

	EditText a,b,c,d;
	Button enter;
	TextView res;
	BigDecimal j,k,l,m;
	int cn;
	boolean t,f,s,q;
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
		setContentView(R.layout.dist);
		
		a=(EditText) findViewById(R.id.ETy);
		b=(EditText) findViewById(R.id.ETyy);
		c=(EditText) findViewById(R.id.ETx);
		d=(EditText) findViewById(R.id.ETxx);
		res=(TextView) findViewById(R.id.tVans);
		registerForContextMenu(res);
		cn=0;
		enter=(Button) findViewById(R.id.bent);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t=checkEmpty(a);
				f=checkEmpty(b);
				s=checkEmpty(c);
				q=checkEmpty(d);
				if(t&&f&&s&&q){
				j= new BigDecimal(a.getText().toString());
				k= new BigDecimal(b.getText().toString());
				l= new BigDecimal(c.getText().toString());
				m= new BigDecimal(d.getText().toString());
				double a=j.doubleValue();
				double b=k.doubleValue();
				double c=l.doubleValue();
				double d=m.doubleValue();
				double n= b-a;
				double m= d-c;
				double o=n*n;
				double oo= m*m;
				double loo=oo+o;
				double io=Math.sqrt((oo+o));
				String ab=Double.toString(io);
				
				
				res.setText(ab.toString());
				
				works[0]="D= \u221A( (x\u2082 - x\u2081)\u00B2 + (y\u2082 - y\u2081)\u00B2 )";
				works[1]="D= \u221A( ("+d+" - "+c+")\u00B2 + ("+b+" - "+a+")\u00B2 )";
				works[2]="D= \u221A( ("+m+")\u00B2 + ("+n+")\u00B2 )";
				works[3]="D= \u221A("+oo+" + "+o+")";
				works[4]="D= \u221A("+loo+")= "+io;
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
