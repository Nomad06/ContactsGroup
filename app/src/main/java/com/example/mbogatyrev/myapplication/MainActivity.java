package com.example.mbogatyrev.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {



    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterHelper ah = new AdapterHelper(this);

        expandableListView = (ExpandableListView) findViewById(R.id.expandable);
        expandableListView.setAdapter(ah.getAdapter());
    }


}
