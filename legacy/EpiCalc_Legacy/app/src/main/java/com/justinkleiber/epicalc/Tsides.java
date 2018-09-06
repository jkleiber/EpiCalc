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

public class Tsides extends Activity implements OnItemSelectedListener{
	int po;
	EditText a,b;
	Button enter;
	TextView res,resu,pic,pr,pro;
	BigDecimal j,k;
	Spinner g;
	boolean t,f;
	String[] works = new String[7];
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
		setContentView(R.layout.tside);
		Spinner g=(Spinner) findViewById(R.id.spinner1);
		g.setOnItemSelectedListener(this);
		ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this, R.array.Tsid, android.R.layout.simple_spinner_dropdown_item);
		adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		g.setAdapter(adapt);
		a=(EditText) findViewById(R.id.ETa);
		b=(EditText) findViewById(R.id.ETl);
		pic=(TextView) findViewById(R.id.textView1);
		//hypotenuse
		res=(TextView) findViewById(R.id.tVans);
		//other leg
		resu=(TextView) findViewById(R.id.tVanss);
		
		pr=(TextView) findViewById(R.id.tvSide);
		pro=(TextView) findViewById(R.id.tVhpo);
		
		registerForContextMenu(res);
		registerForContextMenu(resu);
		
		
		
		enter=(Button) findViewById(R.id.bent);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				t=checkEmpty(a);
				f=checkEmpty(b);
				if(t&&f){
				j= new BigDecimal(a.getText().toString());
				k= new BigDecimal(b.getText().toString());
				
				//usually angle
				double s=j.doubleValue();
				//usually side
				double t=k.doubleValue();
				double z=0, y=0;
				//z is top y is bottom
				if (po==0){
					
					z=s*Math.sin(t*Math.PI/180);
					y=s*Math.cos(t*Math.PI/180);
					
					String ab=Double.toString(y);
					String abb=Double.toString(z);
					resu.setText(ab.toString());
					res.setText(abb.toString());
					
					works[0]="Adjacent leg of angle(al)= Hypotenuse (H) * cos(Angle (a)) (in degrees)";
					works[1]="ol= H * cos(a) = "+ s + " * cos(" +t+")";
					works[2]="ol= "+z;
					works[3]=" ";
					works[4]="Opposite leg of angle(ol)= Hypotenuse (H) * sin(Angle (a)) (in degrees)";
					works[5]="ol= H * sin(a) = "+ s + " * sin(" +t+")";
					works[6]="ol= "+y;
					
				}
				if (po==1){
					
					z=t/Math.tan(s*Math.PI/180);
					y=Math.sqrt((t*t)+(z*z));
					
					
					String ab=Double.toString(y);
					String abb=Double.toString(z);
					resu.setText(abb.toString());
					res.setText(ab.toString());
					
					works[0]="Adjacent leg (al)= Opposite side (os) / tan(Angle(a))";
					works[1]="al= os / tan(a)= "+t+" / tan("+s+")";
					works[2]="al= "+z;
					works[3]=" ";
					works[4]="Hypotenuse (H)\u00B2= Opposite side (os)\u00B2 + Adjacent side (as)\u00B2";
					works[5]="H\u00B2= os\u00B2 + as\u00B2= "+t+"\u00B2 + "+z+"\u00B2";
					works[6]="\u221AH\u00B2= "+y;
				}
				if (po==2){
					
					z=t*Math.tan(s*Math.PI/180);
					y=Math.sqrt((t*t)+(z*z));
					
					String ab=Double.toString(y);
					String abb=Double.toString(z);
					resu.setText(abb.toString());
					res.setText(ab.toString());
					
					works[0]="Opposite leg (al)= Adjacent side (os) * tan(Angle(a))";
					works[1]="al= os / tan(a)= "+t+" * tan("+s+")";
					works[2]="al= "+z;
					works[3]=" ";
					works[4]="Hypotenuse (H)\u00B2= Opposite side (os)\u00B2 + Adjacent side (as)\u00B2";
					works[5]="H\u00B2= os\u00B2 + as\u00B2= "+z+"\u00B2 + "+t+"\u00B2";
					works[6]="\u221AH\u00B2= "+y;
				}
				
				
				}else{
					String err="NO INPUT";
					res.setText(err.toString());
					resu.setText(err.toString());
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
			
			String prom = "Opposite Leg:";
			String promp = "Adjacent Leg:";
			pr.setText(prom.toString());
			pro.setText(promp.toString());
			a.setHint("Enter hypotenuse");
			b.setHint("Enter the angle");
			pic.setBackgroundResource(R.drawable.trop);
			po=0;
		}
		if(pos==1){
			String prom = "Adjacent Leg:";
			String promp = "Hypotenuse:";
			pr.setText(prom.toString());
			pro.setText(promp.toString());
			b.setHint("Enter opposite side of the angle");
			a.setHint("Enter the angle");
			pic.setBackgroundResource(R.drawable.tripa);
			po=1;
		}
		if(pos==2){
			
			String prom = "Opposite Leg:";
			String promp = "Hypotenuse:";
			pr.setText(prom.toString());
			pro.setText(promp.toString());
			a.setHint("Enter angle");
			b.setHint("Enter the adjacent side of angle");
			pic.setBackgroundResource(R.drawable.tria);
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
