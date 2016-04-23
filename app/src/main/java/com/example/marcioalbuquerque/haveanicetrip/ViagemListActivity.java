package com.example.marcioalbuquerque.haveanicetrip;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ViagemListActivity extends ListActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener {
    private AlertDialog alertDialog, dialogConfirmacao;;
    private int viagemSelecionada;
    private ArrayList<Map<String, Object>> viagens;

    private List<String> listarViagens() {
        return Arrays.asList("São Paulo", "Bonito", "Gramado", "Recife", "Sobral","Teresina");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,  int position, long id) {
        this.viagemSelecionada = position;
        alertDialog.show();
        TextView textView = (TextView) view;
        String mensagem = "Viagem selecionada:"  + textView.getText();
        Toast.makeText(getApplicationContext(), mensagem,
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, GastoListActivity.class));
    }

    @Override
    public void onClick(DialogInterface dialog, int item) {
        switch (item) {
            case 0:
                startActivity(new Intent(this, ViagemActivity.class)); break;
            case 1:
                startActivity(new Intent(this, GastoActivity.class)); break;
            case 2:
                startActivity(new Intent(this, GastoListActivity.class)); break;
            case 3:
                dialogConfirmacao.show(); break;
            case DialogInterface.BUTTON_POSITIVE:
                viagens.remove(this.viagemSelecionada);
                getListView().invalidateViews(); break;
            case DialogInterface.BUTTON_NEGATIVE:
                dialogConfirmacao.dismiss(); break;
        }
    }


    private AlertDialog criaAlertDialog() {
        final CharSequence[] items = {
                getString(R.string.editar),
                getString(R.string.novo_gasto),
                getString(R.string.gastos_realizados),
                getString(R.string.remover) };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.opcoes);
        builder.setItems(items, this);
        return builder.create();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                listarViagens()));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);

        // Realiza as outras ações
        this.alertDialog = criaAlertDialog();
        this.dialogConfirmacao = criaDialogConfirmacao();
    }

    private AlertDialog criaDialogConfirmacao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.confirmacao_exclusao_viagem);
        builder.setPositiveButton(getString(R.string.sim), this);
        builder.setNegativeButton(getString(R.string.nao), this);
        return builder.create();
    }
}



