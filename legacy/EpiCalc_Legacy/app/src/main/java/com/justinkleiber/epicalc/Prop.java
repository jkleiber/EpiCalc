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

public class Prop extends Activity{
	EditText a,b,c,d;
	Button enter;
	TextView res;
	BigDecimal j,k,l,m;
	int cn;
	boolean t,f,s,q;
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
		setContentView(R.layout.props);
		
		a=(EditText) findViewById(R.id.ETm);
		b=(EditText) findViewById(R.id.ETe);
		c=(EditText) findViewById(R.id.ETee);
		d=(EditText) findViewById(R.id.ETmm);
		res=(TextView) findViewById(R.id.tVans);
		registerForContextMenu(res);
		cn=0;
		enter=(Button) findViewById(R.id.bent);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int intCheck = 0;
				t=checkEmpty(a);
				if(t)
				{intCheck++;}
				f=checkEmpty(b);
				if(f)
				{intCheck++;}
				s=checkEmpty(c);
				if(s)
				{intCheck++;}
				q=checkEmpty(d);
				if(q)
				{intCheck++;}
				
				if(intCheck==3){
				double n,o,p,r;
				if(t)
					{
					j= new BigDecimal(a.getText().toString());
					n=j.doubleValue();
					
					}
				else{n=0;}
				if(f)
					{
					k= new BigDecimal(b.getText().toString());
					o=k.doubleValue();
					}
				else{o=0;}
				if(s)
					{
					l= new BigDecimal(c.getText().toString());
					p=l.doubleValue();
					}
				else{p=0;}
				if(q)
					{
					m= new BigDecimal(d.getText().toString());
					r=m.doubleValue();
					}
				else{r=0;}
				
				double ans=0;
				
				if(n+p==n)
				{
					ans=(n*r)/o;
					works[0]=n+"/"+"x = "+o+"/"+r;
					works[1]="x= "+n+" * "+r+" / "+ o;
				}
				else if(n+p==p)
				{
					ans=(o*p)/r;
					works[0]="x/"+p+" = "+o+"/"+r;
					works[1]="x= "+o+" * "+p+" / "+ r;
				}
				else if(o+r==o)
				{
					ans=(o*p)/n;
					works[0]=n+"/"+p+" = "+o+"/x";
					works[1]="x= "+o+" * "+p+" / "+ n;
				}
				else
				{
					ans=(r*n)/p;
					works[0]=n+"/"+p+" = "+"x/"+r;
					works[1]="x= "+r+" * "+n+" / "+ p;
				}
				
				works[2]="x= "+ans;
				
				String ab=Double.toString(ans);
				
				res.setText(ab.toString());
				}else{
					String err="Invalid Input";
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
