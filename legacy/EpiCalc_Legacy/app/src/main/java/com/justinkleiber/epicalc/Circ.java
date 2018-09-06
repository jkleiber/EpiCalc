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

public class Circ extends Activity implements OnItemSelectedListener{
	int po;
	EditText a,b,c;
	Button enter;
	TextView res,resu,pic,pr,pro;
	BigDecimal j,k,l;
	Spinner g;
	boolean t,f,s;
	double y,z;
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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.circle);
		
		Spinner g=(Spinner) findViewById(R.id.spinner1);
		g.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this, R.array.circ, android.R.layout.simple_spinner_dropdown_item);
		adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		g.setAdapter(adapt);
		a=(EditText) findViewById(R.id.ETopp);
		b=(EditText) findViewById(R.id.ETadj);
		c=(EditText) findViewById(R.id.etM);
		pic=(TextView) findViewById(R.id.tVant);

		res=(TextView) findViewById(R.id.tVans);

		resu=(TextView) findViewById(R.id.tvDec);
		
		pr=(TextView) findViewById(R.id.tvSide);
		//pro=(TextView) findViewById(R.id.tVhpo);
		
		registerForContextMenu(res);
		registerForContextMenu(resu);
		enter=(Button) findViewById(R.id.bent);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(po==0){
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float arc=j.floatValue();
						float arcs=k.floatValue();
						float ans = (arc-arcs)/2;
						
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Angle = (Large arc - Small arc)/2";
						works[1]="A= ("+arc+"-"+arcs+")/2";
						works[2]="A= "+ans;
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
					
				}
				if(po==1){
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float arc=j.floatValue();
						float arcs=k.floatValue();
						float ans = (arc-arcs)/2;
						
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Angle = (Large arc - Small arc)/2";
						works[1]="A= ("+arc+"-"+arcs+")/2";
						works[2]="A= "+ans;
						
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
					
				}
				if(po==2){
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float arc=j.floatValue();
						float arcs=k.floatValue();
						float ans = (arc-arcs)/2;
						
						
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Angle = (Large arc - Small arc)/2";
						works[1]="A= ("+arc+"-"+arcs+")/2";
						works[2]="A= "+ans;
						
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==3){//Known Arc
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t){
						j=new BigDecimal(a.getText().toString());
						//k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float arc=j.floatValue();
						float ans = arc/2;
						
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Inscribed Angle = Intercepted arc /2";
						works[1]="A= "+arc+"/2";
						works[2]="A= "+ans;
					}else{
						String err="Input?";
						res.setText(err.toString());
						
					}
	
				}

				if(po==4){//Known Angle
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t){
						j=new BigDecimal(a.getText().toString());
						//k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float arc=j.floatValue();
						float ans = arc*2;
						
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Intercepted Arc = Inscribed angle * 2";
						works[1]="A= "+arc+" * 2";
						works[2]="A= "+ans;
						
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==5){	//Known Arcs 
					t=checkEmpty(a);
					f=checkEmpty(b);
					//s=checkEmpty(c);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float ang=j.floatValue();
						float arc=k.floatValue();
						//float arcs=l.floatValue();
						
						float arch=arc+ang;
						//arch/2=ang+x
						float ans = (arch/2);
						
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Vertical Angles = (arc\u2081 + arc\u2082) /2";
						works[1]="A= ("+arc+"+"+ang+") /2";
						works[2]="A= "+ans;
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}	
				if(po==6){
					t=checkEmpty(a);
					f=checkEmpty(b);
					//s=checkEmpty(c);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float ang=j.floatValue();
						float arc=k.floatValue();
						//float arcs=l.floatValue();
						
						float angs=ang*2;
						//angs*2=ang
						float ans = (angs-arc);
						
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Unknown arc = (Angle * 2) - Known arc";
						works[1]="A= ("+ang+" * 2) - "+arc;
						works[2]="A= "+ans;
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
				}

				if(po==7){//SECTORS
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float rad=k.floatValue();
						float arc=j.floatValue();
						float step=arc*(rad*rad);
						float ans = step/360;
						// a/pi*r^2=ang/360
						float anss=(float) (ans*Math.PI);
						String ab=Float.toString(anss);
						String a=Float.toString(ans)+ "\u03C0";
						res.setText(a.toString()) ;
						resu.setText(ab.toString());
						
						works[0]="Sector Area = (\u03C0r\u00B2 * arc) / 360";
						works[1]="A= (\u03C0"+rad+"\u00B2 * "+arc+") /360";
						works[2]="A= "+ans+"\u03C0";
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				
	
				if(po==8){
					t=checkEmpty(a);
					f=checkEmpty(b);
					s=checkEmpty(c);
					if(t&f&s){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						l=new BigDecimal(c.getText().toString());
						float seg=j.floatValue();
						float cseg=k.floatValue();
						float sego=l.floatValue();
						float ans = seg*cseg/sego;
						//String a = "BE PATIENT";
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						works[0]="Segment = (Segment\u2081 * Segment\u2082) / Segment\u2083";
						works[1]="A= ("+seg+" * "+cseg+") / "+sego;
						works[2]="A= "+ans;
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==9){
					t=checkEmpty(a);
					f=checkEmpty(b);
					s=checkEmpty(c);
					if(t&f&s){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						l=new BigDecimal(c.getText().toString());
						float ex=j.floatValue();
						float in=k.floatValue();
						float who=l.floatValue();
						float step=(ex+in)*ex;
						//step/who=x
						float ans = step/who;
						//String a = "BE PATIENT";
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						works[0]="Other External = external * (external + internal) / Other Internal";
						works[1]="A= "+ex+" * ("+ex+" + "+in+") / "+who;
						works[2]="A= "+ans;
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==10){
					t=checkEmpty(a);
					f=checkEmpty(b);
					s=checkEmpty(c);
					if(t&f&s){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						l=new BigDecimal(c.getText().toString());
						float ex=j.floatValue();
						float in=k.floatValue();
						float exx=l.floatValue();
						float step=ex*(ex+in);
						//step/exx=who
						float w=step/exx;
						float ans = w-exx;
						//String a = "BE PATIENT";
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Other Internal = (external * (external + internal) / Other External) - Other External";
						works[1]="A= ("+ex+" * ("+ex+" + "+in+") / "+exx +") - "+exx;
						works[2]="A= "+ans;
						
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==11){
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float tan=j.floatValue();
						float ex=k.floatValue();
						float step=(tan*tan);
						//step=4+2i i=step-4/2
						float ans = (step-(ex*ex))/ex;
						//String a = "BE PATIENT";
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Internal Secant= (Tangent Length\u00B2 - External\u00B2)/External";
						works[1]="A= ("+tan+"\u00B2 - "+ex+"\u00B2) / "+ex;
						works[2]="A= "+ans;
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==12){
					t=checkEmpty(a);
					//f=checkEmpty(b);
					s=checkEmpty(b);
					if(t&s){
						j=new BigDecimal(a.getText().toString());
						//k=new BigDecimal(b.getText().toString());
						l=new BigDecimal(b.getText().toString());
						float tan=j.floatValue();
						//float in=k.floatValue();
						float who=l.floatValue();
						float step=(tan*tan);
						//step=x*(who)
						float ans = step/who;
						//String a = "BE PATIENT";
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="External Secant= (Tangent Length\u00B2) / Total Secant Length";
						works[1]="A= ("+tan+"\u00B2 ) / "+who;
						works[2]="A= "+ans;
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==13){
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float ex=j.floatValue();
						float in=k.floatValue();
						float step=ex*(ex+in);
						//tan^2=step
						double ans = Math.sqrt(step);
						//String a = "BE PATIENT";
						String a=Double.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Tangent = \u221A(external * (external + internal) )";
						works[1]="A= \u221A("+ex+" * ("+ex+" + "+in+") )";
						works[2]="A= "+ans;
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==14){
					t=checkEmpty(a);
					f=checkEmpty(b);
					s=checkEmpty(c);
					if(t&f&s){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						l=new BigDecimal(c.getText().toString());
						float a=j.floatValue();
						float r=k.floatValue();
						float ang=l.floatValue();
						float step=(r*r)*2;
						double alt=(-2*(r*r))*Math.cos(ang*Math.PI/180);
						double side=Math.sqrt(step+alt);
						double s=(side+(2*r))/2;
						double A=Math.sqrt(s*(s-r)*(s-r)*(s-side));
						//double sect=((r*r*Math.PI)*a)/360;
						double ans = a-A;
						//String a = "BE PATIENT";
						String aa=Double.toString(ans);
						res.setText(aa.toString());
						resu.setText(aa.toString());
						
						works[0]="Segment = Sector Area - Triangle";
						works[1]="A= "+a+" - "+A;
						works[2]="A= "+ans;
						
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==15){
					t=checkEmpty(a);
					f=checkEmpty(b);
					s=checkEmpty(c);
					if(t&f&s){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						l=new BigDecimal(c.getText().toString());
						float ang=j.floatValue();
						float arc=k.floatValue();
						float tf=l.floatValue();
						if(tf<=0){
							//x=2ang+arc
							float ans = (ang*2)+arc;
							String a=Float.toString(ans);
							res.setText(a.toString());
							resu.setText(a.toString());
							
							works[0]="Arc = (Angle * 2) + Known arc";
							works[1]="A= ("+ang+" * 2) + "+arc;
							works[2]="A= "+ans;
						}else{
							//-x=2ang-arc
						float ans = ((ang*2)-arc)/-1;
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						
						works[0]="Arc = ((Angle * 2) - Known arc) / -1";
						works[1]="A= ( ("+ang+" * 2) - "+arc +") / -1";
						works[2]="A= "+ans;
						}
						//240-x=160
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==16){
					t=checkEmpty(a);
					f=checkEmpty(b);
					s=checkEmpty(c);
					if(t&f&s){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						l=new BigDecimal(c.getText().toString());
						float ang=j.floatValue();
						float arc=k.floatValue();
						float tf=l.floatValue();
						if(tf==0){
							//x=2ang+arc
							float ans = (ang*2)+arc;
							String a=Float.toString(ans);
							res.setText(a.toString());
							resu.setText(a.toString());
							works[0]="Arc = (Angle * 2) + Known arc";
							works[1]="A= ("+ang+" * 2) + "+arc;
							works[2]="A= "+ans;
						}else{
							//-x=2ang-arc
						float ans = ((ang*2)-arc)/-1;
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						works[0]="Arc = ((Angle * 2) - Known arc) / -1";
						works[1]="A= ( ("+ang+" * 2) - "+arc +") / -1";
						works[2]="A= "+ans;
						}
					
						
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==17){
					t=checkEmpty(a);
					f=checkEmpty(b);
					s=checkEmpty(c);
					if(t&f&s){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						l=new BigDecimal(c.getText().toString());
						float ang=j.floatValue();
						float arc=k.floatValue();
						float tf=l.floatValue();
						if(tf==0){
							//x=2ang+arc
							float ans = (ang*2)+arc;
							String a=Float.toString(ans);
							res.setText(a.toString());
							resu.setText(a.toString());
							works[0]="Arc = (Angle * 2) + Known arc";
							works[1]="A= ("+ang+" * 2) + "+arc;
							works[2]="A= "+ans;
						}else{
							//-x=2ang-arc
						float ans = ((ang*2)-arc)/-1;
						String a=Float.toString(ans);
						res.setText(a.toString());
						resu.setText(a.toString());
						works[0]="Arc = ((Angle * 2) - Known arc) / -1";
						works[1]="A= ( ("+ang+" * 2) - "+arc +") / -1";
						works[2]="A= "+ans;
						}
					
						
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==18){
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float ang=j.floatValue();
						float rad=k.floatValue();
						float step=ang*(2*rad);
						//tan^2=step
						float ans = (step)/360;
						//String a = "BE PATIENT";
						String a=Double.toString(ans)+ "\u03C0";
						res.setText(a.toString());
						float steps =(float) (ang*(rad*2*Math.PI));
						float anss = steps/360;
						String aa=Float.toString(anss);
						resu.setText(aa.toString());
						
						works[0]="Length = (Angle * 2\u03C0r)  / 360";
						works[1]="A= ( ("+ang+" * 2\u03C0"+rad+") / 360";
						works[2]="A= "+ans + "\u03C0";
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
				if(po==19){
					t=checkEmpty(a);
					f=checkEmpty(b);
					if(t&f){
						j=new BigDecimal(a.getText().toString());
						k=new BigDecimal(b.getText().toString());
						//l=new BigDecimal(c.getText().toString());
						float ex=j.floatValue();
						float in=k.floatValue();
						float step=ex*(360);
						//tan^2=step
						double ans = step/(2*in);
						float yolo=2*in;
						//String a = "BE PATIENT";
						String a=Double.toString(ans) + " / \u03C0";
						res.setText(a.toString());
						float anss=(float) (step/(in*2*Math.PI));
						String aa=Float.toString(anss);
						resu.setText(aa.toString());
						
						works[0]="Length = (360 * Arc Length)  / Circumference";
						works[1]="A= (360 *"+ex+") / "+yolo;
						works[2]="A= "+ans + "\u03C0";
						
					}else{
						String err="Input?";
						res.setText(err.toString());
					}
	
				}
			}
		});
}
	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int pos,
			long id) {
		// TODO Auto-generated method stub
		parent.getItemAtPosition(pos);
		
		if(pos==0){//tantan
			po=0;
			pic.setBackgroundResource(R.drawable.tantan);
			a.setHint("Enter larger arc measure");
			b.setHint("Enter smaller arc measure");
			c.setHint("Enter Nothing");
			
			String promp = "Angle:";
			pr.setText(promp.toString());
		}
		if(pos==1){//secsec
			po=1;
			pic.setBackgroundResource(R.drawable.secsec);
			a.setHint("Enter larger arc measure");
			b.setHint("Enter smaller arc measure");
			c.setHint("Enter Nothing");
			
			String promp = "Angle:";
			pr.setText(promp.toString());
		}
		if(pos==2){//sectan
			po=2;
			pic.setBackgroundResource(R.drawable.sectan);
			a.setHint("Enter larger arc measure");
			b.setHint("Enter smaller arc measure");
			c.setHint("Enter Nothing");
			
			String promp = "Angle:";
			pr.setText(promp.toString());
		}
		if(pos==3){//intarc
			po=3;
			pic.setBackgroundResource(R.drawable.intang);
			a.setHint("Enter intercepted arc");
			b.setHint("Enter Nothing");
			c.setHint("Enter Nothing");
			
			String promp = "Angle:";
			pr.setText(promp.toString());
		}
		if(pos==4){//intang
			po=4;
			pic.setBackgroundResource(R.drawable.intarc);
			a.setHint("Enter interior angle");
			b.setHint("Enter Nothing");
			c.setHint("Enter Nothing");
			
			String promp = "Arc:";
			pr.setText(promp.toString());
		}
		if(pos==5){//1v&2a
			po=5;
			pic.setBackgroundResource(R.drawable.vang);
			a.setHint("Enter an arc measure");
			b.setHint("Enter the other arc measure");
			c.setHint("Enter Nothing");
			
			String promp = "Angle:";
			pr.setText(promp.toString());
		}
		if(pos==6){//2v&1a
			po=6;
			pic.setBackgroundResource(R.drawable.varc);
			a.setHint("Enter vertical angle");
			b.setHint("Enter arc measure");
			c.setHint("Enter Nothing");
			
			String promp = "Arc:";
			pr.setText(promp.toString());
		}
		if(pos==7){//circ
			po=7;
			pic.setBackgroundResource(R.drawable.circ);
			a.setHint("Enter the Angle");
			b.setHint("Enter the Radius");
			c.setHint("Enter Nothing");
			
			String promp = "Sector:";
			pr.setText(promp.toString());
		}
		if(pos==8){//circs
			po=8;
			pic.setBackgroundResource(R.drawable.chosegs);
			a.setHint("Enter a segment length");
			b.setHint("Corresponding segment");
			c.setHint("Enter other segment");
			
			String promp = "Segment";
			pr.setText(promp.toString());
		}
		if(pos==9){//circs
			po=9;
			pic.setBackgroundResource(R.drawable.secforex);
			a.setHint("Enter known external");
			b.setHint("Enter corresponding internal");
			c.setHint("Enter other internal");
			
			String promp = "Segment";
			pr.setText(promp.toString());
		}
		if(pos==10){//circs
			po=10;
			pic.setBackgroundResource(R.drawable.secforin);
			a.setHint("Enter Known External");
			b.setHint("Enter corresponding internal");
			c.setHint("Enter other external");
			
			String promp = "Segment";
			pr.setText(promp.toString());
		}
		if(pos==11){//circs
			po=11;
			pic.setBackgroundResource(R.drawable.sectanseg);
			a.setHint("Enter Tangent");
			b.setHint("Enter external secant");
			c.setHint("Enter Nothing");
			
			String promp = "Segment";
			pr.setText(promp.toString());
		}
		if(pos==12){//circs
			po=12;
			pic.setBackgroundResource(R.drawable.isectanseg);
			a.setHint("Enter Tangent");
			b.setHint("Enter whole secant length");
			c.setHint("Enter Nothing");
			
			String promp = "Segment";
			pr.setText(promp.toString());
		}
		if(pos==13){//circs
			po=13;
			pic.setBackgroundResource(R.drawable.tanseg);
			a.setHint("Enter external secant");
			b.setHint("Enter internal secant");
			c.setHint("Enter Nothing");
			
			String promp = "Segment";
			pr.setText(promp.toString());
		}
		if(pos==14){//circs
			po=14;
			pic.setBackgroundResource(R.drawable.circd);
			a.setHint("Enter sector area");
			b.setHint("Enter radius");
			c.setHint("Enter angle");
			
			String promp = "Segment";
			pr.setText(promp.toString());
		}
		if(pos==15){//circs
			po=15;
			pic.setBackgroundResource(R.drawable.itantan);
			a.setHint("Enter Angle");
			b.setHint("Enter known arc");
			c.setHint("Enter 1 if large arc, 0 if small");
			
			String promp = "Arc:";
			pr.setText(promp.toString());
		}
		if(pos==16){//circs
			po=16;
			pic.setBackgroundResource(R.drawable.isecsec);
			a.setHint("Enter Angle");
			b.setHint("Enter known arc");
			c.setHint("Enter 1 if large arc, 0 if small");
			
			String promp = "Arc:";
			pr.setText(promp.toString());
		}
		if(pos==17){//circs
			po=17;
			pic.setBackgroundResource(R.drawable.isectan);
			a.setHint("Enter Angle");
			b.setHint("Enter known arc");
			c.setHint("Enter 1 if large arc, 0 if small");
			
			String promp = "Arc:";
			pr.setText(promp.toString());
		}
		if(pos==18){//circs
			po=18;
			pic.setBackgroundResource(R.drawable.circ);
			a.setHint("Enter Angle");
			b.setHint("Enter Radius");
			c.setHint("Enter Nothing");
			
			String promp = "Arc:";
			pr.setText(promp.toString());
		}
		if(pos==19){//circs
			po=19;
			pic.setBackgroundResource(R.drawable.meas);
			a.setHint("Enter Arc length");
			b.setHint("Enter Radius");
			c.setHint("Enter Nothing");
			
			String promp = "Arc:";
			pr.setText(promp.toString());
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
