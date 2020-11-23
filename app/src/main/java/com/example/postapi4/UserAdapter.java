package com.example.postapi4;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<Users> users;

    public UserAdapter(ArrayList<Users> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kullanici_satir, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        holder.tvKullaniciAdi.setText(users.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvOn, tvKullaniciAdi;
        ImageView ivDahaFazlasi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOn = itemView.findViewById(R.id.tvOn);
            tvKullaniciAdi = itemView.findViewById(R.id.tvKullaniciAdi);
            ivDahaFazlasi = itemView.findViewById(R.id.ivDahaFazlasi);

            ivDahaFazlasi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext().getApplicationContext(), KullaniciDetayActivity.class);
                    intent.putExtra("username", tvKullaniciAdi.getText().toString());
                    intent.putExtra("eposta", users.get(getAdapterPosition()).getEmail());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
