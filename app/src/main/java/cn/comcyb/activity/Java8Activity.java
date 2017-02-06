package cn.comcyb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import cn.comcyb.myclass.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Java8Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java8);
        /*Runnable runnable= ()-> Log.i("","");*/
        /***/

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://101.200.182.221:80/").addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();

        RequestServer requestServer = retrofit.create(RequestServer.class);
        Call<String>  call  = requestServer.Login("login","001","Android001","111111","0", cn.comcyb.view.Util.getSign("customerid" + "001"
                + "userid" + "Android001" + "password"
                + "111111"));
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("88888",response.body().toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("88888","==!");
            }
        });

    }
}




