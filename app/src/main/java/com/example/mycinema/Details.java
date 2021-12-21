package com.example.mycinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Details extends AppCompatActivity {
    TextView titolo;
    Intent i;
    Button btnEsci;
    ImageView image;
    String stringa;
    private SharedViewModel sharedViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        titolo = (TextView) findViewById(R.id.titolo);
        scriviTitolo(titolo);
        init();
        Integer id = sharedViewModel.Ricerca(stringa);
        Log.i("map", "id " + id);
        image.setImageResource(id);


    }

    private void init() {
        image = (ImageView) findViewById(R.id.image);
        btnEsci = (Button) findViewById(R.id.btnEsci2);
        //sharedViewModel.initMap();
        btnEsci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /*Log.i("info", "titolo "+stringa);
        switch(stringa){
            case "Spiderman":
                image.setImageResource(R.drawable.spiderman);
                break;
            case "Balle Spaziali":
                image.setImageResource(R.drawable.ballespaziali);
                image.setScaleX((float)0.9);
                image.setScaleY((float)0.9);
                break;
            default:
                image.setImageResource(R.drawable.noimage);
                break;
        }*/
    }

    private void scriviTitolo(TextView cella) {
        i = getIntent();
        stringa = i.getStringExtra("film");
        cella.setText(stringa);
    }


}