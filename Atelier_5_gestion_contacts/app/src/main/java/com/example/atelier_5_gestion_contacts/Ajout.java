package com.example.atelier_5_gestion_contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Ajout extends AppCompatActivity {

    EditText editText_nom,editText_prenom,editText_telephone;
    Button btn_envoyer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        init();
    }

    private void init() {
        editText_nom = findViewById(R.id.editText_nom);
        editText_telephone = findViewById(R.id.editText_telephone);
        editText_prenom = findViewById(R.id.editText_prenom);
        btn_envoyer = findViewById(R.id.btn_envoyer);
    ecouteur();
    }

    private void ecouteur() {

    }

}
