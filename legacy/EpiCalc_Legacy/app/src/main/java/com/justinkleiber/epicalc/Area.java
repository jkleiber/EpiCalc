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
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Area extends Activity implements OnItemSelectedListener{
	Spinner b;
	Button enter;
	EditText a,d,c;
	BigDecimal x,y,z;
	TextView res,dec;
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
		setContentView(R.layout.area);
		//The Spinner
		Spinner b=(Spinner) findViewById(R.id.spinnerA);
		b.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.area, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		b.setAdapter(adapter);
		enter=(Button) findViewById(R.id.bent);
		a=(EditText) findViewById(R.id.ETare);
		d=(EditText) findViewById(R.id.ETarfe);
		c=(EditText) findViewById(R.id.ETarte);
		res=(TextView) findViewById(R.id.tVans);
		dec=(TextView) findViewById(R.id.tvDec);
		registerForContextMenu(res);
		registerForContextMenu(dec);
		
        
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//square
				if(po==0){
					t=checkEmpty(a);
					if(t){
						x=new BigDecimal(a.getText().toString());
						float side=x.floatValue();
						float ans=side*side;
						String o=Float.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						works[0]="Area of a Square = side\u00B2";
						works[1]="A= "+side+"\u00B2";
						works[2]="A= "+ans;
						works[3]=" ";
						works[4]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//triangle
				if(po==1){
					t=checkEmpty(a);
					f=checkEmpty(c);
					if(t&&f){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						float height=x.floatValue();
						float base=y.floatValue();
						float troll=base*height;
						float ans=(base*height)/2;
						String o=Float.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						works[0]="Area of a Triange = (base * height) / 2";
						works[1]="A= ("+base+" * "+height+") / 2";
						works[2]="A= "+troll+" / 2";
						works[3]="A= "+ans;
						works[4]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				
				//triangle w HERON
				if(po==2){
					t=checkEmpty(a);
					s=checkEmpty(d);
					f=checkEmpty(c);
					if(t&&f&&s){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						z=new BigDecimal(d.getText().toString());
						double aa=x.doubleValue();
						double bb=y.doubleValue();
						double cc=z.doubleValue();
						
						double s=(aa+bb+cc)/2;
						double rr=s-aa;
						double qq=s-bb;
						double ww=s-cc;
						double e=(s*(s-aa)*(s-bb)*(s-cc));
						double ans = Math.sqrt(e);
						
						String o=Double.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						
						works[0]="Heron's Formula= \u221A(s*(s-a)*(s-b)*(s-c)) where s= perimeter/2";
						works[1]="A= \u221A("+s+"*("+s+"-"+aa+")*("+s+"-"+bb+")*("+s+"-"+cc+"))";
						works[2]="A= \u221A("+s+"*("+rr+")*("+qq+")*("+ww+"))";
						works[3]="A= \u221A"+ e;
						works[4]="A= "+ ans;
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				
				
				//trapezoid
				if(po==3){
					t=checkEmpty(a);
					f=checkEmpty(c);
					s=checkEmpty(d);
					if(t&&f&&s){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						z=new BigDecimal(d.getText().toString());
						float height=z.floatValue();
						float base=x.floatValue();
						float baset=y.floatValue();
						float bases= base+baset;
						float prop= bases*height;
						float ans=((base+baset)*height)/2;
						String o=Float.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						
						works[0]="Trapezoid Area= ((Base\u2081 + Base\u2082) * height) / 2";
						works[1]="A= (("+base+ "+" +baset+") * "+height+") / 2";
						works[2]="A= (("+bases+") * "+height+") / 2";
						works[3]="A= ("+prop+") / 2";
						works[4]="A= "+ans;
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//circle
				if(po==4){
					t=checkEmpty(a);
					if(t){
						x=new BigDecimal(a.getText().toString());
						double r=x.doubleValue();
						double xx=r*r;
						double ans=xx;
						String o=Double.toString(ans) + "\u03C0";
						res.setText(o.toString());
						double anss=ans*Math.PI;
						String oo = Double.toString(anss);
						dec.setText(oo.toString());
						
						works[0]="Circle Area= \u03C0r\u00B2";
						works[1]="A= \u03C0"+r+"\u00B2";
						works[2]="A= \u03C0"+xx;
						works[3]=" ";
						works[4]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//rectangle
				if(po==5){
					t=checkEmpty(a);
					f=checkEmpty(c);
					if(t&&f){
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(c.getText().toString());
						float width=y.floatValue();
						float length=x.floatValue();
						float ans=length*width;
						String o=Float.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						
						works[0]="Rectangle Area= length * width";
						works[1]="A= "+length+" * "+width;
						works[2]="A= "+ans;
						works[3]=" ";
						works[4]=" ";
						
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//parallelogram
				if(po==6){
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
						
						works[0]="Parallelogram Area= base * height";
						works[1]="A= "+base+" * "+height;
						works[2]="A= "+ans;
						works[3]=" ";
						works[4]=" ";
						
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//pentagon
				if(po==7){
					t=checkEmpty(a);
					
					if(t){
						x=new BigDecimal(a.getText().toString());
						
						float side=x.floatValue();
						double apothem=Math.tan(54*Math.PI/180)*(side/2);
						double per=(side*5);
						double ans=((side*5)*apothem)/2;
						String o=Double.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						
						works[0]="Regular Pentagon Area= perimeter * apothem / 2";
						works[1]="A= "+per+" * "+apothem+" / 2";
						works[2]="A= "+ans;
						works[3]=" ";
						works[4]=" ";
						
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//hexagon
				if(po==8){
					t=checkEmpty(a);
					
					if(t){
						x=new BigDecimal(a.getText().toString());
						
						float side=x.floatValue();
						double apothem=Math.tan(60*Math.PI/180)*(side/2);
						
						double ans=((side*6)*apothem)/2;
						String o=Double.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						double per=(side*6);
						works[0]="Regular Hexagon Area= perimeter * apothem / 2";
						works[1]="A= "+per+" * "+apothem+" / 2";
						works[2]="A= "+ans;
						works[3]=" ";
						works[4]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//octagon
				if(po==9){
					t=checkEmpty(a);
					
					if(t){
						x=new BigDecimal(a.getText().toString());
						
						float side=x.floatValue();
						double apothem=Math.tan(67.5*Math.PI/180)*(side/2);
						
						double ans=((side*8)*apothem)/2;
						String o=Double.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						double per=(side*8);
						works[0]="Regular Octaagon Area= perimeter * apothem / 2";
						works[1]="A= "+per+" * "+apothem+" / 2";
						works[2]="A= "+ans;
						works[3]=" ";
						works[4]=" ";
					}else{
						String err="NO INPUT";
						res.setText(err.toString());
					}
				}
				//decagon
				if(po==10){
					t=checkEmpty(a);
					
					if(t){
						x=new BigDecimal(a.getText().toString());
						
						float side=x.floatValue();
						double apothem=Math.tan(72*Math.PI/180)*(side/2);
						
						double ans=((side*10)*apothem)/2;
						String o=Double.toString(ans);
						res.setText(o.toString());
						dec.setText(o.toString());
						
						double per=(side*10);
						works[0]="Regular Decagon Area= perimeter * apothem / 2";
						works[1]="A= "+per+" * "+apothem+" / 2";
						works[2]="A= "+ans;
						works[3]=" ";
						works[4]=" ";
						
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
			d.setHint("Enter Nothing");
			c.setHint("Enter Nothing");
			a.setHint("Enter a side");
			po=0;
		}
		if(pos==1){
			d.setHint("Enter Nothing");
			c.setHint("Enter Base");
			a.setHint("Enter Height");
			po=1;
		}
		if(pos==2){
			d.setHint("Enter Side 'C'");
			c.setHint("Enter Side 'B'");
			a.setHint("Enter Side 'A'");
			po=2;
		}
		if(pos==3){
			c.setHint("Enter another Base");
			a.setHint("Enter a Base");
			d.setHint("Enter Height");
			po=3;
		}
		if(pos==4){
			d.setHint("Enter Nothing");
			c.setHint("Enter Nothing");
			a.setHint("Enter Radius");
			po=4;
		}
		if(pos==5){
			d.setHint("Enter Nothing");
			c.setHint("Enter Width");
			a.setHint("Enter Length");
			po=5;
		}
		if(pos==6){
			d.setHint("Enter Nothing");
			c.setHint("Enter Base");
			a.setHint("Enter Height");
			po=6;
		}
		if(pos==7 ){
			d.setHint("Enter Nothing");
			c.setHint("Enter Nothing");
			a.setHint("Enter Side Length");
			po=7;
		}
		if(pos==8 ){
			d.setHint("Enter Nothing");
			c.setHint("Enter Nothing");
			a.setHint("Enter Side Length");
			po=8;
		}
		if(pos==9 ){
			d.setHint("Enter Nothing");
			c.setHint("Enter Nothing");
			a.setHint("Enter Side Length");
			po=9;
		}
		if(pos==10 ){
			d.setHint("Enter Nothing");
			c.setHint("Enter Nothing");
			a.setHint("Enter Side Length");
			po=10;
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
