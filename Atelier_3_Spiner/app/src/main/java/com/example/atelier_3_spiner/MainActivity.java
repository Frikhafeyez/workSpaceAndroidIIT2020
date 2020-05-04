package com.example.atelier_3_spiner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner sp ;
    private Button btn_valider ;

    @Override
    protected void onStart() {
        super.onStart();
        afficher("onStart");
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        afficher("onRestoreInstanceState");
        int n=savedInstanceState.getInt("compteur");
      //  btn_num.setText(n+"");
    }

    @Override
    protected void onStop() {
        super.onStop();
        afficher("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        afficher("onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        afficher("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        afficher("onResume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        sp = findViewById(R.id.sp);
        btn_valider= findViewById(R.id.btn_valider);
        ecouteur();
    }

    private void ecouteur() {
        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valider();
            }
        });
    }

    private void valider() {
        int pos = sp.getSelectedItemPosition();
        Intent i = null ;
        switch (pos){
            case 0 :
                i= new Intent(MainActivity.this , Rectangle.class);
            break;
            case 1 :
                i= new Intent(MainActivity.this , Carre.class);
            break;
            case 2 :
                i= new Intent(MainActivity.this , Cercle.class);
            break;
            case 3 :
                i= new Intent(MainActivity.this , Personaliser.class);
            break;
        }
        startActivity(i);
    }

    private void afficher(String s) {
        Toast.makeText(getApplicationContext(),s+" "+this.getClass().getName(), Toast.LENGTH_SHORT).show();
    }
}
