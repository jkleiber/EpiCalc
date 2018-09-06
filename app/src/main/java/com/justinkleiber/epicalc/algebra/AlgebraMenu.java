package com.justinkleiber.epicalc.algebra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.justinkleiber.epicalc.R;

/**
 * Created by Justin on 7/27/2015.
 */
public class AlgebraMenu extends Activity {

    Button aos, poly, quad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.algebra_list);

        aos = (Button) findViewById(R.id.AOS_Button);
        poly = (Button) findViewById(R.id.Polynomial_Button);
        quad = (Button) findViewById(R.id.Quadratic_Button);


        aos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent("android.intent.action.AOS_FORMULA");
                startActivity(a);
            }
        });

        poly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent("android.intent.action.POLY_FORMULA");
                startActivity(p);
            }
        });

        quad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent q = new Intent("android.intent.action.QUAD_FORMULA");
                startActivity(q);
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
