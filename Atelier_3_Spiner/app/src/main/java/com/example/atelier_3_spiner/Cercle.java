package com.example.atelier_3_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cercle extends AppCompatActivity {

    private EditText editText_rayon ;
    private Button button_cercle ;
    private TextView textView_resulte_s_cercle ,textView_resulte_p_cercle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cercle);
        init();

    }

    private void init() {
        editText_rayon = findViewById(R.id.editText_rayon);
        button_cercle = findViewById(R.id.button_cercle);
        textView_resulte_s_cercle = findViewById(R.id.textView_resulte_s_cercle);
        textView_resulte_p_cercle = findViewById(R.id.textView_resulte_p_rectangle);
        ecouteur();

    }

    private void ecouteur(){
        button_cercle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perimetre();
                surface();
            }
        });
    }

    private void surface() {
        float largeur = Float.parseFloat(editText_rayon.getText().toString());
        //  float longeur = Float.parseFloat(editText_longeur.getText().toString());
        textView_resulte_s_cercle.setText(String.valueOf(Math.PI* Math.pow(largeur,2))+"m²");
    }

    private void perimetre() {
        // float largeur = Float.parseFloat(editText_largeur.getText().toString());
        float longeur = Float.parseFloat(editText_rayon.getText().toString());
        textView_resulte_p_cercle.setText(String.valueOf(2*(Math.PI* longeur))+"m");
    }
}
