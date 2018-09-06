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

public class Times extends Activity implements OnItemSelectedListener{

	
	Button enter;
	EditText a, b, c,d;
	BigDecimal x;
	BigDecimal y, z,w;
	TextView res;
	int po;
	boolean t,f, s,r;
	String[] works = new String[4];
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
		setContentView(R.layout.tim);
		
		Spinner g=(Spinner) findViewById(R.id.spinnerA);
		g.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		g.setAdapter(adapter);
		enter=(Button) findViewById(R.id.bent);
		a=(EditText) findViewById(R.id.ETmax);
		b=(EditText) findViewById(R.id.ETmin);
		c=(EditText) findViewById(R.id.ETgrav);
		d=(EditText) findViewById(R.id.etHeigh);
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
				
				
					if(po==0){
						if(t&f&s){
					x=new BigDecimal(a.getText().toString());
					y=new BigDecimal(b.getText().toString());
					z=new BigDecimal(c.getText().toString());
					
					float max=x.floatValue();
					float min=y.floatValue();
					
					float diff=min-max;
					float op=diff*2;
					float g = z.floatValue();
					if(g>0)
					{
						g*=-1;
					}
					double ans = Math.sqrt((2*diff)/g);
					
					String answer = Double.toString(ans);
					res.setText(answer.toString());
					
					works[0]="Time (t)= 2(\u0394Height (h)) / Gravity (g can't be negative)";
					works[1]="t= 2(\u0394h) / "+g+"= 2("+min+" - "+max+") / "+g;
					works[2]="t= 2("+diff+") / "+g;
					works[3]="t= "+op+" / "+g+"= "+ans;
						}
						else{
							String err = "Missing Input!";
							res.setText(err.toString());
							}
				}
					
					else if(po==1){
						if(t&&f&&s&&r)
						{
						w=new BigDecimal(d.getText().toString());
						x=new BigDecimal(a.getText().toString());
						y=new BigDecimal(b.getText().toString());
						z=new BigDecimal(c.getText().toString());
						
						float vel=x.floatValue();
						float ang=y.floatValue();
						float sta=w.floatValue();
						
						double ve=vel*Math.sin((ang*Math.PI/180));
						double g=z.doubleValue();
						double gg=(2*g*sta);
						double squ=Math.sqrt((ve*ve)+gg);
						double ans = Math.abs((ve+(Math.sqrt((ve*ve)+gg) ))/g);
						
						String answer = Double.toString(ans);
						res.setText(answer.toString());
						
						works[0]="Time (t)= |(Velocity (V) * sin(Angle (a)) + \u221A( (Velocity (V) * sin(Angle (a))\u00B2 + (2*Gravity*Starting Height) ) / (Gravity)|";
						works[1]="t= |("+vel+" * sin("+ang+")) + \u221A( ("+vel+" * sin("+ang+")\u00B2 + "+gg+" ) / "+g+"| = |"+ve+" + \u221A( "+ve+"\u00B2 + "+gg+ " ) /"+g+"|";
						works[2]="t= |"+ve+" + "+squ+" / "+g+"|";
						works[3]="t= "+ans;
					}
					else{
						String err = "Missing Input!";
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
		if(pos==0){
			a.setHint("Enter Maximum Height (units)");
			b.setHint("Enter Minimum Height (units)");
			c.setHint("Enter Gravity (units/s)");
			d.setHint("Nothing to do here.");
			po=0;
		}
		if(pos==1){
			a.setHint("Enter Velocity (units/s)");
			b.setHint("Enter Angle");
			c.setHint("Enter Gravity (units/s)");
			d.setHint("Enter Starting Height (units)");
			po=1;
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