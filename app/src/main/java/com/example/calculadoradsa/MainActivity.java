package com.example.calculadoradsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //posibles operaciones que nos harán falta para determinar operacion
    boolean decimal = false;
    boolean suma = false;
    boolean resta = false;
    boolean multiplicacion = false;
    boolean division = false;

    //elementos necesarios
    Double dato;
    Switch sw;

    //resultados
    Double[] numero = new Double[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw = (Switch)findViewById(R.id.switch1);



        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);
        Button buttonComa = (Button) findViewById(R.id.button11);
        buttonComa.setOnClickListener(this);

        //Operaciones
        Button buttonSuma = (Button) findViewById(R.id.button16);
        buttonSuma.setOnClickListener(this);
        Button buttonResta = (Button) findViewById(R.id.button15);
        buttonResta.setOnClickListener(this);
        Button buttonDivision = (Button) findViewById(R.id.button13);
        buttonDivision.setOnClickListener(this);
        Button buttonMultiplicacion = (Button) findViewById(R.id.button14);
        buttonMultiplicacion.setOnClickListener(this);

        Button buttonSin = (Button) findViewById(R.id.buttonsin);
        buttonSin.setOnClickListener(this);
        Button buttonCos = (Button) findViewById(R.id.buttoncos);
        buttonCos.setOnClickListener(this);


        Button buttonIgual = (Button) findViewById(R.id.button17);
        buttonIgual.setOnClickListener(this);
        Button buttonAC = (Button) findViewById(R.id.button12);
        buttonAC.setOnClickListener(this);

        Switch switch1 = (Switch)findViewById(R.id.switch1);

    }


    public void onClick(View view) {

        TextView screen = (TextView) findViewById(R.id.textView);
        int BotonPulsado = view.getId();
        String text = screen.getText().toString();
        try {
            switch (BotonPulsado) {
                case R.id.button0:
                    screen.setText(text + "0");
                    break;


                case R.id.button1:
                    screen.setText(text + "1");
                    break;


                case R.id.button2:
                    screen.setText(text + "2");
                    break;


                case R.id.button3:
                    screen.setText(text + "3");
                    break;


                case R.id.button4:
                    screen.setText(text + "4");
                    break;


                case R.id.button5:
                    screen.setText(text + "5");
                    break;


                case R.id.button6:
                    screen.setText(text + "6");
                    break;


                case R.id.button7:
                    screen.setText(text + "7");
                    break;


                case R.id.button8:
                    screen.setText(text + "8");
                    break;


                case R.id.button9:
                    screen.setText(text + "9");
                    break;


                case R.id.button11:
                    if (decimal == false) {
                        screen.setText(text + ".");
                        decimal = true;
                    }
                    else return;
                    break;


                case R.id.button12:
                    screen.setText("");
                    decimal = false;
                    break;


                case R.id.button13:
                    division = true;
                    numero[0] = Double.parseDouble(text);
                    screen.setText("");
                    decimal = false;
                    break;


                case R.id.button14:
                    multiplicacion = true;
                    numero[0] = Double.parseDouble(text);
                    screen.setText("");
                    decimal = false;
                    break;


                case R.id.button15:
                    resta = true;
                    numero[0] = Double.parseDouble(text);
                    screen.setText("");
                    decimal = false;
                    break;


                case R.id.button16:
                    suma = true;
                    numero[0] = Double.parseDouble(text);
                    screen.setText("");
                    decimal = false;
                    break;


                case R.id.button17:
                    numero[1] = Double.parseDouble(text);
                    if (suma == true) {
                        dato = numero[0] + numero[1];
                        screen.setText(String.valueOf(dato));
                    } else if (resta == true) {
                        dato = numero[0] - numero[1];
                        screen.setText(String.valueOf(dato));
                    } else if (multiplicacion == true) {
                        dato = numero[0] * numero[1];
                        screen.setText(String.valueOf(dato));
                    } else if (division == true) {
                        dato = numero[0] / numero[1];
                        screen.setText(String.valueOf(dato));
                    }
                    decimal = false;
                    suma = false;
                    division = false;
                    multiplicacion = false;
                    resta = false;
                    break;


                case R.id.buttoncos:
                    if(sw.isChecked()==true) {
                        dato = (Math.cos(Double.parseDouble(text)))/Math.PI;
                        screen.setText("cos(");
                        screen.setText(String.valueOf(dato) + " π");
                    } else {
                        dato = Math.cos(Math.toRadians(Double.parseDouble(text)));
                        screen.setText("cos(");
                        screen.setText(String.valueOf(dato));
                    }
                    decimal = false;
                    break;


                case R.id.buttonsin:
                    if(sw.isChecked()==true) {
                        screen.setText("sin(");
                        dato = (Math.sin(Double.parseDouble(text)))/Math.PI;
                        screen.setText(String.valueOf(dato) + " π");
                    } else {
                        screen.setText("sin(");
                        dato = Math.sin(Math.toRadians(Double.parseDouble(text)));
                        screen.setText(String.valueOf(dato));
                    }
                    decimal = false;
                    break;
            }

        } catch (Exception e) {
            screen.setText("ERROR");
        }
    }
}