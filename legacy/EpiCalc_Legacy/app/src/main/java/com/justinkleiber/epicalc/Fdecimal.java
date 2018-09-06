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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Fdecimal extends Activity implements OnItemSelectedListener{

	Button enter;
	EditText a, c;
	BigDecimal x;
	BigDecimal y;
	TextView res;
	int po;
	
	float num, den, swap, swapd, div=2;
	boolean simple=false, run=true;
	String[] works = new String[3];
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
	boolean t,f;
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
		setContentView(R.layout.ftod);
		a=(EditText) findViewById(R.id.ETdec);
		c=(EditText) findViewById(R.id.ETdecs);
		res=(TextView) findViewById(R.id.tVans);
		registerForContextMenu(res);
		enter=(Button) findViewById(R.id.bent);
		
		Spinner b=(Spinner) findViewById(R.id.spinnerC);
		b.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fd, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		b.setAdapter(adapter);
		simple=false;
		run=true;
		num=0;
		den=0;
		
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simple=false;
				run=true;
				t=checkEmpty(a);
				f=checkEmpty(c);
				
				float j=0,k=0;
				
				
				if(po==0)
				{
					if(t)
					{
						String len=a.getText().toString();
						int lim=len.length();
						x= new BigDecimal(a.getText().toString());
						j=x.floatValue();
						works[0]=".xxxxxxx...=y";
						works[1]="x.xxxxxx...=10y";
						works[2]="10y-y = x.xxx - .xxx = x/9, then simplify if possible";
						num=j;
						den=(float) Math.pow(10, lim)-1;
					}else{
						String err="NO INPUT";
						res.setText(err.toString());			
					}
					
				}
				else if(po==1)
				{
					if(t)
					{
						float jj=0;
						String len=a.getText().toString();
						int lim=len.length();
						x= new BigDecimal(a.getText().toString());
						j=x.floatValue();
						works[0]=".xyxyxy...=y";
						works[1]="xy.xyxy...=100y";
						works[2]="99y = xy.xyxy - .xyxyxy = xy/99, then simplify if possible";
						num=j;
						den=(float) Math.pow(10, lim)-1;
					}else{
						String err="NO INPUT";
						res.setText(err.toString());			
					}
				}
				else if(po==2)
				{
					if(t&&f)
					{
						String len=c.getText().toString();
						int lim=len.length();
						String ln=a.getText().toString();
						int lm=ln.length();
						int jj=0;
						
						x= new BigDecimal(a.getText().toString());
						j=x.floatValue();
						y= new BigDecimal(c.getText().toString());
						k=y.floatValue();
						
						jj=lim+lm;
						float l=0;
						l=j;
						j*=Math.pow(10,jj-1);
						j+=k;
						j-=l;
						num=j;
						den=(float) (Math.pow(10,jj)-Math.pow(10, lm));
						works[0]="x.zzzzz...=10y";
						works[1]="xz.zzzz...=100y";
						works[2]="90y = xz.zzzzz - x.zzzz = (xz-x)/90, then simplify if possible";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());			
					}
				}
				
				
				
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
							simple=true;
							run=false;
							break;
						}
						else if(num%div==0 && den%div==0){
							swap=num/div;
							swapd=den/div;
							num=swap;
							den=swapd;
							div=2;
						}
						else{
							div++;
						}
					}
				}
				
				String ans = num+"/"+den;
				res.setText(ans.toString());
			}
		});
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int pos,
			long id) {
		// TODO Auto-generated method stub
		parent.getItemAtPosition(pos);
		if(pos==0)
		{
			po=0;
			a.setHint("Enter repeating number");
			c.setHint("Enter Nothing");
		}
		if(pos==1)
		{
			po=1;
			a.setHint("Enter the first set of repeating numbers");
			c.setHint("Enter Nothing");
		}
		if(pos==2)
		{
			po=2;
			a.setHint("Enter non-repeating numbers");
			c.setHint("Enter the first set of repeating numbers");
		}
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
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
