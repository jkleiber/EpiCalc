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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Justin on 7/28/2015.
 */
public class PolynomialFactoring extends Activity {

    EditText a;
    Button c;
    TextView answer, equation, remainder_p, remainder;

    ArrayList<Double> coeffs, rList, real_roots;
    ArrayList<Double> pList,qList;
    HashMap<Double, Integer> rootMultiplicity;

    HashMap<String, Integer> cpxMultiplicity;
    ArrayList<String> cpx_roots;

    int i=0;
    String equ = "";
    boolean isCalculable,isPolynomial,isImaginary, isIrrational;

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
    private boolean containsOnlyDecimalNumbers(String s)
    {
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if(!(Character.isDigit(c) || c=='-' || c=='+')) {
                return false;
            }
        }

        return true;
    }

    private boolean isRemainderZero(double div, ArrayList<Double> coef_list)
    {
        double rem=0;
        for(int i=0;i<coef_list.size();i++)
        {
            rem += coef_list.get(i) * Math.pow(div,(coef_list.size()-1-i));
        }

        Log.d("REMAINDER:", String.valueOf(div) + " -> " + String.valueOf(rem));

        return rem==0;
    }

    private ArrayList<Double> doSyntheticDivide(double div, ArrayList<Double> coef_list)
    {
        ArrayList<Double> result = new ArrayList<Double>();

        double cRem=coef_list.get(0);
        result.add(cRem);
        for(int i=1;i<coef_list.size()-1;i++)
        {
            cRem *= div;
            cRem = coef_list.get(i) + cRem;
            result.add(cRem);
        }

        return result;
    }

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

    public String makePolyEquation(int len)
    {
        String equ_new="";
        for (i = len; i >= 0; i--) {
            if (coeffs.get(len - i) > 0) {
                if (i != coeffs.size() - 1) {
                    if (looksLikeInteger(coeffs.get(len - i))) {
                        if(coeffs.get(len - i) != 1) {
                            equ_new += "+ " + String.valueOf((coeffs.get(len - i)).intValue());
                        }
                        else if(i==0)
                        {
                            equ_new += "+ " + String.valueOf((coeffs.get(len - i)).intValue());
                        }
                        else
                        {
                            equ_new += "+";
                        }
                    } else {
                        equ_new += "+ " + String.valueOf(coeffs.get(len - i));
                    }
                } else {
                    if (looksLikeInteger(coeffs.get(len - i))) {
                        if(coeffs.get(len - i) != 1) {
                            equ_new += String.valueOf((coeffs.get(len - i)).intValue());
                        }

                    } else {
                        equ_new += String.valueOf(coeffs.get(len - i));
                    }
                }

                if (i != 0) {
                    equ_new += "x";

                    if(i!=1) {
                        String s = String.valueOf(i);
                        for (int ii = 0; ii < s.length(); ii++) {
                            equ_new += "<s>" + s.charAt(ii);
                        }
                    }

                    equ_new += " ";
                }
            } else if (coeffs.get(len - i) < 0) {
                if (looksLikeInteger(coeffs.get(len - i))) {
                    if(coeffs.get(len - i) != -1) {
                        equ_new += String.valueOf((coeffs.get(len - i)).intValue());
                    }
                    else if(i==0)
                    {
                        equ_new += String.valueOf((coeffs.get(len - i)).intValue());
                    }
                    else
                    {
                        equ_new += "-";
                    }
                } else {
                    equ_new += String.valueOf(coeffs.get(len - i));
                }

                if (i != 0) {
                    equ_new += "x";

                    if(i!=1) {
                        String s = String.valueOf(i);
                        for (int ii = 0; ii < s.length(); ii++) {
                            equ_new += "<s>" + s.charAt(ii);
                        }
                    }

                    equ_new += " ";
                }

            }


        }

        return equ_new;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.polynomial_factoring_formula);

        coeffs = new ArrayList<Double>();
        pList = new ArrayList<Double>();
        qList = new ArrayList<Double>();
        rList = new ArrayList<Double>();
        real_roots = new ArrayList<Double>();

        cpx_roots = new ArrayList<String>();

        rootMultiplicity = new HashMap<Double,Integer>();

        cpxMultiplicity = new HashMap<String, Integer>();

        a = (EditText) findViewById(R.id.Polynomial_EditText);

        answer = (TextView) findViewById(R.id.Answer_TextView);
        equation = (TextView) findViewById(R.id.Equation_TextView);
        remainder_p = (TextView) findViewById(R.id.textView4);
        remainder = (TextView) findViewById(R.id.Remainder_TextView);

        remainder_p.setVisibility(View.INVISIBLE);
        remainder.setVisibility(View.INVISIBLE);

        c = (Button) findViewById(R.id.Calculate_Button);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmpty(a))
                {
                    String str = a.getText().toString();
                    String[] splitString = str.split("\\s+");

                    coeffs.clear();
                    real_roots.clear();
                    cpx_roots.clear();

                    rootMultiplicity.clear();
                    cpxMultiplicity.clear();

                    remainder_p.setVisibility(View.INVISIBLE);
                    remainder.setVisibility(View.INVISIBLE);

                    equ="";
                    i=0;

                    int polyCount=0, m=splitString.length;
                    boolean counted = false;

                    for(String s : splitString)
                    {
                        isCalculable = containsOnlyDecimalNumbers(s);

                        if(!isCalculable)
                        {
                            break;
                        }

                        coeffs.add(Double.parseDouble(s));
                        if(Double.parseDouble(s)!=0 && !counted)
                        {
                            polyCount = m;
                            counted=true;
                        }

                        m--;
                    }

                    isPolynomial = polyCount>1;

                    if(isCalculable)
                    {

                        int len = coeffs.size() - 1;
                        equ = makePolyEquation(len);

                        int foundRoots = 0;
                        isImaginary=false;
                        isIrrational=false;
                        int lent = len;

                        if (isPolynomial)
                        {
                            while (foundRoots < lent && coeffs.size() > 1 && !isImaginary && !isIrrational) {
                                double p, q = 0;
                                rList.clear();
                                pList.clear();
                                qList.clear();


                                p = Math.abs(coeffs.get(len));

                                if(p!=0) {
                                    for (int ii = 0; ii < len; ii++) {
                                        if (coeffs.get(ii) != 0) {
                                            q = Math.abs(coeffs.get(ii));
                                            break;
                                        }
                                    }

                                    for (int y = 1; y <= Math.sqrt(p); y++) {
                                        if (p % y == 0) {
                                            pList.add((double)y);
                                            pList.add(p/y);
                                        }
                                    }
                                    for (int y = 1; y <= Math.sqrt(q); y++) {
                                        if (q % y == 0) {
                                            qList.add((double)y);
                                            qList.add(q/y);
                                        }
                                    }

                                    for(double pr : pList)
                                    {
                                        for(double qr : qList)
                                        {
                                            double d = pr/qr;
                                            if(!rList.contains(d))
                                            {
                                                rList.add(d);
                                            }
                                            if(!rList.contains(-d))
                                            {
                                                rList.add(-d);
                                            }
                                        }
                                    }
                                }
                                else
                                {
                                    rList.add(0.0);
                                }

                                for(int ii=0;ii<rList.size();ii++) {
                                    double r = rList.get(ii);
                                    if (isRemainderZero(r, coeffs)) {
                                        foundRoots++;
                                        coeffs = doSyntheticDivide(r, coeffs);
                                        len--;
                                        if(real_roots.contains(r)) {
                                            rootMultiplicity.put(r, rootMultiplicity.get(r) + 1);
                                        }
                                        else {
                                            rootMultiplicity.put(r, 1);
                                            real_roots.add(r);
                                        }

                                        break;
                                    }
                                    else if(!isRemainderZero(r, coeffs) && ii==rList.size()-1)
                                    {
                                        isIrrational = true;
                                    }
                                }

                            }

                            if(isIrrational && len==2)
                            {
                                isIrrational = false;
                                isImaginary=false;
                                double a,b,c,d;
                                a=coeffs.get(0);
                                b=coeffs.get(1);
                                c=coeffs.get(2);

                                d=(Math.pow(b,2)) + (-4)*a*c;
                                foundRoots += 2;
                                len -= 2;

                                if(d>=0)
                                {
                                    double r = (-b + Math.sqrt(d))/(2*a);
                                    double rr = (-b - Math.sqrt(d))/(2*a);

                                    if(real_roots.contains(r)) {
                                        rootMultiplicity.put(r, rootMultiplicity.get(r) + 1);
                                    }
                                    else {
                                        rootMultiplicity.put(r, 1);
                                        real_roots.add(r);
                                    }

                                    if(real_roots.contains(rr)) {
                                        rootMultiplicity.put(rr, rootMultiplicity.get(rr) + 1);
                                    }
                                    else {
                                        rootMultiplicity.put(rr, 1);
                                        real_roots.add(rr);
                                    }
                                }
                                else
                                {
                                    String real_d;
                                    boolean before = false;

                                    if(looksLikeInteger(Math.sqrt(Math.abs(d))))
                                    {
                                        d = Math.sqrt(Math.abs(d));
                                        if(looksLikeInteger(d/(2*a)))
                                        {
                                            d/=(2*a);
                                            int rd = (int)d;
                                            real_d = String.valueOf(rd);
                                        }
                                        else {
                                            int rd = (int)d;
                                            real_d = String.valueOf(rd) + "/" + String.valueOf((int)(2*a));
                                            before = true;
                                        }
                                    }
                                    else {
                                        int rd = (int) Math.abs(d);

                                        real_d = "\u221A" + "[" + String.valueOf(rd) + "]/" + String.valueOf((int)(2*a));
                                        Log.d("WHAT IS REAL_D:", String.valueOf(real_d));
                                        before = true;
                                    }


                                    double aos = (-b) / (2*a);

                                    String cpx1, cpx2;
                                    if(aos!=0) {
                                        if(!before) {
                                            cpx1 = String.valueOf(aos) + " - " + real_d + "i";
                                            cpx2 = String.valueOf(aos) + " + " + real_d + "i";
                                        }
                                        else
                                        {
                                            cpx1 = String.valueOf(aos) + " - " + "i" + real_d;
                                            cpx2 = String.valueOf(aos) + " + " + "i" + real_d;
                                        }
                                    }
                                    else {
                                        if(!before) {
                                            cpx1 = real_d + "i";
                                            cpx2 = real_d + "i";
                                        }
                                        else
                                        {
                                            cpx1 = "i" + real_d;
                                            cpx2 = "i" + real_d;
                                        }
                                    }

                                    if(cpx_roots.contains(cpx1)) {
                                        cpxMultiplicity.put(cpx1, cpxMultiplicity.get(cpx1) + 1);
                                    }
                                    else {
                                        cpxMultiplicity.put(cpx1, 1);
                                        cpx_roots.add(cpx1);
                                    }

                                    if(cpx_roots.contains(cpx2)) {
                                        cpxMultiplicity.put(cpx2, cpxMultiplicity.get(cpx2) + 1);
                                    }
                                    else {
                                        cpxMultiplicity.put(cpx2, 1);
                                        cpx_roots.add(cpx2);
                                    }

                                    isImaginary=true;
                                }
                            }

                                equ = superscript(equ);

                                equation.setTextColor(Color.parseColor("#000000"));
                                equation.setText(equ);
                                String ans = "x = ";
                                if(foundRoots!=0) {

                                    for (int ii = 0; ii < real_roots.size(); ii++) {
                                        if (ii == real_roots.size() - 1) {
                                            ans += String.valueOf(real_roots.get(ii)) + "(" + rootMultiplicity.get(real_roots.get(ii)) + ") ";
                                        } else {
                                            ans += String.valueOf(real_roots.get(ii)) + "(" + rootMultiplicity.get(real_roots.get(ii)) + "), ";
                                        }
                                    }

                                    if(isImaginary && len%2==0)
                                    {
                                        for (int ii = 0; ii < cpx_roots.size(); ii++) {
                                            if (ii == cpx_roots.size() - 1) {
                                                ans += String.valueOf(cpx_roots.get(ii)) + " ";// + "(" + cpxMultiplicity.get(cpx_roots.get(ii)) + ") ";
                                            } else {
                                                ans += String.valueOf(cpx_roots.get(ii)) + ", ";//+"(" + cpxMultiplicity.get(cpx_roots.get(ii)) + "), ";
                                            }
                                        }

                                        if(len>0)
                                        {
                                            ans += "and " + String.valueOf(len) + " imaginary zeros";
                                            remainder_p.setVisibility(View.VISIBLE);
                                            remainder.setVisibility(View.VISIBLE);

                                            remainder.setText(superscript(makePolyEquation(len)));
                                        }
                                    }
                                    else if(isIrrational)
                                    {
                                        ans += "and " + String.valueOf(len) + " unknown zeros";
                                        remainder_p.setVisibility(View.VISIBLE);
                                        remainder.setVisibility(View.VISIBLE);

                                        remainder.setText(superscript(makePolyEquation(len)));
                                    }
                                }
                                else
                                {
                                    ans += String.valueOf(len) + " unknown zeros";
                                    remainder_p.setVisibility(View.VISIBLE);
                                    remainder.setVisibility(View.VISIBLE);

                                    remainder.setText(superscript(makePolyEquation(len)));
                                }

                                answer.setTextColor(Color.parseColor("#000000"));
                                answer.setText(ans);

                        }
                        else
                        {
                            answer.setTextColor(Color.parseColor("#FF0000"));
                            answer.setText("Polynomials need at least 2 terms");

                            equation.setTextColor(Color.parseColor("#FF0000"));
                            equation.setText("Not enough terms for a polynomial");
                        }

                    }
                    else
                    {
                        answer.setTextColor(Color.parseColor("#FF0000"));
                        answer.setText("Remove all letters and special characters and try again");

                        equation.setTextColor(Color.parseColor("#FF0000"));
                        equation.setText("Coefficients must only contain 0-9,+ or -");
                    }
                }
                else
                {
                    answer.setTextColor(Color.parseColor("#FF0000"));
                    answer.setText("Missing Input Requirement");

                    equation.setTextColor(Color.parseColor("#FF0000"));
                    equation.setText("Missing Input Requirement");
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
