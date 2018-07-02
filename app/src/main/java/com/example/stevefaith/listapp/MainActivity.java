    package com.example.stevefaith.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

    public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String [] items;
    String [] prices;
    String [] description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();

        myListView = (ListView) findViewById(R.id.myListView);

        items= res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        description = res.getStringArray(R.array.descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, description);
        myListView.setAdapter(itemAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.stevefaith.ITEM_INDEX", i );
                startActivity(showDetailActivity);


            }
        });

        //this was done to test out the Resources and print out a single line
        //myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, items));



    }
}
