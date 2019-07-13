package com.responsi.mvp.prasenter;

import android.util.Log;

import com.responsi.mvp.MainActivity;
import com.responsi.mvp.model.People;
import com.responsi.mvp.service.PeopleApi;
import com.responsi.mvp.service.PeopleService;
import com.responsi.mvp.view.PeopleView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeoplePresenterImpl implements PeoplePresenter {

    PeopleView peopleView;
    PeopleApi peopleApi;

    public PeoplePresenterImpl (PeopleView peopleView) {
        this.peopleView = peopleView;
        if (peopleApi == null) {
            peopleApi = PeopleService.createService();
        }
    }

    @Override
    public void callPeopleData(String results, String nat) {
        peopleApi.callPeople(results , nat)
                .enqueue(new Callback<People>() {
                    @Override
                    public void onResponse(Call<People> call, Response<People> response) {
                        if (response.isSuccessful()) {
                            Log.i("xxxx" , "Succes" + response.body().getResults());
                        }else {
                            Log.i("xxxx" , "Unsucsess :" +response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<People> call, Throwable t) {
                        Log.i("xxxx" , "Throw" + t);

                    }
                });



    }
}
