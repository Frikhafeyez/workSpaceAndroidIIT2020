package com.example.atelier_3_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Carre extends AppCompatActivity {

    private EditText editText_carre;
    private Button btn_carre;
    private TextView textView_resultat_s_carre ,textView_resultat_p_carre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carre);

        init();
    }

    private void init() {

        editText_carre = findViewById(R.id.editText_carre);
        btn_carre = findViewById(R.id.btn_carre);
        textView_resultat_s_carre = findViewById(R.id.textView_resultat_s_carre);
        textView_resultat_p_carre = findViewById(R.id.textView_resultat_p_carre);
        ecouteur();
    }

    private void ecouteur() {
        btn_carre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perimetre();
                surface();
            }
        });
    }

    private void surface() {
        float largeur = Float.parseFloat(editText_carre.getText().toString());
      //  float longeur = Float.parseFloat(editText_longeur.getText().toString());
        textView_resultat_s_carre.setText(String.valueOf(Math.pow(largeur,2))+"m²");
    }

    private void perimetre() {
       // float largeur = Float.parseFloat(editText_largeur.getText().toString());
        float longeur = Float.parseFloat(editText_carre.getText().toString());
        textView_resultat_p_carre.setText(String.valueOf(4*longeur)+"m");

    }
}