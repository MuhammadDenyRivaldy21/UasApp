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

import com.qiraht.kuliah.testingapps.ListScheduleAdapter;
import com.qiraht.kuliah.testingapps.R;
import com.qiraht.kuliah.testingapps.model.MatchSchedule.EventsItem;
import com.qiraht.kuliah.testingapps.model.MatchSchedule.ResponseSchedule;
import com.qiraht.kuliah.testingapps.retrofit.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleFragment extends Fragment {
    RecyclerView rvSchedule;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSchedule = view.findViewById(R.id.rv_schedule);
        rvSchedule.setHasFixedSize(true);
        rvSchedule.setLayoutManager(new LinearLayoutManager(getActivity()));
        getResult();
    }

    private void getResult() {
        Call<ResponseSchedule> call = ApiClient.getInstance().getApiService().getSchedule("4332");
        call.enqueue(new Callback<ResponseSchedule>() {
            @Override
            public void onResponse(Call<ResponseSchedule> call, Response<ResponseSchedule> response) {
                List<EventsItem> schedule = response.body().getEvents();
                rvSchedule.setAdapter(new ListScheduleAdapter(schedule));
            }

            @Override
            public void onFailure(Call<ResponseSchedule> call, Throwable t) {

            }
        });
    }
}