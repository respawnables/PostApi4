package com.example.postapi4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvKullaniciListe;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Users> users = new ArrayList<>();

        IUserService userService = ApiClient.getClient().create(IUserService.class);
        Call<List<Users>> call = userService.getUsers();
        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                assert response.body() != null;
                users.addAll(response.body());
                System.out.println(users.size());

                adapter = new UserAdapter(users);
                rvKullaniciListe = findViewById(R.id.rvKullaniciListe);
                rvKullaniciListe.setAdapter(adapter);
                rvKullaniciListe.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                System.out.println("Hata meydana geldi " + t.getMessage());
            }
        });





    }

    public void Goster(View view)
    {
        Intent intent = new Intent(MainActivity.this, EkleActivity.class);
        startActivity(intent);
    }
}