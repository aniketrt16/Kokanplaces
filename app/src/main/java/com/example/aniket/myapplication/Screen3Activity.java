package com.example.aniket.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Screen3Activity extends AppCompatActivity {

    HashMap<String, List<String>> myExpandableViewHashMap;
    List<String> myExpandableViewList;
    ExpandableListView myExpandableView;
    ExpandableViewAdapter adapter;

    ViewPager viewPager;
    CustomSwipeAdapter customSwipeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        Object o=findViewById(R.id.expandable_list);
        myExpandableView = (ExpandableListView)findViewById(R.id.expandable_list);
        myExpandableViewHashMap = DataProvider.getInfo();
        myExpandableViewList = new ArrayList<String>(myExpandableViewHashMap.keySet()); // will get values like Overview and addReview
        adapter = new ExpandableViewAdapter(Screen3Activity.this,myExpandableViewHashMap,myExpandableViewList);
        myExpandableView.setAdapter(adapter);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        customSwipeAdapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(customSwipeAdapter);

    }
}
