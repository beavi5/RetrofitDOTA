package com.example.beavi5.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.beavi5.retrofittest.Models.RVAdapter;
import com.example.beavi5.retrofittest.retrofit.DotaAPI;
import com.example.beavi5.retrofittest.retrofit.models.Player;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
Retrofit retrofit;
    Button searchBtn;
    DotaAPI dotaAPI;
    RecyclerView recyclerview;
    EditText searchET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchET = (EditText) findViewById(R.id.searchET);
        searchBtn = (Button) findViewById(R.id.searchBtn);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchET.getText().toString().isEmpty()) return;
                searchET.setEnabled(false);
                searchET.setEnabled(true);
                dotaAPI.loadUsers(searchET.getText().toString(),1).enqueue(new Callback<Player[]>() {
                    @Override
                    public void onResponse(Call<Player[]> call, Response<Player[]> response) {
                        // Log.d("RESPONSE", "onResponse: "+response.body()[1].getAvatarfull());

                        recyclerview.setAdapter(new RVAdapter(response.body()));


                    }


                    @Override
                    public void onFailure(Call<Player[]> call, Throwable t) {

                    }
                });
            }
        });


        recyclerview= (RecyclerView) findViewById(R.id.playersRV);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        recyclerview.setLayoutManager(llm);

        retrofit = new Retrofit.Builder().baseUrl("https://api.opendota.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
         dotaAPI = retrofit.create(DotaAPI.class);

    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
