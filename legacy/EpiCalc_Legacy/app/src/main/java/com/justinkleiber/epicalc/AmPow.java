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

@SuppressWarnings("deprecation")
public class AmPow extends Activity{
	Button enter;
	EditText a, b;
	BigDecimal x,y;
	TextView res,resu;
	boolean t,f;
	String[] works = new String[9];
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
	@SuppressWarnings("deprecation")
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
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.apo);
		enter=(Button) findViewById(R.id.bent);
		a=(EditText) findViewById(R.id.ETv);
		b=(EditText) findViewById(R.id.ETr);
		res=(TextView) findViewById(R.id.tVans);
		resu=(TextView) findViewById(R.id.tVansw);
		registerForContextMenu(res);
		registerForContextMenu(resu);
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
				double i=n/l;
				double w=(i*i)*l;
				String ans=Double.toString(i);
				res.setText(ans.toString());
				String ann=Double.toString(w);
				resu.setText(ann.toString());
				
				works[0]="First, Solve for Current:";
				works[1]="Amps (I) = Voltage (V)/Resistance (R)";
				works[2]="I= V/R = "+ n +"/"+ l;
				works[3]="I= "+ i;
				works[4]=" ";
				works[5]="Then Solve for Power:";
				works[6]="Power = I\u00B2 * V";
				works[7]="P= "+ i + "\u00B2 * " +l;
				works[8]="P= "+w;
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
