package com.example.mrmjo.listviewwithcheckboxes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;
    ArrayList dataModels;
    ListView listView;
    private CustomAdapter adapter;
    ArrayList<String> arrayList1, arrayList2;
    String tempString1, tempString2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        init();
        addListner();

        adapter = new CustomAdapter(dataModels, getApplicationContext());
        listView.setAdapter(adapter);

    }


    public void bindView() {

        btnSubmit = findViewById(R.id.btnSubnit);
        listView = findViewById(R.id.lvListView);
    }

    private void init() {

        dataModels = new ArrayList();
        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();


        dataModels.add(new DataModel("Apple Pie", "1.0", false));
        dataModels.add(new DataModel("Banana Bread", "1.1", false));
        dataModels.add(new DataModel("Cupcake", "1.5", false));
        dataModels.add(new DataModel("Donut", "1.6", false));
        dataModels.add(new DataModel("Eclair", "2.0", false));
        dataModels.add(new DataModel("Froyo", "2.2", false));
        dataModels.add(new DataModel("Gingerbread", "2.3", false));
        dataModels.add(new DataModel("Honeycomb", "3.0", false));
        dataModels.add(new DataModel("Ice Cream Sandwich", "4.0", false));
        dataModels.add(new DataModel("Jelly Bean", "4.1", false));
        dataModels.add(new DataModel("Kitkat", "4.4", false));
        dataModels.add(new DataModel("Lollipop", "5.0", false));
        dataModels.add(new DataModel("Marshmallow", "6.0", false));
        dataModels.add(new DataModel("Nougat", "7.0", false));
        dataModels.add(new DataModel("Oreo", "8.0", false));

    }

    private void addListner() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                DataModel dataModel = (DataModel) dataModels.get(position);
                dataModel.checked = !dataModel.checked;

                adapter.notifyDataSetChanged();

                if (dataModel.checked) {

                    tempString1 = dataModel.name;
                    tempString2 = dataModel.version;

                    arrayList1.add(tempString1);
                    arrayList2.add(tempString2);

                }

                if (!dataModel.checked) {

                    arrayList1.remove(position);
                    arrayList2.remove(position);
                }

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1 = new Intent(MainActivity.this, Second.class);

                Bundle b1 = new Bundle();

                b1.putStringArrayList("Extra", arrayList1);
                b1.putStringArrayList("Extras", arrayList2);

                i1.putExtras(b1);
                startActivity(i1);

            }
        });

    }

}