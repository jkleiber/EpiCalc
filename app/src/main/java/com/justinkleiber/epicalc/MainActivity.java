package com.justinkleiber.epicalc;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button algebra, geometry, stats, precal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        algebra = (Button) findViewById(R.id.Algebra_Button);
        geometry = (Button) findViewById(R.id.Geometry_Button);
        stats = (Button) findViewById(R.id.Stats_Button);
        precal = (Button) findViewById(R.id.PreCal_Button);


        algebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent("android.intent.action.ALGEBRA");
                startActivity(a);
            }
        });

        geometry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent("android.intent.action.GEOMETRY");
                startActivity(g);
            }
        });

        precal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent("android.intent.action.PRECAL");
                startActivity(p);
            }
        });

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent("android.intent.action.STATISTICS");
                startActivity(s);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.action_settings:
                break;
            case R.id.action_request:
                break;
            case R.id.action_help:
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
