package com.example.atelier_3_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Personaliser extends AppCompatActivity {

    private EditText editText_carre;
    private EditText editText_rayon ;
    private EditText editText_largeur , editText_longeur;

    private TextView textView_resultat_surface , textView_resultat_perimetre;
    private Spinner sp ;
    private Button btn_cal_per ;
    private LinearLayout layout_rectangle ,layout_carre ,layout_cercle ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaliser);
        init();
    }

    private void init() {
        sp = (Spinner) findViewById(R.id.sp);
        layout_rectangle = (LinearLayout) findViewById(R.id.layout_rectangle);
        layout_carre = (LinearLayout) findViewById(R.id.layout_carre);
        layout_cercle = (LinearLayout) findViewById(R.id.layout_cercle);

        editText_carre = findViewById(R.id.editText_carre);
        editText_rayon = findViewById(R.id.editText_rayon);
        editText_largeur = findViewById(R.id.editText_largeur);
        editText_longeur = findViewById(R.id.editText_longeur);

        btn_cal_per = findViewById(R.id.btn_cal_per);

        textView_resultat_surface = findViewById(R.id.textView_resultat_surface);
        textView_resultat_perimetre = findViewById(R.id.textView_resultat_perimetre);

        ecouter();
    }

    private void ecouter() {
        btn_cal_per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                traiter();
            }
        });
    }

    private void traiter() {
        int pos = sp.getSelectedItemPosition();
        switch (pos) {
            case 0:
                layout_rectangle.setVisibility(View.VISIBLE);
                layout_carre.setVisibility(View.GONE);
                layout_cercle.setVisibility(View.GONE);
                float largeur = Float.parseFloat(editText_largeur.getText().toString());
                float longeur = Float.parseFloat(editText_longeur.getText().toString());
                textView_resultat_surface.setText(String.valueOf(longeur * largeur)+"m²");
                textView_resultat_perimetre.setText(String.valueOf(2*(longeur+largeur))+"m");
                break;

            case 1:
                layout_rectangle.setVisibility(View.GONE);
                layout_carre.setVisibility(View.VISIBLE);
                layout_cercle.setVisibility(View.GONE);
                float cote = Float.parseFloat(editText_carre.getText().toString());
                textView_resultat_surface.setText(String.valueOf(Math.pow(cote,2))+"m²");
                textView_resultat_perimetre.setText(String.valueOf(4*cote)+"m");
                break;

            case 2:
                layout_rectangle.setVisibility(View.GONE);
                layout_carre.setVisibility(View.GONE);
                layout_cercle.setVisibility(View.VISIBLE);
                float rayon = Float.parseFloat(editText_rayon.getText().toString());
                textView_resultat_surface.setText(String.valueOf(Math.PI* Math.pow(rayon,2))+"m²");
                textView_resultat_perimetre.setText(String.valueOf(2*(Math.PI* rayon))+"m");
                break;
        }
    }
}