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

public class Theta extends Activity implements OnItemSelectedListener{
	Button enter;
	EditText a, b;
	BigDecimal x;
	BigDecimal y;
	TextView res, pic;
	Spinner g;
	int po;
	String[] works = new String[3];
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
		setContentView(R.layout.theta);
		
		Spinner g=(Spinner) findViewById(R.id.spinner1);
		g.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this, R.array.theta, android.R.layout.simple_spinner_dropdown_item);
		adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		g.setAdapter(adapt);
		enter=(Button) findViewById(R.id.bent);
		a=(EditText) findViewById(R.id.ETopp);
		b=(EditText) findViewById(R.id.ETadj);
		
		res=(TextView) findViewById(R.id.tVans);
		pic=(TextView) findViewById(R.id.tVant);
		
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
				if (po==0){
					double c=Math.toDegrees(Math.asin(l/n));
					String m=Double.toString(c);
					res.setText(m.toString());
					
					works[0]="Angle (a)= asin(Opposite side / Hypotenuse)";
					works[1]="a= asin("+l+"/"+n+")";
					works[2]="a= "+c;
					}
				if (po==1){
					double c=Math.toDegrees(Math.acos(l/n));
					String m=Double.toString(c);
					res.setText(m.toString());
					
					works[0]="Angle (a)= acos(Adjacent side / Hypotenuse)";
					works[1]="a= acos("+l+"/"+n+")";
					works[2]="a= "+c;
					}
				if (po==2){
					double c=Math.toDegrees(Math.atan(n/l));
					String m=Double.toString(c);
					res.setText(m.toString());
					works[0]="Angle (a)= atan(Opposite side / Adjacent side)";
					works[1]="a= atan("+n+"/"+l+")";
					works[2]="a= "+c;
				}
				
				}else{
					String err="NO INPUT";
					res.setText(err.toString());
					
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
			
			a.setHint("Enter hypotenuse");
			b.setHint("Enter opposite side of angle");
			pic.setBackgroundResource(R.drawable.tripps);
			po=0;
		}
		if(pos==1){
			
			a.setHint("Enter hypotenuse");
			b.setHint("Enter adjacent side of angle");
			pic.setBackgroundResource(R.drawable.tripp);
			po=1;
		}
		if(pos==2){
			
			a.setHint("Enter opposite side of angle");
			b.setHint("Enter adjacent side of angle");
			pic.setBackgroundResource(R.drawable.trops);
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
