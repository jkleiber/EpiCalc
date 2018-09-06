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

public class Perm extends Activity{

	Button enter;
	EditText a, b;
	BigDecimal x;
	BigDecimal y;
	TextView res;
	String[] works = new String[4];
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
		setContentView(R.layout.perm);
	
		enter=(Button) findViewById(R.id.bent);
		a=(EditText) findViewById(R.id.ETpart);
		b=(EditText) findViewById(R.id.ETwho);
		res=(TextView) findViewById(R.id.tVans);
		registerForContextMenu(res);
		enter.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				boolean t=checkEmpty(a), f=checkEmpty(b);
				if(t&&f){
				x=new BigDecimal(a.getText().toString());
				y=new BigDecimal(b.getText().toString());
				
				float p=x.floatValue();
				float w = y.floatValue();
				
				float diff = w-p;
				works[1]="P= ("+w+"!)/("+diff+"!)";
				String str1 = String.valueOf(w), str2 = String.valueOf(diff);
				for(float i=w-1;i>0;i--){
					w*=i;
					str1+=" * "+String.valueOf(i);
				}
				
				for(float ii=diff-1;ii>0;ii--){
					diff*=ii;
					str2+=" * "+String.valueOf(ii);
				}
				float pp=w/diff;
				String m=Float.toString(pp);
				res.setText(m.toString());
				
				works[0]="Permutations= (whole group!)/((whole-partial)!)";
				works[2]="P= ("+str1+")/("+str2+")";
				works[3]="P= "+w+"/"+diff+"= "+pp;
				
			}else{
				String err="NO INPUT";
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
