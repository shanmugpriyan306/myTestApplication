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
import com.example.w5kf2xgg.myapplication.pojo.Datum;
import com.example.w5kf2xgg.myapplication.pojo.Survey;
import com.example.w5kf2xgg.myapplication.utility.Adapter;
import com.example.w5kf2xgg.myapplication.utility.Utilities;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Object> datumListForAdapter = new ArrayList<Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new Adapter(datumListForAdapter);
        Utilities utilities = new Utilities();
        String s = utilities.simpleText(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        Survey survey = new Gson().fromJson(s, Survey.class);

        List<Datum> datumList = survey.getResult().getData();
        datumListForAdapter = new ArrayList<>();

        for (int i = 0; i < datumList.size(); i++) {
            List<Datum> tempListDatum = new ArrayList<>();
            if (datumList.get(i).getDatatype().equals("Template")) {
                tempListDatum.add(datumList.get(i));
                tempListDatum.add(datumList.get(i + 1));
                datumListForAdapter.add(new Type1(tempListDatum));
            } else if (datumList.get(i).getDatatype().equals("Template - Radio")) {
                tempListDatum.add(datumList.get(i));
                tempListDatum.add(datumList.get(i + 1));
                datumListForAdapter.add(new Type2(tempListDatum));
            } else if (datumList.get(i).getDatatype().equals("String - Comments")) {
                tempListDatum.add(datumList.get(i));
                datumListForAdapter.add(new Type3(tempListDatum));
            }
        }

        bindDataToAdapter();

        Log.i("Hlp", "Help");
    }

    private void bindDataToAdapter() {
        // Bind adapter to recycler view object
        recyclerView.setAdapter(new Adapter(datumListForAdapter));
    }
}
