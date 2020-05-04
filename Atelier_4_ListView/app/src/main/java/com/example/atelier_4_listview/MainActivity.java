package com.example.atelier_4_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_Pays;
    private Button btn_ajouter , btn_vider;
    private ListView list_view;
    private ArrayAdapter<String> adapter  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        editText_Pays = findViewById(R.id.editText_Pays);
        btn_ajouter = findViewById(R.id.btn_ajouter);
        btn_vider = findViewById(R.id.btn_vider);
        list_view = findViewById(R.id.list_view);

        ecouteur();
        lier();
    }
    public void lier (){

        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item);
        list_view.setAdapter(adapter);
    }

    private void ecouteur() {
        btn_vider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vider();
            }
        });
        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter_list_view();
            }
        });
    }

    private void ajouter_list_view() {
        String s = editText_Pays.getText().toString();
        if (!s.isEmpty()){
            adapter.add(s);
            editText_Pays.setText("");
        }
        else{
            Toast t = Toast.makeText(getApplicationContext(),
                    "Pays est vide \n Veuillez tapper votre pays ",Toast.LENGTH_LONG);
            t.show();
        }
   }

    private void vider() {
        adapter.clear();
    }
}
