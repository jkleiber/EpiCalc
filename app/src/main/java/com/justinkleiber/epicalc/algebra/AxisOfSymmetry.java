package com.justinkleiber.epicalc.algebra;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.justinkleiber.epicalc.R;

import java.math.BigDecimal;

/**
 * Created by Justin on 7/28/2015.
 */
public class AxisOfSymmetry extends Activity {

    EditText a,b;
    Button c;
    TextView answer;

    BigDecimal e_a, e_b;

    private boolean checkEmpty(EditText editText)
    {
        boolean x=true;
        if(editText.getText().toString().trim().length() > 0){
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aos_formula);

        a = (EditText) findViewById(R.id.AOS_A_EditText);
        b = (EditText) findViewById(R.id.AOS_B_EditText);

        answer = (TextView) findViewById(R.id.Answer_TextView);

        c = (Button) findViewById(R.id.Calculate_Button);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmpty(a) && checkEmpty(b))
                {
                    e_a = new BigDecimal(a.getText().toString());
                    e_b = new BigDecimal(b.getText().toString());

                    double da = e_a.doubleValue();
                    double db = e_b.doubleValue();

                    double ans = (-db) / (2*da);
                    String str = "x = " + Double.toString(ans);

                    answer.setTextColor(Color.parseColor("#000000"));
                    answer.setText(str);
                }
                else
                {
                    answer.setTextColor(Color.parseColor("#FF0000"));
                    answer.setText("Missing Input Requirement");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.formula_menu, menu);
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
