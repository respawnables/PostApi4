package com.example.postapi4;

import androidx.annotation.experimental.Experimental;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EkleActivity extends AppCompatActivity {

    private TextInputEditText tiKullaniciAdi;
    private TextInputEditText tiAdi;
    private TextInputEditText tiSoyadi;
    private TextInputEditText tiEposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekle);

        init();
    }

    public void init()
    {
        tiKullaniciAdi = findViewById(R.id.tiKullaniciAdi);
        tiAdi = findViewById(R.id.tiAdi);
        tiSoyadi = findViewById(R.id.tiSoyadi);
        tiEposta = findViewById(R.id.tiEposta);
    }

    public void addUser(View view)
    {

        Users user = new Users();

        user.setUsername(tiKullaniciAdi.getText().toString());
        user.setName(tiAdi.getText().toString());
        user.setLast_name(tiSoyadi.getText().toString());
        user.setEmail(tiEposta.getText().toString());





        IUserService userService = ApiClient.getClient().create(IUserService.class);
        Call<Users> call = userService.postUsers(user);
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                System.out.println("Response status code : " + response.message());
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                System.out.println("Bir hata meydana geldi");
            }
        });



    }
}