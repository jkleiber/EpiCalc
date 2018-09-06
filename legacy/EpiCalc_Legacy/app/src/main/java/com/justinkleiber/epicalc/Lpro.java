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

public class Lpro extends Activity{
	EditText x,y,z;
	Button enter;
	TextView res;
	BigDecimal j,k,l;
	boolean t,f,s;
	String[] works = new String[10];
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
		setContentView(R.layout.lpro);
		x=(EditText) findViewById(R.id.ETvel);
		y=(EditText) findViewById(R.id.ETc);
		z=(EditText) findViewById(R.id.ETa);
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
				if(t&&f&&s){
				j= new BigDecimal(x.getText().toString());
				k= new BigDecimal(y.getText().toString());
				l= new BigDecimal(z.getText().toString());
				double a=j.doubleValue();
				double b=k.doubleValue();
				double c=l.doubleValue();
				double co=a*Math.cos(c*Math.PI/180);
				double si=a*Math.sin(c*Math.PI/180);
				//-4.9x+si*x+b
				double x=(-si-(Math.sqrt((si*si)+(-4*-4.9*b))))/(-9.8);
				double m=co*x;
				String aa=Double.toString(m);
				res.setText(aa.toString());
				
				works[0]="First, Vector Decomposition";
				works[1]="let vx = Hypotenuse * sin(Angle) & let vy = Hypotenuse * cos(Angle)";
				works[2]="vx= "+a+" * sin("+c+")= "+si+" & vy= "+a+" * cos("+c+")= "+co;
				works[3]=" ";
				works[4]="Find time with y= (vx*t)+(-4.9t\u00B2)+ starting height";
				works[5]="y= ("+si+" * t) + (-4.9t\u00B2) + "+b;
				works[6]="Find the solution of time with the quadratic equation";
				works[7]="y= "+x;
				works[8]="Find range with x= vy * t";
				works[9]="x= "+co+" * "+x+"= "+m;
				
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