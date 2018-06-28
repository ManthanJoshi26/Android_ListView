package com.example.mrmjo.listviewwithcheckboxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class Second extends AppCompatActivity {

    public static final String EXTRA_MESSAGE1 = "com.example.mrmjo.demo8_1.MESSAGE";
    private CAdapter adapter;
    ArrayList<String> arrayList1;
    ArrayList<String> arrayList2;
    Bundle dataStore = new Bundle();
    ListView listView2;
    Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bindView();
        init();
        addListner();

        adapter = new CAdapter(arrayList1, arrayList2, getApplicationContext());
        listView2.setAdapter(adapter);

    }

    public void addListner() {

        btBack.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent i1 = new Intent(Second.this, MainActivity.class);
                startActivity(i1);

            }
        });

    }

    public void init() {

        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();

        dataStore = getIntent().getExtras();
        arrayList1 = dataStore.getStringArrayList("Extra");
        arrayList2 = dataStore.getStringArrayList("Extras");

    }

    public void bindView() {

        listView2 = findViewById(R.id.lvListView2);
        btBack = findViewById(R.id.btnBack);

    }


}

