package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class User extends AppCompatActivity {
    Button btnLogOut;
    TextView tvBien;
    LinearLayout LL;
    FirebaseAuth firebaseAuth;
    String UserId ;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        UserId = this.getIntent().getStringExtra("UserId");

        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        LL = (LinearLayout) findViewById(R.id.LL);
        tvBien = (TextView) findViewById(R.id.tvBien);


        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(User.this, Login.class);
                startActivity(I);
                finish();
            }
        });
        //frikhafeyez@gmail.com
        //11074131
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mParam)
        {
            Intent i = new Intent(User.this,Parametres.class);
            i.putExtra("UserId",UserId);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        recuperer();
        super.onResume();
    }

    private void recuperer() {
//        SharedPreferences p = getSharedPreferences("parametres", MODE_PRIVATE);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference RefUsers = database.getReference("users");
        DatabaseReference RefMode = RefUsers.child(UserId).child("mode");
        DatabaseReference RefTaille =RefUsers.child(UserId).child("taille");

//        DatabaseReference RefMode = database.getReference("mode");
//        DatabaseReference RefTaille = database.getReference("taille");


//        if (p!=null) {
//            String mode = p.getString("mode", "jour");
//            int taille = p.getInt("taille", 0);

            RefMode.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()){
                        String mode = dataSnapshot.getValue(String.class);
                        if (mode.equals("jour")) {
                            LL.setBackgroundColor(Color.WHITE);
                            tvBien.setTextColor(Color.BLACK);
                        } else {
                            LL.setBackgroundColor(Color.BLACK);
                            tvBien.setTextColor(Color.WHITE);
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

//            RefTaille.addValueEventListener(new ValueEventListener() {
            RefTaille.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   if (dataSnapshot.exists()){
                       int taille = dataSnapshot.getValue(Integer.class);
                       switch (taille) {
                           case 0:
                               tvBien.setTextSize(15);
                               btnLogOut.setTextSize(15);
                               break;
                           case 1:
                               tvBien.setTextSize(25);
                               btnLogOut.setTextSize(25);
                               break;
                           case 2:
                               tvBien.setTextSize(35);
                               btnLogOut.setTextSize(35);
                               break;
                       }
                   }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        //}
    }
}
