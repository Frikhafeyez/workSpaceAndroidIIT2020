package com.example.atelier_3_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Rectangle extends AppCompatActivity {

    private EditText editText_largeur ,editText_longeur;
    private Button btn_rectangle;
    private TextView textView_resulte_s_rectangle , textView_resulte_p_rectangle ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        init();
    }

    private void init() {
        editText_largeur = findViewById(R.id.editText_largeur);
        editText_longeur = findViewById(R.id.editText_longeur);
        btn_rectangle = findViewById(R.id.btn_rectangle);
        textView_resulte_s_rectangle = findViewById(R.id.textView_resulte_s_rectangle);
        textView_resulte_p_rectangle = findViewById(R.id.textView_resulte_p_rectangle);
        ecouteur();
    }

    private void ecouteur() {
        btn_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perimetre();
                surface();
            }
        });
    }

    private void surface() {
        float largeur = Float.parseFloat(editText_largeur.getText().toString());
        float longeur = Float.parseFloat(editText_longeur.getText().toString());
        textView_resulte_s_rectangle.setText(String.valueOf(longeur*largeur)+"m²");
    }

    private void perimetre() {
        float largeur = Float.parseFloat(editText_largeur.getText().toString());
        float longeur = Float.parseFloat(editText_longeur.getText().toString());
        textView_resulte_p_rectangle.setText(String.valueOf(2*(longeur+largeur))+"m");
    }
}
