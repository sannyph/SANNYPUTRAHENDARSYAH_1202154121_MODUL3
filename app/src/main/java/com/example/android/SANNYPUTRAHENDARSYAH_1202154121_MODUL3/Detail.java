package com.example.android.SANNYPUTRAHENDARSYAH_1202154121_MODUL3;

//method default dari android yang digunakan sesuai dengan kebutuhan
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//untuk membuat class Detail dengan mengextend class AppCompatActivity
public class Detail extends AppCompatActivity {

    // untuk mendeklarasikan objek
    TextView judul, Liter;
    ImageView Foto, Baterai;

    //tipe data integer dengan variabel liters yang bernilai 0
    private int liters = 0;

    // method ketika dijalankan saat activity dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent(); // mengambil data dari activity sebelumnya
        String Title = intent.getStringExtra("Title");
        Integer Background = intent.getIntExtra("Background",0);

        judul = (TextView)findViewById(R.id.detailTitle);
        Liter = (TextView)findViewById(R.id.Liter);
        Foto = (ImageView)findViewById(R.id.detailPhoto);
        Baterai = (ImageView)findViewById(R.id.baterry);

        judul.setText(Title);
        Bottle();
        Foto.setImageResource(Background);
    }

    //method untuk melakukan penambahan
    public void onPlus(View view) {
        liters++;
        Bottle();
    }

    //method yang digunakan untuk pengurangan
    public void onMin(View view) {
        liters--;
        Bottle();
    }

    //method yang digunakan untuk melakukan pengisian volume air
    public void Bottle(){

        //melakukan pengkondisian dan menentukan gambar sesuai dengan kondisinya (20%)
        if (liters <= 0 ){ // 20%
            Liter.setText("1L");
            Baterai.setImageResource(R.drawable.ic_battery_20);
            Toast.makeText(this,"Air sedikit",Toast.LENGTH_SHORT).show();

        //melakukan pengkondisian dan menentukan gambar sesuai dengan kondisinya (50%)
        }else if (liters == 1){ // 50%
            Liter.setText("2L");
            Baterai.setImageResource(R.drawable.ic_battery_50);

        //melakukan pengkondisian dan menentukan gambar sesuai dengan kondisinya (80%)
        }else if(liters == 2){ // 80%
            Liter.setText("3L");
            Baterai.setImageResource(R.drawable.ic_battery_80);

        //melakukan pengkondisian dan menentukan gambar sesuai dengan kondisinya (100%)
        }else{ // 100%
            Liter.setText("4L");
            Baterai.setImageResource(R.drawable.ic_battery_full);
            Toast.makeText(this,"Air penuh",Toast.LENGTH_SHORT).show();
        }
    }
}
