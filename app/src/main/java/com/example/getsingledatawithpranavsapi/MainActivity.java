package com.example.getsingledatawithpranavsapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
EditText email;
TextView data;
Button get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        data=findViewById(R.id.data);
        get=findViewById(R.id.get);


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api=retrofit.create(Api.class);
                Call<Data> call=api.getData(email.getText().toString());

                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                       Data d=response.body();
                   String name=d.getName();
                       String email=d.getEmail();
                       String mob=d.getMobile();
                       String pass=d.getPassword();
                       // Toast.makeText(MainActivity.this, ""+name, Toast.LENGTH_SHORT).show();

                   data.setText(name+"\n"+email+"\n"+mob+"\n"+pass+"\n");
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });
    }
}
