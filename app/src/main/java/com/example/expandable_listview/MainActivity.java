package com.example.expandable_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;

    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = findViewById(R.id.expandableListView_Id);

        customAdapter = new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);




    }

    public void prepareListData(){

        String[] headerString = getResources().getStringArray(R.array.network_abbreviation_list_header);
        String[] childString = getResources().getStringArray(R.array.network_abbreviation_list_child);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();


        for (int i=0;i<headerString.length;i++){

            //Adding header data
            listDataHeader.add(headerString[i]);

            List<String> child = new ArrayList<String>();
            child.add(childString[i]);

            listDataChild.put(listDataHeader.get(i),child);

        }


    }




}