package com.atry.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Standart extends AppCompatActivity {
    TextView inputText,outputText;
    private  String input,output,newOutput;

    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonAdd,buttonMultiply,buttonSubs,buttonDivision,buttonPoint,buttonPower,buttonEqual,buttonClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standart);
        inputText = findViewById(R.id.input_text);
        outputText=findViewById(R.id.output_text);

        button0=findViewById(R.id.btn0);
        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);
        button3=findViewById(R.id.btn3);
        button4=findViewById(R.id.btn4);
        button5=findViewById(R.id.btn5);
        button6=findViewById(R.id.btn6);
        button7=findViewById(R.id.btn7);
        button8=findViewById(R.id.btn8);
        button9=findViewById(R.id.btn9);
        buttonAdd=findViewById(R.id.addition_btn);
        buttonClear=findViewById(R.id.clear_btn);
        buttonDivision=findViewById(R.id.division_btn);
        buttonEqual=findViewById(R.id.equal_btn);
        buttonMultiply=findViewById(R.id.multiply_btn);
        buttonSubs=findViewById(R.id.substraction_btn);
        buttonPower=findViewById(R.id.power_btn);
        buttonPoint=findViewById(R.id.btnpoint);


    }
    public void onButtonClicked(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "C":
                input=null;
                output=null;
                outputText.setText("");
                inputText.setText(input);
                break;
            case "^":
                input+="^";
                solve();
                inputText.setText(input);
                break;
            case "*":
                input+="*";
                solve();
                inputText.setText(input);
                break;
            case "=":
                solve();
                break;
            case "%":
                input+="%";
                double d = Double.parseDouble(inputText.getText().toString())/100;
                outputText.setText(String.valueOf(d));
                inputText.setText(input);
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") ||  data.equals("/") || data.equals("-")){
                    solve();
                }
                input+=data;
                inputText.setText(input);

        }
        // inputText.setText(input);
    }
    private void solve(){
        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d;
                if(numbers[0].endsWith("%")){
                    numbers[0]  = numbers[0].substring(0,numbers[0].length()-1);
                    d= (Double.parseDouble(numbers[0])/100) + Double.parseDouble(numbers[1]);
                }
                else{
                    d= Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                }
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e) {
                outputText.setText("impossible");
            }
        }
        if (input.split("\\*").length == 2) {
            String numbers[] = input.split("\\*");
            try {
                double d;
                if(numbers[0].endsWith("%")){
                    numbers[0]  = numbers[0].substring(0,numbers[0].length()-1);
                    d= (Double.parseDouble(numbers[0])/100) * Double.parseDouble(numbers[1]);
                }
                else{
                    d= Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                }
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e){
                outputText.setText("impossible");
            }
        }
        if (input.split("\\/").length == 2) {
            String numbers[] = input.split("\\/");
            try {
                double d;
                if(numbers[0].endsWith("%")){
                    numbers[0]  = numbers[0].substring(0,numbers[0].length()-1);
                    d= (Double.parseDouble(numbers[0])/100) / Double.parseDouble(numbers[1]);
                }
                else{
                    d= Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                }

                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e){
                outputText.setText("impossible");
            }
        }
        if (input.split("\\^").length == 2) {
            String numbers[] = input.split("\\^");
            try {
                double d;
                if(numbers[0].endsWith("%")){
                    numbers[0]  = numbers[0].substring(0,numbers[0].length()-1);
                    d= Math.pow((Double.parseDouble(numbers[0])/100) , Double.parseDouble(numbers[1]));
                }
                else{
                    d= Math.pow((Double.parseDouble(numbers[0])) , Double.parseDouble(numbers[1]));
                }

                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d +"";
            }catch (Exception e){
                outputText.setText("impossible");
            }
        }
        if (input.split("\\-").length == 2) {
            String numbers[] = input.split("\\-");
            try {

                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d;
                    if(numbers[0].endsWith("%")){
                        numbers[0]  = numbers[0].substring(0,numbers[0].length()-1);
                        d= (Double.parseDouble(numbers[0])/100) - Double.parseDouble(numbers[1]);
                    }
                    else{
                        d= Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    }

                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText("-" + newOutput);
                    input = d +"";
                }
                else {
                    double d;
                    if(numbers[0].endsWith("%")){
                        numbers[0]  = numbers[0].substring(0,numbers[0].length()-1);
                        d= (Double.parseDouble(numbers[0])/100) - Double.parseDouble(numbers[1]);
                    }
                    else{
                        d= Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    }

                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    outputText.setText(newOutput);
                    input = d + "";
                }
            }catch (Exception e){
                outputText.setText("impossible");
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu4,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId())
        {
            case R.id.scientifique:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.standard:
                Intent j = new Intent(this,Standart.class);
                startActivity(j);
                break;

            case R.id.historique:
                Intent k = new Intent(this,Historique.class);
                startActivity(k);
                break;
            case R.id.about:
                Intent l = new Intent(this,About.class);
                startActivity(l);
                break;
        }

        return true;
    }

    private String cutDecimal(String number){
        String n [] = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }}
