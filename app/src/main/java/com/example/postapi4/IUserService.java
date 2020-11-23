package com.example.postapi4;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IUserService {

    @GET("users")
    Call<List<Users>> getUsers();

    /*@POST("users/")
    @FormUrlEncoded
    Call<Users> postUsers(@Field("username") String username,
                          @Field("first_name") String first_name,
                          @Field("last_name") String last_name,
                          @Field("email") String email);*/

    @POST("users/")
    Call<Users> postUsers(@Body Users users);
}
