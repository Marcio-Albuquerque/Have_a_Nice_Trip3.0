package com.example.marcioalbuquerque.haveanicetrip;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class GastoListActivity extends ListActivity implements AdapterView.OnItemClickListener {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                    listarGastos()));
            ListView listView = getListView();
            listView.setOnItemClickListener(this);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView textView = (TextView) view;
            Toast.makeText(this, "Gasto selecionado: "
                    + textView.getText(), Toast.LENGTH_SHORT).show();
        }

        private List<String> listarGastos() {
            return Arrays.asList("Pastel R$ 4,50",
                    "Transfer R$ 100,00",
                    "Livro R$ 74,00");
        }
}
