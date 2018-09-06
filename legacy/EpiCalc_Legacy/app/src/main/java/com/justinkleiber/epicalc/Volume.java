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

public class Volume extends Activity implements OnItemSelectedListener{
	
	String[] works = new String[6];
	Spinner b;
	Button enter;
	EditText a,c,d;
	BigDecimal x,y,z;
	TextView res,dec;
	
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
		setContentView(R.layout.vol);
		Spinner b=(Spinner) findViewById(R.id.spinnerA);
		b.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.vols, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		b.setAdapter(adapter);
		enter=(Button) findViewById(R.id.bent);
		a=(EditText) findViewById(R.id.ETare);
	
		c=(EditText) findViewById(R.id.ETarte);
		d=(EditText) findViewById(R.id.ETarfe);
		res=(TextView) findViewById(R.id.tVans);
		dec=(TextView) findViewById(R.id.tvDec);
		
		registerForContextMenu(res);
		registerForContextMenu(dec);
		
		
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t=checkEmpty(a);
				f=checkEmpty(c);
				if(po==0){
					t=checkEmpty(a);
					f=checkEmpty(c);
					if(t&&f){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						float height=x.floatValue();
						float base=y.floatValue();
						float ans=base*height;
						String o=Float.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						works[0]="Prism Volume (V)= Base Area (B) * Height (h)";
						works[1]="V= bh ="+ base + " * "+ height;
						works[2]="V= "+ans;
						works[3]=" ";
						works[4]=" ";
						works[5]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
					
				}
				if(po==1){
					t=checkEmpty(a);
					f=checkEmpty(c);
					if(t&&f){
						y=new BigDecimal(a.getText().toString());
						x=new BigDecimal(c.getText().toString());
						float height=x.floatValue();
						float base=y.floatValue();
						float bases=(base*base);
						float ans=bases*height;
						String o=Float.toString(ans) + "\u03C0";
						res.setText(o.toString());
						float anss=(float) (ans*Math.PI);
						String oo=Float.toString(anss);
						dec.setText(oo.toString());
						works[0]="Cylinder Volume (V)= \u03C0r\u00B2 * Height (h) or Base * Height";
						works[1]="V= bh = \u03C0"+ base + "\u00B2 * "+ height;
						works[2]="V= \u03C0"+bases+" * "+ height;
						works[3]="V= "+ans + "\u03C0";
						works[4]=" ";
						works[5]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
					
				}
				if(po==2){
					t=checkEmpty(a);
					f=checkEmpty(c);
					if(t&&f){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						float height=x.floatValue();
						float base=y.floatValue();
						float ans=(base*height)/3;
						float lol=base*height;
						String o=Float.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						works[0]="Pyramid Volume (V)= 1/3(Base Area (B) * Height (h))";
						works[1]="V= 1/3(bh) = 1/3("+ base + " * "+ height+")";
						works[2]="V= 1/3("+lol+")";
						works[3]="V= "+ ans;
						works[4]=" ";
						works[5]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
					
				}
				if(po==3){
					t=checkEmpty(a);
					f=checkEmpty(c);
					if(t&&f){
						y=new BigDecimal(a.getText().toString());
						x=new BigDecimal(c.getText().toString());
						float height=x.floatValue();
						float base=y.floatValue();
						float bases=(base*base);
						float ans=(bases*height)/3;
						float rofl=bases*height;
						String o=rofl + "\u03C0 /3";
						res.setText(o.toString());
						float anss=(float) (rofl*Math.PI/3);
						String oo=Float.toString(anss);
						dec.setText(oo.toString());
						works[0]="Cone Volume (V)= 1/3(\u03C0r\u00B2 * Height (h)) or 1/3(Base * Height)";
						works[1]="V= 1/3(bh) = 1/3(\u03C0"+ base + "\u00B2 * "+ height +")";
						works[2]="V= 1/3(\u03C0"+bases+" * "+ height+")";
						works[3]="V= 1/3("+rofl + "\u03C0)";
						works[4]="Simplify if needed";
						works[5]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
					
				}
				if(po==4){
					t=checkEmpty(a);
					//f=checkEmpty(c);
					if(t){
						x=new BigDecimal(a.getText().toString());
						//y=new BigDecimal(c.getText().toString());
						float height=x.floatValue();
						//float base=y.floatValue();
						float bases=(height*height*height);
						float ans=bases*4/3;
						String o=Float.toString(ans) + "\u03C0";
						res.setText(o.toString());
						float anss=(float) (ans*Math.PI);
						String oo=Float.toString(anss);
						dec.setText(oo.toString());
						works[0]="Sphere Volume (V)= 4/3(\u03C0r\u00B3)";
						works[1]="V= 4/3(\u03C0"+height+"\u00B3)";
						works[2]="V= 4/3("+bases+"\u03C0)";
						works[3]="V= "+ans+"\u03C0";
						works[4]=" ";
						works[5]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
					
				}
				if(po==5){
					t=checkEmpty(a);
					f=checkEmpty(c);
					s=checkEmpty(d);
					if(t&&f&&s){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						z=new BigDecimal(d.getText().toString());
						float r=x.floatValue();
						float rr=y.floatValue();
						float h=z.floatValue();
						float base=(r*r);
						float bases=rr*rr;
						float comb=base+bases;
						float omg=base*bases;
						double mean=Math.sqrt(base*bases);
						
						double ans=(h*(comb+mean))/3;
						double yolo=(h*(comb+mean));
						String o=Double.toString(yolo) + "\u03C0 /3";
						res.setText(o.toString());
						
						float anss=(float) (ans*Math.PI);
						String oo=Float.toString(anss);
						dec.setText(oo.toString());
						
						works[0]="Volume of a Frustum (V)= 1/3( Height(h) * (\u03C0 * Radius 1 (R\u2081)\u00B2) + (\u03C0 * Radius 2 (R\u2082)\u00B2) + \u221A (\u03C0 * Radius 1 (R\u2081)\u00B2) * (\u03C0 * Radius 2 (R\u2082)\u00B2)))";
						works[1]="V= 1/3("+h+" * ((\u03C0"+r+"\u00B2) + (\u03C0" + rr+"\u00B2) + \u221A (\u03C0"+r+"\u00B2) * (\u03C0" + rr+"\u00B2)))";
						works[2]="V= 1/3("+h+" * (("+base+"\u03C0) + ("+bases+"\u03C0) + \u221A ("+base+"\u03C0) * ("+bases+"\u03C0)))";
						works[3]="V= 1/3("+h+" * ("+comb+"\u03C0 + \u221A "+omg+"\u03C0))";
						works[4]="V= 1/3("+h+" * "+comb+" + "+mean+")";
						works[5]="V= "+yolo+"\u03C0 /3  -  Simplify if needed";
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
			a.setHint("Enter Base Area");
			c.setHint("Enter Height");
			d.setHint("Enter Nothing");
			po=0;
		}
		if(pos==1){
			a.setHint("Enter Radius");
			c.setHint("Enter Height");
			d.setHint("Enter Nothing");
			po=1;
		}
		if(pos==2){
			a.setHint("Enter Base Area");
			c.setHint("Enter Height");
			d.setHint("Enter Nothing");
			po=2;
		}
		if(pos==3){
			a.setHint("Enter Radius");
			c.setHint("Enter Height");
			d.setHint("Enter Nothing");
			po=3;
		}
		if(pos==4){
			a.setHint("Enter Radius");
			c.setHint("Enter Nothing");
			d.setHint("Enter Nothing");
			po=4;
		}
		if(pos==5){
			a.setHint("Enter Radius 1");
			c.setHint("Enter Radius 2");
			d.setHint("Enter Height");
			po=5;
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
