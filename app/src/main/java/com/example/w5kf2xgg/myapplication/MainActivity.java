package com.example.w5kf2xgg.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.w5kf2xgg.myapplication.TypeCastingClass.Type1;
import com.example.w5kf2xgg.myapplication.TypeCastingClass.Type2;
import com.example.w5kf2xgg.myapplication.TypeCastingClass.Type3;
import com.example.w5kf2xgg.myapplication.pojo.servey.question.Datum;
import com.example.w5kf2xgg.myapplication.pojo.servey.question.SurveryQuestion;
import com.example.w5kf2xgg.myapplication.pojo.servey.submit.Result;
import com.example.w5kf2xgg.myapplication.pojo.servey.submit.SurveryFeedbackSubmit;
import com.example.w5kf2xgg.myapplication.utility.Adapter;
import com.example.w5kf2xgg.myapplication.utility.Utilities;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.AdapterButtonClickListener {
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Object> datumListForAdapter = new ArrayList<Object>();
    HashMap<Integer, List<com.example.w5kf2xgg.myapplication.pojo.servey.submit.Datum>> outPutHash = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new Adapter(datumListForAdapter, this, this);
        Utilities utilities = new Utilities();
        String s = utilities.simpleText(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        SurveryQuestion survey = new Gson().fromJson(s, SurveryQuestion.class);

        List<Datum> datumList = survey.getResult().getData();
        datumListForAdapter = new ArrayList<>();

        for (int i = 0; i < datumList.size(); i++) {
            if (datumList.get(i).getDatatype().equals("Template")) {
                datumListForAdapter.add(new Type1(datumList.get(i)));
            } else if (datumList.get(i).getDatatype().equals("Template - Radio")) {
                datumListForAdapter.add(new Type2(datumList.get(i)));
            } else if (datumList.get(i).getDatatype().equals("String - Comments")) {
                datumListForAdapter.add(new Type3(datumList.get(i)));
            }
        }

        bindDataToAdapter();

        Log.i("Hlp", "Help");
    }

    private void bindDataToAdapter() {
        // Bind adapter to recycler view object

        for (int i = 0; i < datumListForAdapter.size(); i++) {
            outPutHash.put(i, new ArrayList<com.example.w5kf2xgg.myapplication.pojo.servey.submit.Datum>());
        }

        datumListForAdapter.add("ButtonCLick");
        recyclerView.setAdapter(new Adapter(datumListForAdapter, this, this));
    }

    @Override
    public void click() {
        //Todo all condition need to be checked here
        SurveryFeedbackSubmit surveryFeedbackSubmit = new SurveryFeedbackSubmit();
        surveryFeedbackSubmit.setIntegrationID("INTG001048");
        surveryFeedbackSubmit.setId("699bee42dbfe0b041f49f29eaf96192b");
        Result results = new Result();

        List<com.example.w5kf2xgg.myapplication.pojo.servey.submit.Datum> datumList = new ArrayList<>();

        for (int i = 0; i < outPutHash.size(); i++) {
            for (int j = 0; j < outPutHash.get(i).size(); i++) {
                datumList.add(outPutHash.get(i).get(j));
            }
        }

        results.setData(datumList);
        surveryFeedbackSubmit.setResult(results);
        new Gson().toJson(surveryFeedbackSubmit);
    }

    @Override
    public void onItemClick(List<com.example.w5kf2xgg.myapplication.pojo.servey.submit.Datum> submitDatum, int position) {
        outPutHash.put(position, submitDatum);
    }
}
