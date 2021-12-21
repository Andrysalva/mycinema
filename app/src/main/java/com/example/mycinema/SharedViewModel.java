package com.example.mycinema;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;

public class SharedViewModel extends ViewModel {
    private static Map<String, Integer> map = new HashMap<>();

    public void initMap() {
        map.put("Spiderman", R.drawable.spiderman);
        map.put("Titanic", R.drawable.titanic);
        map.put("Balle Spaziali", R.drawable.ballespaziali);
    }

    public Integer Ricerca(String titolo) {
        Integer immagine = 0;
        if (map.containsKey(titolo)) {
            immagine = map.get(titolo);
        }
        return immagine;
    }
}
