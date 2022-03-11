package com.sergei.lab4;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telecom.Call;
import android.telephony.TelephonyManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver callReceiver;
    private List<String> callList = new ArrayList<>();
    //private ArrayAdapter<String> adapter;
    CallAdapter callAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callReceiver = new CallReceiver(this);

        IntentFilter filter = new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        registerReceiver(callReceiver, filter);
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, callList);
        //ListView numberList = findViewById(R.id.);
        //numberList.setAdapter(adapter);
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        callAdapter = new CallAdapter(this, callList);
        recyclerView.setAdapter(callAdapter);
    }

    //lisab telefoninumbri nimekirja
    public void addPhoneNumberTolist(String number){
        callList.add(number);
      //  adapter.notifyDataSetChanged();
        callAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(callReceiver);
    }
}