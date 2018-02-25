package com.example.android.SANNYPUTRAHENDARSYAH_1202154121_MODUL3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    //menset edittext
    EditText UserName, Password;

    //method yang dilakukan saat activity akan dimulai
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UserName = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
    }

    //persyaratan login
    public void onLogin(View view) {
        if (UserName.getText().toString().equals("EAD") && Password.getText().toString().equals("MOBILE")){

            //menampilkan toast saat login benar
            Toast.makeText(getApplicationContext(),"Login Berhasil", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            //menampilkan toast saat login salah
            Toast.makeText(getApplicationContext(),"Login Gagal", Toast.LENGTH_SHORT).show();
            //akan mengembalikan kolom ke posisi kosong
            UserName.setText("");
            Password.setText("");
        }
    }
}
