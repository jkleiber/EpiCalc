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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class Laws extends Activity implements OnItemSelectedListener {
	Spinner b;
	Button enter;
	EditText a,c,d;
	BigDecimal x,y,z;
	TextView res;
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
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		menu.add(0, v.getId(), 0, "Copy");
		
		TextView cop = (TextView) v;
		
		ClipboardManager cb = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
		cb.setText(cop.getText());
	}
	boolean t,f,s;
	int po;
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
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.law);
		Spinner b=(Spinner) findViewById(R.id.spinnerA);
		b.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sincos, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		b.setAdapter(adapter);
		enter=(Button) findViewById(R.id.bent);
		a=(EditText) findViewById(R.id.ETare);
		d=(EditText) findViewById(R.id.ETarfe);
		c=(EditText) findViewById(R.id.ETarte);
		res=(TextView) findViewById(R.id.tVans);
		
		registerForContextMenu(res);
		
		enter.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//cs
				if(po==0){
					t=checkEmpty(a);
					f=checkEmpty(c);
					s=checkEmpty(d);
					if(t&&f&&s){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						z=new BigDecimal(d.getText().toString());
						float b=x.floatValue();
						float c=y.floatValue();
						float A=z.floatValue();
						float sides=(b*b)+(c*c);
						double alts=(-2*(b*c))*Math.cos(A*Math.PI/180);
						double ans=Math.sqrt(sides+alts);
						//float ans=base*height;
						String o=Double.toString(ans);
						res.setText(o.toString());
						
						works[0]="unknown side\u00B2 = s\u2081\u00B2 + s\u2082\u00B2 -2*s\u2081*s\u2082*cos(Angle)";
						works[1]="Plug in and solve";
						
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//ca
				if(po==1){
					t=checkEmpty(a);
					f=checkEmpty(c);
					s=checkEmpty(d);
					if(t&&f&&s){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						z=new BigDecimal(d.getText().toString());
						float a=x.floatValue();
						float b=y.floatValue();
						float c=z.floatValue();
						float sides=(a*a)-((b*b)+(c*c));
						float oth=-2*(b*c);
						float alts=sides/oth;
						
						double ans=Math.toDegrees(Math.acos(alts));
						//float ans=base*height;
						String o=Double.toString(ans);
						res.setText(o.toString());
						
						works[0]="s\u2083\u00B2 = s\u2081\u00B2 + s\u2082\u00B2 -2*s\u2081*s\u2082*cos(Angle)";
						works[1]="Solve by moving everything to the left side and then use inverse cosine";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//ss
				if(po==2){
					t=checkEmpty(a);
					f=checkEmpty(c);
					s=checkEmpty(d);
					if(t&&f&&s){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						z=new BigDecimal(d.getText().toString());
						float a=x.floatValue();
						float A=y.floatValue();
						float B=z.floatValue();
						double sides=Math.sin(B*Math.PI/180)*a;
						
						double ans=sides/Math.sin(A*Math.PI/180);
						//float ans=base*height;
						works[0]="sin(A)/a = sin(B)/b";
						works[1]="Solve like a proportion for b";
						String o=Double.toString(ans);
						res.setText(o.toString());
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//sa
				if(po==3){
					t=checkEmpty(a);
					f=checkEmpty(c);
					s=checkEmpty(d);
					if(t&&f&&s){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						z=new BigDecimal(d.getText().toString());
						float a=x.floatValue();
						float A=y.floatValue();
						float b=z.floatValue();
						double sides=(Math.sin(A*Math.PI/180)/a)*b;
						
						double ans=Math.toDegrees(Math.asin((sides)));
						//float ans=base*height;
						String o=Double.toString(ans);
						res.setText(o.toString());
						works[0]="sin(A)/a = sin(B)/b";
						works[1]="Solve like a proportion for B";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				
			}
		});
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		// TODO Auto-generated method stub
		parent.getItemAtPosition(pos);
		if(pos==0){
			a.setHint("Enter Known Side a");
			c.setHint("Enter Known Side b");
			d.setHint("Enter Angle Opposite Unknown");
			po=0;
		}
		if(pos==1){
			a.setHint("Enter Side Opposite Unknown");
			c.setHint("Enter Known Side b");
			d.setHint("Enter Known Side c");
			po=1;
		}
		if(pos==3){
			a.setHint("Enter Known Side a");
			d.setHint("Enter Side Opposite Unknown");
			c.setHint("Enter Known Angle A");
			po=3;		
			}
		if(pos==2){
			a.setHint("Enter Known Side a");
			c.setHint("Enter Known Angle A");
			d.setHint("Enter Angle Opposite Unknown");
			po=2;
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
