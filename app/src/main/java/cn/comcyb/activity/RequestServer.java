package cn.comcyb.activity;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by user on 2016/12/22.
 */

interface  RequestServer{
    @POST("api/account/{login}")
    Call<String> Login(@Path("login") String login,
                       @Query("customerid") String customerid, @Query("userid") String userid, @Query("password") String password,
                       @Query("Language") String Language, @Query("sign") String sign);

}