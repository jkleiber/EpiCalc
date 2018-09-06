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

public class Systems extends Activity{
	Button enter;
	EditText a, b, c, d, e, g;
	BigDecimal x, y, z;
	BigDecimal xx, yy, zz;
	TextView res;
	String[] works = new String[7];
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
	boolean t,f,s,r,q,w;
	double xs,ys,bs;
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
	@SuppressWarnings("deprecation")
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
		setContentView(R.layout.systems);
		
		enter=(Button) findViewById(R.id.bent);
		a=(EditText) findViewById(R.id.ETx);
		b=(EditText) findViewById(R.id.ETy);
		c=(EditText) findViewById(R.id.ETb);
		d=(EditText) findViewById(R.id.ETxx);
		e=(EditText) findViewById(R.id.ETyy);
		g=(EditText) findViewById(R.id.ETbb);
		res=(TextView) findViewById(R.id.tVans);
		registerForContextMenu(res);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t=checkEmpty(a);
				f=checkEmpty(b);
				s=checkEmpty(c);
				r=checkEmpty(d);
				q=checkEmpty(e);
				w=checkEmpty(g);
				if(t&&f&&s&&r&&q&&w){
				x= new BigDecimal(a.getText().toString());
				y= new BigDecimal(b.getText().toString());
				z= new BigDecimal(c.getText().toString());
				xx= new BigDecimal(d.getText().toString());
				yy= new BigDecimal(e.getText().toString());
				zz= new BigDecimal(g.getText().toString());
				double m=x.doubleValue();
				double f=y.doubleValue();
				double i=z.doubleValue();
				double mm=xx.doubleValue();
				double ff=yy.doubleValue();
				double ii=zz.doubleValue();
				String answer = "";
				
				if((mm<0 && m>0) || (mm>0 && m<0))
				{
					
					double fh=f;
					double ui=i;
					ff*=Math.abs(m);
					ii*=Math.abs(m);
					f*=Math.abs(mm);
					i*=Math.abs(mm);
					works[0]="Multiply by the absolute value of the 'a' value in the other equation. This eliminates the a's.";
					ys=ff+f;
					bs=ii+i;
					if(ys!=0)
					{
						works[2]=ys+"y = "+bs+"= y="+bs+"/"+ys;
						
						bs/=ys;
						double rg=fh*bs;
						
						xs=(ui-(fh*bs))/m;
						double lol=xs*m;
						answer = "("+xs+","+bs+")";
						res.setText(answer.toString());
						works[1]="Since the b values didn't cancel, just divide c by b.";
						works[3]="y="+bs;
						works[4]="Plug y back in and solve.";
						works[5]=m+"x +"+fh+"("+bs+") = "+ui +"="+ m+"x +"+rg+"="+ui;
						works[6]=m+"x = "+ui+"-"+rg +"="+lol+", x= "+lol+"/"+m+"= "+xs;
					}
					else if(ys==0 && bs==0)
					{
						answer = "{x,y|"+m+"x"+"+"+fh+"y = "+ ui + "}";
						res.setText(answer.toString());
						works[1]="Because the b and c values also cancel, you are dealing with the same line.";
						works[2]="Put the equation in set builder notation";
						works[3]=" ";
						works[4]=" ";
						works[5]=" ";
						works[6]=" ";
						
					}
					else if(ys==0 && bs!=0)
					{
						answer = "No Solutions";
						res.setText(answer.toString());
						works[1]="Because the b values cancel and the c values do not, you are dealing with parallel lines.";
						works[2]="There are no intersections (solutions)";
						works[3]=" ";
						works[4]=" ";
						works[5]=" ";
						works[6]=" ";
					}
					
				}
				
				else
				{
					double fh=f;
					double ui=i;
					works[0]="To get opposite values for elimination, multiply by the opposite of the a value in the other equation," +
							"Then multiply by the unchanged 'a' when doing the other equation.";
					if(m>mm)
					{
						ff*=-m;
						ii*=-m;
						f*=mm;
						i*=mm;
					}
					else
					{
						ff*=m;
						ii*=m;
						f*=-mm;
						i*=-mm;
					}
					ys=ff+f;
					bs=ii+i;
					
					if(ys!=0)
					{
						works[2]=ys+"y = "+bs+"= y="+bs+"/"+ys;
						
						bs/=ys;
						double rg=fh*bs;
						xs=(ui-(fh*bs))/m;
						double lol=xs*m;
						answer = "("+xs+","+bs+")";
						res.setText(answer.toString());
						works[1]="Since the b values didn't cancel, just divide c by b.";
						works[3]="y="+bs;
						works[4]="Plug y back in and solve.";
						works[5]=m+"x +"+fh+"("+bs+") = "+ui +"="+ m+"x +"+rg+"="+ui;
						works[6]=m+"x = "+ui+"/"+rg +"="+lol+", x= "+lol+"/"+m+"= "+xs;
					}
					else if(ys==0 && bs==0)
					{
						answer = "{x,y|"+m+"x"+"+"+fh+"y = "+ ui + "}";
						res.setText(answer.toString());
						works[1]="Because the b and c values also cancel, you are dealing with the same line.";
						works[2]="Put the equation in set builder notation";
						works[3]=" ";
						works[4]=" ";
						works[5]=" ";
						works[6]=" ";
					}
					else if(ys==0 && bs!=0)
					{
						answer = "No Solutions";
						res.setText(answer.toString());
						works[1]="Because the b values cancel and the c values do not, you are dealing with parallel lines.";
						works[2]="There are no intersections (solutions)";
						works[3]=" ";
						works[4]=" ";
						works[5]=" ";
						works[6]=" ";
					}
					
				}
				
				
				}else{
					String err="More input needed";
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
