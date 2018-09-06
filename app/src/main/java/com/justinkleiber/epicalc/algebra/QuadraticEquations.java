package com.justinkleiber.epicalc.algebra;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.justinkleiber.epicalc.R;

/**
 * Created by Justin on 7/30/2015.
 */
public class QuadraticEquations extends Activity {

    EditText aa,bb,cc;
    Button calc;
    TextView answer;

    public static String superscript(String str) {
        str = str.replaceAll("<s>0", "\u2070");
        str = str.replaceAll("<s>1", "\u00B9");
        str = str.replaceAll("<s>2", "\u00B2");
        str = str.replaceAll("<s>3", "\u00B3");
        str = str.replaceAll("<s>4", "\u2074");
        str = str.replaceAll("<s>5", "\u2075");
        str = str.replaceAll("<s>6", "\u2076");
        str = str.replaceAll("<s>7", "\u2077");
        str = str.replaceAll("<s>8", "\u2078");
        str = str.replaceAll("<s>9", "\u2079");
        return str;
    }

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

    private boolean looksLikeInteger(double d)
    {
        if(Math.floor(d)==d && !Double.isInfinite(d))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quadratic_formula);

        aa = (EditText) findViewById(R.id.QF_A_EditText);
        bb = (EditText) findViewById(R.id.QF_B_EditText);
        cc = (EditText) findViewById(R.id.QF_C_EditText);

        answer = (TextView) findViewById(R.id.Answer_TextView);

        calc = (Button) findViewById(R.id.Calculate_Button);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkEmpty(aa) && checkEmpty(bb) && checkEmpty(cc)) {
                    double a, b, c, d;
                    String sa, sb, sc;
                    sa = aa.getText().toString();
                    sb = bb.getText().toString();
                    sc = cc.getText().toString();

                    a = Double.parseDouble(sa);
                    b = Double.parseDouble(sb);
                    c = Double.parseDouble(sc);

                    d = (Math.pow(b, 2)) + (-4) * a * c;


                    if (d >= 0) {
                        double r = (-b + Math.sqrt(d)) / (2 * a);
                        double rr = (-b - Math.sqrt(d)) / (2 * a);

                        String str = "x = " + String.valueOf(r) + ", " + String.valueOf(rr);
                        answer.setTextColor(Color.parseColor("#000000"));
                        answer.setText(str);

                    } else {
                        String real_d;
                        boolean before = false;

                        if (looksLikeInteger(Math.sqrt(Math.abs(d)))) {
                            d = Math.sqrt(Math.abs(d));
                            if (looksLikeInteger(d / (2 * a))) {
                                d /= (2 * a);
                                int rd = (int) d;
                                real_d = String.valueOf(rd);
                            } else {
                                int rd = (int) d;
                                real_d = String.valueOf(rd) + "/" + String.valueOf((int) (2 * a));
                                before = true;
                            }
                        } else {
                            int rd = (int) Math.abs(d);

                            real_d = "\u221A" + "[" + String.valueOf(rd) + "]/" + String.valueOf((int) (2 * a));
                            Log.d("WHAT IS REAL_D:", String.valueOf(real_d));
                            before = true;
                        }


                        double aos = (-b) / (2 * a);

                        String cpx1, cpx2;
                        if (aos != 0) {
                            if (!before) {
                                cpx1 = String.valueOf(aos) + " - " + real_d + "i";
                                cpx2 = String.valueOf(aos) + " + " + real_d + "i";
                            } else {
                                cpx1 = String.valueOf(aos) + " - " + "i" + real_d;
                                cpx2 = String.valueOf(aos) + " + " + "i" + real_d;
                            }
                        } else {
                            if (!before) {
                                cpx1 = real_d + "i";
                                cpx2 = real_d + "i";
                            } else {
                                cpx1 = "i" + real_d;
                                cpx2 = "i" + real_d;
                            }
                        }

                        answer.setTextColor(Color.parseColor("#000000"));
                        answer.setText("x = " + cpx1 + ", " + cpx2);

                    }
                } else {
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
