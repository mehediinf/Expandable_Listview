package com.example.expandable_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;

    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;

    private int lastExpandedPositon = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = findViewById(R.id.expandableListView_Id);

        customAdapter = new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);

//Header Listener
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                String groupName = listDataHeader.get(groupPosition);
                Toast.makeText(getApplicationContext(),groupName,Toast.LENGTH_SHORT).show();

                return false;
            }
        });
//Header Collapse Listener
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                String groupName = listDataHeader.get(groupPosition);
                Toast.makeText(getApplicationContext(),groupName+" is collapsed",Toast.LENGTH_SHORT).show();

            }
        });

//Child Listener
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String childString = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(),childString,Toast.LENGTH_SHORT).show();

                return false;
            }
        });

//........................
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                if (lastExpandedPositon != -1 && lastExpandedPositon != groupPosition){

                    expandableListView.collapseGroup(lastExpandedPositon);
                }
                lastExpandedPositon = groupPosition;


            }
        });


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