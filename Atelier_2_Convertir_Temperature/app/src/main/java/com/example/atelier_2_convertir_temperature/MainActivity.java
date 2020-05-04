package com.example.atelier_2_convertir_temperature;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_C ,btn_F ;
    private EditText editText_F;
    private EditText editText_C ;
    private RelativeLayout relative_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        ajouterEcouteur();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void colorer() {
        float temp = Float.parseFloat(editText_C.getText().toString());
        if (temp <= 0){
          //relative_layout.setBackgroundColor(Color.BLACK);
          editText_C.setBackgroundColor(Color.BLACK);
          editText_F.setBackgroundColor(Color.BLACK);
          editText_C.setTextColor(Color.WHITE);
          editText_F.setTextColor(Color.WHITE);

      }
        if (temp <= 20 && temp > 0){
            editText_C.setBackgroundColor(Color.BLUE);
            editText_F.setBackgroundColor(Color.BLUE);
            editText_C.setTextColor(Color.WHITE);
            editText_F.setTextColor(Color.WHITE);
        }
        if (temp <= 30 && temp > 20 ){
            editText_C.setBackgroundColor(Color.GREEN);
            editText_F.setBackgroundColor(Color.GREEN);
            editText_C.setTextColor(Color.BLACK);
            editText_F.setTextColor(Color.BLACK);
        }
        if (temp > 30){
            editText_C.setBackgroundColor(Color.GRAY);
            editText_F.setBackgroundColor(Color.GRAY);
            editText_C.setTextColor(Color.RED);
            editText_F.setTextColor(Color.RED);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void convertirDC_To_DF() {
        try {
            float c ,f;
            c = Float.parseFloat(editText_C.getText().toString());
            f = (c*9)/5+32;
            editText_F.setText(String.valueOf(f));
            colorer();

        }catch (Exception e){
            Toast t = Toast.makeText(getApplicationContext(),
                    "La  températeur °C est vide ",Toast.LENGTH_LONG);
            t.show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void convertirDF_To_DC() {
        try {
            float c ,f;
            f = Float.parseFloat(editText_F.getText().toString());
            c = (f-32)*5/9;
//          editText_C.setText(String.valueOf(c));
            editText_C.setText(c+"");
            colorer();

        }catch (Exception e){
            Toast t = Toast.makeText(getApplicationContext(),
                    "La  températeur °F est vide ",Toast.LENGTH_LONG);
            t.show();
        }
    }

    private void ajouterEcouteur() {
        btn_F.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                convertirDF_To_DC();
            }
        });
        btn_C.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                convertirDC_To_DF();
            }
        });
    }

    private void init() {
        relative_layout = findViewById(R.id.relative_layout);
        btn_C = findViewById(R.id.btn_C);
        btn_F = findViewById(R.id.btn_F);
        editText_C = findViewById(R.id.editText_C);
        editText_F = findViewById(R.id.editText_F);
    }
}
