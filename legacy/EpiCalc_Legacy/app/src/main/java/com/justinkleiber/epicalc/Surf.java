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

public class Surf extends Activity implements OnItemSelectedListener{

	Spinner b;
	Button enter;
	EditText a,c,d;
	BigDecimal x,y,z;
	TextView res,dec;
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
		setContentView(R.layout.surf);
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
				
				if(po==0){
					t=checkEmpty(a);
					f=checkEmpty(c);
					s=checkEmpty(d);
					if(t&&f&&s){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						z=new BigDecimal(d.getText().toString());
						float b=x.floatValue();
						float p=y.floatValue();
						float h=z.floatValue();
						float ans=(2*b)+h*p;
						float yo=2*b;
						float lo=p*h;
						String o=Float.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						works[0]="SA= 2B+Ph = "+"2("+b+") + "+p+" * "+h;
						works[1]="SA="+yo+" + "+lo;
						works[2]="SA= "+ans;
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
					
				}
				
				if(po==1){
					t=checkEmpty(a);
					f=checkEmpty(c);
					if(t&&f){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						//z=new BigDecimal(d.getText().toString());
						float r=x.floatValue();
						float h=y.floatValue();
						//float h=z.floatValue();
						float ans=(float) (2*((r*r)*Math.PI)+(r*2)*h);
						float c=r*r;
						float rr=r*2;
						float lo=rr*h;
						float yo=2*c;
						
						works[0]="SA= 2B+Ch = "+"2(\u03C0"+r+"\u00B2) + "+rr+" * "+h;
						works[1]="SA="+yo+"\u03C0 + "+lo;
						works[2]=" ";
						
						String o=yo + "\u03C0 +" + lo;
						res.setText(o.toString());
						
						String oo = Double.toString(ans);
						dec.setText(oo.toString());
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
					
				}
				
				if(po==2){
					t=checkEmpty(a);
					f=checkEmpty(c);
					s=checkEmpty(d);
					if(t&&f&&s){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						z=new BigDecimal(d.getText().toString());
						float b=x.floatValue();
						float p=y.floatValue();
						float l=z.floatValue();
						float lo=(p*l)/2;
						float ans=b+(p*l)/2;
						String o=Float.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						
						works[0]="SA= B+(P*Slant height)/2 = "+b+"+("+p+" * "+l+")/2";
						works[1]="SA="+b+" + "+lo;
						works[2]="SA= "+ans;
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
					
				}
				
				if(po==3){
					t=checkEmpty(a);
					f=checkEmpty(c);
					if(t&&f){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						//z=new BigDecimal(d.getText().toString());
						float r=x.floatValue();
						float l=y.floatValue();
						float rr=r*2;
						float wins=r*r;
						float oth=((r*2)*l)/2;
						//float l=z.floatValue();
						float ans=(r*r)+((r*2)*l)/2;
						String o=wins + "\u03C0 + "+ oth;
						res.setText(o.toString());
						double anss=ans*Math.PI;
						String oo = Double.toString(anss);
						dec.setText(oo.toString());
						works[0]="SA= B+(C*Slant Height)/2 = "+"(\u03C0"+r+"\u00B2) + ("+rr+" * "+l+")/2";
						works[1]="SA="+wins+"\u03C0 + "+oth;
						works[2]=" ";
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
						//z=new BigDecimal(d.getText().toString());
						float r=x.floatValue();
						//float l=y.floatValue();
						//float l=z.floatValue();
						float ans=(r*r)*4;
						float rs=r*r;
						String o=Float.toString(ans) + "\u03C0";
						res.setText(o.toString());
						double anss=ans*Math.PI;
						String oo = Double.toString(anss);
						dec.setText(oo.toString());
						works[0]="SA= 4\u03C0r\u00B2 = "+"(4\u03C0"+r+"\u00B2)";
						works[1]="SA= 4("+rs+"\u03C0)";
						works[2]="SA= "+ans+"\u03C0";
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
						double ans=((r+rr)*Math.PI)*(Math.sqrt( ((r-rr)*(r-rr)) + (h*h) ))+(r*r*Math.PI)+(rr*rr*Math.PI);
						float b=r*r;
						float bb=rr*rr;
						float bp=rr+r;
						float bs=b+bb;
						float plo=(r-rr)*(r-rr);
						float ru=h*h;
						float pol=plo+ru;
						float run=((r-rr)*(r-rr)) + (h*h);
						String o=bp + "\u03C0 * \u221A("+run+") + "+bs + "\u03C0";
						res.setText(o.toString());
						String oo = Double.toString(ans);
						dec.setText(oo.toString());
						
						works[0]="SA= \u03C0(r1 +r2) * \u221A( (r1-r2)\u00B2 + l\u00B2 ) + B1 + B2 = \u03C0("+r+"+"+rr+") * \u221A( ("+r+"-"+rr+")\u00B2 + "+h+"\u00B2 ) + " + b +"\u03C0 + "+bb+"\u03C0";
						works[1]="SA= \u03C0"+bp+"\u221A( "+plo+" + "+ru+" ) + "+bs + "\u03C0";
						works[2]="SA= "+o;
						
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
					
				}
				
			}
		});
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		// TODO Auto-generated method stub
		parent.getItemAtPosition(pos);
		if(pos==0){
			a.setHint("Enter Base Area");
			c.setHint("Enter Base Perimeter");
			d.setHint("Enter Height");
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
			c.setHint("Enter Base Perimeter");
			d.setHint("Enter Slant Height");
			po=2;
		}
		if(pos==3){
			a.setHint("Enter Radius");
			c.setHint("Enter Slant Height");
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
			a.setHint("Enter Larger Radius");
			c.setHint("Enter Smaller Radius");
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
