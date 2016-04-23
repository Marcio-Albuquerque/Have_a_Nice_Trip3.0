package com.example.marcioalbuquerque.haveanicetrip;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.Calendar;

public class GastoActivity extends AppCompatActivity {

    private int ano, mes, dia;
    private Button dataGasto;
    private Spinner categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto);
        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(calendar.YEAR);
        mes = calendar.get(calendar.MONTH);
        dia = calendar.get(calendar.DAY_OF_MONTH);

        dataGasto = (Button)findViewById(R.id.data);

        dataGasto.setText(dia + "/" + (mes+1) + "/" + ano);

        //I don't know it --->Ler uma aqui de string !!!!!!!!!!!

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categoria_gasto, android.R.layout.simple_spinner_item);

        categoria = (Spinner) findViewById(R.id.categoria);

        //I don't now it
        categoria.setAdapter(adapter);
    }

    public  void  selecionarData(View view){
        //Whats ?????
        showDialog(view.getId());
    }

    protected Dialog onCreateDialog(int id){
        if(R.id.data==id){
            return  new DatePickerDialog(this,listener,ano,mes,dia);
        }
        return null;

    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            dataGasto.setText(dia + "/" + (mes+1) + "/" + ano);
        }
    };


}
