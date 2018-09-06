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

public class MidPt extends Activity{

	EditText a,b,c,d;
	Button enter;
	TextView res;
	BigDecimal j,k,l,m;
	int cn;
	boolean t,f,s,p;
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
		setContentView(R.layout.midpt);
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
				p=checkEmpty(d);
				if(t&&f&&s&&p){
				j= new BigDecimal(a.getText().toString());
				k= new BigDecimal(b.getText().toString());
				l= new BigDecimal(c.getText().toString());
				m= new BigDecimal(d.getText().toString());
				double a=j.doubleValue();
				double b=k.doubleValue();
				double c=l.doubleValue();
				double d=m.doubleValue();
				double n= b+a;
				double m= d+c;
				double o= n/2;
				double oo= m/2;
				String ab="("+oo+","+o+")";
				
				res.setText(ab.toString());
				
				works[0]="(x\u2081+x\u2082)/2,(y\u2081+y\u2082)/2";
				works[1]="("+d+"+"+c+")/2,("+b+"+"+a+")/2";
				works[2]="("+m+")/2,("+n+")/2";
				works[3]="("+oo+","+o+")";
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
