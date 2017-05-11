package com.pro100svitlo.nfccardread;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dependencies {

    private GoboPayClient goboPayClient;

    public GoboPayClient getGoboPayClient() {
        if (goboPayClient == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://gobo-node.pcf-apps.intware.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            goboPayClient = retrofit.create(GoboPayClient.class);
        }
        return goboPayClient;
    }
}
