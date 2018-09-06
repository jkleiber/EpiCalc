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

public class Radical extends Activity{

	EditText a,b,c;
	Button enter, ent;
	TextView res,resu,rent,renu,rede;
	BigDecimal j,k;
	boolean t, flag, simple;
	int x,y,s,swap,hold,aa=0,bb=0, div,swapd;
	boolean f;
	
	String[] works;
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
		setContentView(R.layout.rad);
		
		a=(EditText) findViewById(R.id.ETx);
		
		b=(EditText) findViewById(R.id.etNum);
		c=(EditText) findViewById(R.id.etDen);
		
		resu=(TextView) findViewById(R.id.tVanss);
		
		rede=(TextView) findViewById(R.id.tvan);
		
		registerForContextMenu(resu);
		
		registerForContextMenu(rede);

		x=4;
		y=5;
		div=2;
		simple=false;
		flag=true;
		hold=1;
		t=false;
		aa=0;
		bb=0;
		
		ent=(Button) findViewById(R.id.bentt);
		
		enter=(Button) findViewById(R.id.bent);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				f=checkEmpty(a);
				if(f){
				x=4;
				y=5;
				t=false;
				simple=false;
				flag=true;
				hold=1;
				j= new BigDecimal(a.getText().toString());
				
				aa=j.intValue();
				double size=0.7496*Math.log(aa) + 0.1608;
				works=new String[(int) (size+3)];
				works[2]="\u221A("+aa;
				int i=3;
				while(!simple){
					while(flag){
						if(x<=aa){
							if(aa==x){
								aa=1;
								t=true;
								flag=false;
								break;
								
							}
						else if(aa%x==0){
								
								s=aa/x;
								aa=x;
								swap=s;
								s=aa;
								aa=swap;
								t=true;
								flag=false;
								break;
								} 
							else{
								x+=y;
								y+=2;
								flag=false;
								break;
							}
							
							
						}
						if(!t){
							flag=false;
							break;
						}
					}
					
					if(t==true){
						hold*=Math.sqrt(x);
						x=4;
						y=5;
						t=false;
						works[i-1]+="/"+x+")";
						works[i]=hold+"\u221A("+aa;
						i++;
					}
					if(x<=aa){
						flag=true;
					
					}
					else{
						simple=true;
						works[i-1]+=")";
						break;
					}
				}
				int jj=hold;
				int k=aa;
				String ab=jj+"\u221A"+k;
				resu.setText(ab.toString());
				
				works[0]="To simplify radical \u221A20: 20/4 (perfect square) =\u221A4\u221A(20/4) = 2\u221A5";
				works[1]=" ";
				
				
				
			}else{
				String err="NULL";
				resu.setText(err.toString());
			}

			}
		});
		
		
		x=4;
		y=5;
		div=2;
		simple=false;
		flag=true;
		hold=1;
		t=false;
		aa=0;
		bb=0;
		
		
ent.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t=checkEmpty(b);
				f=checkEmpty(c);
				if(f){
				x=4;
				y=5;
				t=false;
				simple=false;
				flag=true;
				hold=1;
				j= new BigDecimal(b.getText().toString());
				k= new BigDecimal(c.getText().toString());
				int q=0, qq=0;
				q=k.intValue();
				qq=j.intValue();
				bb=q;
				aa=qq*q;
				double size=0.7496*Math.log(aa) + 0.1608;
				works=new String[(int) (size+3)];
				works[2]="\u221A("+qq+"/"+q+") = \u221A("+aa+")/"+bb;
				int i=3;
				while(simple==false){
					while(flag==true){
						if(x<=aa){
							if(aa==x){
								aa=1;
								t=true;
								flag=false;
								break;
							}
							else if(aa%x==0){
								
								s=aa/x;
								aa=x;
								swap=s;
								s=aa;
								aa=swap;
								t=true;
								flag=false;
								break;
								}
							else{
								x+=y;
								y+=2;
								flag=false;
								break;
							}
							
							
						}
						if(!t){
							flag=false;
							break;
						}
					}
					
					if(t==true){
						hold*=Math.sqrt(x);
						x=4;
						y=5;
						t=false;
						
						works[i]=hold+"\u221A("+aa+")/"+bb;
						i++;
					}
					if(x<=aa){
						flag=true;
					
					}
					else{
						simple=true;
						break;
					}
				}
				works[i]="Then simplify as a fraction";
				boolean simples=false, run=true;
				int num = hold, den = bb;
				while(run){
					while(!simples){
						if(num<div || den<div){
							div=2;
							simples=true;
							run=false;
							
							break;
						}
						else if(num%den==0){
							swap=num/den;
							num=swap;
							den=1;
							div=2;
							simples=true;
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
				
				int jj=num;
				int k=aa;
				int kk=den;
				String absy="("+jj+"\u221A"+k+")/"+kk;
				rede.setText(absy.toString());
				
				works[0]="Simplify Radical \u221A(40/5): \u221A40/\u221A5 = \u221A40 * \u221A5 /5, then just simplify like normal.";
				works[1]=" ";
			}else{
				String err="NULL";
				
				rede.setText(err.toString());
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
