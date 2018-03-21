package com.example.guillermo.webservice01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button click;
    public static TextView datapais;
    public static TextView dataciudad;
    public static TextView dataclima;
    public static TextView datatempmin;
    public static TextView datatempmax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.getBtn);
        datapais = (TextView) findViewById(R.id.txtpais);
        dataciudad = (TextView) findViewById(R.id.txtCiudad);
        dataclima = (TextView) findViewById(R.id.txtClima);
        datatempmin = (TextView) findViewById(R.id.txtTempMin);
        datatempmax = (TextView) findViewById(R.id.txtTempMax);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJson process = new GetJson();
                process.execute();
            }
        });

    }
}
