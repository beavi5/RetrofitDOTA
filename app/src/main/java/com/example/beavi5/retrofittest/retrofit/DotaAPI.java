package com.example.beavi5.retrofittest.retrofit;

import com.example.beavi5.retrofittest.retrofit.models.Player;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by beavi5 on 21.09.2017.
 */

public interface DotaAPI {

@GET("search")
Call<Player[]> loadUsers(@Query("q") String searchString, @Query("similarity") int count);

}
