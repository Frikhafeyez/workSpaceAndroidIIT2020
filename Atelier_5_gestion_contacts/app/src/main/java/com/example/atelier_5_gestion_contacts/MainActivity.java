package com.example.atelier_5_gestion_contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_add ;
    private ListView list_contacts;

    ArrayAdapter<Personne> adapter;
    ArrayList<Personne> listPers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        btn_add = findViewById(R.id.btn_add);
        list_contacts = findViewById(R.id.list_contacts);
        // initialisation du adapter
        listPers = new ArrayList<Personne>();
        adapter = new ArrayAdapter<Personne>(this,android.R.layout.simple_spinner_item,listPers);
        // Lier adapter au ListView
        list_contacts.setAdapter(adapter);
        ecouteur();
    }
    private void ecouteur() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Ajout.class);
                startActivityForResult(i,999);
                //on peut pas ajouter startActivity
                // car startActivity ne permet pas de retourner une resultat (des données)
                // requestCode permet de savaoir le activity responsable de la reponse
            }
        });
        // list_contacts.setOnItemLongClickListener();
    }
}
