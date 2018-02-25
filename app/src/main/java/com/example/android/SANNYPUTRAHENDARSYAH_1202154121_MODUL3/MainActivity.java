package com.example.android.SANNYPUTRAHENDARSYAH_1202154121_MODUL3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    //deklaraasi objek
    private final LinkedList<String> mListJudul = new LinkedList<>();
    private final LinkedList<String> mListSubTitle = new LinkedList<>();
    private final LinkedList<Integer> mListLatarBelakang = new LinkedList<>();
    private int mCount = 0;
    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;

    // method ketika dijalankan saat activity dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();
        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ListAdapter(this, mListJudul, mListSubTitle, mListLatarBelakang );
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
    }

    private void setData(){
        //memberikan nama pada produk atau barang
        String brands[] = {"Ades","Amidis", "Aqua", "Cleo", "Club", "Equil", "Evian", "Leminerale", "Nestle", "Pristine", "Vit"};
        for (String brand: brands) {
            mListJudul.addLast(brand);
            //deskripsi produk atau barang
            mListSubTitle.addLast("Ini adalah air minum merk "+brand);
        }
        //mengambil file gambar dari drawable
        mListLatarBelakang.addLast(R.drawable.ades);
        mListLatarBelakang.addLast(R.drawable.amidis);
        mListLatarBelakang.addLast(R.drawable.aqua);
        mListLatarBelakang.addLast(R.drawable.cleo);
        mListLatarBelakang.addLast(R.drawable.club);
        mListLatarBelakang.addLast(R.drawable.equil);
        mListLatarBelakang.addLast(R.drawable.evian);
        mListLatarBelakang.addLast(R.drawable.leminerale);
        mListLatarBelakang.addLast(R.drawable.nestle);
        mListLatarBelakang.addLast(R.drawable.pristine);
        mListLatarBelakang.addLast(R.drawable.vit);
    }
}
