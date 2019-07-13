package com.responsi.mvp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleService {

    public static final String baseUrl = "https://private-0e6b9-ganjarwidiatmansyah.apiary-mock.com/";

    public static PeopleApi createService() {


        Retrofit builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  builder.create(PeopleApi.class);
    }

}
