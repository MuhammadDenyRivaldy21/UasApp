package com.qiraht.kuliah.testingapps.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qiraht.kuliah.testingapps.ListResultAdapter;
import com.qiraht.kuliah.testingapps.R;
import com.qiraht.kuliah.testingapps.model.MatchResult.EventsItem;
import com.qiraht.kuliah.testingapps.model.MatchResult.ResponseResult;
import com.qiraht.kuliah.testingapps.retrofit.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultFragment extends Fragment {

    RecyclerView rvResult;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvResult = view.findViewById(R.id.rv_result);
        rvResult.setHasFixedSize(true);
        rvResult.setLayoutManager(new LinearLayoutManager(getActivity()));
        getResult();
    }


    private void getResult() {
        Call<ResponseResult> call = ApiClient.getInstance().getApiService().getResult("4332");
        call.enqueue(new Callback<ResponseResult>() {
            @Override
            public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
                List<EventsItem> result = response.body().getEvents();
                rvResult.setAdapter(new ListResultAdapter(result));


            }

            @Override
            public void onFailure(Call<ResponseResult> call, Throwable t) {

            }
        });

    }

}