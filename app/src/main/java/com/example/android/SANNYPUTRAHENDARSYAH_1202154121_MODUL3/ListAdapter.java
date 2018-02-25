package com.example.android.SANNYPUTRAHENDARSYAH_1202154121_MODUL3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;


public class ListAdapter extends
    RecyclerView.Adapter<ListAdapter.WordViewHolder>   {

    // untuk mendeklarasikan objek
    private final LinkedList<String> mListJudul;
    private final LinkedList<String> mListSubtitle;
    private final LinkedList<Integer> mListLatarBelakang;
    private LayoutInflater mInflater;

    public ListAdapter(Context context, LinkedList<String> TitleList, LinkedList<String> SubTitleList, LinkedList<Integer> BackgroundList) {
        mInflater = LayoutInflater.from(context);
        this.mListJudul = TitleList;
        this.mListSubtitle = SubTitleList;
        this.mListLatarBelakang = BackgroundList;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate layout item pada menu list pada saat membuka menu activity list
        View mItemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        //mendapatkan posisi dari judul deskripsi
        final String mCurrentTitle = mListJudul.get(position);
        final String mCurrentSubTitle = mListSubtitle.get(position);
        final Integer mCurrentBackground = mListLatarBelakang.get(position);

        //meletakkan teks dan gambar kedalam posisi yang sudah didapat pada sebelumnya
        holder.titleItemView.setText(mCurrentTitle);
        holder.subtitleItemView.setText(mCurrentSubTitle);
        holder.linearLayout.setBackgroundResource(mCurrentBackground);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Detail.class);
                intent.putExtra("Title",mCurrentTitle);
                intent.putExtra("Background",mCurrentBackground);
                view.getContext().startActivity(intent);
            }
        });
    }

    //method untuk melakukan perhitungan item
    @Override
    public int getItemCount() {
        return mListJudul.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView titleItemView, subtitleItemView;
        public final LinearLayout linearLayout;
        final ListAdapter mAdapter;
        public WordViewHolder(View itemView, ListAdapter adapter) {
            super(itemView);
            titleItemView = (TextView) itemView.findViewById(R.id.title);
            subtitleItemView = (TextView) itemView.findViewById(R.id.subTitle);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.listBackground);
            this.mAdapter = adapter;
        }
    }
}
