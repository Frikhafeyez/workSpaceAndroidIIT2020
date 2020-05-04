package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Parametres extends AppCompatActivity {

   /* private RadioGroup rdgMode;
    private SeekBar seekBar;
    private Button btnEnregistrer;
    */

    @BindView(R.id.rdgMode)
    RadioGroup rdgMode;
    @BindView(R.id.rdJour)
    RadioButton rdJour;
    @BindView(R.id.rdNuit)
    RadioButton rdNuit;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.btnEnregistrer)
    Button btnEnregistrer;

    String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
        ButterKnife.bind(this);
        UserId = this.getIntent().getStringExtra("UserId");
        //init();
    }

    @OnClick(R.id.btnEnregistrer)
    public void onViewClicked() {
//        SharedPreferences p = getSharedPreferences("parametres", MODE_PRIVATE);
//        SharedPreferences.Editor ed = p.edit();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference RefUsers = database.getReference("users");
//        DatabaseReference RefMode = database.getReference("mode");
//        DatabaseReference RefTaille = database.getReference("taille");


        String mode="";
        switch (rdgMode.getCheckedRadioButtonId()){
            case R.id.rdJour: mode = "jour"; break;
            case R.id.rdNuit: mode = "nuit"; break;
        }

    int taille = seekBar.getProgress();
    RefUsers.child(UserId).child("mode").setValue(mode);
    RefUsers.child(UserId).child("taille").setValue(taille);
//    RefMode.setValue(mode);
//    RefTaille.setValue(taille);

//    ed.putString("mode",mode);
//    ed.putInt("taille",taille);
//    ed.commit();
        Toast.makeText(getApplicationContext(),"Paramétre enregistrés",Toast.LENGTH_LONG).show();
        finish();
    }
}
