package com.example.cv_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int i=0;
    String array[];
    private TextView textView_CONTACTS, textView_CERTIFICATS , textView_SKILLS;
    private TextView textView_COURCE , textView5EXPERIENCE,textView_LANGUE ,textView_INFORMATION;

    private EditText editText_Level ,editText_info , editText_URL_linkedin ;
    private EditText editText_certificats , editText_skills , editText_langue ;
    private EditText editText_ful_name , editText_course , editText_experience ;
    private EditText editText_E_mail , editText_Cle_pays , editText_phone;

    private Button btn_import_photo_profil , btn_add_course , btn_add_experience , btn_info ;
    private Button btn_add_certificats , btn_add_skills ,btn_add_langue, btn_add_contacts ;

    private ListView list_course , list_experience ,list_certificats ;
    private ListView list_langue , list_info , list_skills ,list_Contacts;

    private ArrayAdapter<String> adapter_list_course  ;
    private ArrayAdapter<String> adapter_list_experience  ;
    private ArrayAdapter<String> adapter_list_certificats  ;
    private ArrayAdapter<String> adapter_list_skills  ;
    private ArrayAdapter<String> adapter_list_langue  ;
    private ArrayAdapter<String> adapter_list_info ;
    private ArrayAdapter<String> adapter_Contacts ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        lier_adapter_list ();
    }

    public void lier_adapter_list (){

        adapter_list_course = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item);
        list_course.setAdapter(adapter_list_course);

        adapter_list_experience = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item);
        list_experience.setAdapter(adapter_list_experience);

        adapter_list_certificats = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item);
        list_certificats.setAdapter(adapter_list_certificats);

        adapter_list_info = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item);
        list_info.setAdapter(adapter_list_info);

        adapter_list_skills = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item);
        list_skills.setAdapter(adapter_list_skills);

        adapter_list_langue = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item);
        list_langue.setAdapter(adapter_list_langue);

        adapter_Contacts = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        list_Contacts.setAdapter(adapter_Contacts);

        }

    private void init() {

        textView_CONTACTS = findViewById(R.id.textView_CONTACTS);
        textView_CERTIFICATS = findViewById(R.id.textView_CERTIFICATS);
        textView_SKILLS = findViewById(R.id.textView_SKILLS);
        textView_COURCE = findViewById(R.id.textView_COURCE);
        textView5EXPERIENCE = findViewById(R.id.textView5EXPERIENCE);
        textView_LANGUE = findViewById(R.id.textView_LANGUE);
        textView_INFORMATION= findViewById(R.id.textView_INFORMATION);

        editText_Level = findViewById(R.id.editText_Level);
        editText_info = findViewById(R.id.editText_info);
        editText_URL_linkedin = findViewById(R.id.editText_URL_linkedin);
        editText_certificats = findViewById(R.id.editText_certificats);
        editText_skills = findViewById(R.id.editText_skills);
        editText_langue = findViewById(R.id.editText_langue);
        editText_ful_name = findViewById(R.id.editText_ful_name);
        editText_course= findViewById(R.id.editText_course);
        editText_experience = findViewById(R.id.editText_experience);
        editText_E_mail = findViewById(R.id.editText_E_mail);
        editText_Cle_pays = findViewById(R.id.editText_Cle_pays);
        editText_phone = findViewById(R.id.editText_phone);


        btn_import_photo_profil = findViewById(R.id.btn_import_photo_profil);
        btn_add_course = findViewById(R.id.btn_add_course);
        btn_add_experience = findViewById(R.id.btn_add_experience);
        btn_add_certificats = findViewById(R.id.btn_add_certificats);
        btn_info = findViewById(R.id.btn_info);
        btn_add_skills = findViewById(R.id.btn_add_skills);
        btn_add_langue= findViewById(R.id.btn_add_langue);
        btn_add_contacts = findViewById(R.id.btn_add_contacts);

        list_course  = findViewById(R.id.list_course );
        list_certificats = findViewById(R.id.list_certificats);
        list_experience = findViewById(R.id.list_experience);
        list_skills = findViewById(R.id.list_skills);
        list_langue  = findViewById(R.id.list_langue );
        list_info = findViewById(R.id.list_info);
        list_Contacts = findViewById(R.id.list_Contacts);

        ecouteur();
    }

    private void ecouteur() {

        btn_import_photo_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajout_photo();
            }
        });

        btn_add_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter_list_view(editText_course , adapter_list_course , textView_COURCE );
            }
        });
        btn_add_experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter_list_view(editText_experience , adapter_list_experience , textView5EXPERIENCE );
            }
        });
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter_list_view(editText_info , adapter_list_info , textView_INFORMATION );
            }
        });
        btn_add_certificats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter_list_view(editText_certificats , adapter_list_certificats , textView_CERTIFICATS );
            }
        });
        btn_add_skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter_list_view(editText_skills , adapter_list_skills , textView_SKILLS );
            }
        });
        btn_add_langue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter_list_view(editText_langue , adapter_list_langue , textView_LANGUE );
            }
        });
        btn_add_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_contacts();
            }
        });

    }

    private void add_contacts() {
        String URL_linkedin = editText_URL_linkedin.getText().toString();
        String E_mail = editText_E_mail.getText().toString();
        String Cle_pays = editText_Cle_pays.getText().toString();
        String phone =editText_phone.getText().toString();

        if (!URL_linkedin.isEmpty() && !E_mail.isEmpty() && !Cle_pays.isEmpty() && !phone.isEmpty() ){
           /* array[1]= URL_linkedin;
            array[2]=E_mail;
            array[3]=Cle_pays+" "+phone;
            array[4]="******************";

            */

            adapter_Contacts.add(URL_linkedin);
            adapter_Contacts.add(E_mail);
            adapter_Contacts.add(Cle_pays+" "+phone);
            adapter_Contacts.add("******************");

            editText_URL_linkedin.setText("");
            editText_E_mail.setText("");
            editText_Cle_pays.setText("");
            editText_phone.setText("");
        }
        else{
            Toast t = Toast.makeText(getApplicationContext(),
                    "Vérifier le block CONTACTS !! \n Veuillez lui ressaisir ...",Toast.LENGTH_LONG);
            t.show();
        }

    }

    private void ajout_photo() {
    }

    private void ajouter_list_view(EditText editText , ArrayAdapter adapter , TextView textView) {
        String s = editText.getText().toString();
        String text = textView.getText().toString();

        if (!s.isEmpty()){
            adapter.add(s);
            editText.setText("");
        }
        else{
            Toast t = Toast.makeText(getApplicationContext(),
                    text+" est vide \n Veuillez lui saisir  ",Toast.LENGTH_LONG);
            t.show();
        }
    }
}