package com.example.android.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.text.NumberFormat;
import java.lang.String;
import bsh.EvalError;
import bsh.Interpreter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


    }
    String expression="";
    String x="";
    String a;

    public void one(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+1;
        display(expression);
    }
    public void two(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+2;
        display(expression);
    }
    public void three(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+3;
        display(expression);
    }
    public void four(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+4;
        display(expression);
    }
    public void five(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+5;
        display(expression);
    }
    public void six(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+6;
        display(expression);
    }
    public void seven(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+7;
        display(expression);
    }
    public void eight(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+8;
        display(expression);
    }
    public void nine(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+9;
        display(expression);
    }
    public void zero(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+0;
        display(expression);
    }
    public void dot(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        if(expression.length()==0)
            expression="0";
        expression=expression+'.';
        display(expression);
    }

    public void openBracket(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+" ( ";
        display(expression);
    }

    public void closeBracket(View view){
        if(x.length()!=0){
            x="";
            expression="";
        }
        expression=expression+" ) ";
        display(expression);
    }


    public void plus(View view){
        if(x.length()!=0) {
            expression = x;
            x = "";
        }
        if(expression.length()!=0) {
            a = expression.substring(expression.length() - 1);
            if (!"+".equals(a) && !"-".equals(a) && !"*".equals(a) && !"/".equals(a)) {
                expression = expression + " " + '+' + " ";
                display(expression);
            }
        }
        else
            display("0");

    }
    public void minus(View view){
        if(x.length()!=0) {
            expression = x;
            x = "";
        }
        if(expression.length()!=0) {
            a = expression.substring(expression.length() - 1);
            if (!"+".equals(a) && !"-".equals(a) && !"*".equals(a) && !"/".equals(a)) {
                expression = expression + " " + '-' + " ";
                display(expression);
            }
        }
        else {
            expression = expression+"-";
            display(expression);
        }
    }
    public void multiplication(View view){
        if(x.length()!=0) {
            expression = x;
            x = "";
        }
        if(expression.length()!=0) {
            a = expression.substring(expression.length() - 1);
            if (!"+".equals(a) && !"-".equals(a) && !"*".equals(a) && !"/".equals(a)) {
                expression = expression + " " + '*' + " ";
                display(expression);
            }
        }
        else
            display("0");
    }
    public void division(View view){
        if(x.length()!=0) {
            expression = x;
            x = "";
        }
        if(expression.length()!=0) {
            a = expression.substring(expression.length() - 1);
            if (!"+".equals(a) && !"-".equals(a) && !"*".equals(a) && !"/".equals(a)) {
                expression = expression + " " + '/' + " ";
                display(expression);
            }
        }
        else
            display("0");
    }

    public void c(View view){
        expression="";
        x="";
        display("0");
        displayResult("0");
    }

    public void backspace(View view){
        if(expression.length()>1){
            char b=expression.charAt(expression.length()-1);
            if(Character.isDigit(b) || expression.charAt(expression.length()-1) == '.')
                expression=expression.substring(0,expression.length()-1);
            else
                expression=expression.substring(0,expression.length()-3);
            display(expression);
        }
        else {
            expression = "";
            display("0");
        }

    }

    public void result(View view)  {
        double a;
        int b;
        if(!expression.equals("")) {
            try {
                x = EvaluateString.evaluate(expression);
                // Interpreter interpreter = new Interpreter();
                //  x = interpreter.eval(expression).toString();
                if (Character.isDigit(x.charAt(0))) {
                    a = Double.parseDouble(x);
                    if (a % 1 == 0) {
                        b = (int) a;
                        displayResult(String.valueOf(b));
                    } else
                        displayResult(x);
                }
                displayResult(x);
            }catch(Exception e){
                expression="";
                display("Wrong Expression");
            }
        }
        else
            expression="";
    }
    private void display(String message) {
        TextView Input_Number = (TextView) findViewById(R.id.Input_Number);
        Input_Number.setText(message);
    }

   /* private void displayResult(int number) {
        TextView Show_Result = (TextView) findViewById(R.id.Show_Result);
        Show_Result.setText(NumberFormat.getInstance().format(number));
    }*/

    private void displayResult(String message) {
        TextView Show_Result = (TextView) findViewById(R.id.Show_Result);
        Show_Result.setText(message);
    }
}
