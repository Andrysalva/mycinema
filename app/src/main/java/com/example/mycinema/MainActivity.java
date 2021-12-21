package com.example.mycinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String film[] = {"Spiderman", "Titanic", "Balle Spaziali"};
    ListView lvFilm;
    Button btnEsci;
    Context context;
    private SharedViewModel sharedViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        sharedViewModel.initMap();

        lvFilm = (ListView) findViewById(R.id.lvFilm);
        btnEsci = (Button) findViewById(R.id.btnEsci);
        context = (Context) getApplicationContext();

        ArrayAdapter<String> aaFilm = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, film);
        lvFilm.setAdapter(aaFilm);

        /*btnEsci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "stai per uscire", Toast.LENGTH_LONG).show();
            }
        });*/
        lvFilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String titolo = (String) lvFilm.getItemAtPosition(i);
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("film", titolo.toString());
                startActivity(intent);
                Toast.makeText(getApplicationContext(), titolo, Toast.LENGTH_LONG).show();
            }
        });
    }
}